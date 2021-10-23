package id.go.lan.pusaka.ikksurvey.model.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KoordinatorInstansiCardDto {
    private Integer kebijakanMasuk;
    private Integer kebijakanDisetujui;
    private Integer kebijakanDitolak;
}
