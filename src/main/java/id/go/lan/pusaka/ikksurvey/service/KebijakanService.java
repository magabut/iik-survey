package id.go.lan.pusaka.ikksurvey.service;

import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import id.go.lan.pusaka.ikksurvey.model.dto.KebijakanDto;
import id.go.lan.pusaka.ikksurvey.model.dto.SampleKebijakanDto;

import java.util.List;

public interface KebijakanService {

	public Kebijakan save(Kebijakan kebijakan);

	List<Kebijakan> findAll();

	Kebijakan findById(Long id);

	Kebijakan findByEnumeratorAndId(String enumerator, Long id);

	Kebijakan findByInstansiAndId(String instansi, Long id);

	List<Kebijakan> findByInstansi(String instansi);
	
	List<Kebijakan> findByEnumerator(String enumerator);
  
  List<Kebijakan> findByCreatedBy(String nip);

	SampleKebijakanDto findSampleKebijakanByInstansi(String instansi);

	KebijakanDto assignEnumeratorToKebijakan(String instansi, Long idKebijakan, String nipEnumerator);
}
