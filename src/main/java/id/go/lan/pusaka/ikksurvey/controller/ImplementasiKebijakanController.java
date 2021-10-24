package id.go.lan.pusaka.ikksurvey.controller;

import id.go.lan.pusaka.ikksurvey.model.ImplementasiKebijakan;
import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import id.go.lan.pusaka.ikksurvey.model.KebijakanDetail;
import id.go.lan.pusaka.ikksurvey.model.dto.ImplementasiKebijakanDto;
import id.go.lan.pusaka.ikksurvey.service.ImplementasiKebijakanService;
import id.go.lan.pusaka.ikksurvey.service.KebijakanDetailService;
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
public class ImplementasiKebijakanController {
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private KebijakanService kebijakanService;
    @Autowired
    private KebijakanDetailService kebijakanDetailService;
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

    @PostMapping("/implementasikebijakan/{idKebijakan}/c1a")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public ImplementasiKebijakanDto saveImplementasiKebijakanC1AByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        ImplementasiKebijakan implementasiKebijakan = implementasiKebijakanService.findById(kebijakan.getImplementasiKebijakan().getId());
        String currentAnswer = implementasiKebijakan.getC1A();

        if (file == null) {
            implementasiKebijakan.setC1A(answer);
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        } else {
            implementasiKebijakan.setC1A(answer);
            implementasiKebijakan.setPathC1A(uploadFile(file, currentPrincipalName));
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        }
    }

    @PostMapping("/implementasikebijakan/{idKebijakan}/c1b")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public ImplementasiKebijakanDto saveImplementasiKebijakanC1BByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        ImplementasiKebijakan implementasiKebijakan = implementasiKebijakanService.findById(kebijakan.getImplementasiKebijakan().getId());
        String currentAnswer = implementasiKebijakan.getC1B();

        if (file == null) {
            implementasiKebijakan.setC1B(answer);
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        } else {
            implementasiKebijakan.setC1B(answer);
            implementasiKebijakan.setPathC1B(uploadFile(file, currentPrincipalName));
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        }
    }

    @PostMapping("/implementasikebijakan/{idKebijakan}/c1c")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public ImplementasiKebijakanDto saveImplementasiKebijakanC1CByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        ImplementasiKebijakan implementasiKebijakan = implementasiKebijakanService.findById(kebijakan.getImplementasiKebijakan().getId());
        String currentAnswer = implementasiKebijakan.getC1C();

        if (file == null) {
            implementasiKebijakan.setC1C(answer);
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        } else {
            implementasiKebijakan.setC1C(answer);
            implementasiKebijakan.setPathC1C(uploadFile(file, currentPrincipalName));
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        }
    }

    @PostMapping("/implementasikebijakan/{idKebijakan}/c1d")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public ImplementasiKebijakanDto saveImplementasiKebijakanC1DByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        ImplementasiKebijakan implementasiKebijakan = implementasiKebijakanService.findById(kebijakan.getImplementasiKebijakan().getId());
        String currentAnswer = implementasiKebijakan.getC1D();

        if (file == null) {
            implementasiKebijakan.setC1D(answer);
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        } else {
            implementasiKebijakan.setC1D(answer);
            implementasiKebijakan.setPathC1D(uploadFile(file, currentPrincipalName));
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        }
    }

    @PostMapping("/implementasikebijakan/{idKebijakan}/c2a")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public ImplementasiKebijakanDto saveImplementasiKebijakanC2AByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        ImplementasiKebijakan implementasiKebijakan = implementasiKebijakanService.findById(kebijakan.getImplementasiKebijakan().getId());
        String currentAnswer = implementasiKebijakan.getC2A();

        if (file == null) {
            implementasiKebijakan.setC2A(answer);
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        } else {
            implementasiKebijakan.setC2A(answer);
            implementasiKebijakan.setPathC2A(uploadFile(file, currentPrincipalName));
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        }
    }

    @PostMapping("/implementasikebijakan/{idKebijakan}/c2b")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public ImplementasiKebijakanDto saveImplementasiKebijakanC2BByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        ImplementasiKebijakan implementasiKebijakan = implementasiKebijakanService.findById(kebijakan.getImplementasiKebijakan().getId());
        String currentAnswer = implementasiKebijakan.getC2B();

        if (file == null) {
            implementasiKebijakan.setC2B(answer);
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        } else {
            implementasiKebijakan.setC2B(answer);
            implementasiKebijakan.setPathC2B(uploadFile(file, currentPrincipalName));
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        }
    }

    @PostMapping("/implementasikebijakan/{idKebijakan}/c2c")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public ImplementasiKebijakanDto saveImplementasiKebijakanC2CByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        ImplementasiKebijakan implementasiKebijakan = implementasiKebijakanService.findById(kebijakan.getImplementasiKebijakan().getId());
        String currentAnswer = implementasiKebijakan.getC1C();

        if (file == null) {
            implementasiKebijakan.setC2C(answer);
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        } else {
            implementasiKebijakan.setC2C(answer);
            implementasiKebijakan.setPathC2C(uploadFile(file, currentPrincipalName));
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        }
    }

    @PostMapping("/implementasikebijakan/{idKebijakan}/c3a")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public ImplementasiKebijakanDto saveImplementasiKebijakanC3AByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        ImplementasiKebijakan implementasiKebijakan = implementasiKebijakanService.findById(kebijakan.getImplementasiKebijakan().getId());
        String currentAnswer = implementasiKebijakan.getC3A();

        if (file == null) {
            implementasiKebijakan.setC3A(answer);
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        } else {
            implementasiKebijakan.setC3A(answer);
            implementasiKebijakan.setPathC3A(uploadFile(file, currentPrincipalName));
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        }
    }

    @PostMapping("/implementasikebijakan/{idKebijakan}/c3b")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public ImplementasiKebijakanDto saveImplementasiKebijakanC3BByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        ImplementasiKebijakan implementasiKebijakan = implementasiKebijakanService.findById(kebijakan.getImplementasiKebijakan().getId());
        String currentAnswer = implementasiKebijakan.getC3B();

        if (file == null) {
            implementasiKebijakan.setC3B(answer);
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        } else {
            implementasiKebijakan.setC3B(answer);
            implementasiKebijakan.setPathC3B(uploadFile(file, currentPrincipalName));
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        }
    }

    @PostMapping("/implementasikebijakan/{idKebijakan}/c3c")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public ImplementasiKebijakanDto saveImplementasiKebijakanC3CByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        ImplementasiKebijakan implementasiKebijakan = implementasiKebijakanService.findById(kebijakan.getImplementasiKebijakan().getId());
        String currentAnswer = implementasiKebijakan.getC3C();

        if (file == null) {
            implementasiKebijakan.setC3C(answer);
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        } else {
            implementasiKebijakan.setC3C(answer);
            implementasiKebijakan.setPathC3C(uploadFile(file, currentPrincipalName));
            ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);

            updateProgress(kebijakan, currentAnswer);

            ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
            implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

            return implementasiKebijakanDto;
        }
    }

    @PostMapping("/implementasikebijakan/{idKebijakan}/informasic4")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public ImplementasiKebijakanDto saveImplementasiKebijakanInformasiC4ByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        ImplementasiKebijakan implementasiKebijakan = implementasiKebijakanService.findById(kebijakan.getImplementasiKebijakan().getId());
        implementasiKebijakan.setInformasiC4(answer);

        ImplementasiKebijakan savedImplementasiKebijakan = implementasiKebijakanService.save(implementasiKebijakan);
        ImplementasiKebijakanDto implementasiKebijakanDto = modelMapperUtility.initialize().map(savedImplementasiKebijakan, ImplementasiKebijakanDto.class);
        implementasiKebijakanDto.setIdKebijakan(kebijakan.getId());
        implementasiKebijakanDto.setIdImplementasiKebijakan(savedImplementasiKebijakan.getId());

        return implementasiKebijakanDto;
    }

    private void updateProgress(Kebijakan kebijakan, String answer) {
        KebijakanDetail kebijakanDetail = kebijakan.getKebijakanDetail();
        Double progres = kebijakanDetail.getProgres();
        Double incrementValue = (1.0 / 39.0) * 100.0;

        if (answer == null) {
            kebijakanDetail.setProgres(progres + incrementValue);
            kebijakanDetailService.save(kebijakanDetail);
        }
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
