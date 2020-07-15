package com.alfazid.siasd.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 08/08/19.
 */

@Entity
@Table(name = "guru", schema = "")
public class GuruEntity {
    private int idSekolah;
    private int idGuru;
    private String nip;
    private String namaGuru;
    private String jenisKelamin;
    private String alamat;
    private String telepon;
    private String email;
    private String active;
    private Integer userCreated;
    private Timestamp timestampCreated;
    private Integer userUpdated;
    private Timestamp timestampUpdate;

    @Basic
    @Column(name = "id_sekolah")
    public int getIdSekolah() {
        return idSekolah;
    }

    public void setIdSekolah(int idSekolah) {
        this.idSekolah = idSekolah;
    }

    @Id
    @Column(name = "id_guru")
    public int getIdGuru() {
        return idGuru;
    }

    public void setIdGuru(int idGuru) {
        this.idGuru = idGuru;
    }

    @Basic
    @Column(name = "nip")
    @NotBlank(message = "Nip wajib diisi")
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Basic
    @Column(name = "nama_guru")
    @NotBlank(message = "Nama wajib diisi")
    public String getNamaGuru() {
        return namaGuru;
    }

    public void setNamaGuru(String namaGuru) {
        this.namaGuru = namaGuru;
    }

    @Basic
    @Column(name = "jenis_kelamin")
    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    @Basic
    @Column(name = "alamat")
    @NotBlank(message = "Alamat wajib diisi")
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Basic
    @Column(name = "telepon")
    @NotBlank(message = "Telepon wajib diisi")
    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

        GuruEntity guruEntity = (GuruEntity) o;

        if (idSekolah != guruEntity.idSekolah) return false;
        if (idGuru != guruEntity.idGuru) return false;
        if (nip != null ? !nip.equals(guruEntity.nip) : guruEntity.nip != null) return false;
        if (namaGuru != null ? !namaGuru.equals(guruEntity.namaGuru) : guruEntity.namaGuru != null) return false;
        if (jenisKelamin != null ? !jenisKelamin.equals(guruEntity.jenisKelamin) : guruEntity.jenisKelamin != null) return false;
        if (alamat != null ? !alamat.equals(guruEntity.alamat) : guruEntity.alamat != null) return false;
        if (telepon != null ? !telepon.equals(guruEntity.telepon) : guruEntity.telepon != null) return false;
//        if (email != null ? !email.equals(guruEntity.email) : guruEntity.email != null) return false;
        if (active != null ? !active.equals(guruEntity.active) : guruEntity.active != null) return false;
        if (userCreated != null ? !userCreated.equals(guruEntity.userCreated) : guruEntity.userCreated != null) return false;
        if (timestampCreated != null ? !timestampCreated.equals(guruEntity.timestampCreated) : guruEntity.timestampCreated != null)
            return false;
        if (userUpdated != null ? !userUpdated.equals(guruEntity.userUpdated) : guruEntity.userUpdated != null) return false;
        if (timestampUpdate != null ? !timestampUpdate.equals(guruEntity.timestampUpdate) : guruEntity.timestampUpdate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSekolah;
        result = 31 * result + idGuru;
        result = 31 * result + (nip != null ? nip.hashCode() : 0);
        result = 31 * result + (namaGuru != null ? namaGuru.hashCode() : 0);
        result = 31 * result + (jenisKelamin != null ? jenisKelamin.hashCode() : 0);
        result = 31 * result + (alamat != null ? alamat.hashCode() : 0);
        result = 31 * result + (telepon != null ? telepon.hashCode() : 0);
//        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (userCreated != null ? userCreated.hashCode() : 0);
        result = 31 * result + (timestampCreated != null ? timestampCreated.hashCode() : 0);
        result = 31 * result + (userUpdated != null ? userUpdated.hashCode() : 0);
        result = 31 * result + (timestampUpdate != null ? timestampUpdate.hashCode() : 0);
        return result;
    }
}
