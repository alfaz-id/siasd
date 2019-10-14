package com.alfazid.siasd.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cigist on 04/08/19.
 */
@Entity
@Table(name = "provinsi", schema = "")
public class ProvinsiEntity {
    private int idProvinsi;
    private Integer kodeProvinsi;
    private String namaProvinsi;
    private String active;
    private Integer userCreated;
    private Timestamp timestampCreated;
    private Integer userUpdated;
    private Timestamp timestampUpdate;

    public ProvinsiEntity() {
    }

    public ProvinsiEntity(int idProvinsi,String namaProvinsi) {
        this.idProvinsi = idProvinsi;
        this.namaProvinsi = namaProvinsi;
    }

    public ProvinsiEntity(int idProvinsi, Integer kodeProvinsi, String namaProvinsi, String active, Integer userCreated, Timestamp timestampCreated, Integer userUpdated, Timestamp timestampUpdate) {
        this.idProvinsi = idProvinsi;
        this.kodeProvinsi = kodeProvinsi;
        this.namaProvinsi = namaProvinsi;
        this.active = active;
        this.userCreated = userCreated;
        this.timestampCreated = timestampCreated;
        this.userUpdated = userUpdated;
        this.timestampUpdate = timestampUpdate;
    }

    @Id
    @Column(name = "id_provinsi")
    public int getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(int idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    @Basic
    @Column(name = "kode_provinsi")
    public Integer getKodeProvinsi() {
        return kodeProvinsi;
    }

    public void setKodeProvinsi(Integer kodeProvinsi) {
        this.kodeProvinsi = kodeProvinsi;
    }

    @Basic
    @Column(name = "nama_provinsi")
    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
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

        ProvinsiEntity that = (ProvinsiEntity) o;

        if (idProvinsi != that.idProvinsi) return false;
        if (kodeProvinsi != null ? !kodeProvinsi.equals(that.kodeProvinsi) : that.kodeProvinsi != null) return false;
        if (namaProvinsi != null ? !namaProvinsi.equals(that.namaProvinsi) : that.namaProvinsi != null) return false;
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
        int result = idProvinsi;
        result = 31 * result + (kodeProvinsi != null ? kodeProvinsi.hashCode() : 0);
        result = 31 * result + (namaProvinsi != null ? namaProvinsi.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (userCreated != null ? userCreated.hashCode() : 0);
        result = 31 * result + (timestampCreated != null ? timestampCreated.hashCode() : 0);
        result = 31 * result + (userUpdated != null ? userUpdated.hashCode() : 0);
        result = 31 * result + (timestampUpdate != null ? timestampUpdate.hashCode() : 0);
        return result;
    }
}
