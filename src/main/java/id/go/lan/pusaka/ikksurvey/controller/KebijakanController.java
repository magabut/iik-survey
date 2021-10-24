package id.go.lan.pusaka.ikksurvey.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import id.go.lan.pusaka.ikksurvey.model.*;
import id.go.lan.pusaka.ikksurvey.model.dto.*;
import id.go.lan.pusaka.ikksurvey.model.request.*;
import id.go.lan.pusaka.ikksurvey.service.*;
import id.go.lan.pusaka.ikksurvey.utility.ModelMapperUtility;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/kebijakan")
public class KebijakanController {
	@Autowired
	private ModelMapperUtility modelMapperUtility;
	@Autowired
	KebijakanService kebijakanService;
	@Autowired
	AgendaSettingService agendaSettingService;
	@Autowired
	EvaluasiKebijakanService evaluasiKebijakanService;
	@Autowired
	FormulasiKebijakanService formulasiKebijakanService;
	@Autowired
	ImplementasiKebijakanService implementasiKebijakanService;

	// Koordinator Instansi

	@GetMapping("/koordinatorinstansi")
	@PreAuthorize("hasAnyAuthority('role_koordinator_instansi')")
	public List<DaftarKebijakanDto> koordinatorGetDaftarKebijakan(@RequestHeader(value = "Authorization") String token) throws UnirestException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		List<DaftarKebijakanDto> daftarKebijakanDtoList = new ArrayList<>();
		List<InstansiListResponse> instansiList = getInstansiList(currentPrincipalName, token);

		for (InstansiListResponse instansi : instansiList) {
			DaftarKebijakanDto daftarKebijakanDto = new DaftarKebijakanDto();
			daftarKebijakanDto.setNamaInstansi(instansi.getNamaInstansi());
			daftarKebijakanDto.setTotalKebijakan(kebijakanService.countByCreateByAndIsSentByAdminEquals(instansi.getAdminInstansi()));
			daftarKebijakanDto.setNipAdminInstansi(instansi.getAdminInstansi());
			daftarKebijakanDto.setTanggal(new Date());
			// TO DO -> masih null
//			daftarKebijakanDto.setTanggal(kebijakanService.findTopByCreateBy(instansi.getAdminInstansi()).getTanggal());
			daftarKebijakanDtoList.add(daftarKebijakanDto);
		}

		return daftarKebijakanDtoList;
	}

	@GetMapping("/koordinatorinstansi/detail/{nip}")
	@PreAuthorize("hasAnyAuthority('role_koordinator_instansi')")
	public DaftarKebijakanInstansiDto koordinatorGetDetailKebijakanByInstansi(
			@RequestHeader(value = "Authorization") String token,
			@PathVariable String nip
	) throws UnirestException {
		List<Kebijakan> kebijakanList = kebijakanService.findByInstansiAndCreateByAndIsSentByAdminEquals(
				getData(nip, token).getInstansiKerjaNama(),
				getData(nip, token).getNipBaru()
		);
		List<KebijakanDto> kebijakanDtoList = new ArrayList<>();
		for (Kebijakan kebijakan : kebijakanList) {
			KebijakanDto kebijakanDto = modelMapperUtility.initialize().map(kebijakan, KebijakanDto.class);
			kebijakanDtoList.add(kebijakanDto);
		}

		DaftarKebijakanInstansiDto daftarKebijakanInstansiDto = new DaftarKebijakanInstansiDto();
		daftarKebijakanInstansiDto.setIsReadySend(validateReadySend(kebijakanDtoList));
		daftarKebijakanInstansiDto.setKebijakanDtoList(kebijakanDtoList);

		return daftarKebijakanInstansiDto;
	}

	private Boolean validateReadySend(List<KebijakanDto> kebijakanDtoList) {

		for (KebijakanDto kebijakanDto : kebijakanDtoList) {
			if (!kebijakanDto.getIsVerified()) {
				return false;
			}
		}

		return true;
	}

	@PostMapping("/koordinatorinstansi/detail/{nip}/approve/{id}")
	@PreAuthorize("hasAnyAuthority('role_koordinator_instansi')")
	public String koordinatorApproveKebijakanByInstansi(
			@PathVariable String nip,
			@PathVariable Long id
	) {
		Kebijakan kebijakan = kebijakanService.findById(id);
		kebijakan.setStatus("disetujui");
		kebijakan.setIsVerified(true);
		kebijakanService.save(kebijakan);
		return "Kebijakan disetujui";
	}

	@PostMapping("/koordinatorinstansi/detail/{nip}/disapprove/{id}")
	@PreAuthorize("hasAnyAuthority('role_koordinator_instansi')")
	public String koordinatorDisapproveKebijakanByInstansi(
			@PathVariable String nip,
			@PathVariable Long id
	) {
		Kebijakan kebijakan = kebijakanService.findById(id);
		kebijakan.setStatus("ditolak");
		kebijakan.setIsVerified(true);
		kebijakanService.save(kebijakan);
		return "Kebijakan ditolak";
	}

	@PostMapping("/koordinatorinstansi/detail/{nip}/kirim")
	@PreAuthorize("hasAnyAuthority('role_koordinator_instansi')")
	public String koordinatorKirimKebijakanKeAdminInstansi(
			@RequestHeader(value = "Authorization") String token,
			@PathVariable String nip
	) throws UnirestException {
		List<Kebijakan> kebijakanList = kebijakanService.findByCreatedBy(getData(nip, token).getNipBaru());
		for (Kebijakan kebijakan : kebijakanList) {
			if (kebijakan.getIsVerified()) {
				kebijakan.setIsSentByKoordinator(true);
				kebijakan.setSentByKoordinatorAt(new Date());
				kebijakanService.save(kebijakan);
			}
		}
		return "Kebijakan berhasil dikirim ke Admin Instansi";
	}

	// CRUD Kebijakan

	@PostMapping("/")
	@PreAuthorize("hasAnyAuthority('role_admin_instansi')")
	public Kebijakan simpan(
			@RequestBody KebijakanRequest kebijakanRequest,
			@RequestHeader(value = "Authorization") String token
	) throws UnirestException {

		Kebijakan kebijakan = new Kebijakan();
		kebijakan.setNama(kebijakanRequest.getNama());
		kebijakan.setEnumerator(kebijakanRequest.getEnumerator());
		kebijakan.setTanggal(kebijakanRequest.getTanggal());
		kebijakan.setJenis(kebijakanRequest.getJenis());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		kebijakan.setInstansi(getData(currentPrincipalName, token).getInstansiKerjaNama());
		kebijakan.setCreateBy(currentPrincipalName);
		kebijakan.setCreatedAt(new Date());
		kebijakanRequest.setTanggal(kebijakanRequest.getTanggal());
		KebijakanDetail kebijakanDetail = new KebijakanDetail();
		kebijakanDetail.setProgres(0.0);
		kebijakan.setKebijakanDetail(kebijakanDetail);
		AgendaSetting agendaSetting = new AgendaSetting();
		kebijakan.setAgendaSetting(agendaSettingService.save(agendaSetting));
		EvaluasiKebijakan evaluasiKebijakan = new EvaluasiKebijakan();
		kebijakan.setEvaluasiKebijakan(evaluasiKebijakanService.save(evaluasiKebijakan));
		FormulasiKebijakan formulasiKebijakan = new FormulasiKebijakan();
		kebijakan.setFormulasiKebijakan(formulasiKebijakanService.save(formulasiKebijakan));
		ImplementasiKebijakan implementasiKebijakan = new ImplementasiKebijakan();
		kebijakan.setImplementasiKebijakan(implementasiKebijakanService.save(implementasiKebijakan));
		kebijakan.setStatus("diajukan");
		kebijakan.setIsVerified(false);
		kebijakan.setIsSentByAdmin(false);
		kebijakan.setIsSentByKoordinator(false);
		return kebijakanService.save(kebijakan);
	}

	@GetMapping("/")
	@PreAuthorize("hasAnyAuthority('role_admin_instansi')")
	public List<KebijakanDto> findKebijakan(
			@RequestHeader(value = "Authorization") String token,
			@RequestParam(defaultValue = "diajukan") String status
	) throws UnirestException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		List<KebijakanDto> kebijakanDtoList = new ArrayList<>();
		List<Kebijakan> kebijakanList = kebijakanService.findByInstansiAndCreateByAndStatus(
				getData(currentPrincipalName, token).getInstansiKerjaNama(),
				currentPrincipalName,
				status
		);

		for (Kebijakan kebijakan : kebijakanList) {
			KebijakanDto kebijakanDto = modelMapperUtility.initialize().map(kebijakan, KebijakanDto.class);
			kebijakanDtoList.add(kebijakanDto);
		}
		return kebijakanDtoList;
	}

	@PostMapping("/kirim")
	@PreAuthorize("hasAnyAuthority('role_admin_instansi')")
	public String kirimPopulasiKebijakan(@RequestHeader(value = "Authorization") String token) throws UnirestException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		List<Kebijakan> kebijakanList = kebijakanService.findByInstansiAndCreateByAndStatus(
				getData(currentPrincipalName, token).getInstansiKerjaNama(),
				currentPrincipalName,
				"diajukan"
		);

		for (Kebijakan kebijakan : kebijakanList) {
			kebijakan.setIsSentByAdmin(true);
			kebijakan.setSentByAdminAt(new Date());
			kebijakanService.save(kebijakan);
		}

		return "Populasi kebijakan berhasil dikirim";
	}

	@GetMapping("/sampling")
	@PreAuthorize("hasAnyAuthority('role_admin_instansi')")
	public SampleKebijakanDto findSampleKebijakan(@RequestHeader(value = "Authorization") String token) throws UnirestException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return kebijakanService.findSampleKebijakanByInstansi(
				getData(currentPrincipalName, token).getInstansiKerjaNama(),
				currentPrincipalName
		);
	}

	@PostMapping("/sampling")
	@PreAuthorize("hasAnyAuthority('role_admin_instansi')")
	public SampleKebijakanDto addSampleKebijakan(@RequestHeader(value = "Authorization") String token) throws UnirestException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return kebijakanService.addSampleKebijakanByInstansi(
				getData(currentPrincipalName, token).getInstansiKerjaNama(),
				currentPrincipalName
		);
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasAnyAuthority('role_admin_instansi')")
	public Kebijakan updateKebijakanById(@RequestBody KebijakanRequest kebijakanRequest, @PathVariable("id") Long id,
										@RequestHeader(value = "Authorization") String token)
			throws UnirestException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByInstansiAndId(getData(currentPrincipalName, token).getInstansiKerjaNama(),
				id);
		kebijakan.setNama(kebijakanRequest.getNama());
		kebijakan.setTanggal(kebijakanRequest.getTanggal());
		kebijakan.setJenis(kebijakanRequest.getJenis());
		kebijakan.setEnumerator(kebijakanRequest.getEnumerator());
		return kebijakanService.save(kebijakan);
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAnyAuthority('role_admin_instansi')")
	public String deleteKebijakanById(
			@RequestHeader(value = "Authorization") String token,
			@PathVariable Long id
	) {
		Kebijakan kebijakan = kebijakanService.findById(id);
		kebijakanService.delete(kebijakan);

		return "Kebijakan berhasil dihapus";
	}

	@PutMapping("/assign/{idKebijakan}")
	@PreAuthorize("hasAnyAuthority('role_admin_instansi')")
	public KebijakanDto assignEnumeratorKebijakan(
			@RequestBody AssignEnumeratorKebijakanRequest requestBody,
			@PathVariable("idKebijakan") Long idKebijakan,
			@RequestHeader(value = "Authorization") String token) throws UnirestException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return kebijakanService.assignEnumeratorToKebijakan(
				getData(currentPrincipalName, token).getInstansiKerjaNama(),
				idKebijakan,
				requestBody.getNipEnumerator());
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('role_admin_instansi')")
	public Kebijakan cariKebijkanById(@PathVariable("id") Long id,
									  @RequestHeader(value = "Authorization") String token) throws UnirestException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return kebijakanService.findByInstansiAndId(getData(currentPrincipalName, token).getInstansiKerjaNama(), id);
	}

	@GetMapping("/enumerator")
	@PreAuthorize("hasAnyAuthority('role_enumerator')")
	public List<Kebijakan> findKebijakanEnumerator() throws UnirestException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return kebijakanService.findByEnumerator(currentPrincipalName);
	}

//	@GetMapping("/enumerator/agendasetting/{id}")
//	@PreAuthorize("hasAnyAuthority('role_enumerator')")
//	public AgendaSetting findKebijakanEnumeratorId(@PathVariable("id") Long id) throws UnirestException {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String currentPrincipalName = authentication.getName();
//		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
//
//		AgendaSetting agendaSetting = kebijakan.getAgendaSetting();
//		return agendaSetting;
//	}

	@PostMapping("/enumerator/agendasetting/{id}")
	@PreAuthorize("hasAnyAuthority('role_enumerator')")
	public AgendaSetting simpanKebijakanEnumeratorIdAgendaSeting(@RequestBody AgendaSettingRequest agendaSettingRequest,
			@PathVariable("id") Long id) throws UnirestException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);

		AgendaSetting agendaSetting = agendaSettingService.findById(kebijakan.getAgendaSetting().getId());
		agendaSetting.setA1A(agendaSettingRequest.getA1A());
		agendaSetting.setA1B(agendaSettingRequest.getA1B());
		agendaSetting.setA1C(agendaSettingRequest.getA1C());
		agendaSetting.setA1D(agendaSettingRequest.getA1D());
		agendaSetting.setA2A(agendaSettingRequest.getA2A());
		agendaSetting.setA2B(agendaSettingRequest.getA2B());
		agendaSetting.setA2C(agendaSettingRequest.getA2C());
		agendaSetting.setInformasiA3(agendaSettingRequest.getInformasiA3());

		return agendaSettingService.save(agendaSetting);
	}

//	@GetMapping("/enumerator/formulasikebijakan/{id}")
//	@PreAuthorize("hasAnyAuthority('role_enumerator')")
//	public FormulasiKebijakan findKebijakanEnumeratorIdFormulasiKebijakan(@PathVariable("id") Long id)
//			throws UnirestException {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String currentPrincipalName = authentication.getName();
//		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
//
//		FormulasiKebijakan formulasiKebijakan = kebijakan.getFormulasiKebijakan();
//		return formulasiKebijakan;
//	}

	@PostMapping("/enumerator/formulasikebijakan/{id}")
	@PreAuthorize("hasAnyAuthority('role_enumerator')")
	public FormulasiKebijakan simpanKebijakanEnumeratorIdFormulasiKebijakan(
			@RequestBody FormulasiKebijakanRequest formulasiKebijakanRequest, @PathVariable("id") Long id)
			throws UnirestException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);

		FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService
				.findById(kebijakan.getFormulasiKebijakan().getId());
		formulasiKebijakan.setB1A(formulasiKebijakanRequest.getB1A());
		formulasiKebijakan.setB1B(formulasiKebijakanRequest.getB1B());
		formulasiKebijakan.setB2A(formulasiKebijakanRequest.getB2A());
		formulasiKebijakan.setB2B(formulasiKebijakanRequest.getB2B());
		formulasiKebijakan.setB3A(formulasiKebijakanRequest.getB3A());
		formulasiKebijakan.setB3B(formulasiKebijakanRequest.getB3B());
		formulasiKebijakan.setB3C(formulasiKebijakanRequest.getB3C());
		formulasiKebijakan.setB4A(formulasiKebijakanRequest.getB4A());
		formulasiKebijakan.setB4B(formulasiKebijakanRequest.getB4B());
		formulasiKebijakan.setB4C(formulasiKebijakanRequest.getB4C());
		formulasiKebijakan.setB5A(formulasiKebijakanRequest.getB5A());
		formulasiKebijakan.setB5B(formulasiKebijakanRequest.getB5B());
		formulasiKebijakan.setB5C(formulasiKebijakanRequest.getB5C());
		formulasiKebijakan.setInformasiB6(formulasiKebijakanRequest.getInformasiB6());
		return formulasiKebijakanService.save(formulasiKebijakan);
	}

//	@GetMapping("/enumerator/implementasikebijakan/{id}")
//	@PreAuthorize("hasAnyAuthority('role_enumerator')")
//	public ImplementasiKebijakan findKebijakanEnumeratorIdImplementasiKebijakan(@PathVariable("id") Long id)
//			throws UnirestException {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String currentPrincipalName = authentication.getName();
//		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
//
//		ImplementasiKebijakan implementasiKebijakan = kebijakan.getImplementasiKebijakan();
//		return implementasiKebijakan;
//	}

	@PostMapping("/enumerator/implementasikebijakan/{id}")
	@PreAuthorize("hasAnyAuthority('role_enumerator')")
	public ImplementasiKebijakan simpanKebijakanEnumeratorIdImplementasiKebiajakan(
			@RequestBody ImplementasiKebijakanRequest implementasiKebijakanRequest, @PathVariable("id") Long id)
			throws UnirestException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);

		ImplementasiKebijakan implementasiKebijakan = implementasiKebijakanService
				.findById(kebijakan.getImplementasiKebijakan().getId());
		implementasiKebijakan.setC1A(implementasiKebijakanRequest.getC1A());
		implementasiKebijakan.setC1B(implementasiKebijakanRequest.getC1B());
		implementasiKebijakan.setC1C(implementasiKebijakanRequest.getC1C());
		implementasiKebijakan.setC1D(implementasiKebijakanRequest.getC1D());
		implementasiKebijakan.setC2A(implementasiKebijakanRequest.getC2A());
		implementasiKebijakan.setC2B(implementasiKebijakanRequest.getC2B());
		implementasiKebijakan.setC2C(implementasiKebijakanRequest.getC2C());
		implementasiKebijakan.setC3A(implementasiKebijakanRequest.getC3A());
		implementasiKebijakan.setC3B(implementasiKebijakanRequest.getC3B());
		implementasiKebijakan.setC3C(implementasiKebijakanRequest.getC3C());
		implementasiKebijakan.setInformasiC4(implementasiKebijakanRequest.getInformasiC4());
		return implementasiKebijakanService.save(implementasiKebijakan);
	}

//	@GetMapping("/enumerator/evaluasikebijakan/{id}")
//	@PreAuthorize("hasAnyAuthority('role_enumerator')")
//	public EvaluasiKebijakan findKebijakanEnumeratorIdEvaluasiKebijakan(@PathVariable("id") Long id)
//			throws UnirestException {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String currentPrincipalName = authentication.getName();
//		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
//
//		EvaluasiKebijakan evaluasiKebijakan = kebijakan.getEvaluasiKebijakan();
//		return evaluasiKebijakan;
//	}

	@PostMapping("/enumerator/evaluasikebijakan/{id}")
	@PreAuthorize("hasAnyAuthority('role_enumerator')")
	public EvaluasiKebijakan simpanKebijakanEnumeratorIdEvaluasiKebijakan(
			@RequestBody EvaluasiKebijakanRequest evaluasiKebijakanRequest, @PathVariable("id") Long id)
			throws UnirestException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);

		EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService
				.findById(kebijakan.getEvaluasiKebijakan().getId());
		evaluasiKebijakan.setD1A(evaluasiKebijakanRequest.getD1A());
		evaluasiKebijakan.setD1B(evaluasiKebijakanRequest.getD1B());
		evaluasiKebijakan.setD2A(evaluasiKebijakanRequest.getD2A());
		evaluasiKebijakan.setD2B(evaluasiKebijakanRequest.getD2B());
		evaluasiKebijakan.setD3A(evaluasiKebijakanRequest.getD3A());
		evaluasiKebijakan.setD3B(evaluasiKebijakanRequest.getD3B());
		evaluasiKebijakan.setD3C(evaluasiKebijakanRequest.getD3C());
		evaluasiKebijakan.setD3D(evaluasiKebijakanRequest.getD3D());
		evaluasiKebijakan.setD3E(evaluasiKebijakanRequest.getD3E());
		evaluasiKebijakan.setInformasiD4(evaluasiKebijakanRequest.getInformasiD4());
		return evaluasiKebijakanService.save(evaluasiKebijakan);
	}

	// Admin Instansi TO DO

//	@PostMapping("/admininstansi/kirim")
//	@PreAuthorize("hasAnyAuthority('role_admin_instansi')")
//	public

	List<InstansiListResponse> getInstansiList(String nip, String token) throws UnirestException {
		HttpResponse<JsonNode> response = Unirest.get("http://localhost:8090/user/pegawai/instansi/" + nip)
				.header("Authorization", token)
				.asJson();

		JSONArray object = response.getBody().getArray();

		Gson gson = new Gson();
		Type instansiListType = new TypeToken<ArrayList<InstansiListResponse>>(){}.getType();

		return gson.fromJson(String.valueOf(object), instansiListType);
	}

	Pegawai getData(String nip, String token) throws UnirestException {
		Pegawai pegawai = new Pegawai();
		try {
			Unirest.setTimeouts(0, 0);
			HttpResponse<String> response = Unirest.get("http://localhost:8090/user/pegawai/" + nip)
					.header("Authorization", token).asString();
			JSONObject jsonObj = new JSONObject(response.getBody());
			Gson g = new Gson();
			pegawai = g.fromJson(jsonObj.toString(), Pegawai.class);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}

		return pegawai;
	}
}
