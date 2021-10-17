package id.go.lan.pusaka.ikksurvey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.go.lan.pusaka.ikksurvey.model.EvaluasiKebijakan;
import id.go.lan.pusaka.ikksurvey.repository.EvaluasiKebijakanRepository;
import id.go.lan.pusaka.ikksurvey.service.EvaluasiKebijakanService;

@Service
public class EvaluasiKebijakanServiceImpl implements EvaluasiKebijakanService {
	@Autowired
	EvaluasiKebijakanRepository evaluasiKebijakanRepository;

	@Override
	public EvaluasiKebijakan save(EvaluasiKebijakan evaluasiKebijakan) {
		// TODO Auto-generated method stub
		return evaluasiKebijakanRepository.save(evaluasiKebijakan);
	}

	@Override
	public EvaluasiKebijakan findById(Long id) {
		// TODO Auto-generated method stub
		return evaluasiKebijakanRepository.findById(id).orElse(null);
	}

}
