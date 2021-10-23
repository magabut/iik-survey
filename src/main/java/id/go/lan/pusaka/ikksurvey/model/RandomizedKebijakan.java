package id.go.lan.pusaka.ikksurvey.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "randomized_kebijakan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RandomizedKebijakan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nipAdminInstansi;
    private Long idKebijakan;
}
