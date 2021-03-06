package com.alfazid.siasd.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cigist on 04/08/19.
 */
@Entity
@Table(name = "mengajar", schema = "")
public class MengajarEntity {
    private int idSekolah;
    private int idMengajar;
    private int idGuru;
    private int idKelas;
    private int idMapel;
    private String tahunAjaran;
    private int semester;
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
    @Column(name = "id_mengajar")
    public int getIdMengajar() {
        return idMengajar;
    }

    public void setIdMengajar(int idMengajar) {
        this.idMengajar = idMengajar;
    }

    @Basic
    @Column(name = "id_guru")
    public int getIdGuru() {
        return idGuru;
    }

    public void setIdGuru(int idGuru) {
        this.idGuru = idGuru;
    }

    @Basic
    @Column(name = "id_kelas")
    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    @Basic
    @Column(name = "id_mapel")
    public int getIdMapel() {
        return idMapel;
    }

    public void setIdMapel(int idMapel) {
        this.idMapel = idMapel;
    }

    @Basic
    @Column(name = "tahun_ajaran")
    public String getTahunAjaran() {
        return tahunAjaran;
    }

    public void setTahunAjaran(String tahunAjaran) {
        this.tahunAjaran = tahunAjaran;
    }

    @Basic
    @Column(name = "semester")
    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
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

        MengajarEntity that = (MengajarEntity) o;

        if (idSekolah != that.idSekolah) return false;
        if (idMengajar != that.idMengajar) return false;
        if (idGuru != that.idGuru) return false;
        if (idKelas != that.idKelas) return false;
        if (idMapel != that.idMapel) return false;
        if (semester != that.semester) return false;
        if (tahunAjaran != null ? !tahunAjaran.equals(that.tahunAjaran) : that.tahunAjaran != null) return false;
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
        result = 31 * result + idMengajar;
        result = 31 * result + idGuru;
        result = 31 * result + idKelas;
        result = 31 * result + idMapel;
        result = 31 * result + (tahunAjaran != null ? tahunAjaran.hashCode() : 0);
        result = 31 * result + semester;
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (userCreated != null ? userCreated.hashCode() : 0);
        result = 31 * result + (timestampCreated != null ? timestampCreated.hashCode() : 0);
        result = 31 * result + (userUpdated != null ? userUpdated.hashCode() : 0);
        result = 31 * result + (timestampUpdate != null ? timestampUpdate.hashCode() : 0);
        return result;
    }
}
