package id.go.lan.pusaka.ikksurvey.service;

import id.go.lan.pusaka.ikksurvey.model.StatusKebijakan;

public interface StatusKebijakanService {
	StatusKebijakan findByInstansi(String instansi);

	StatusKebijakan save(StatusKebijakan statusKebijakan);
}
