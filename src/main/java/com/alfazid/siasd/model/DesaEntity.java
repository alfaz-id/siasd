package com.alfazid.siasd.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cigist on 04/08/19.
 */
@Entity
@Table(name = "desa", schema = "")
public class DesaEntity {
    private int idDesa;
    private Integer idKecamatan;
    private String kodeDesa;
    private String namaDesa;
    private String active;
    private Integer userCreated;
    private Timestamp timestampCreated;
    private Integer userUpdated;
    private Timestamp timestampUpdate;

    public DesaEntity() {
    }

    public DesaEntity(int idDesa,String namaDesa) {
        this.idDesa = idDesa;
        this.namaDesa = namaDesa;
    }

    public DesaEntity(int idDesa, Integer idKecamatan, String kodeDesa, String namaDesa, String active, Integer userCreated, Timestamp timestampCreated, Integer userUpdated, Timestamp timestampUpdate) {
        this.idDesa = idDesa;
        this.idKecamatan = idKecamatan;
        this.kodeDesa = kodeDesa;
        this.namaDesa = namaDesa;
        this.active = active;
        this.userCreated = userCreated;
        this.timestampCreated = timestampCreated;
        this.userUpdated = userUpdated;
        this.timestampUpdate = timestampUpdate;
    }

    @Id
    @Column(name = "id_desa")
    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    @Basic
    @Column(name = "id_kecamatan")
    public Integer getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(Integer idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    @Basic
    @Column(name = "kode_desa")
    public String getKodeDesa() {
        return kodeDesa;
    }

    public void setKodeDesa(String kodeDesa) {
        this.kodeDesa = kodeDesa;
    }

    @Basic
    @Column(name = "nama_desa")
    public String getNamaDesa() {
        return namaDesa;
    }

    public void setNamaDesa(String namaDesa) {
        this.namaDesa = namaDesa;
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

        DesaEntity that = (DesaEntity) o;

        if (idDesa != that.idDesa) return false;
        if (idKecamatan != null ? !idKecamatan.equals(that.idKecamatan) : that.idKecamatan != null) return false;
        if (kodeDesa != null ? !kodeDesa.equals(that.kodeDesa) : that.kodeDesa != null) return false;
        if (namaDesa != null ? !namaDesa.equals(that.namaDesa) : that.namaDesa != null) return false;
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
        int result = idDesa;
        result = 31 * result + (idKecamatan != null ? idKecamatan.hashCode() : 0);
        result = 31 * result + (kodeDesa != null ? kodeDesa.hashCode() : 0);
        result = 31 * result + (namaDesa != null ? namaDesa.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (userCreated != null ? userCreated.hashCode() : 0);
        result = 31 * result + (timestampCreated != null ? timestampCreated.hashCode() : 0);
        result = 31 * result + (userUpdated != null ? userUpdated.hashCode() : 0);
        result = 31 * result + (timestampUpdate != null ? timestampUpdate.hashCode() : 0);
        return result;
    }
}
