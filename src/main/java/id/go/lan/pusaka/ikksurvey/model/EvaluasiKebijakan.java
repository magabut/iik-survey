package id.go.lan.pusaka.ikksurvey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "evaluasi_kebijakan")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EvaluasiKebijakan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String d1A;
	private String pathD1A;
	private String d1B;
	private String pathD1B;
	private String d2A;
	private String pathD2A;
	private String d2B;
	private String pathD2B;
	private String d3A;
	private String pathD3A;

	private String d3B;
	private String pathD3B;
	private String d3C;
	private String pathD3C;
	private String d3D;
	private String pathD3D;

	private String d3E;
	private String pathD3E;

	@Column(columnDefinition = "TEXT")
	private String informasiD4;
	@OneToOne(mappedBy = "evaluasiKebijakan")
	@JsonIgnoreProperties("evaluasiKebijakan")
	private Kebijakan kebijakan;
}
