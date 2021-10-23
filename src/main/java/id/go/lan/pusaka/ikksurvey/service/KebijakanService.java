package id.go.lan.pusaka.ikksurvey.service;

import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import id.go.lan.pusaka.ikksurvey.model.dto.KebijakanDto;
import id.go.lan.pusaka.ikksurvey.model.dto.SampleKebijakanDto;

import java.util.List;

public interface KebijakanService {

	Kebijakan save(Kebijakan kebijakan);

	void delete(Kebijakan kebijakan);

	List<Kebijakan> findAll();

	Kebijakan findById(Long id);

	Kebijakan findByEnumeratorAndId(String enumerator, Long id);

	Kebijakan findByInstansiAndId(String instansi, Long id);

	List<Kebijakan> findByInstansi(String instansi);
	
	List<Kebijakan> findByEnumerator(String enumerator);
  
  	List<Kebijakan> findByCreatedBy(String nip);

	SampleKebijakanDto findSampleKebijakanByInstansi(String instansi, String nip);

	SampleKebijakanDto addSampleKebijakanByInstansi(String instansi, String nip);

	KebijakanDto assignEnumeratorToKebijakan(String instansi, Long idKebijakan, String nipEnumerator);

	Integer countByCreateByAndIsSentByAdminEquals(String nip);

	List<Kebijakan> findByInstansiAndCreateByAndIsSentByAdminEquals(String instansi, String nip);

	List<Kebijakan> findByInstansiAndCreateByAndStatus(String instansi, String createBy, String status);
}
