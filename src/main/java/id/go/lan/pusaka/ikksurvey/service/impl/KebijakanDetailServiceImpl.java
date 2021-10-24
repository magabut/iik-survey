package id.go.lan.pusaka.ikksurvey.service.impl;

import id.go.lan.pusaka.ikksurvey.model.KebijakanDetail;
import id.go.lan.pusaka.ikksurvey.repository.KebijakanDetailRepository;
import id.go.lan.pusaka.ikksurvey.service.KebijakanDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KebijakanDetailServiceImpl implements KebijakanDetailService {
    @Autowired
    private KebijakanDetailRepository kebijakanDetailRepository;

    @Override
    public KebijakanDetail save(KebijakanDetail kebijakanDetail) {
        return kebijakanDetailRepository.save(kebijakanDetail);
    }
}
