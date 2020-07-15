package com.alfazid.siasd.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cigist on 04/08/19.
 */
@Entity
@Table(name = "sekolah", schema = "")
public class SekolahEntity {
    private int idSekolah;
    private String kodeSekolah;
    private String namaSekolah;
    private Integer tipeSekolah;
    private String nomorIzinSekolah;
    private String akreditasi;
    private String alamat;
    private String telepon;
    private String active;
    private Integer userCreated;
    private Timestamp timestampCreated;
    private Integer userUpdated;
    private Timestamp timestampUpdate;

    @Id
    @Column(name = "id_sekolah")
    public int getIdSekolah() {
        return idSekolah;
    }

    public void setIdSekolah(int idSekolah) {
        this.idSekolah = idSekolah;
    }

    @Basic
    @Column(name = "kode_sekolah")
    public String getKodeSekolah() {
        return kodeSekolah;
    }

    public void setKodeSekolah(String kodeSekolah) {
        this.kodeSekolah = kodeSekolah;
    }

    @Basic
    @Column(name = "nama_sekolah")
    public String getNamaSekolah() {
        return namaSekolah;
    }

    public void setNamaSekolah(String namaSekolah) {
        this.namaSekolah = namaSekolah;
    }

    @Basic
    @Column(name = "tipe_sekolah")
    public Integer getTipeSekolah() {
        return tipeSekolah;
    }

    public void setTipeSekolah(Integer tipeSekolah) {
        this.tipeSekolah = tipeSekolah;
    }

    @Basic
    @Column(name = "nomor_izin_sekolah")
    public String getNomorIzinSekolah() {
        return nomorIzinSekolah;
    }

    public void setNomorIzinSekolah(String nomorIzinSekolah) {
        this.nomorIzinSekolah = nomorIzinSekolah;
    }

    @Basic
    @Column(name = "akreditasi")
    public String getAkreditasi() {
        return akreditasi;
    }

    public void setAkreditasi(String akreditasi) {
        this.akreditasi = akreditasi;
    }

    @Basic
    @Column(name = "alamat")
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Basic
    @Column(name = "telepon")
    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    @Basic
    @Column(name = "active")
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Basic
    @Column(name = "user_created")
    public Integer getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Integer userCreated) {
        this.userCreated = userCreated;
    }

    @Basic
    @Column(name = "timestamp_created")
    public Timestamp getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(Timestamp timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    @Basic
    @Column(name = "user_updated")
    public Integer getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(Integer userUpdated) {
        this.userUpdated = userUpdated;
    }

    @Basic
    @Column(name = "timestamp_update")
    public Timestamp getTimestampUpdate() {
        return timestampUpdate;
    }

    public void setTimestampUpdate(Timestamp timestampUpdate) {
        this.timestampUpdate = timestampUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SekolahEntity that = (SekolahEntity) o;

        if (idSekolah != that.idSekolah) return false;
        if (kodeSekolah != null ? !kodeSekolah.equals(that.kodeSekolah) : that.kodeSekolah != null) return false;
        if (namaSekolah != null ? !namaSekolah.equals(that.namaSekolah) : that.namaSekolah != null) return false;
        if (tipeSekolah != null ? !tipeSekolah.equals(that.tipeSekolah) : that.tipeSekolah != null) return false;
        if (nomorIzinSekolah != null ? !nomorIzinSekolah.equals(that.nomorIzinSekolah) : that.nomorIzinSekolah != null)
            return false;
        if (akreditasi != null ? !akreditasi.equals(that.akreditasi) : that.akreditasi != null) return false;
        if (alamat != null ? !alamat.equals(that.alamat) : that.alamat != null) return false;
        if (telepon != null ? !telepon.equals(that.telepon) : that.telepon != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (userCreated != null ? !userCreated.equals(that.userCreated) : that.userCreated != null) return false;
        if (timestampCreated != null ? !timestampCreated.equals(that.timestampCreated) : that.timestampCreated != null)
            return false;
        if (userUpdated != null ? !userUpdated.equals(that.userUpdated) : that.userUpdated != null) return false;
        if (timestampUpdate != null ? !timestampUpdate.equals(that.timestampUpdate) : that.timestampUpdate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSekolah;
        result = 31 * result + (kodeSekolah != null ? kodeSekolah.hashCode() : 0);
        result = 31 * result + (namaSekolah != null ? namaSekolah.hashCode() : 0);
        result = 31 * result + (tipeSekolah != null ? tipeSekolah.hashCode() : 0);
        result = 31 * result + (nomorIzinSekolah != null ? nomorIzinSekolah.hashCode() : 0);
        result = 31 * result + (akreditasi != null ? akreditasi.hashCode() : 0);
        result = 31 * result + (alamat != null ? alamat.hashCode() : 0);
        result = 31 * result + (telepon != null ? telepon.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (userCreated != null ? userCreated.hashCode() : 0);
        result = 31 * result + (timestampCreated != null ? timestampCreated.hashCode() : 0);
        result = 31 * result + (userUpdated != null ? userUpdated.hashCode() : 0);
        result = 31 * result + (timestampUpdate != null ? timestampUpdate.hashCode() : 0);
        return result;
    }
}
