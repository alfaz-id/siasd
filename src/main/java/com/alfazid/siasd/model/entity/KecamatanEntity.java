package com.alfazid.siasd.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cigist on 04/08/19.
 */
@Entity
@Table(name = "kecamatan", schema = "")
public class KecamatanEntity {
    private int idKecamatan;
    private int idKabupaten;
    private String kodeKecamatan;
    private String namaKecamatan;
    private String active;
    private Integer userCreated;
    private Timestamp timestampCreated;
    private Integer userUpdated;
    private Timestamp timestampUpdate;
    
    

    public KecamatanEntity() {
		super();
	}

	public KecamatanEntity(int idKecamatan, String namaKecamatan) {
		super();
		this.idKecamatan = idKecamatan;
		this.namaKecamatan = namaKecamatan;
	}

	public KecamatanEntity(int idKecamatan, int idKabupaten, String kodeKecamatan, String namaKecamatan,
			String active, Integer userCreated, Timestamp timestampCreated, Integer userUpdated,
			Timestamp timestampUpdate) {
		super();
		this.idKecamatan = idKecamatan;
		this.idKabupaten = idKabupaten;
		this.kodeKecamatan = kodeKecamatan;
		this.namaKecamatan = namaKecamatan;
		this.active = active;
		this.userCreated = userCreated;
		this.timestampCreated = timestampCreated;
		this.userUpdated = userUpdated;
		this.timestampUpdate = timestampUpdate;
	}

	@Id
    @Column(name = "id_kecamatan")
    public int getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(int idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    @Basic
    @Column(name = "id_kabupaten")
    public int getIdKabupaten() {
        return idKabupaten;
    }

    public void setIdKabupaten(int idKabuaten) {
        this.idKabupaten = idKabupaten;
    }

    @Basic
    @Column(name = "kode_kecamatan")
    public String getKodeKecamatan() {
        return kodeKecamatan;
    }

    public void setKodeKecamatan(String kodeKecamatan) {
        this.kodeKecamatan = kodeKecamatan;
    }

    @Basic
    @Column(name = "nama_kecamatan")
    public String getNamaKecamatan() {
        return namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
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

        KecamatanEntity that = (KecamatanEntity) o;

        if (idKecamatan != that.idKecamatan) return false;
        if (idKabupaten != that.idKabupaten) return false;
        if (kodeKecamatan != null ? !kodeKecamatan.equals(that.kodeKecamatan) : that.kodeKecamatan != null)
            return false;
        if (namaKecamatan != null ? !namaKecamatan.equals(that.namaKecamatan) : that.namaKecamatan != null)
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
        int result = idKecamatan;
        result = 31 * result + (kodeKecamatan != null ? kodeKecamatan.hashCode() : 0);
        result = 31 * result + (namaKecamatan != null ? namaKecamatan.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (userCreated != null ? userCreated.hashCode() : 0);
        result = 31 * result + (timestampCreated != null ? timestampCreated.hashCode() : 0);
        result = 31 * result + (userUpdated != null ? userUpdated.hashCode() : 0);
        result = 31 * result + (timestampUpdate != null ? timestampUpdate.hashCode() : 0);
        return result;
    }
}
