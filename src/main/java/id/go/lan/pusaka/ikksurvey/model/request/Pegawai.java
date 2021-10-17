package id.go.lan.pusaka.ikksurvey.model.request;

import java.util.Date;

import javax.persistence.Table;

@Table(name = "pegawai")
public class Pegawai {
	private Long id;
	private String nipBaru;
	private String nipLama;
	private String nama;
	private String tempatLahir;
	private Date tglLahir;
	private String alamat;
	private String jenisKelamin;

	private String instansiKerjaNama;
	private String jenisJabatanId;
	private String jabatanStrukturalNama;
	private String jabatanFungsionalNama;
	private String jabatanFungsionalUmumNama;
	private String golRuangAkhir;
	private Date tmtCpns;
	private Date tmtPns;
	private String posisi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNipBaru() {
		return nipBaru;
	}

	public void setNipBaru(String nipBaru) {
		this.nipBaru = nipBaru;
	}

	public String getNipLama() {
		return nipLama;
	}

	public void setNipLama(String nipLama) {
		this.nipLama = nipLama;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public Date getTglLahir() {
		return tglLahir;
	}

	public void setTglLahir(Date tglLahir) {
		this.tglLahir = tglLahir;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public String getInstansiKerjaNama() {
		return instansiKerjaNama;
	}

	public void setInstansiKerjaNama(String instansiKerjaNama) {
		this.instansiKerjaNama = instansiKerjaNama;
	}

	public String getJenisJabatanId() {
		return jenisJabatanId;
	}

	public void setJenisJabatanId(String jenisJabatanId) {
		this.jenisJabatanId = jenisJabatanId;
	}

	public String getJabatanStrukturalNama() {
		return jabatanStrukturalNama;
	}

	public void setJabatanStrukturalNama(String jabatanStrukturalNama) {
		this.jabatanStrukturalNama = jabatanStrukturalNama;
	}

	public String getJabatanFungsionalNama() {
		return jabatanFungsionalNama;
	}

	public void setJabatanFungsionalNama(String jabatanFungsionalNama) {
		this.jabatanFungsionalNama = jabatanFungsionalNama;
	}

	public String getJabatanFungsionalUmumNama() {
		return jabatanFungsionalUmumNama;
	}

	public void setJabatanFungsionalUmumNama(String jabatanFungsionalUmumNama) {
		this.jabatanFungsionalUmumNama = jabatanFungsionalUmumNama;
	}

	public String getGolRuangAkhir() {
		return golRuangAkhir;
	}

	public void setGolRuangAkhir(String golRuangAkhir) {
		this.golRuangAkhir = golRuangAkhir;
	}

	public Date getTmtCpns() {
		return tmtCpns;
	}

	public void setTmtCpns(Date tmtCpns) {
		this.tmtCpns = tmtCpns;
	}

	public Date getTmtPns() {
		return tmtPns;
	}

	public void setTmtPns(Date tmtPns) {
		this.tmtPns = tmtPns;
	}

	public String getPosisi() {
		return posisi;
	}

	public void setPosisi(String posisi) {
		this.posisi = posisi;
	}

}
