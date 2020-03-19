package com.alfazid.siasd.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cigist on 04/08/19.
 */
@Entity
@Table(name = "global")
public class GlobalEntity {
    private int idGlobal;
    private String kodeGlobal;
    private String typeMaster;
    private String keterangan;
    private String active;
    private Integer userCreated;
    private Timestamp timestampCreated;
    private Integer userUpdated;
    private Timestamp timestampUpdate;

    @Id
    @Column(name = "id_global")
    public int getIdGlobal() {
        return idGlobal;
    }

    public void setIdGlobal(int idGlobal) {
        this.idGlobal = idGlobal;
    }

    @Basic
    @Column(name = "kode_global")
    public String getKodeGlobal() {
        return kodeGlobal;
    }

    public void setKodeGlobal(String kodeGlobal) {
        this.kodeGlobal = kodeGlobal;
    }

    @Basic
    @Column(name = "type_master")
    public String getTypeMaster() {
		return typeMaster;
	}

	public void setTypeMaster(String typeMaster) {
		this.typeMaster = typeMaster;
	}

	@Basic
    @Column(name = "keterangan")
    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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

        GlobalEntity that = (GlobalEntity) o;

        if (idGlobal != that.idGlobal) return false;
        if (kodeGlobal != null ? !kodeGlobal.equals(that.kodeGlobal) : that.kodeGlobal != null) return false;
        if (keterangan != null ? !keterangan.equals(that.keterangan) : that.keterangan != null) return false;
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
        int result = idGlobal;
        result = 31 * result + (kodeGlobal != null ? kodeGlobal.hashCode() : 0);
        result = 31 * result + (keterangan != null ? keterangan.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (userCreated != null ? userCreated.hashCode() : 0);
        result = 31 * result + (timestampCreated != null ? timestampCreated.hashCode() : 0);
        result = 31 * result + (userUpdated != null ? userUpdated.hashCode() : 0);
        result = 31 * result + (timestampUpdate != null ? timestampUpdate.hashCode() : 0);
        return result;
    }
}
