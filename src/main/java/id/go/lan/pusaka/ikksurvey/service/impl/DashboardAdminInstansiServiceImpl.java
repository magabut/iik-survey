package id.go.lan.pusaka.ikksurvey.service.impl;

import id.go.lan.pusaka.ikksurvey.model.DataKebijakan;
import id.go.lan.pusaka.ikksurvey.model.dto.dashboard.DashboardAdminInstansiCardDto;
import id.go.lan.pusaka.ikksurvey.service.DashboardAdminInstansiService;
import id.go.lan.pusaka.ikksurvey.service.DataKebijakanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class DashboardAdminInstansiServiceImpl implements DashboardAdminInstansiService {

    @Autowired
    private DataKebijakanService dataKebijakanService;

    @Override
    public DashboardAdminInstansiCardDto getAdminInstansiDashboardCardData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String nip = authentication.getName();

        DataKebijakan dataKebijakan = dataKebijakanService.findDataKebijakanByNipAdminInstansi(nip);

        Integer totalKebijakanDiajukan = dataKebijakan.getKebijakanDiajukan();
        Integer totalKebijakanDisetujui = dataKebijakan.getKebijakanDisetujui();
        Integer totalKebijakanDitolak = dataKebijakan.getKebijakanDitolak();

        DashboardAdminInstansiCardDto dashboardAdminInstansiCardDto = new DashboardAdminInstansiCardDto();

        dashboardAdminInstansiCardDto.setKebijakanDiajukan(totalKebijakanDiajukan);
        dashboardAdminInstansiCardDto.setKebijakanDisetujui(totalKebijakanDisetujui);
        dashboardAdminInstansiCardDto.setKebijakanDitolak(totalKebijakanDitolak);
        return dashboardAdminInstansiCardDto;
    }
}
