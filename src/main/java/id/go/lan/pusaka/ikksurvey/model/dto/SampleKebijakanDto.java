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
public class SampleKebijakanDto {
    private int totalKebijakanDiajukan;
    private int totalKebijakanDisetujui;
    private int totalSampleKebijakan;
    private Boolean isRandomized = false;
    private List<KebijakanDto> sampleKebijakanList;
}
