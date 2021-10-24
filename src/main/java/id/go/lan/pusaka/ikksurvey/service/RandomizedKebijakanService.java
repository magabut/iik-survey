package id.go.lan.pusaka.ikksurvey.service;

import id.go.lan.pusaka.ikksurvey.model.RandomizedKebijakan;

import java.util.List;

public interface RandomizedKebijakanService {
    void save(RandomizedKebijakan randomizedKebijakan);
    void deleteAllByNipAdminInstansi(String nipAdminInstansi);
    Integer countByNipAdminInstansi(String nipAdminInstansi);
    List<RandomizedKebijakan> findByNipAdminInstansi(String nipAdminInstansi);
}
