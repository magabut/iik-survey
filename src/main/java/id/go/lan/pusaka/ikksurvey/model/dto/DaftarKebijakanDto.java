package id.go.lan.pusaka.ikksurvey.model.dto;

import java.util.Date;

public class DaftarKebijakanDto {
    private String namaInstansi;
    private Integer totalKebijakan;
    private String nipAdminInstansi;
    private Date tanggal;

    public String getNamaInstansi() {
        return namaInstansi;
    }

    public void setNamaInstansi(String namaInstansi) {
        this.namaInstansi = namaInstansi;
    }

    public Integer getTotalKebijakan() {
        return totalKebijakan;
    }

    public void setTotalKebijakan(Integer totalKebijakan) {
        this.totalKebijakan = totalKebijakan;
    }

    public String getNipAdminInstansi() {
        return nipAdminInstansi;
    }

    public void setNipAdminInstansi(String nipAdminInstansi) {
        this.nipAdminInstansi = nipAdminInstansi;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
