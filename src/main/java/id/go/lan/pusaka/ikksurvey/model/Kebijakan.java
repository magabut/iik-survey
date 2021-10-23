package id.go.lan.pusaka.ikksurvey.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "kebijakan")
public class Kebijakan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nama;
	private Date tanggal;
	private String jenis;
	private String createBy;
	private Date createdAt;
	private String enumerator;
	private String instansi;
	private Date assignAt;
	private Integer status;
	private Boolean terverifikasi;
	@Column(name = "tanggal_verifikasi")
	private Date tanggalVerifikasi;
	private String koordinator;
	@OneToOne
	@JoinColumn(name = "agenda_setting_id", referencedColumnName = "id")
	@JsonIgnoreProperties("kebijakan")
	private AgendaSetting agendaSetting;
	@OneToOne
	@JoinColumn(name = "formulasi_kebijakan_id", referencedColumnName = "id")
	@JsonIgnoreProperties("kebijakan")
	private FormulasiKebijakan formulasiKebijakan;
	@OneToOne
	@JoinColumn(name = "implementasi_kebijakan_id", referencedColumnName = "id")
	@JsonIgnoreProperties("kebijakan")
	private ImplementasiKebijakan implementasiKebijakan;
	@OneToOne
	@JoinColumn(name = "evaluasi_kebijakan_id", referencedColumnName = "id")
	@JsonIgnoreProperties("kebijakan")
	private EvaluasiKebijakan evaluasiKebijakan;

	public Kebijakan() {
		super();
	}

	public Kebijakan(Long id, String nama, Date tanggal, String jenis) {
		super();
		this.id = id;
		this.nama = nama;
		this.tanggal = tanggal;
		this.jenis = jenis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public ImplementasiKebijakan getImplementasiKebijakan() {
		return implementasiKebijakan;
	}

	public void setImplementasiKebijakan(ImplementasiKebijakan implementasiKebijakan) {
		this.implementasiKebijakan = implementasiKebijakan;
	}

	public EvaluasiKebijakan getEvaluasiKebijakan() {
		return evaluasiKebijakan;
	}

	public void setEvaluasiKebijakan(EvaluasiKebijakan evaluasiKebijakan) {
		this.evaluasiKebijakan = evaluasiKebijakan;
	}

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}

	public AgendaSetting getAgendaSetting() {
		return agendaSetting;
	}

	public void setAgendaSetting(AgendaSetting agendaSetting) {
		this.agendaSetting = agendaSetting;
	}

	public FormulasiKebijakan getFormulasiKebijakan() {
		return formulasiKebijakan;
	}

	public void setFormulasiKebijakan(FormulasiKebijakan formulasiKebijakan) {
		this.formulasiKebijakan = formulasiKebijakan;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEnumerator() {
		return enumerator;
	}

	public void setEnumerator(String enumerator) {
		this.enumerator = enumerator;
	}

	public String getInstansi() {
		return instansi;
	}

	public void setInstansi(String instansi) {
		this.instansi = instansi;
	}

	public Date getAssignAt() {
		return assignAt;
	}

	public void setAssignAt(Date assignAt) {
		this.assignAt = assignAt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getTerverifikasi() {
		return terverifikasi;
	}

	public void setTerverifikasi(Boolean terverifikasi) {
		this.terverifikasi = terverifikasi;
	}

	public Date getTanggalVerifikasi() {
		return tanggalVerifikasi;
	}

	public void setTanggalVerifikasi(Date tanggalVerifikasi) {
		this.tanggalVerifikasi = tanggalVerifikasi;
	}

	public String getKoordinator() {
		return koordinator;
	}

	public void setKoordinator(String koordinator) {
		this.koordinator = koordinator;
	}

}
