package id.go.lan.pusaka.ikksurvey.service;

import id.go.lan.pusaka.ikksurvey.model.ImplementasiKebijakan;

public interface ImplementasiKebijakanService {
	public ImplementasiKebijakan save(ImplementasiKebijakan implementasiKebijakan);

	public ImplementasiKebijakan findById(Long id);
}
