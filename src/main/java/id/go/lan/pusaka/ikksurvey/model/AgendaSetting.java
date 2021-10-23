package id.go.lan.pusaka.ikksurvey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "agenda_setting")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgendaSetting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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

	private String a2C;
	private String pathA2C;
	@Column(columnDefinition = "TEXT")
	private String informasiA3;

	@OneToOne(mappedBy = "agendaSetting")
	@JsonIgnoreProperties("agendaSetting")
	private Kebijakan kebijakan;
}
