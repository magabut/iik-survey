package id.go.lan.pusaka.ikksurvey.service.impl;

import id.go.lan.pusaka.ikksurvey.model.dto.dashboard.DashboardAdminInstansiCardDto;
import id.go.lan.pusaka.ikksurvey.repository.KebijakanRepository;
import id.go.lan.pusaka.ikksurvey.service.DashboardAdminInstansiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class DashboardAdminInstansiServiceImpl implements DashboardAdminInstansiService {

    @Autowired
    private KebijakanRepository kebijakanRepository;

    @Override
    public DashboardAdminInstansiCardDto getAdminInstansiDashboardCardData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String nip = authentication.getName();

        Integer totalKebijakanDiajukan = kebijakanRepository.countByCreateByAndIsSentByAdminEquals(nip, true);
        Integer totalKebijakanDisetujui = kebijakanRepository.countByCreateByAndStatusAndIsSentByAdmin(nip, "disetujui", true);
        Integer totalKebijakanDitolak = kebijakanRepository.countByCreateByAndStatusAndIsSentByAdmin(nip, "ditolak", true);

        DashboardAdminInstansiCardDto dashboardAdminInstansiCardDto = new DashboardAdminInstansiCardDto();

        dashboardAdminInstansiCardDto.setKebijakanDiajukan(totalKebijakanDiajukan);
        dashboardAdminInstansiCardDto.setKebijakanDisetujui(totalKebijakanDisetujui);
        dashboardAdminInstansiCardDto.setKebijakanDitolak(totalKebijakanDitolak);
        return dashboardAdminInstansiCardDto;
    }
}
