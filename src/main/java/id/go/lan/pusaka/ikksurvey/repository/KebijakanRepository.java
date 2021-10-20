package id.go.lan.pusaka.ikksurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import java.util.List;

public interface KebijakanRepository extends JpaRepository<Kebijakan, Long> {
	List<Kebijakan> findByInstansi(String instansi);

	List<Kebijakan> findByInstansiAndEnumerator(String instansi, String enermurator);

	Kebijakan findByEnumeratorAndId(String enumerator, Long id);

	Kebijakan findByInstansiAndId(String instansi, Long id);

	List<Kebijakan> findByEnumerator(String enumerator);

	List<Kebijakan> findByInstansiAndStatus(String instansi, String status);

	List<Kebijakan> findByCreateBy(String nip);
}
