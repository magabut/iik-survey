package id.go.lan.pusaka.ikksurvey.repository;

import id.go.lan.pusaka.ikksurvey.model.DataKebijakan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataKebijakanRepository extends JpaRepository<DataKebijakan, Long> {
    DataKebijakan findDataKebijakanByNipAdminInstansi(String nipAdminInstansi);
    List<DataKebijakan> findDataKebijakansByNipKoordinatorInstansi(String nipKoordinatorInstansi);
}
