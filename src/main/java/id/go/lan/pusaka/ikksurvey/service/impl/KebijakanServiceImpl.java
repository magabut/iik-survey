package id.go.lan.pusaka.ikksurvey.service.impl;

import id.go.lan.pusaka.ikksurvey.exception.ResourceNotFoundException;
import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import id.go.lan.pusaka.ikksurvey.model.RandomizedKebijakan;
import id.go.lan.pusaka.ikksurvey.model.dto.KebijakanDto;
import id.go.lan.pusaka.ikksurvey.model.dto.SampleKebijakanDto;
import id.go.lan.pusaka.ikksurvey.repository.KebijakanRepository;
import id.go.lan.pusaka.ikksurvey.service.DataKebijakanService;
import id.go.lan.pusaka.ikksurvey.service.KebijakanService;
import id.go.lan.pusaka.ikksurvey.service.RandomizedKebijakanService;
import id.go.lan.pusaka.ikksurvey.utility.ModelMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class KebijakanServiceImpl implements KebijakanService {
	private static final String STATUS_KEBIJAKAN_DIAJUKAN = "diajukan";
	private static final String STATUS_KEBIJAKAN_DISETUJUI = "disetujui";
	private static final String STATUS_KEBIJAKAN_PROSES = "proses";
	private static final String STATUS_KEBIJAKAN_SELESAI = "selesai";
	private static final String STATUS_KEBIJAKAN_DITOLAK = "ditolak";

	@Autowired
	private ModelMapperUtility modelMapperUtility;

	@Autowired
	KebijakanRepository kebijakanRepository;

	@Autowired
	RandomizedKebijakanService randomizedKebijakanService;

	@Autowired
	DataKebijakanService dataKebijakanService;

	@Override
	public Kebijakan save(Kebijakan kebijakan) {
		// TODO Auto-generated method stub
		return kebijakanRepository.save(kebijakan);
	}

	@Override
	public void delete(Kebijakan kebijakan) {
		kebijakanRepository.delete(kebijakan);
	}

	@Override
	public List<Kebijakan> findAll() {
		// TODO Auto-generated method stub
		return kebijakanRepository.findAll();
	}

	@Override
	public Kebijakan findById(Long id) {
		return kebijakanRepository.findById(id)
				.orElseThrow(RuntimeException::new);
	}

	@Override
	public Kebijakan findByEnumeratorAndId(String enumerator, Long id) {
		// TODO Auto-generated method stub
		return kebijakanRepository.findByEnumeratorAndId(enumerator, id);
	}

	@Override
	public Kebijakan findByInstansiAndId(String instansi, Long id) {
		// TODO Auto-generated method stub
		return kebijakanRepository.findByInstansiAndId(instansi, id);
	}

	@Override
	public List<Kebijakan> findByInstansi(String instansi) {
		// TODO Auto-generated method stub
		return kebijakanRepository.findByInstansi(instansi);
	}

	@Override
	public List<Kebijakan> findByEnumerator(String enumerator) {
		// TODO Auto-generated method stub
		return kebijakanRepository.findByEnumerator(enumerator);
	}

	@Override
  public List<Kebijakan> findByCreatedBy(String nip) {
		return kebijakanRepository.findByCreateBy(nip);
  }

  @Override
	public SampleKebijakanDto findSampleKebijakanByInstansi(String instansi, String nip) {

		int totalKebijakanDisetujui = dataKebijakanService.findDataKebijakanByNipAdminInstansi(nip).getKebijakanDisetujui();
	  	int totalKebijakanDiajukan = dataKebijakanService.findDataKebijakanByNipAdminInstansi(nip).getKebijakanDiajukan();

	  	List<KebijakanDto> kebijakanSampleDtoList = new ArrayList<>();
	  	if (!randomizedKebijakanService.countByNipAdminInstansi(nip).equals(0)) {
			if (totalKebijakanDisetujui != 0) {
				List<Kebijakan> kebijakanSampleList = new ArrayList<>();
				List<RandomizedKebijakan> randomizedKebijakanList = randomizedKebijakanService.findByNipAdminInstansi(nip);
				for (RandomizedKebijakan randomizedKebijakan : randomizedKebijakanList) {
					Kebijakan kebijakan = kebijakanRepository.findById(randomizedKebijakan.getIdKebijakan())
							.orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
					KebijakanDto kebijakanDto = modelMapperUtility.initialize().map(kebijakan, KebijakanDto.class);
					kebijakanSampleList.add(kebijakan);
					kebijakanSampleDtoList.add(kebijakanDto);
				}

				return new SampleKebijakanDto(
						totalKebijakanDiajukan,
						totalKebijakanDisetujui,
						kebijakanSampleList.size(),
						true,
						kebijakanSampleDtoList);
			}
		}

		return new SampleKebijakanDto(
				totalKebijakanDiajukan,
				totalKebijakanDisetujui,
				0,
				false,
				kebijakanSampleDtoList);
	}

	@Override
	public SampleKebijakanDto addSampleKebijakanByInstansi(String instansi, String nip) {

		List<Kebijakan> kebijakanDiajukanList = kebijakanRepository.findByInstansiAndIsSentByAdmin(instansi, true);
		List<Kebijakan> kebijakanDisetujuiList = kebijakanRepository.findByInstansiAndStatus(instansi, STATUS_KEBIJAKAN_DISETUJUI);

		int totalKebijakanDisetujui = kebijakanDisetujuiList.size();
		int totalKebijakanDiajukan = kebijakanDiajukanList.size();

		List<KebijakanDto> kebijakanSampleDtoList = new ArrayList<>();
		if (randomizedKebijakanService.countByNipAdminInstansi(nip).equals(0)) {
			List<Kebijakan> kebijakanSampleList = generateKebijakanSample(kebijakanDisetujuiList);
			for (Kebijakan kebijakan : kebijakanSampleList) {
				KebijakanDto kebijakanDto = modelMapperUtility.initialize().map(kebijakan, KebijakanDto.class);
				kebijakanSampleDtoList.add(kebijakanDto);

				RandomizedKebijakan randomizedKebijakan = new RandomizedKebijakan();
				randomizedKebijakan.setIdKebijakan(kebijakan.getId());
				randomizedKebijakan.setNipAdminInstansi(kebijakan.getCreateBy());
				randomizedKebijakanService.save(randomizedKebijakan);
			}

			return new SampleKebijakanDto(
					totalKebijakanDiajukan,
					totalKebijakanDisetujui,
					kebijakanSampleList.size(),
					true,
					kebijakanSampleDtoList);
		}
		return null;
	}

	@Override
	public KebijakanDto assignEnumeratorToKebijakan(String instansi, Long idKebijakan, String nipEnumerator) {
		Kebijakan kebijakan = kebijakanRepository.findByInstansiAndId(instansi, idKebijakan);
		kebijakan.setEnumerator(nipEnumerator);
		kebijakan.setStatus(STATUS_KEBIJAKAN_DISETUJUI);
		kebijakan.setAssignAt(new Date());
		Kebijakan savedKebijakan = kebijakanRepository.save(kebijakan);
		return modelMapperUtility.initialize().map(savedKebijakan, KebijakanDto.class);
	}

	@Override
	public Integer countByCreateByAndIsSentByAdminEquals(String nip) {
		kebijakanRepository.countByCreateByAndIsSentByAdminEquals(nip, true);
		return kebijakanRepository.countByCreateByAndIsSentByAdminEquals(nip, true);
	}

	@Override
	public List<Kebijakan> findByInstansiAndCreateByAndIsSentByAdminEquals(String instansi, String nip) {
		return kebijakanRepository.findByInstansiAndCreateByAndIsSentByAdminEquals(instansi, nip, true);
	}

	@Override
	public List<Kebijakan> findByInstansiAndCreateByAndStatus(String instansi, String createBy, String status) {
		return kebijakanRepository.findByInstansiAndCreateByAndStatus(instansi, createBy, status);
	}

	private List<Kebijakan> generateKebijakanSample(List<Kebijakan> kebijakanList) {
		int totalKebijakan = kebijakanList.size();
		int totalSample = (int) Math.floor(Math.sqrt(totalKebijakan) + 1);

		Random random = new Random();
		List<Kebijakan> generatedKebijakanSample = new ArrayList<>();
		for (int i = 0; i < totalSample; i++) {
			int randomIndex = random.nextInt(kebijakanList.size());
			generatedKebijakanSample.add(kebijakanList.get(randomIndex));
			kebijakanList.remove(randomIndex);
		}

		return generatedKebijakanSample;
	}
}
