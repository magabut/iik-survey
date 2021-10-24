package id.go.lan.pusaka.ikksurvey.model;

import java.util.Date;

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
	private String status;
	private Boolean isVerified = false;
	private Boolean isSentByAdmin = false;
	private Boolean isSentByKoordinator = false;
	private Date sentByAdminAt;
	private Date sentByKoordinatorAt;
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
	@OneToOne
	@JoinColumn(name = "kebijakan_detail_id", referencedColumnName = "id")
	@JsonIgnoreProperties("kebijakan")
	private KebijakanDetail kebijakanDetail;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Boolean getIsSentByAdmin() {
		return isSentByAdmin;
	}

	public void setIsSentByAdmin(Boolean sentByAdmin) {
		isSentByAdmin = sentByAdmin;
	}

	public Boolean getIsSentByKoordinator() {
		return isSentByKoordinator;
	}

	public void setIsSentByKoordinator(Boolean sentByKoordinator) {
		isSentByKoordinator = sentByKoordinator;
	}

	public Date getSentByAdminAt() {
		return sentByAdminAt;
	}

	public void setSentByAdminAt(Date sentByAdminAt) {
		this.sentByAdminAt = sentByAdminAt;
	}

	public Date getSentByKoordinatorAt() {
		return sentByKoordinatorAt;
	}

	public void setSentByKoordinatorAt(Date sentByKoordinatorAt) {
		this.sentByKoordinatorAt = sentByKoordinatorAt;
	}

	public KebijakanDetail getKebijakanDetail() {
		return kebijakanDetail;
	}

	public void setKebijakanDetail(KebijakanDetail kebijakanDetail) {
		this.kebijakanDetail = kebijakanDetail;
	}
}
