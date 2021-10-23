package id.go.lan.pusaka.ikksurvey.controller;

import id.go.lan.pusaka.ikksurvey.model.ImplementasiKebijakan;
import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import id.go.lan.pusaka.ikksurvey.model.dto.ImplementasiKebijakanDto;
import id.go.lan.pusaka.ikksurvey.service.ImplementasiKebijakanService;
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
public class ImplementasiKebijakanController {
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private KebijakanService kebijakanService;
    @Autowired
    private ImplementasiKebijakanService implementasiKebijakanService;

    @GetMapping("/implementasikebijakan/{idKebijakan}")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public ImplementasiKebijakanDto findImplementasiKebijakanByIdKebijakan(@PathVariable("idKebijakan") Long idKebijakan) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        ImplementasiKebijakan savedImplementasiKebijakan = kebijakan.getImplementasiKebijakan();
        ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
        implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
        implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

        return implementasiKebijakanDto;
    }
}
