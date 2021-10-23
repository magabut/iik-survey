package id.go.lan.pusaka.ikksurvey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.go.lan.pusaka.ikksurvey.model.StatusKebijakan;
import id.go.lan.pusaka.ikksurvey.repository.StatusKebijakanRepository;
import id.go.lan.pusaka.ikksurvey.service.StatusKebijakanService;

@Service
public class StatsuKebijakanService implements StatusKebijakanService {

	@Autowired
	StatusKebijakanRepository statusKebijakanRepository;

	@Override
	public StatusKebijakan findByInstansi(String instansi) {
		// TODO Auto-generated method stub
		return statusKebijakanRepository.findByInstansi(instansi);
	}

	@Override
	public StatusKebijakan save(StatusKebijakan statusKebijakan) {
		// TODO Auto-generated method stub
		return statusKebijakanRepository.save(statusKebijakan);
	}

}
