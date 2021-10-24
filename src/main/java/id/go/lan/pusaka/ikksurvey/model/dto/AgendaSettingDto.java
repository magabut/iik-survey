package id.go.lan.pusaka.ikksurvey.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgendaSettingDto {
    private Long idKebijakan;
    private Long idAgendaSetting;

    private String a1A;
    private String pathA1A;

    private String a1B;
    private String pathA1B;

    private String a1C;
    private String pathA1C;

    private String a1D;
    private String pathA1D;

    private String a2A;
    private String pathA2A;

    private String a2B;
    private String pathA2B;

    private List<String> a2C;
    private String pathA2C;

    private String informasiA3;

    public void setA2C(String a2c) {
        if (a2c == null) {
            this.a2C = new ArrayList<>();
        } else {
            List<String> a2cList = Stream.of(a2c.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            this.a2C = a2cList;
        }
    }
}
