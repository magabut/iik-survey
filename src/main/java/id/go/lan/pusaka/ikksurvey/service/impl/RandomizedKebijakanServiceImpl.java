package id.go.lan.pusaka.ikksurvey.service.impl;

import id.go.lan.pusaka.ikksurvey.model.RandomizedKebijakan;
import id.go.lan.pusaka.ikksurvey.repository.RandomizedKebijakanRepository;
import id.go.lan.pusaka.ikksurvey.service.RandomizedKebijakanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomizedKebijakanServiceImpl implements RandomizedKebijakanService {

    @Autowired
    private RandomizedKebijakanRepository randomizedKebijakanRepository;

    @Override
    public void save(RandomizedKebijakan randomizedKebijakan) {
        randomizedKebijakanRepository.save(randomizedKebijakan);
    }

    @Override
    public void deleteAllByNipAdminInstansi(String nipAdminInstansi) {
        randomizedKebijakanRepository.deleteAllByNipAdminInstansi(nipAdminInstansi);
    }

    @Override
    public Integer countByNipAdminInstansi(String nipAdminInstansi) {
        return randomizedKebijakanRepository.countByNipAdminInstansi(nipAdminInstansi);
    }
}
