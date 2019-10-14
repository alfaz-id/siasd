package com.alfazid.siasd.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cigist on 04/08/19.
 */
@Entity
@Table(name = "nilai_mapel", schema = "")
public class NilaiMapelEntity {
    private int idSekolah;
    private int idNilaiMapel;
    private int idMapel;
    private int idGuru;
    private int idSiswa;
    private Integer kkm;
    private Integer ki12;
    private Integer ki3;
    private Integer ki4;
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
    @Column(name = "id_nilai_mapel")
    public int getIdNilaiMapel() {
        return idNilaiMapel;
    }

    public void setIdNilaiMapel(int idNilaiMapel) {
        this.idNilaiMapel = idNilaiMapel;
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
    @Column(name = "id_guru")
    public int getIdGuru() {
        return idGuru;
    }

    public void setIdGuru(int idGuru) {
        this.idGuru = idGuru;
    }

    @Basic
    @Column(name = "id_siswa")
    public int getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(int idSiswa) {
        this.idSiswa = idSiswa;
    }

    @Basic
    @Column(name = "kkm")
    public Integer getKkm() {
        return kkm;
    }

    public void setKkm(Integer kkm) {
        this.kkm = kkm;
    }

    @Basic
    @Column(name = "ki_1_2")
    public Integer getKi12() {
        return ki12;
    }

    public void setKi12(Integer ki12) {
        this.ki12 = ki12;
    }

    @Basic
    @Column(name = "ki_3")
    public Integer getKi3() {
        return ki3;
    }

    public void setKi3(Integer ki3) {
        this.ki3 = ki3;
    }

    @Basic
    @Column(name = "ki_4")
    public Integer getKi4() {
        return ki4;
    }

    public void setKi4(Integer ki4) {
        this.ki4 = ki4;
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

        NilaiMapelEntity that = (NilaiMapelEntity) o;

        if (idSekolah != that.idSekolah) return false;
        if (idNilaiMapel != that.idNilaiMapel) return false;
        if (idMapel != that.idMapel) return false;
        if (idGuru != that.idGuru) return false;
        if (idSiswa != that.idSiswa) return false;
        if (kkm != null ? !kkm.equals(that.kkm) : that.kkm != null) return false;
        if (ki12 != null ? !ki12.equals(that.ki12) : that.ki12 != null) return false;
        if (ki3 != null ? !ki3.equals(that.ki3) : that.ki3 != null) return false;
        if (ki4 != null ? !ki4.equals(that.ki4) : that.ki4 != null) return false;
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
        result = 31 * result + idNilaiMapel;
        result = 31 * result + idMapel;
        result = 31 * result + idGuru;
        result = 31 * result + idSiswa;
        result = 31 * result + (kkm != null ? kkm.hashCode() : 0);
        result = 31 * result + (ki12 != null ? ki12.hashCode() : 0);
        result = 31 * result + (ki3 != null ? ki3.hashCode() : 0);
        result = 31 * result + (ki4 != null ? ki4.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (userCreated != null ? userCreated.hashCode() : 0);
        result = 31 * result + (timestampCreated != null ? timestampCreated.hashCode() : 0);
        result = 31 * result + (userUpdated != null ? userUpdated.hashCode() : 0);
        result = 31 * result + (timestampUpdate != null ? timestampUpdate.hashCode() : 0);
        return result;
    }
}
