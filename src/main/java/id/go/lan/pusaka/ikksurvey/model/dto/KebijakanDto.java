package id.go.lan.pusaka.ikksurvey.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KebijakanDto {
    private Long id;
    private String nama;
    private Date tanggal;
    private String enumerator;
}