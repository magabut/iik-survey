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
@Table(name = "")
public class ImplementasiKebijakan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer c1A;
	private String pathC1A;

	private Integer c1B;
	private String pathC1B;

	private Integer c1C;
	private String pathC1C;

	private Integer c1D;
	private String pathC1D;

	private Integer c2A;
	private String pathC2A;

	private Integer c2B;
	private String pathC2B;

	private Integer c2C;
	private String pathC2C;

	private Integer c3A;
	private String pathC3A;

	private Integer c3B;
	private String pathC3B;

	private Integer c3C;
	private String pathC3C;

	@Column(columnDefinition = "TEXT")
	private String informasiC4;
	@OneToOne(mappedBy = "implementasiKebijakan")
	@JsonIgnoreProperties("implementasiKebijakan")
	private Kebijakan kebijakan;

	public ImplementasiKebijakan() {
		super();
	}

	public ImplementasiKebijakan(Long id, Integer c1a, String pathC1A, Integer c1b, String pathC1B, Integer c1c,
			String pathC1C, Integer c1d, String pathC1D, Integer c2a, String pathC2A, Integer c2b, String pathC2B,
			Integer c2c, String pathC2C, Integer c3a, String pathC3A, Integer c3b, String pathC3B, Integer c3c,
			String pathC3C, String informasiC4, Kebijakan kebijakan) {
		super();
		this.id = id;
		c1A = c1a;
		this.pathC1A = pathC1A;
		c1B = c1b;
		this.pathC1B = pathC1B;
		c1C = c1c;
		this.pathC1C = pathC1C;
		c1D = c1d;
		this.pathC1D = pathC1D;
		c2A = c2a;
		this.pathC2A = pathC2A;
		c2B = c2b;
		this.pathC2B = pathC2B;
		c2C = c2c;
		this.pathC2C = pathC2C;
		c3A = c3a;
		this.pathC3A = pathC3A;
		c3B = c3b;
		this.pathC3B = pathC3B;
		c3C = c3c;
		this.pathC3C = pathC3C;
		this.informasiC4 = informasiC4;
		this.kebijakan = kebijakan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getC1A() {
		return c1A;
	}

	public void setC1A(Integer c1a) {
		c1A = c1a;
	}

	public String getPathC1A() {
		return pathC1A;
	}

	public void setPathC1A(String pathC1A) {
		this.pathC1A = pathC1A;
	}

	public Integer getC1B() {
		return c1B;
	}

	public void setC1B(Integer c1b) {
		c1B = c1b;
	}

	public String getPathC1B() {
		return pathC1B;
	}

	public void setPathC1B(String pathC1B) {
		this.pathC1B = pathC1B;
	}

	public Integer getC1C() {
		return c1C;
	}

	public void setC1C(Integer c1c) {
		c1C = c1c;
	}

	public String getPathC1C() {
		return pathC1C;
	}

	public void setPathC1C(String pathC1C) {
		this.pathC1C = pathC1C;
	}

	public Integer getC1D() {
		return c1D;
	}

	public void setC1D(Integer c1d) {
		c1D = c1d;
	}

	public String getPathC1D() {
		return pathC1D;
	}

	public void setPathC1D(String pathC1D) {
		this.pathC1D = pathC1D;
	}

	public Integer getC2A() {
		return c2A;
	}

	public void setC2A(Integer c2a) {
		c2A = c2a;
	}

	public String getPathC2A() {
		return pathC2A;
	}

	public void setPathC2A(String pathC2A) {
		this.pathC2A = pathC2A;
	}

	public Integer getC2B() {
		return c2B;
	}

	public void setC2B(Integer c2b) {
		c2B = c2b;
	}

	public String getPathC2B() {
		return pathC2B;
	}

	public void setPathC2B(String pathC2B) {
		this.pathC2B = pathC2B;
	}

	public Integer getC2C() {
		return c2C;
	}

	public void setC2C(Integer c2c) {
		c2C = c2c;
	}

	public String getPathC2C() {
		return pathC2C;
	}

	public void setPathC2C(String pathC2C) {
		this.pathC2C = pathC2C;
	}

	public Integer getC3A() {
		return c3A;
	}

	public void setC3A(Integer c3a) {
		c3A = c3a;
	}

	public String getPathC3A() {
		return pathC3A;
	}

	public void setPathC3A(String pathC3A) {
		this.pathC3A = pathC3A;
	}

	public Integer getC3B() {
		return c3B;
	}

	public void setC3B(Integer c3b) {
		c3B = c3b;
	}

	public String getPathC3B() {
		return pathC3B;
	}

	public void setPathC3B(String pathC3B) {
		this.pathC3B = pathC3B;
	}

	public Integer getC3C() {
		return c3C;
	}

	public void setC3C(Integer c3c) {
		c3C = c3c;
	}

	public String getPathC3C() {
		return pathC3C;
	}

	public void setPathC3C(String pathC3C) {
		this.pathC3C = pathC3C;
	}

	public String getInformasiC4() {
		return informasiC4;
	}

	public void setInformasiC4(String informasiC4) {
		this.informasiC4 = informasiC4;
	}

	public Kebijakan getKebijakan() {
		return kebijakan;
	}

	public void setKebijakan(Kebijakan kebijakan) {
		this.kebijakan = kebijakan;
	}

}
