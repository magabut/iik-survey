package id.go.lan.pusaka.ikksurvey.service;

import id.go.lan.pusaka.ikksurvey.model.EvaluasiKebijakan;

public interface EvaluasiKebijakanService {
	public EvaluasiKebijakan save(EvaluasiKebijakan evaluasiKebijakan);

	public EvaluasiKebijakan findById(Long id);
}
