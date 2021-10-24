package id.go.lan.pusaka.ikksurvey.service.impl;

import id.go.lan.pusaka.ikksurvey.model.DataKebijakan;
import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import id.go.lan.pusaka.ikksurvey.repository.DataKebijakanRepository;
import id.go.lan.pusaka.ikksurvey.service.DataKebijakanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataKebijakanServiceImpl implements DataKebijakanService {

    @Autowired
    private DataKebijakanRepository dataKebijakanRepository;

    @Override
    public DataKebijakan findDataKebijakanByNipAdminInstansi(String nip) {
        return dataKebijakanRepository.findDataKebijakanByNipAdminInstansi(nip);
    }

    @Override
    public void save(DataKebijakan dataKebijakan) {
        dataKebijakanRepository.save(dataKebijakan);
    }

    @Override
    public Boolean isExists(String nip) {
        return dataKebijakanRepository.existsById(findDataKebijakanByNipAdminInstansi(nip).getId());
    }
}
