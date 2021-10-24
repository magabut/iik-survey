package id.go.lan.pusaka.ikksurvey.service;

import id.go.lan.pusaka.ikksurvey.model.DataKebijakan;

import java.util.List;

public interface DataKebijakanService {
    DataKebijakan findDataKebijakanByNipAdminInstansi(String nip);
    List<DataKebijakan> findDataKebijakansByNipAdminKoordinatorInstansi(String nip);
    void save(DataKebijakan dataKebijakan);
    Boolean isExists(String nip);
}
