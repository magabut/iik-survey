package id.go.lan.pusaka.ikksurvey.controller;

import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import id.go.lan.pusaka.ikksurvey.model.dto.KebijakanDto;
import id.go.lan.pusaka.ikksurvey.service.KebijakanService;
import id.go.lan.pusaka.ikksurvey.utility.ModelMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/kebijakan")
public class EnumeratorController {
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private KebijakanService kebijakanService;

    @GetMapping("/enumerator/dashboard/{idKebijakan}")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public KebijakanDto findKebijakanByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan) {
        Kebijakan kebijakan = kebijakanService.findById(idKebijakan);
        KebijakanDto kebijakanDto = modelMapperUtility.initialize().map(kebijakan, KebijakanDto.class);

        Double progres = BigDecimal.valueOf(kebijakan.getKebijakanDetail().getProgres())
                .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                .doubleValue();

        kebijakanDto.setProgres(progres);
        return kebijakanDto;
    }

    @GetMapping("/enumerator/dashboard/masuk")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public List<KebijakanDto> findKebijakanByEnumeratorAndStatusDisetujui() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        List<Kebijakan> kebijakanList = kebijakanService.findByEnumeratorAndStatus(currentPrincipalName, "disetujui");

        List<KebijakanDto> kebijakanDtoList = new ArrayList<>();
        for (Kebijakan kebijakan : kebijakanList) {
            KebijakanDto kebijakanDto = modelMapperUtility.initialize().map(kebijakan, KebijakanDto.class);

            Double progres = BigDecimal.valueOf(kebijakan.getKebijakanDetail().getProgres())
                    .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                    .doubleValue();

            kebijakanDto.setProgres(progres);

            kebijakanDtoList.add(kebijakanDto);
        }
        return kebijakanDtoList;
    }

    @GetMapping("/enumerator/dashboard/proses")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public List<KebijakanDto> findKebijakanByEnumeratorAndStatusProses() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        List<Kebijakan> kebijakanList = kebijakanService.findByEnumeratorAndStatus(currentPrincipalName, "proses");

        List<KebijakanDto> kebijakanDtoList = new ArrayList<>();
        for (Kebijakan kebijakan : kebijakanList) {
            KebijakanDto kebijakanDto = modelMapperUtility.initialize().map(kebijakan, KebijakanDto.class);

            Double progres = BigDecimal.valueOf(kebijakan.getKebijakanDetail().getProgres())
                    .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                    .doubleValue();

            kebijakanDto.setProgres(progres);

            kebijakanDtoList.add(kebijakanDto);
        }
        return kebijakanDtoList;
    }

    @PostMapping("/enumerator/mulai/{idKebijakan}")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public KebijakanDto startKebijakanEnumeratorByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan) {
        Kebijakan kebijakan = kebijakanService.findById(idKebijakan);
        kebijakan.setStatus("proses");
        Kebijakan savedKebijakan = kebijakanService.save(kebijakan);

        KebijakanDto kebijakanDto = modelMapperUtility.initialize().map(savedKebijakan, KebijakanDto.class);
        Double progres = BigDecimal.valueOf(kebijakan.getKebijakanDetail().getProgres())
                .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                .doubleValue();

        kebijakanDto.setProgres(progres);
        return kebijakanDto;
    }

    @PostMapping("/enumerator/kirim/{idKebijakan}")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public KebijakanDto sendKebijakanToAdminInstansiByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan) {
        Kebijakan kebijakan = kebijakanService.findById(idKebijakan);
        kebijakan.setIsSentByEnumerator(true);
        kebijakan.setSentByEnumeratorAt(new Date());
        Kebijakan savedKebijakan = kebijakanService.save(kebijakan);

        KebijakanDto kebijakanDto = modelMapperUtility.initialize().map(savedKebijakan, KebijakanDto.class);
        Double progres = BigDecimal.valueOf(kebijakan.getKebijakanDetail().getProgres())
                .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                .doubleValue();

        kebijakanDto.setProgres(progres);
        return kebijakanDto;
    }
}
