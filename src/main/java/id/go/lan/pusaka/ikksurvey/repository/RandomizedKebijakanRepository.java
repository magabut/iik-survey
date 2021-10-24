package id.go.lan.pusaka.ikksurvey.repository;

import id.go.lan.pusaka.ikksurvey.model.RandomizedKebijakan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RandomizedKebijakanRepository extends JpaRepository<RandomizedKebijakan, Long> {
    Integer countByNipAdminInstansi(String nipAdminInstansi);
    void deleteAllByNipAdminInstansi(String nipAdminInstansi);
    List<RandomizedKebijakan> findByNipAdminInstansi(String nipAdminInstansi);
}
