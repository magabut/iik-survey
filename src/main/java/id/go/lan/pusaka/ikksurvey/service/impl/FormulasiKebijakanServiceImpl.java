package id.go.lan.pusaka.ikksurvey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.go.lan.pusaka.ikksurvey.model.FormulasiKebijakan;
import id.go.lan.pusaka.ikksurvey.repository.FormulasiKebijakanRepository;
import id.go.lan.pusaka.ikksurvey.service.FormulasiKebijakanService;

@Service
public class FormulasiKebijakanServiceImpl implements FormulasiKebijakanService {
	@Autowired
	FormulasiKebijakanRepository formulasiKebijakanRepository;

	@Override
	public FormulasiKebijakan save(FormulasiKebijakan formulasiKebijakan) {
		// TODO Auto-generated method stub
		return formulasiKebijakanRepository.save(formulasiKebijakan);
	}

	@Override
	public FormulasiKebijakan findById(Long id) {
		// TODO Auto-generated method stub
		return formulasiKebijakanRepository.findById(id).orElse(null);
	}

}
