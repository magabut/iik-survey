package id.go.lan.pusaka.ikksurvey.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import id.go.lan.pusaka.ikksurvey.model.AgendaSetting;
import id.go.lan.pusaka.ikksurvey.model.EvaluasiKebijakan;
import id.go.lan.pusaka.ikksurvey.model.FormulasiKebijakan;
import id.go.lan.pusaka.ikksurvey.model.ImplementasiKebijakan;
import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import id.go.lan.pusaka.ikksurvey.model.request.AgendSettingRequest;
import id.go.lan.pusaka.ikksurvey.model.request.EvaluasiKebijakanRequest;
import id.go.lan.pusaka.ikksurvey.model.request.FormulasiKebijakanRequest;
import id.go.lan.pusaka.ikksurvey.model.request.ImplementasiKebijakanRequest;
import id.go.lan.pusaka.ikksurvey.model.request.KebijakanRequest;
import id.go.lan.pusaka.ikksurvey.model.request.Pegawai;
import id.go.lan.pusaka.ikksurvey.service.AgendaSettingService;
import id.go.lan.pusaka.ikksurvey.service.EvaluasiKebijakanService;
import id.go.lan.pusaka.ikksurvey.service.FormulasiKebijakanService;
import id.go.lan.pusaka.ikksurvey.service.ImplementasiKebijakanService;
import id.go.lan.pusaka.ikksurvey.service.KebijakanService;

@RestController
@RequestMapping("unggahdokumen")
public class FIleController {
	@Autowired
	KebijakanService kebijakanService;
	@Autowired
	AgendaSettingService agendaSettingService;

	@Autowired
	FormulasiKebijakanService formulasiKebijakanService;
	@Autowired
	ImplementasiKebijakanService implementasiKebijakanService;
	@Autowired
	EvaluasiKebijakanService evaluasiKebijakanService;

	@PostMapping("/agendasetting/a1A/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahA1A(@PathVariable("id") Long id, @RequestParam("fileA1A") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			AgendaSetting agendaSetting = kebijakan.getAgendaSetting();
			agendaSetting.setPathA1A(unggahUndangan(uploadfile, currentPrincipalName));
			agendaSettingService.save(agendaSetting);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/agendasetting/a1B/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahA1B(@PathVariable("id") Long id, @RequestParam("fileA1B") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			AgendaSetting agendaSetting = kebijakan.getAgendaSetting();
			agendaSetting.setPathA1B(unggahUndangan(uploadfile, currentPrincipalName));
			agendaSettingService.save(agendaSetting);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/agendasetting/a1C/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahA1C(@PathVariable("id") Long id, @RequestParam("fileA1C") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			AgendaSetting agendaSetting = kebijakan.getAgendaSetting();
			agendaSetting.setPathA1C(unggahUndangan(uploadfile, currentPrincipalName));
			agendaSettingService.save(agendaSetting);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/agendasetting/a1D/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahA1D(@PathVariable("id") Long id, @RequestParam("fileA1D") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			AgendaSetting agendaSetting = kebijakan.getAgendaSetting();
			agendaSetting.setPathA1D(unggahUndangan(uploadfile, currentPrincipalName));
			agendaSettingService.save(agendaSetting);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/agendasetting/a2A/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahA2A(@PathVariable("id") Long id, @RequestParam("fileA2A") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			AgendaSetting agendaSetting = kebijakan.getAgendaSetting();
			agendaSetting.setPathA2A(unggahUndangan(uploadfile, currentPrincipalName));
			agendaSettingService.save(agendaSetting);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/agendasetting/a2B/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahA2B(@PathVariable("id") Long id, @RequestParam("fileA2B") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			AgendaSetting agendaSetting = kebijakan.getAgendaSetting();
			agendaSetting.setPathA2B(unggahUndangan(uploadfile, currentPrincipalName));
			agendaSettingService.save(agendaSetting);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/agendasetting/a2C/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahA2C(@PathVariable("id") Long id, @RequestParam("fileA2C") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			AgendaSetting agendaSetting = kebijakan.getAgendaSetting();
			agendaSetting.setPathA2C(unggahUndangan(uploadfile, currentPrincipalName));
			agendaSettingService.save(agendaSetting);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/formulasikebijakan/b1A/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahB1A(@PathVariable("id") Long id, @RequestParam("fileB1A") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			FormulasiKebijakan formulasiKebijakan = kebijakan.getFormulasiKebijakan();
			formulasiKebijakan.setPathB1A(unggahUndangan(uploadfile, currentPrincipalName));
			formulasiKebijakanService.save(formulasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/formulasikebijakan/b1B/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahB1B(@PathVariable("id") Long id, @RequestParam("fileB1B") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			FormulasiKebijakan formulasiKebijakan = kebijakan.getFormulasiKebijakan();
			formulasiKebijakan.setPathB1B(unggahUndangan(uploadfile, currentPrincipalName));
			formulasiKebijakanService.save(formulasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/formulasikebijakan/b2A/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahB2A(@PathVariable("id") Long id, @RequestParam("fileB2A") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			FormulasiKebijakan formulasiKebijakan = kebijakan.getFormulasiKebijakan();
			formulasiKebijakan.setPathB2A(unggahUndangan(uploadfile, currentPrincipalName));
			formulasiKebijakanService.save(formulasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/formulasikebijakan/b2B/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahB2B(@PathVariable("id") Long id, @RequestParam("fileB2B") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			FormulasiKebijakan formulasiKebijakan = kebijakan.getFormulasiKebijakan();
			formulasiKebijakan.setPathB2B(unggahUndangan(uploadfile, currentPrincipalName));
			formulasiKebijakanService.save(formulasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/formulasikebijakan/b3A/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahB3A(@PathVariable("id") Long id, @RequestParam("fileB3A") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			FormulasiKebijakan formulasiKebijakan = kebijakan.getFormulasiKebijakan();
			formulasiKebijakan.setPathB3A(unggahUndangan(uploadfile, currentPrincipalName));
			formulasiKebijakanService.save(formulasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/formulasikebijakan/b3B/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahB3B(@PathVariable("id") Long id, @RequestParam("fileB3B") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			FormulasiKebijakan formulasiKebijakan = kebijakan.getFormulasiKebijakan();
			formulasiKebijakan.setPathB3B(unggahUndangan(uploadfile, currentPrincipalName));
			formulasiKebijakanService.save(formulasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/formulasikebijakan/b3C/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahB3C(@PathVariable("id") Long id, @RequestParam("fileB3C") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			FormulasiKebijakan formulasiKebijakan = kebijakan.getFormulasiKebijakan();
			formulasiKebijakan.setPathB3C(unggahUndangan(uploadfile, currentPrincipalName));
			formulasiKebijakanService.save(formulasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/formulasikebijakan/b4A/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahB4A(@PathVariable("id") Long id, @RequestParam("fileB4A") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			FormulasiKebijakan formulasiKebijakan = kebijakan.getFormulasiKebijakan();
			formulasiKebijakan.setPathB4A(unggahUndangan(uploadfile, currentPrincipalName));
			formulasiKebijakanService.save(formulasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/formulasikebijakan/b4B/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahB4B(@PathVariable("id") Long id, @RequestParam("fileB4B") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			FormulasiKebijakan formulasiKebijakan = kebijakan.getFormulasiKebijakan();
			formulasiKebijakan.setPathB4B(unggahUndangan(uploadfile, currentPrincipalName));
			formulasiKebijakanService.save(formulasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/formulasikebijakan/b4C/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahB4C(@PathVariable("id") Long id, @RequestParam("fileB4C") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			FormulasiKebijakan formulasiKebijakan = kebijakan.getFormulasiKebijakan();
			formulasiKebijakan.setPathB4C(unggahUndangan(uploadfile, currentPrincipalName));
			formulasiKebijakanService.save(formulasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/formulasikebijakan/b5A/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahB5A(@PathVariable("id") Long id, @RequestParam("fileB5A") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			FormulasiKebijakan formulasiKebijakan = kebijakan.getFormulasiKebijakan();
			formulasiKebijakan.setPathB5A(unggahUndangan(uploadfile, currentPrincipalName));
			formulasiKebijakanService.save(formulasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/formulasikebijakan/b5B/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahB5B(@PathVariable("id") Long id, @RequestParam("fileB5B") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			FormulasiKebijakan formulasiKebijakan = kebijakan.getFormulasiKebijakan();
			formulasiKebijakan.setPathB5B(unggahUndangan(uploadfile, currentPrincipalName));
			formulasiKebijakanService.save(formulasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/formulasikebijakan/b5C/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahB5C(@PathVariable("id") Long id, @RequestParam("fileB5C") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			FormulasiKebijakan formulasiKebijakan = kebijakan.getFormulasiKebijakan();
			formulasiKebijakan.setPathB5C(unggahUndangan(uploadfile, currentPrincipalName));
			formulasiKebijakanService.save(formulasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/implementasikebijakan/c1A/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahC1A(@PathVariable("id") Long id, @RequestParam("fileC1A") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			ImplementasiKebijakan implementasiKebijakan = kebijakan.getImplementasiKebijakan();
			implementasiKebijakan.setPathC1A(unggahUndangan(uploadfile, currentPrincipalName));
			implementasiKebijakanService.save(implementasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/implementasikebijakan/c1B/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahC1B(@PathVariable("id") Long id, @RequestParam("fileC1B") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			ImplementasiKebijakan implementasiKebijakan = kebijakan.getImplementasiKebijakan();
			implementasiKebijakan.setPathC1B(unggahUndangan(uploadfile, currentPrincipalName));
			implementasiKebijakanService.save(implementasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/implementasikebijakan/c1C/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahC1C(@PathVariable("id") Long id, @RequestParam("fileC1C") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			ImplementasiKebijakan implementasiKebijakan = kebijakan.getImplementasiKebijakan();
			implementasiKebijakan.setPathC1C(unggahUndangan(uploadfile, currentPrincipalName));
			implementasiKebijakanService.save(implementasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/implementasikebijakan/c1D/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahC1D(@PathVariable("id") Long id, @RequestParam("fileC1D") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			ImplementasiKebijakan implementasiKebijakan = kebijakan.getImplementasiKebijakan();
			implementasiKebijakan.setPathC1D(unggahUndangan(uploadfile, currentPrincipalName));
			implementasiKebijakanService.save(implementasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/implementasikebijakan/c2A/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahC2A(@PathVariable("id") Long id, @RequestParam("fileC2A") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			ImplementasiKebijakan implementasiKebijakan = kebijakan.getImplementasiKebijakan();
			implementasiKebijakan.setPathC2A(unggahUndangan(uploadfile, currentPrincipalName));
			implementasiKebijakanService.save(implementasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/implementasikebijakan/c2B/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahC2B(@PathVariable("id") Long id, @RequestParam("fileC2B") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			ImplementasiKebijakan implementasiKebijakan = kebijakan.getImplementasiKebijakan();
			implementasiKebijakan.setPathC2B(unggahUndangan(uploadfile, currentPrincipalName));
			implementasiKebijakanService.save(implementasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/implementasikebijakan/c2C/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahC2C(@PathVariable("id") Long id, @RequestParam("fileC2C") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			ImplementasiKebijakan implementasiKebijakan = kebijakan.getImplementasiKebijakan();
			implementasiKebijakan.setPathC2C(unggahUndangan(uploadfile, currentPrincipalName));
			implementasiKebijakanService.save(implementasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/implementasikebijakan/c3A/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahC3A(@PathVariable("id") Long id, @RequestParam("fileC3A") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			ImplementasiKebijakan implementasiKebijakan = kebijakan.getImplementasiKebijakan();
			implementasiKebijakan.setPathC3A(unggahUndangan(uploadfile, currentPrincipalName));
			implementasiKebijakanService.save(implementasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/implementasikebijakan/c3B/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahC3B(@PathVariable("id") Long id, @RequestParam("fileC3B") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			ImplementasiKebijakan implementasiKebijakan = kebijakan.getImplementasiKebijakan();
			implementasiKebijakan.setPathC3B(unggahUndangan(uploadfile, currentPrincipalName));
			implementasiKebijakanService.save(implementasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/implementasikebijakan/c3C/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahC3C(@PathVariable("id") Long id, @RequestParam("fileC3C") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			ImplementasiKebijakan implementasiKebijakan = kebijakan.getImplementasiKebijakan();
			implementasiKebijakan.setPathC3C(unggahUndangan(uploadfile, currentPrincipalName));
			implementasiKebijakanService.save(implementasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/evaluasikebijakan/d1A/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahD1A(@PathVariable("id") Long id, @RequestParam("fileD1A") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			EvaluasiKebijakan evaluasiKebijakan = kebijakan.getEvaluasiKebijakan();
			evaluasiKebijakan.setPathD1A(unggahUndangan(uploadfile, currentPrincipalName));
			evaluasiKebijakanService.save(evaluasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/evaluasikebijakan/d1B/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahD1B(@PathVariable("id") Long id, @RequestParam("fileD1B") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			EvaluasiKebijakan evaluasiKebijakan = kebijakan.getEvaluasiKebijakan();
			evaluasiKebijakan.setPathD1B(unggahUndangan(uploadfile, currentPrincipalName));
			evaluasiKebijakanService.save(evaluasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/evaluasikebijakan/d2A/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahD2A(@PathVariable("id") Long id, @RequestParam("fileD2A") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			EvaluasiKebijakan evaluasiKebijakan = kebijakan.getEvaluasiKebijakan();
			evaluasiKebijakan.setPathD2A(unggahUndangan(uploadfile, currentPrincipalName));
			evaluasiKebijakanService.save(evaluasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/evaluasikebijakan/d2B/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahD2B(@PathVariable("id") Long id, @RequestParam("fileD2B") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			EvaluasiKebijakan evaluasiKebijakan = kebijakan.getEvaluasiKebijakan();
			evaluasiKebijakan.setPathD2B(unggahUndangan(uploadfile, currentPrincipalName));
			evaluasiKebijakanService.save(evaluasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/evaluasikebijakan/d3A/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahD3A(@PathVariable("id") Long id, @RequestParam("fileD3A") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			EvaluasiKebijakan evaluasiKebijakan = kebijakan.getEvaluasiKebijakan();
			evaluasiKebijakan.setPathD3A(unggahUndangan(uploadfile, currentPrincipalName));
			evaluasiKebijakanService.save(evaluasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/evaluasikebijakan/d3B/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahD3B(@PathVariable("id") Long id, @RequestParam("fileD3B") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			EvaluasiKebijakan evaluasiKebijakan = kebijakan.getEvaluasiKebijakan();
			evaluasiKebijakan.setPathD3B(unggahUndangan(uploadfile, currentPrincipalName));
			evaluasiKebijakanService.save(evaluasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/evaluasikebijakan/d3C/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahD3C(@PathVariable("id") Long id, @RequestParam("fileD3C") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			EvaluasiKebijakan evaluasiKebijakan = kebijakan.getEvaluasiKebijakan();
			evaluasiKebijakan.setPathD3C(unggahUndangan(uploadfile, currentPrincipalName));
			evaluasiKebijakanService.save(evaluasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/evaluasikebijakan/d3D/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahD3D(@PathVariable("id") Long id, @RequestParam("fileD3D") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			EvaluasiKebijakan evaluasiKebijakan = kebijakan.getEvaluasiKebijakan();
			evaluasiKebijakan.setPathD3D(unggahUndangan(uploadfile, currentPrincipalName));
			evaluasiKebijakanService.save(evaluasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	@PostMapping("/evaluasikebijakan/d3E/{id}")
	@PreAuthorize("hasAnyAuthority('role_kld_enumerator')")
	public String unggahD3E(@PathVariable("id") Long id, @RequestParam("fileD3E") MultipartFile uploadfile)
			throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, id);
		try {
			EvaluasiKebijakan evaluasiKebijakan = kebijakan.getEvaluasiKebijakan();
			evaluasiKebijakan.setPathD3E(unggahUndangan(uploadfile, currentPrincipalName));
			evaluasiKebijakanService.save(evaluasiKebijakan);
			return "Berhasil";
		} catch (Exception e) {
			return "Gagal";
		}
	}

	private String unggahUndangan(MultipartFile uploadfile, String nip) {
		String filepath = "";
		if (uploadfile != null) {
			try {
				// Get the filename and build the local file path (be sure that the
				// application have write permissions on such directory)
				Date date = new Date(); // your date
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH) + 1;
				int day = cal.get(Calendar.DAY_OF_MONTH);

				String directory = "/opt/data/ikk/" + nip + "/" + year + "/" + month + "/" + day + "/";
				File directory2 = new File(directory);
				if (!directory2.exists()) {
					directory2.mkdirs();
				}

				String filename = UUID.randomUUID().toString() + uploadfile.getOriginalFilename().toString().substring(
						uploadfile.getOriginalFilename().toString().lastIndexOf("."),
						uploadfile.getOriginalFilename().toString().length());

				filepath = Paths.get(directory, filename).toString();

				// Save the file locally
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				stream.write(uploadfile.getBytes());
				stream.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		if (filepath.equals(""))

			return null;
		else
			return filepath;
	}

}
