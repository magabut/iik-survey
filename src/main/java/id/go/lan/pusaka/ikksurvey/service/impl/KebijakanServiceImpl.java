package id.go.lan.pusaka.ikksurvey.service.impl;

import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import id.go.lan.pusaka.ikksurvey.model.dto.KebijakanDto;
import id.go.lan.pusaka.ikksurvey.model.dto.SampleKebijakanDto;
import id.go.lan.pusaka.ikksurvey.repository.KebijakanRepository;
import id.go.lan.pusaka.ikksurvey.service.KebijakanService;
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

	@Override
	public Kebijakan save(Kebijakan kebijakan) {
		// TODO Auto-generated method stub
		return kebijakanRepository.save(kebijakan);
	}

	@Override
	public Kebijakan delete(Kebijakan kebijakan) {
		kebijakanRepository.delete(kebijakan);
		return kebijakan;
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
	public SampleKebijakanDto findSampleKebijakanByInstansi(String instansi) {
		List<Kebijakan> kebijakanDiajukanList = kebijakanRepository.findByInstansiAndStatus(instansi, STATUS_KEBIJAKAN_DIAJUKAN);
		List<Kebijakan> kebijakanDisetujuiList = kebijakanRepository.findByInstansiAndStatus(instansi, STATUS_KEBIJAKAN_DISETUJUI);
		List<Kebijakan> kebijakanDitolakList = kebijakanRepository.findByInstansiAndStatus(instansi, STATUS_KEBIJAKAN_DITOLAK);

		int totalKebijakanDisetujui = kebijakanDisetujuiList.size();
		int totalKebijakanDitolak = kebijakanDitolakList.size();
	  	int totalKebijakanDiajukan = kebijakanDiajukanList.size();

	  	List<KebijakanDto> kebijakanSampleDtoList = new ArrayList<>();
	  	if (kebijakanDisetujuiList.size() != 0) {
			List<Kebijakan> kebijakanSampleList = generateKebijakanSample(kebijakanDisetujuiList);
			for (Kebijakan kebijakan : kebijakanSampleList) {
				KebijakanDto kebijakanDto = modelMapperUtility.initialize().map(kebijakan, KebijakanDto.class);
				kebijakanSampleDtoList.add(kebijakanDto);
			}

			return new SampleKebijakanDto(
					totalKebijakanDiajukan,
					totalKebijakanDisetujui,
					kebijakanSampleList.size(),
					kebijakanSampleDtoList);
		}
		  return new SampleKebijakanDto(
				  totalKebijakanDiajukan,
				  totalKebijakanDisetujui,
				  0,
				  kebijakanSampleDtoList);
	}

	@Override
	public KebijakanDto assignEnumeratorToKebijakan(String instansi, Long idKebijakan, String nipEnumerator) {
		Kebijakan kebijakan = kebijakanRepository.findByInstansiAndId(instansi, idKebijakan);
		kebijakan.setEnumerator(nipEnumerator);
		kebijakan.setStatus(STATUS_KEBIJAKAN_PROSES);
		Kebijakan savedKebijakan = kebijakanRepository.save(kebijakan);
		return modelMapperUtility.initialize().map(savedKebijakan, KebijakanDto.class);
	}

	@Override
	public Integer countByCreateBy(String nip) {
		if (kebijakanRepository.countByCreateBy(nip).equals(null)) {
			return 0;
		} else {
			return kebijakanRepository.countByCreateBy(nip);
		}
	}

	@Override
	public Kebijakan findTopByCreateBy(String nip) {
		return kebijakanRepository.findTopByCreateBy(nip);
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
