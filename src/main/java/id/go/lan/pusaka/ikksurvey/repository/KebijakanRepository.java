package id.go.lan.pusaka.ikksurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.go.lan.pusaka.ikksurvey.model.Kebijakan;

import java.util.Date;
import java.util.List;

public interface KebijakanRepository extends JpaRepository<Kebijakan, Long> {
	List<Kebijakan> findByInstansi(String instansi);

	List<Kebijakan> findByInstansiAndEnumerator(String instansi, String enermurator);

	Kebijakan findByEnumeratorAndId(String enumerator, Long id);

	Kebijakan findByInstansiAndId(String instansi, Long id);

	List<Kebijakan> findByEnumerator(String enumerator);

	List<Kebijakan> findByInstansiAndStatus(String instansi, String status);

	List<Kebijakan> findByInstansiAndCreateByAndStatus(String instansi, String createBy, String status);

	List<Kebijakan> findByInstansiAndCreateByAndIsSentByAdminEquals(String instansi, String createBy, Boolean isSentByAdmin);

	List<Kebijakan> findByCreateBy(String nip);

	List<Kebijakan> findByInstansiAndIsSentByAdmin(String instansi, Boolean isSentByAdmin);

	Integer countByCreateByAndIsSentByAdminEquals(String createBy, Boolean isSentByAdmin);

	Kebijakan findTopByCreateBy(String nip);

	List<Kebijakan> findByEnumeratorAndStatus(String enumerator, String status);

	Integer countByCreateByAndStatusAndIsSentByAdmin(String createBy, String status, Boolean isSentByAdmin);
}
