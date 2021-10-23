package id.go.lan.pusaka.ikksurvey.service;

import id.go.lan.pusaka.ikksurvey.model.RandomizedKebijakan;

public interface RandomizedKebijakanService {
    void save(RandomizedKebijakan randomizedKebijakan);
    void deleteAllByNipAdminInstansi(String nipAdminInstansi);
    Integer countByNipAdminInstansi(String nipAdminInstansi);
}
