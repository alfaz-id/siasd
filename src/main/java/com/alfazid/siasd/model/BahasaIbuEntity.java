package com.alfazid.siasd.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cigist on 04/08/19.
 */
@Entity
@Table(name = "bahasa_ibu", schema = "")
public class BahasaIbuEntity {
    private int idBahasaIbu;
    private String namaBahasaIbu;
    private String active;
    private Integer userCreated;
    private Timestamp timestampCreated;
    private Integer userUpdated;
    private Timestamp timestampUpdate;

    @Id
    @Column(name = "id_bahasa_ibu")
    public int getIdBahasaIbu() {
        return idBahasaIbu;
    }

    public void setIdBahasaIbu(int idBahasaIbu) {
        this.idBahasaIbu = idBahasaIbu;
    }

    @Basic
    @Column(name = "nama_bahasa_ibu")
    public String getNamaBahasaIbu() {
        return namaBahasaIbu;
    }

    public void setNamaBahasaIbu(String namaBahasaIbu) {
        this.namaBahasaIbu = namaBahasaIbu;
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

        BahasaIbuEntity that = (BahasaIbuEntity) o;

        if (idBahasaIbu != that.idBahasaIbu) return false;
        if (namaBahasaIbu != null ? !namaBahasaIbu.equals(that.namaBahasaIbu) : that.namaBahasaIbu != null)
            return false;
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
        int result = idBahasaIbu;
        result = 31 * result + (namaBahasaIbu != null ? namaBahasaIbu.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (userCreated != null ? userCreated.hashCode() : 0);
        result = 31 * result + (timestampCreated != null ? timestampCreated.hashCode() : 0);
        result = 31 * result + (userUpdated != null ? userUpdated.hashCode() : 0);
        result = 31 * result + (timestampUpdate != null ? timestampUpdate.hashCode() : 0);
        return result;
    }
}
