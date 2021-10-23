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

    @PostMapping("/evaluasikebijakan/{idKebijakan}/d1a")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public EvaluasiKebijakanDto saveEvaluasiKebijakanD1AByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD1A(answer);

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        } else {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD1A(answer);
            evaluasiKebijakan.setPathD1A(uploadFile(file, currentPrincipalName));

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        }
    }

    @PostMapping("/evaluasikebijakan/{idKebijakan}/d1b")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public EvaluasiKebijakanDto saveEvaluasiKebijakanD1BByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD1B(answer);

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        } else {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD1B(answer);
            evaluasiKebijakan.setPathD1B(uploadFile(file, currentPrincipalName));

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        }
    }

    @PostMapping("/evaluasikebijakan/{idKebijakan}/d2a")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public EvaluasiKebijakanDto saveEvaluasiKebijakanD2AByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD2A(answer);

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        } else {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD2A(answer);
            evaluasiKebijakan.setPathD2A(uploadFile(file, currentPrincipalName));

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        }
    }

    @PostMapping("/evaluasikebijakan/{idKebijakan}/d2b")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public EvaluasiKebijakanDto saveEvaluasiKebijakanD2BByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD2B(answer);

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        } else {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD2B(answer);
            evaluasiKebijakan.setPathD2B(uploadFile(file, currentPrincipalName));

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        }
    }

    @PostMapping("/evaluasikebijakan/{idKebijakan}/d3a")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public EvaluasiKebijakanDto saveEvaluasiKebijakanD3AByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD3A(answer);

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        } else {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD3A(answer);
            evaluasiKebijakan.setPathD3A(uploadFile(file, currentPrincipalName));

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        }
    }

    @PostMapping("/evaluasikebijakan/{idKebijakan}/d3b")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public EvaluasiKebijakanDto saveEvaluasiKebijakanD3BByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD3B(answer);

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        } else {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD3B(answer);
            evaluasiKebijakan.setPathD3B(uploadFile(file, currentPrincipalName));

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        }
    }

    @PostMapping("/evaluasikebijakan/{idKebijakan}/d3c")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public EvaluasiKebijakanDto saveEvaluasiKebijakanD3CByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD3C(answer);

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        } else {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD3C(answer);
            evaluasiKebijakan.setPathD3C(uploadFile(file, currentPrincipalName));

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        }
    }

    @PostMapping("/evaluasikebijakan/{idKebijakan}/d3d")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public EvaluasiKebijakanDto saveEvaluasiKebijakanD3DByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD3D(answer);

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        } else {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD3D(answer);
            evaluasiKebijakan.setPathD3D(uploadFile(file, currentPrincipalName));

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        }
    }

    @PostMapping("/evaluasikebijakan/{idKebijakan}/d3e")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public EvaluasiKebijakanDto saveEvaluasiKebijakanD3EByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        if (file == null) {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD3E(answer);

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        } else {
            EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
            evaluasiKebijakan.setD3E(answer);
            evaluasiKebijakan.setPathD3E(uploadFile(file, currentPrincipalName));

            EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
            EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
            evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
            evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

            return evaluasiKebijakanDto;
        }
    }

    @PostMapping("/evaluasikebijakan/{idKebijakan}/informasid4")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public EvaluasiKebijakanDto saveEvaluasiKebijakanInformasiD4ByIdKebijakan(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        EvaluasiKebijakan evaluasiKebijakan = evaluasiKebijakanService.findById(kebijakan.getEvaluasiKebijakan().getId());
        evaluasiKebijakan.setInformasiD4(answer);

        EvaluasiKebijakan savedEvaluasiKebijakan = evaluasiKebijakanService.save(evaluasiKebijakan);
        EvaluasiKebijakanDto evaluasiKebijakanDto = modelMapperUtility.initialize().map(savedEvaluasiKebijakan, EvaluasiKebijakanDto.class);
        evaluasiKebijakanDto.setIdKebijakan(kebijakan.getId());
        evaluasiKebijakanDto.setIdEvaluasiKebijakan(savedEvaluasiKebijakan.getId());

        return evaluasiKebijakanDto;
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
