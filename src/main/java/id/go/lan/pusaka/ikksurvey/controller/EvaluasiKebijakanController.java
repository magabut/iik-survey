package id.go.lan.pusaka.ikksurvey.controller;

import id.go.lan.pusaka.ikksurvey.model.EvaluasiKebijakan;
import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import id.go.lan.pusaka.ikksurvey.model.dto.EvaluasiKebijakanDto;
import id.go.lan.pusaka.ikksurvey.service.EvaluasiKebijakanService;
import id.go.lan.pusaka.ikksurvey.service.KebijakanService;
import id.go.lan.pusaka.ikksurvey.utility.ModelMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kebijakan/enumerator")
public class EvaluasiKebijakanController {
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private KebijakanService kebijakanService;
    @Autowired
    private EvaluasiKebijakanService evaluasiKebijakanService;

    @GetMapping("/evaluasikebijakan/{idKebijakan}")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public EvaluasiKebijakanDto findEvaluasiKebijakanByIdKebijakan(@PathVariable("idKebijakan") Long idKebijakan) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        EvaluasiKebijakan savedEvaluasiKebijakan = kebijakan.getEvaluasiKebijakan();
        EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
        evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
        evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

        return evaluasiKebijakanDto;
    }
}
