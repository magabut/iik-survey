package id.go.lan.pusaka.ikksurvey.model.request;

import java.util.Date;

public class KebijakanRequest {
	private String nama;
	private Date tanggal;
	private String jenis;
	private String enumerator;

	public KebijakanRequest() {
		super();
	}

	public KebijakanRequest(String nama, Date tanggal, String jenis, String enumerator) {
		super();
		this.nama = nama;
		this.tanggal = tanggal;
		this.jenis = jenis;
		this.enumerator = enumerator;
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

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}

	public String getEnumerator() {
		return enumerator;
	}

	public void setEnumerator(String enumerator) {
		this.enumerator = enumerator;
	}

}
