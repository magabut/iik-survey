package id.go.lan.pusaka.ikksurvey.controller;

import id.go.lan.pusaka.ikksurvey.model.FormulasiKebijakan;
import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import id.go.lan.pusaka.ikksurvey.model.dto.FormulasiKebijakanDto;
import id.go.lan.pusaka.ikksurvey.service.FormulasiKebijakanService;
import id.go.lan.pusaka.ikksurvey.service.KebijakanService;
import id.go.lan.pusaka.ikksurvey.utility.ModelMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/kebijakan/enumerator")
public class FormulasiKebijakanController {
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private KebijakanService kebijakanService;
    @Autowired
    private FormulasiKebijakanService formulasiKebijakanService;

    @GetMapping("/formulasikebijakan/{idKebijakan}")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto findFormulasiKebijakanByIdKebijakan(@PathVariable("idKebijakan") Long idKebijakan) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        FormulasiKebijakan savedFormulasiKebijakan = kebijakan.getFormulasiKebijakan();
        FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
        formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
        formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

        return formulasiKebijakanDto;
    }

    @PostMapping("/formulasikebijakan/{idKebijakan}/b1a")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto saveFormulasiKebijakanB1AByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB1A(answer);

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        } else {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB1A(answer);
            formulasiKebijakan.setPathB1A(uploadFile(file, currentPrincipalName));

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        }
    }

    @PostMapping("/formulasikebijakan/{idKebijakan}/b1b")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto saveFormulasiKebijakanB1BByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB1B(answer);

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        } else {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB1B(answer);
            formulasiKebijakan.setPathB1B(uploadFile(file, currentPrincipalName));

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        }
    }

    @PostMapping("/formulasikebijakan/{idKebijakan}/b2a")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto saveFormulasiKebijakanB2AByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB2A(answer);

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        } else {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB2A(answer);
            formulasiKebijakan.setPathB2A(uploadFile(file, currentPrincipalName));

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        }
    }

    @PostMapping("/formulasikebijakan/{idKebijakan}/b2b")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto saveFormulasiKebijakanB2BByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB2B(answer);

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        } else {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB2B(answer);
            formulasiKebijakan.setPathB2B(uploadFile(file, currentPrincipalName));

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        }
    }

    @PostMapping("/formulasikebijakan/{idKebijakan}/b3a")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto saveFormulasiKebijakanB3AByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB3A(answer);

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        } else {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB3A(answer);
            formulasiKebijakan.setPathB3A(uploadFile(file, currentPrincipalName));

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        }
    }

    @PostMapping("/formulasikebijakan/{idKebijakan}/b3b")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto saveFormulasiKebijakanB3BByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB3B(answer);

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        } else {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB3B(answer);
            formulasiKebijakan.setPathB3B(uploadFile(file, currentPrincipalName));

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        }
    }

    @PostMapping("/formulasikebijakan/{idKebijakan}/b3c")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto saveFormulasiKebijakanB3CByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB3C(answer);

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        } else {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB3C(answer);
            formulasiKebijakan.setPathB3C(uploadFile(file, currentPrincipalName));

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        }
    }

    @PostMapping("/formulasikebijakan/{idKebijakan}/b4a")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto saveFormulasiKebijakanB4AByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB4A(answer);

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        } else {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB4A(answer);
            formulasiKebijakan.setPathB4A(uploadFile(file, currentPrincipalName));

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        }
    }

    @PostMapping("/formulasikebijakan/{idKebijakan}/b4b")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto saveFormulasiKebijakanB4BByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB4B(answer);

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        } else {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB4B(answer);
            formulasiKebijakan.setPathB4B(uploadFile(file, currentPrincipalName));

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        }
    }

    @PostMapping("/formulasikebijakan/{idKebijakan}/b4c")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto saveFormulasiKebijakanB4CByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB4C(answer);

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        } else {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB4C(answer);
            formulasiKebijakan.setPathB4C(uploadFile(file, currentPrincipalName));

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        }
    }

    @PostMapping("/formulasikebijakan/{idKebijakan}/b5a")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto saveFormulasiKebijakanB5AByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB5A(answer);

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        } else {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB5A(answer);
            formulasiKebijakan.setPathB5A(uploadFile(file, currentPrincipalName));

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        }
    }

    @PostMapping("/formulasikebijakan/{idKebijakan}/b5b")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto saveFormulasiKebijakanB5BByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB5B(answer);

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        } else {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB5B(answer);
            formulasiKebijakan.setPathB5B(uploadFile(file, currentPrincipalName));

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        }
    }

    @PostMapping("/formulasikebijakan/{idKebijakan}/b5c")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto saveFormulasiKebijakanB5CByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB5C(answer);

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        } else {
            FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getAgendaSetting().getId());
            formulasiKebijakan.setB5C(answer);
            formulasiKebijakan.setPathB5C(uploadFile(file, currentPrincipalName));

            FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
            FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
            formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

            return formulasiKebijakanDto;
        }
    }

    @PostMapping("/formulasikebijakan/{idKebijakan}/informasib6")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public FormulasiKebijakanDto saveFormulasiKebijakanInformasiB6ByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        FormulasiKebijakan formulasiKebijakan = formulasiKebijakanService.findById(kebijakan.getFormulasiKebijakan().getId());
        formulasiKebijakan.setInformasiB6(answer);

        FormulasiKebijakan savedFormulasiKebijakan = formulasiKebijakanService.save(formulasiKebijakan);
        FormulasiKebijakanDto formulasiKebijakanDto = modelMapperUtility.initialize().map(savedFormulasiKebijakan, FormulasiKebijakanDto.class);
        formulasiKebijakanDto.setIdKebijakan(kebijakan.getId());
        formulasiKebijakanDto.setIdFormulasiKebijakan(savedFormulasiKebijakan.getId());

        return formulasiKebijakanDto;
    }

    private String uploadFile(MultipartFile file, String nip) {
        String filePath = "";
        if (file != null) {
            try {
                // Get the filename and build the local file path (be sure that the
                // application have write permissions on such directory)
                Date date = new Date(); // your date
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH) + 1;
                int day = cal.get(Calendar.DAY_OF_MONTH);

                String directory = "./media/uploads/" + nip + "/" + year + "/" + month + "/" + day + "/";
                File directory2 = new File(directory);
                if (!directory2.exists()) {
                    directory2.mkdirs();
                }

                String filename = UUID.randomUUID().toString() + file.getOriginalFilename().toString().substring(
                        file.getOriginalFilename().toString().lastIndexOf("."),
                        file.getOriginalFilename().toString().length());

                filePath = Paths.get(directory, filename).toString();

                // Save the file locally
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                stream.write(file.getBytes());
                stream.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (filePath.equals(""))
            return null;
        else
            return filePath;
    }
}
