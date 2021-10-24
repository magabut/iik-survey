package id.go.lan.pusaka.ikksurvey.repository;

import id.go.lan.pusaka.ikksurvey.model.KebijakanDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KebijakanDetailRepository extends JpaRepository<KebijakanDetail, Long> {

}
