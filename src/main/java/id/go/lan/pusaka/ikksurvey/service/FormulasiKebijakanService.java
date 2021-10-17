package id.go.lan.pusaka.ikksurvey.service;

import id.go.lan.pusaka.ikksurvey.model.FormulasiKebijakan;

public interface FormulasiKebijakanService {
	public FormulasiKebijakan save(FormulasiKebijakan formulasiKebijakan);

	public FormulasiKebijakan findById(Long id);
}
