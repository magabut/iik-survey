package id.go.lan.pusaka.ikksurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.go.lan.pusaka.ikksurvey.model.StatusKebijakan;

public interface StatusKebijakanRepository extends JpaRepository<StatusKebijakan, Long> {
	StatusKebijakan findByInstansi(String instansi);
}
