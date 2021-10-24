package id.go.lan.pusaka.ikksurvey.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataKebijakan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaInstansi;
    private String nipAdminInstansi;
    private String nipKoordinatorInstansi;
    private Integer kebijakanDiajukan = 0;
    private Integer kebijakanDisetujui = 0;
    private Integer kebijakanDiproses = 0;
    private Integer kebijakanDitolak = 0;
    private Integer kebijakanSelesai = 0;
    private Date sentByAdminAt;
    private Date sentByKoordinatorAt;
}
