package id.go.lan.pusaka.ikksurvey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "formulasi_kebijakan")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FormulasiKebijakan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String b1A;
	private String pathB1A;

	private String b1B;
	private String pathB1B;

	private String b2A;
	private String pathB2A;

	private String b2B;
	private String pathB2B;

	private String b3A;
	private String pathB3A;

	private String b3B;
	private String pathB3B;

	private String b3C;
	private String pathB3C;

	private String b4A;
	private String pathB4A;

	private String b4B;
	private String pathB4B;

	private String b4C;
	private String pathB4C;

	private String b5A;
	private String pathB5A;

	private String b5B;
	private String pathB5B;

	private String b5C;
	private String pathB5C;

	@Column(columnDefinition = "TEXT")
	private String informasiB6;

	@OneToOne(mappedBy = "formulasiKebijakan")
	@JsonIgnoreProperties("formulasiKebijakan")
	private Kebijakan kebijakan;
}
