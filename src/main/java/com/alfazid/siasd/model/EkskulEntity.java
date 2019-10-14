package com.alfazid.siasd.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cigist on 04/08/19.
 */
@Entity
@Table(name = "ekskul", schema = "")
public class EkskulEntity {
    private int idSekolah;
    private int idEkskul;
    private String namaEkskul;
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
    @Column(name = "id_ekskul")
    public int getIdEkskul() {
        return idEkskul;
    }

    public void setIdEkskul(int idEkskul) {
        this.idEkskul = idEkskul;
    }

    @Basic
    @Column(name = "nama_ekskul")
    public String getNamaEkskul() {
        return namaEkskul;
    }

    public void setNamaEkskul(String namaEkskul) {
        this.namaEkskul = namaEkskul;
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

        EkskulEntity that = (EkskulEntity) o;

        if (idSekolah != that.idSekolah) return false;
        if (idEkskul != that.idEkskul) return false;
        if (namaEkskul != null ? !namaEkskul.equals(that.namaEkskul) : that.namaEkskul != null) return false;
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
        result = 31 * result + idEkskul;
        result = 31 * result + (namaEkskul != null ? namaEkskul.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (userCreated != null ? userCreated.hashCode() : 0);
        result = 31 * result + (timestampCreated != null ? timestampCreated.hashCode() : 0);
        result = 31 * result + (userUpdated != null ? userUpdated.hashCode() : 0);
        result = 31 * result + (timestampUpdate != null ? timestampUpdate.hashCode() : 0);
        return result;
    }
}
