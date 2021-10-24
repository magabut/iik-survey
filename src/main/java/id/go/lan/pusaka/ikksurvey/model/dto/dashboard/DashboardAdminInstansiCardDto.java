package id.go.lan.pusaka.ikksurvey.model.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DashboardAdminInstansiCardDto {
    private Integer kebijakanDiajukan;
    private Integer kebijakanDisetujui;
    private Integer kebijakanDitolak;
}
