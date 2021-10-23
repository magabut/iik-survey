package id.go.lan.pusaka.ikksurvey.model.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DashboardKoordinatorInstansiCardDto {
    private Integer kebijakanMasuk;
    private Integer kebijakanDiproses;
    private Integer kebijakanSelesai;
    private Integer kebijakanDitolak;
}
