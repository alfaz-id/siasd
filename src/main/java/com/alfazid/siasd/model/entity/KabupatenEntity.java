package com.alfazid.siasd.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cigist on 04/08/19.
 */
@Entity
@Table(name = "kabupaten", schema = "")
public class KabupatenEntity {
    private int idKabupaten;
    private Integer idProvinsi;
    private String kodeKabupaten;
    private String namaKabupaten;
    private String active;
    private Integer userCreated;
    private Timestamp timestampCreated;
    private Integer userUpdated;
    private Timestamp timestampUpdate;

    
    public KabupatenEntity() {
		
	}

	public KabupatenEntity(int idKabupaten, String namaKabupaten) {
		this.idKabupaten = idKabupaten;
		this.namaKabupaten = namaKabupaten;
	}

	public KabupatenEntity(int idKabupaten, Integer idProvinsi, String kodeKabupaten, String namaKabupaten,
			String active, Integer userCreated, Timestamp timestampCreated, Integer userUpdated,
			Timestamp timestampUpdate) {
		super();
		this.idKabupaten = idKabupaten;
		this.idProvinsi = idProvinsi;
		this.kodeKabupaten = kodeKabupaten;
		this.namaKabupaten = namaKabupaten;
		this.active = active;
		this.userCreated = userCreated;
		this.timestampCreated = timestampCreated;
		this.userUpdated = userUpdated;
		this.timestampUpdate = timestampUpdate;
	}

	@Id
    @Column(name = "id_kabupaten")
    public int getIdKabupaten() {
        return idKabupaten;
    }

    public void setIdKabupaten(int idKabupaten) {
        this.idKabupaten = idKabupaten;
    }

    @Basic
    @Column(name = "id_provinsi")
    public Integer getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(Integer idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    @Basic
    @Column(name = "kode_kabupaten")
    public String getKodeKabupaten() {
        return kodeKabupaten;
    }

    public void setKodeKabupaten(String kodeKabupaten) {
        this.kodeKabupaten = kodeKabupaten;
    }

    @Basic
    @Column(name = "nama_kabupaten")
    public String getNamaKabupaten() {
        return namaKabupaten;
    }

    public void setNamaKabupaten(String namaKabupaten) {
        this.namaKabupaten = namaKabupaten;
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

        KabupatenEntity that = (KabupatenEntity) o;

        if (idKabupaten != that.idKabupaten) return false;
        if (idProvinsi != null ? !idProvinsi.equals(that.idProvinsi) : that.idProvinsi != null) return false;
        if (kodeKabupaten != null ? !kodeKabupaten.equals(that.kodeKabupaten) : that.kodeKabupaten != null)
            return false;
        if (namaKabupaten != null ? !namaKabupaten.equals(that.namaKabupaten) : that.namaKabupaten != null)
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
        int result = idKabupaten;
        result = 31 * result + (idProvinsi != null ? idProvinsi.hashCode() : 0);
        result = 31 * result + (kodeKabupaten != null ? kodeKabupaten.hashCode() : 0);
        result = 31 * result + (namaKabupaten != null ? namaKabupaten.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (userCreated != null ? userCreated.hashCode() : 0);
        result = 31 * result + (timestampCreated != null ? timestampCreated.hashCode() : 0);
        result = 31 * result + (userUpdated != null ? userUpdated.hashCode() : 0);
        result = 31 * result + (timestampUpdate != null ? timestampUpdate.hashCode() : 0);
        return result;
    }
}
