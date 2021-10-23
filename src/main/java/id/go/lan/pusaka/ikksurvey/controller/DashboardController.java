package id.go.lan.pusaka.ikksurvey.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import id.go.lan.pusaka.ikksurvey.service.DashboardAdminInstansiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kebijakan/dashboard")
public class DashboardController {

    @Autowired
    private DashboardAdminInstansiService dashboardAdminInstansiService;

    @GetMapping("admininstansi")
    @PreAuthorize("hasAnyAuthority('role_admin_instansi')")
    public ResponseEntity<Object> getAdminInstansiDashboardCard() {
        return new ResponseEntity<>(dashboardAdminInstansiService.getAdminInstansiDashboardCardData(), HttpStatus.OK);
    }
}
