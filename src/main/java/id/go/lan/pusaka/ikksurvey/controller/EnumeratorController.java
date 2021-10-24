package id.go.lan.pusaka.ikksurvey.controller;

import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import id.go.lan.pusaka.ikksurvey.model.dto.KebijakanDto;
import id.go.lan.pusaka.ikksurvey.service.KebijakanService;
import id.go.lan.pusaka.ikksurvey.utility.ModelMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

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
}
