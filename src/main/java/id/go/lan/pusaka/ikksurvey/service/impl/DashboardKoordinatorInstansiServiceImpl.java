package id.go.lan.pusaka.ikksurvey.service.impl;

import id.go.lan.pusaka.ikksurvey.model.dto.dashboard.DashboardAdminInstansiCardDto;
import id.go.lan.pusaka.ikksurvey.repository.KebijakanRepository;
import id.go.lan.pusaka.ikksurvey.service.DashboardKoordinatorInstansiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardKoordinatorInstansiServiceImpl implements DashboardKoordinatorInstansiService {
    @Autowired
    private KebijakanRepository kebijakanRepository;

    @Override
    public DashboardAdminInstansiCardDto getKoordinatorInstansiDashboardCardData() {
        return null;
    }
}
