package id.go.lan.pusaka.ikksurvey.service;

import id.go.lan.pusaka.ikksurvey.model.DataKebijakan;

public interface DataKebijakanService {
    DataKebijakan findDataKebijakanByNipAdminInstansi(String nip);
    void save(DataKebijakan dataKebijakan);
    Boolean isExists(String nip);
}
