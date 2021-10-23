package id.go.lan.pusaka.ikksurvey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "implementasi_kebijakan")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImplementasiKebijakan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String c1A;
	private String pathC1A;

	private String c1B;
	private String pathC1B;

	private String c1C;
	private String pathC1C;

	private String c1D;
	private String pathC1D;

	private String c2A;
	private String pathC2A;

	private String c2B;
	private String pathC2B;

	private String c2C;
	private String pathC2C;

	private String c3A;
	private String pathC3A;

	private String c3B;
	private String pathC3B;

	private String c3C;
	private String pathC3C;

	@Column(columnDefinition = "TEXT")
	private String informasiC4;
	@OneToOne(mappedBy = "implementasiKebijakan")
	@JsonIgnoreProperties("implementasiKebijakan")
	private Kebijakan kebijakan;
}
