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
@Table(name = "formulasi_kebijakan")
public class FormulasiKebijakan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer b1A;
	private String pathB1A;

	private Integer b1B;
	private String pathB1B;

	private Integer b2A;
	private String pathB2A;

	private Integer b2B;
	private String pathB2B;

	private Integer b3A;
	private String pathB3A;

	private Integer b3B;
	private String pathB3B;

	private Integer b3C;
	private String pathB3C;

	private Integer b4A;
	private String pathB4A;

	private String b4B;
	private String pathB4B;

	private Integer b4C;
	private String pathB4C;

	private Integer b5A;
	private String pathB5A;

	private Integer b5B;
	private String pathB5B;

	private Integer b5C;
	private String pathB5C;

	@Column(columnDefinition = "TEXT")
	private String informasiB6;

	@OneToOne(mappedBy = "formulasiKebijakan")
	@JsonIgnoreProperties("formulasiKebijakan")
	private Kebijakan kebijakan;

	public FormulasiKebijakan() {
		super();
	}

	public FormulasiKebijakan(Long id, Integer b1a, String pathB1A, Integer b1b, String pathB1B, Integer b2a,
			String pathB2A, Integer b2b, String pathB2B, Integer b3a, String pathB3A, Integer b3c, String pathB3C,
			Integer b4a, String pathB4A, String b4b, String pathB4B, Integer b4c, String pathB4C, Integer b5a,
			String pathB5A, Integer b5b, String pathB5B, Integer b5c, String pathB5C, String informasiB6,
			Kebijakan kebijakan) {
		super();
		this.id = id;
		b1A = b1a;
		this.pathB1A = pathB1A;
		b1B = b1b;
		this.pathB1B = pathB1B;

		b2A = b2a;
		this.pathB2A = pathB2A;
		b2B = b2b;
		this.pathB2B = pathB2B;
		b3A = b3a;
		this.pathB3A = pathB3A;
		b3C = b3c;
		this.pathB3C = pathB3C;
		b4A = b4a;
		this.pathB4A = pathB4A;
		b4B = b4b;
		this.pathB4B = pathB4B;

		b4C = b4c;
		this.pathB4C = pathB4C;
		b5A = b5a;
		this.pathB5A = pathB5A;
		b5B = b5b;
		this.pathB5B = pathB5B;
		b5C = b5c;
		this.pathB5C = pathB5C;
		this.informasiB6 = informasiB6;
		this.kebijakan = kebijakan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getB1A() {
		return b1A;
	}

	public void setB1A(Integer b1a) {
		b1A = b1a;
	}

	public String getPathB1A() {
		return pathB1A;
	}

	public void setPathB1A(String pathB1A) {
		this.pathB1A = pathB1A;
	}

	public Integer getB1B() {
		return b1B;
	}

	public void setB1B(Integer b1b) {
		b1B = b1b;
	}

	public String getPathB1B() {
		return pathB1B;
	}

	public void setPathB1B(String pathB1B) {
		this.pathB1B = pathB1B;
	}

	public Integer getB2A() {
		return b2A;
	}

	public void setB2A(Integer b2a) {
		b2A = b2a;
	}

	public String getPathB2A() {
		return pathB2A;
	}

	public void setPathB2A(String pathB2A) {
		this.pathB2A = pathB2A;
	}

	public Integer getB2B() {
		return b2B;
	}

	public void setB2B(Integer b2b) {
		b2B = b2b;
	}

	public String getPathB2B() {
		return pathB2B;
	}

	public void setPathB2B(String pathB2B) {
		this.pathB2B = pathB2B;
	}

	public Integer getB3A() {
		return b3A;
	}

	public void setB3A(Integer b3a) {
		b3A = b3a;
	}

	public String getPathB3A() {
		return pathB3A;
	}

	public void setPathB3A(String pathB3A) {
		this.pathB3A = pathB3A;
	}

	public Integer getB3C() {
		return b3C;
	}

	public void setB3C(Integer b3c) {
		b3C = b3c;
	}

	public String getPathB3C() {
		return pathB3C;
	}

	public void setPathB3C(String pathB3C) {
		this.pathB3C = pathB3C;
	}

	public Integer getB4A() {
		return b4A;
	}

	public void setB4A(Integer b4a) {
		b4A = b4a;
	}

	public String getPathB4A() {
		return pathB4A;
	}

	public void setPathB4A(String pathB4A) {
		this.pathB4A = pathB4A;
	}

	public String getB4B() {
		return b4B;
	}

	public void setB4B(String b4b) {
		b4B = b4b;
	}

	public String getPathB4B() {
		return pathB4B;
	}

	public void setPathB4B(String pathB4B) {
		this.pathB4B = pathB4B;
	}

	public Integer getB4C() {
		return b4C;
	}

	public void setB4C(Integer b4c) {
		b4C = b4c;
	}

	public String getPathB4C() {
		return pathB4C;
	}

	public void setPathB4C(String pathB4C) {
		this.pathB4C = pathB4C;
	}

	public Integer getB5A() {
		return b5A;
	}

	public void setB5A(Integer b5a) {
		b5A = b5a;
	}

	public String getPathB5A() {
		return pathB5A;
	}

	public void setPathB5A(String pathB5A) {
		this.pathB5A = pathB5A;
	}

	public Integer getB5B() {
		return b5B;
	}

	public void setB5B(Integer b5b) {
		b5B = b5b;
	}

	public String getPathB5B() {
		return pathB5B;
	}

	public void setPathB5B(String pathB5B) {
		this.pathB5B = pathB5B;
	}

	public Integer getB5C() {
		return b5C;
	}

	public void setB5C(Integer b5c) {
		b5C = b5c;
	}

	public String getPathB5C() {
		return pathB5C;
	}

	public void setPathB5C(String pathB5C) {
		this.pathB5C = pathB5C;
	}

	public String getInformasiB6() {
		return informasiB6;
	}

	public void setInformasiB6(String informasiB6) {
		this.informasiB6 = informasiB6;
	}

	public Kebijakan getKebijakan() {
		return kebijakan;
	}

	public void setKebijakan(Kebijakan kebijakan) {
		this.kebijakan = kebijakan;
	}

	public Integer getB3B() {
		return b3B;
	}

	public void setB3B(Integer b3b) {
		b3B = b3b;
	}

	public String getPathB3B() {
		return pathB3B;
	}

	public void setPathB3B(String pathB3B) {
		this.pathB3B = pathB3B;
	}

}
