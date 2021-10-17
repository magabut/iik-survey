package id.go.lan.pusaka.ikksurvey.service;

import java.util.List;

import id.go.lan.pusaka.ikksurvey.model.Kebijakan;

public interface KebijakanService {

	public Kebijakan save(Kebijakan kebijakan);

	List<Kebijakan> findAll();

	Kebijakan findByEnumeratorAndId(String enumerator, Long id);

	Kebijakan findByInstansiAndId(String instansi, Long id);

	List<Kebijakan> findByInstansi(String instansi);
	
	List<Kebijakan> findByEnumerator(String enumerator);
}
