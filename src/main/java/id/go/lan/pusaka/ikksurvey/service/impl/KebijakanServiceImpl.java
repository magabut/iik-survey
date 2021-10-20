package id.go.lan.pusaka.ikksurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import id.go.lan.pusaka.ikksurvey.repository.KebijakanRepository;
import id.go.lan.pusaka.ikksurvey.service.KebijakanService;

@Service
public class KebijakanServiceImpl implements KebijakanService {
	@Autowired
	KebijakanRepository kebijakanRepository;

	@Override
	public Kebijakan save(Kebijakan kebijakan) {
		// TODO Auto-generated method stub
		return kebijakanRepository.save(kebijakan);
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

}
