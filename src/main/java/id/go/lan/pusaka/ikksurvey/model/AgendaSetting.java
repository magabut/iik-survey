package id.go.lan.pusaka.ikksurvey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "agenda_setting")
public class AgendaSetting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer a1A;
	private String pathA1A;

	private Integer a1B;
	private String pathA1B;

	private Integer a1C;
	private String pathA1C;

	private Integer a1D;
	private String pathA1D;
	private Integer a2A;
	private String pathA2A;
	private Integer a2B;
	private String pathA2B;

	private Integer a2C;
	private String pathA2C;
	@Column(columnDefinition = "TEXT")
	private String informasiA3;

	@OneToOne(mappedBy = "agendaSetting")
	@JsonIgnoreProperties("agendaSetting")
	private Kebijakan kebijakan;

	public AgendaSetting() {
		super();
	}

	public AgendaSetting(Long id, Integer a1a, String pathA1A, Integer a1b, String pathA1B, Integer a1c, String pathA1C,
			Integer a1d, String pathA1D, Integer a2a, String pathA2A, Integer a2b, String pathA2B, Integer a2c,
			String pathA2C, String informasiA3, Kebijakan kebijakan) {
		super();
		this.id = id;
		a1A = a1a;
		this.pathA1A = pathA1A;
		a1B = a1b;
		this.pathA1B = pathA1B;
		a1C = a1c;
		this.pathA1C = pathA1C;
		a1D = a1d;
		this.pathA1D = pathA1D;
		a2A = a2a;
		this.pathA2A = pathA2A;
		a2B = a2b;
		this.pathA2B = pathA2B;
		a2C = a2c;
		this.pathA2C = pathA2C;
		this.informasiA3 = informasiA3;
		this.kebijakan = kebijakan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getA1A() {
		return a1A;
	}

	public void setA1A(Integer a1a) {
		a1A = a1a;
	}

	public String getPathA1A() {
		return pathA1A;
	}

	public void setPathA1A(String pathA1A) {
		this.pathA1A = pathA1A;
	}

	public Integer getA1B() {
		return a1B;
	}

	public void setA1B(Integer a1b) {
		a1B = a1b;
	}

	public String getPathA1B() {
		return pathA1B;
	}

	public void setPathA1B(String pathA1B) {
		this.pathA1B = pathA1B;
	}

	public Integer getA1C() {
		return a1C;
	}

	public void setA1C(Integer a1c) {
		a1C = a1c;
	}

	public String getPathA1C() {
		return pathA1C;
	}

	public void setPathA1C(String pathA1C) {
		this.pathA1C = pathA1C;
	}

	public Integer getA1D() {
		return a1D;
	}

	public void setA1D(Integer a1d) {
		a1D = a1d;
	}

	public String getPathA1D() {
		return pathA1D;
	}

	public void setPathA1D(String pathA1D) {
		this.pathA1D = pathA1D;
	}

	public Integer getA2A() {
		return a2A;
	}

	public void setA2A(Integer a2a) {
		a2A = a2a;
	}

	public String getPathA2A() {
		return pathA2A;
	}

	public void setPathA2A(String pathA2A) {
		this.pathA2A = pathA2A;
	}

	public Integer getA2B() {
		return a2B;
	}

	public void setA2B(Integer a2b) {
		a2B = a2b;
	}

	public String getPathA2B() {
		return pathA2B;
	}

	public void setPathA2B(String pathA2B) {
		this.pathA2B = pathA2B;
	}

	public Integer getA2C() {
		return a2C;
	}

	public void setA2C(Integer a2c) {
		a2C = a2c;
	}

	public String getPathA2C() {
		return pathA2C;
	}

	public void setPathA2C(String pathA2C) {
		this.pathA2C = pathA2C;
	}

	public String getInformasiA3() {
		return informasiA3;
	}

	public void setInformasiA3(String informasiA3) {
		this.informasiA3 = informasiA3;
	}

	public Kebijakan getKebijakan() {
		return kebijakan;
	}

	public void setKebijakan(Kebijakan kebijakan) {
		this.kebijakan = kebijakan;
	}

}
