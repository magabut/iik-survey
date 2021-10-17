package id.go.lan.pusaka.ikksurvey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.go.lan.pusaka.ikksurvey.model.ImplementasiKebijakan;
import id.go.lan.pusaka.ikksurvey.repository.ImplementasiKebijakanRepository;
import id.go.lan.pusaka.ikksurvey.service.ImplementasiKebijakanService;

@Service
public class ImplementasiKebijakanServiceImpl implements ImplementasiKebijakanService {
	@Autowired
	ImplementasiKebijakanRepository implementasiKebijakanRepository;

	@Override
	public ImplementasiKebijakan save(ImplementasiKebijakan implementasiKebijakan) {
		// TODO Auto-generated method stub
		return implementasiKebijakanRepository.save(implementasiKebijakan);
	}

	@Override
	public ImplementasiKebijakan findById(Long id) {
		// TODO Auto-generated method stub
		return implementasiKebijakanRepository.findById(id).orElse(null);
	}

}
