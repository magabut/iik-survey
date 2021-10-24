package id.go.lan.pusaka.ikksurvey.service.impl;

import id.go.lan.pusaka.ikksurvey.model.DataKebijakan;
import id.go.lan.pusaka.ikksurvey.model.dto.dashboard.DashboardAdminInstansiCardDto;
import id.go.lan.pusaka.ikksurvey.model.dto.dashboard.DashboardKoordinatorInstansiCardDto;
import id.go.lan.pusaka.ikksurvey.repository.KebijakanRepository;
import id.go.lan.pusaka.ikksurvey.service.DashboardKoordinatorInstansiService;
import id.go.lan.pusaka.ikksurvey.service.DataKebijakanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardKoordinatorInstansiServiceImpl implements DashboardKoordinatorInstansiService {

    @Autowired
    private DataKebijakanService dataKebijakanService;

    @Override
    public DashboardKoordinatorInstansiCardDto getKoordinatorInstansiDashboardCardData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String nip = authentication.getName();

        DashboardKoordinatorInstansiCardDto dashboardKoordinatorInstansiCardDto = new DashboardKoordinatorInstansiCardDto();

        Integer kebijakanMasuk = 0;
        Integer kebijakanDiproses = 0;
        Integer kebijakanSelesai = 0;
        Integer kebijakanDitolak = 0;

        List<DataKebijakan> dataKebijakanList = dataKebijakanService.findDataKebijakansByNipAdminKoordinatorInstansi(nip);

        for (DataKebijakan dataKebijakan : dataKebijakanList) {
            if (dataKebijakan.getSentByAdminAt() != null) {
                kebijakanMasuk += dataKebijakan.getKebijakanDiajukan();
                kebijakanDiproses += dataKebijakan.getKebijakanDiproses();
                kebijakanDitolak += dataKebijakan.getKebijakanDitolak();
                kebijakanSelesai += dataKebijakan.getKebijakanSelesai();
            }
        }

        dashboardKoordinatorInstansiCardDto.setKebijakanMasuk(kebijakanMasuk);
        dashboardKoordinatorInstansiCardDto.setKebijakanDiproses(kebijakanDiproses);
        dashboardKoordinatorInstansiCardDto.setKebijakanSelesai(kebijakanSelesai);
        dashboardKoordinatorInstansiCardDto.setKebijakanDitolak(kebijakanDitolak);

        return dashboardKoordinatorInstansiCardDto;
    }
}
