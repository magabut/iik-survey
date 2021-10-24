package id.go.lan.pusaka.ikksurvey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "kebijakan_detail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KebijakanDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double progres;
    @OneToOne(
            fetch = FetchType.LAZY,
            mappedBy = "kebijakanDetail")
    @JsonIgnoreProperties("kebijakanDetail")
    private Kebijakan kebijakan;
}
