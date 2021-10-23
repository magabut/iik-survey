package id.go.lan.pusaka.ikksurvey.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status_kebijakan")
public class StatusKebijakan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String instansi;
	private Date tanggalKirim;
	private String pengirim;
	private Integer status;
	private Date tanggalValidasi;
	private String koordinator;
	private Integer totalKebijakan;

	public StatusKebijakan() {
		super();
	}

	public StatusKebijakan(Long id, String instansi, Date tanggalKirim, String pengirim, Integer status,
			Date tanggalValidasi, String koordinator) {
		super();
		this.id = id;
		this.instansi = instansi;
		this.tanggalKirim = tanggalKirim;
		this.pengirim = pengirim;
		this.status = status;
		this.tanggalValidasi = tanggalValidasi;
		this.koordinator = koordinator;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstansi() {
		return instansi;
	}

	public void setInstansi(String instansi) {
		this.instansi = instansi;
	}

	public Date getTanggalKirim() {
		return tanggalKirim;
	}

	public void setTanggalKirim(Date tanggalKirim) {
		this.tanggalKirim = tanggalKirim;
	}

	public String getPengirim() {
		return pengirim;
	}

	public void setPengirim(String pengirim) {
		this.pengirim = pengirim;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getTanggalValidasi() {
		return tanggalValidasi;
	}

	public void setTanggalValidasi(Date tanggalValidasi) {
		this.tanggalValidasi = tanggalValidasi;
	}

	public String getKoordinator() {
		return koordinator;
	}

	public void setKoordinator(String koordinator) {
		this.koordinator = koordinator;
	}

	public Integer getTotalKebijakan() {
		return totalKebijakan;
	}

	public void setTotalKebijakan(Integer totalKebijakan) {
		this.totalKebijakan = totalKebijakan;
	}
	
	

}
