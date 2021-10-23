package id.go.lan.pusaka.ikksurvey.controller;

import id.go.lan.pusaka.ikksurvey.model.AgendaSetting;
import id.go.lan.pusaka.ikksurvey.model.Kebijakan;
import id.go.lan.pusaka.ikksurvey.model.dto.AgendaSettingDto;
import id.go.lan.pusaka.ikksurvey.service.AgendaSettingService;
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
public class AgendaSettingController {
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private KebijakanService kebijakanService;
    @Autowired
    private AgendaSettingService agendaSettingService;

    @GetMapping("/agendasetting/{idKebijakan}")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public AgendaSettingDto findKebijakanEnumeratorId(@PathVariable("idKebijakan") Long idKebijakan) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        AgendaSetting savedAgendaSetting = kebijakan.getAgendaSetting();
        AgendaSettingDto agendaSettingDto = modelMapperUtility.initialize().map(savedAgendaSetting, AgendaSettingDto.class);
        agendaSettingDto.setIdKebijakan(kebijakan.getId());
        agendaSettingDto.setIdAgendaSetting(savedAgendaSetting.getId());

        return agendaSettingDto;
    }

    @PostMapping("/agendasetting/{idKebijakan}/a1a")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public AgendaSettingDto saveKebijakanEnumeratorIdAgendaSettingA1A(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam("file")MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        AgendaSetting agendaSetting = agendaSettingService.findById(kebijakan.getAgendaSetting().getId());
        agendaSetting.setA1A(answer);
        agendaSetting.setPathA1A(uploadFile(file, currentPrincipalName));

        AgendaSetting savedAgendaSetting = agendaSettingService.save(agendaSetting);
        AgendaSettingDto agendaSettingDto = modelMapperUtility.initialize().map(savedAgendaSetting, AgendaSettingDto.class);
        agendaSettingDto.setIdKebijakan(kebijakan.getId());
        agendaSettingDto.setIdAgendaSetting(savedAgendaSetting.getId());

        return agendaSettingDto;
    }

    @PostMapping("/agendasetting/{idKebijakan}/a1b")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public AgendaSettingDto saveKebijakanEnumeratorIdAgendaSettingA1B(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam("file")MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        AgendaSetting agendaSetting = agendaSettingService.findById(kebijakan.getAgendaSetting().getId());
        agendaSetting.setA1B(answer);
        agendaSetting.setPathA1B(uploadFile(file, currentPrincipalName));

        AgendaSetting savedAgendaSetting = agendaSettingService.save(agendaSetting);
        AgendaSettingDto agendaSettingDto = modelMapperUtility.initialize().map(savedAgendaSetting, AgendaSettingDto.class);
        agendaSettingDto.setIdKebijakan(kebijakan.getId());
        agendaSettingDto.setIdAgendaSetting(savedAgendaSetting.getId());

        return agendaSettingDto;
    }

    @PostMapping("/agendasetting/{idKebijakan}/a1c")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public AgendaSettingDto saveKebijakanEnumeratorIdAgendaSettingA1C(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam("file")MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        AgendaSetting agendaSetting = agendaSettingService.findById(kebijakan.getAgendaSetting().getId());
        agendaSetting.setA1C(answer);
        agendaSetting.setPathA1C(uploadFile(file, currentPrincipalName));

        AgendaSetting savedAgendaSetting = agendaSettingService.save(agendaSetting);
        AgendaSettingDto agendaSettingDto = modelMapperUtility.initialize().map(savedAgendaSetting, AgendaSettingDto.class);
        agendaSettingDto.setIdKebijakan(kebijakan.getId());
        agendaSettingDto.setIdAgendaSetting(savedAgendaSetting.getId());

        return agendaSettingDto;
    }

    @PostMapping("/agendasetting/{idKebijakan}/a1d")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public AgendaSettingDto saveKebijakanEnumeratorIdAgendaSettingA1D(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam("file")MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        AgendaSetting agendaSetting = agendaSettingService.findById(kebijakan.getAgendaSetting().getId());
        agendaSetting.setA1D(answer);
        agendaSetting.setPathA1D(uploadFile(file, currentPrincipalName));

        AgendaSetting savedAgendaSetting = agendaSettingService.save(agendaSetting);
        AgendaSettingDto agendaSettingDto = modelMapperUtility.initialize().map(savedAgendaSetting, AgendaSettingDto.class);
        agendaSettingDto.setIdKebijakan(kebijakan.getId());
        agendaSettingDto.setIdAgendaSetting(savedAgendaSetting.getId());

        return agendaSettingDto;
    }

    @PostMapping("/agendasetting/{idKebijakan}/a2a")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public AgendaSettingDto saveKebijakanEnumeratorIdAgendaSettingA2A(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam("file")MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        AgendaSetting agendaSetting = agendaSettingService.findById(kebijakan.getAgendaSetting().getId());
        agendaSetting.setA2A(answer);
        agendaSetting.setPathA2A(uploadFile(file, currentPrincipalName));

        AgendaSetting savedAgendaSetting = agendaSettingService.save(agendaSetting);
        AgendaSettingDto agendaSettingDto = modelMapperUtility.initialize().map(savedAgendaSetting, AgendaSettingDto.class);
        agendaSettingDto.setIdKebijakan(kebijakan.getId());
        agendaSettingDto.setIdAgendaSetting(savedAgendaSetting.getId());

        return agendaSettingDto;
    }

    @PostMapping("/agendasetting/{idKebijakan}/a2b")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public AgendaSettingDto saveKebijakanEnumeratorIdAgendaSettingA2B(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam("file")MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        AgendaSetting agendaSetting = agendaSettingService.findById(kebijakan.getAgendaSetting().getId());
        agendaSetting.setA2B(answer);
        agendaSetting.setPathA2B(uploadFile(file, currentPrincipalName));

        AgendaSetting savedAgendaSetting = agendaSettingService.save(agendaSetting);
        AgendaSettingDto agendaSettingDto = modelMapperUtility.initialize().map(savedAgendaSetting, AgendaSettingDto.class);
        agendaSettingDto.setIdKebijakan(kebijakan.getId());
        agendaSettingDto.setIdAgendaSetting(savedAgendaSetting.getId());

        return agendaSettingDto;
    }

    @PostMapping("/agendasetting/{idKebijakan}/a2c")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public AgendaSettingDto saveKebijakanEnumeratorIdAgendaSettingA2C(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer,
            @RequestParam("file")MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        AgendaSetting agendaSetting = agendaSettingService.findById(kebijakan.getAgendaSetting().getId());
        agendaSetting.setA2C(answer);
        agendaSetting.setPathA2C(uploadFile(file, currentPrincipalName));

        AgendaSetting savedAgendaSetting = agendaSettingService.save(agendaSetting);
        AgendaSettingDto agendaSettingDto = modelMapperUtility.initialize().map(savedAgendaSetting, AgendaSettingDto.class);
        agendaSettingDto.setIdKebijakan(kebijakan.getId());
        agendaSettingDto.setIdAgendaSetting(savedAgendaSetting.getId());

        return agendaSettingDto;
    }

    @PostMapping("/agendasetting/{idKebijakan}/informasia3")
    @PreAuthorize("hasAnyAuthority('role_enumerator')")
    public AgendaSettingDto saveKebijakanEnumeratorIdAgendaSettingInformasiA3(
            @PathVariable("idKebijakan") Long idKebijakan,
            @RequestParam("answer") String answer) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Kebijakan kebijakan = kebijakanService.findByEnumeratorAndId(currentPrincipalName, idKebijakan);

        AgendaSetting agendaSetting = agendaSettingService.findById(kebijakan.getAgendaSetting().getId());
        agendaSetting.setInformasiA3(answer);

        AgendaSetting savedAgendaSetting = agendaSettingService.save(agendaSetting);
        AgendaSettingDto agendaSettingDto = modelMapperUtility.initialize().map(savedAgendaSetting, AgendaSettingDto.class);
        agendaSettingDto.setIdKebijakan(kebijakan.getId());
        agendaSettingDto.setIdAgendaSetting(savedAgendaSetting.getId());

        return agendaSettingDto;
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
