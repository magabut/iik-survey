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
@Table(name = "evaluasi_kebijakan")
public class EvaluasiKebijakan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer d1A;
	private String pathD1A;
	private Integer d1B;
	private String pathD1B;
	private Integer d2A;
	private String pathD2A;
	private Integer d2B;
	private String pathD2B;
	private Integer d3A;
	private String pathD3A;

	private Integer d3B;
	private String pathD3B;
	private Integer d3C;
	private String pathD3C;
	private Integer d3D;
	private String pathD3D;

	private Integer d3E;
	private String pathD3E;

	@Column(columnDefinition = "TEXT")
	private String informasiD4;
	@OneToOne(mappedBy = "evaluasiKebijakan")
	@JsonIgnoreProperties("evaluasiKebijakan")
	private Kebijakan kebijakan;

	public EvaluasiKebijakan() {
		super();
	}

	public EvaluasiKebijakan(Long id, Integer d1a, String pathD1A, Integer d1b, String pathD1B, Integer d2a,
			String pathD2A, Integer d2b, String pathD2B, Integer d3a, String pathD3A, Integer d3b, String pathD3B,
			Integer d3c, String pathD3C, Integer d3d, String pathD3D, Integer d3e, String pathD3E, String informasiD4,
			Kebijakan kebijakan) {
		super();
		this.id = id;
		d1A = d1a;
		this.pathD1A = pathD1A;
		d1B = d1b;
		this.pathD1B = pathD1B;
		d2A = d2a;
		this.pathD2A = pathD2A;
		d2B = d2b;
		this.pathD2B = pathD2B;
		d3A = d3a;
		this.pathD3A = pathD3A;
		d3B = d3b;
		this.pathD3B = pathD3B;
		d3C = d3c;
		this.pathD3C = pathD3C;
		d3D = d3d;
		this.pathD3D = pathD3D;
		d3E = d3e;
		this.pathD3E = pathD3E;
		this.informasiD4 = informasiD4;
		this.kebijakan = kebijakan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getD1A() {
		return d1A;
	}

	public void setD1A(Integer d1a) {
		d1A = d1a;
	}

	public String getPathD1A() {
		return pathD1A;
	}

	public void setPathD1A(String pathD1A) {
		this.pathD1A = pathD1A;
	}

	public Integer getD1B() {
		return d1B;
	}

	public void setD1B(Integer d1b) {
		d1B = d1b;
	}

	public String getPathD1B() {
		return pathD1B;
	}

	public void setPathD1B(String pathD1B) {
		this.pathD1B = pathD1B;
	}

	public Integer getD2A() {
		return d2A;
	}

	public void setD2A(Integer d2a) {
		d2A = d2a;
	}

	public String getPathD2A() {
		return pathD2A;
	}

	public void setPathD2A(String pathD2A) {
		this.pathD2A = pathD2A;
	}

	public Integer getD2B() {
		return d2B;
	}

	public void setD2B(Integer d2b) {
		d2B = d2b;
	}

	public String getPathD2B() {
		return pathD2B;
	}

	public void setPathD2B(String pathD2B) {
		this.pathD2B = pathD2B;
	}

	public Integer getD3A() {
		return d3A;
	}

	public void setD3A(Integer d3a) {
		d3A = d3a;
	}

	public String getPathD3A() {
		return pathD3A;
	}

	public void setPathD3A(String pathD3A) {
		this.pathD3A = pathD3A;
	}

	public Integer getD3B() {
		return d3B;
	}

	public void setD3B(Integer d3b) {
		d3B = d3b;
	}

	public String getPathD3B() {
		return pathD3B;
	}

	public void setPathD3B(String pathD3B) {
		this.pathD3B = pathD3B;
	}

	public Integer getD3C() {
		return d3C;
	}

	public void setD3C(Integer d3c) {
		d3C = d3c;
	}

	public String getPathD3C() {
		return pathD3C;
	}

	public void setPathD3C(String pathD3C) {
		this.pathD3C = pathD3C;
	}

	public Integer getD3D() {
		return d3D;
	}

	public void setD3D(Integer d3d) {
		d3D = d3d;
	}

	public String getPathD3D() {
		return pathD3D;
	}

	public void setPathD3D(String pathD3D) {
		this.pathD3D = pathD3D;
	}

	public Integer getD3E() {
		return d3E;
	}

	public void setD3E(Integer d3e) {
		d3E = d3e;
	}

	public String getPathD3E() {
		return pathD3E;
	}

	public void setPathD3E(String pathD3E) {
		this.pathD3E = pathD3E;
	}

	public String getInformasiD4() {
		return informasiD4;
	}

	public void setInformasiD4(String informasiD4) {
		this.informasiD4 = informasiD4;
	}

	public Kebijakan getKebijakan() {
		return kebijakan;
	}

	public void setKebijakan(Kebijakan kebijakan) {
		this.kebijakan = kebijakan;
	}

}
