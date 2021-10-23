package id.go.lan.pusaka.ikksurvey.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DaftarKebijakanInstansiDto {
    private Boolean isReadySend;
    private List<KebijakanDto> kebijakanDtoList;
}