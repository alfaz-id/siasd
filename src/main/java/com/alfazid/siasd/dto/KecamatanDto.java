package com.alfazid.siasd.dto;

import java.sql.Timestamp;

public class KecamatanDto {
	private int idKecamatan;
	private int idKabupaten;
	private String namaKabupaten;
	private String kodeKecamatan;
	private String namaKecamatan;
	private String active;
	private Integer userCreated;
	private Timestamp timestampCreated;
	private Integer userUpdated;
	private Timestamp timestampUpdate;

	public KecamatanDto() {
	}

	public KecamatanDto(int idKecamatan, int idKabupaten, String namaKabupaten, String kodeKecamatan, String namaKecamatan, String active, Integer userCreated, Timestamp timestampCreated, Integer userUpdated, Timestamp timestampUpdate) {
		this.idKecamatan = idKecamatan;
		this.idKabupaten = idKabupaten;
		this.namaKabupaten = namaKabupaten;
		this.kodeKecamatan = kodeKecamatan;
		this.namaKecamatan = namaKecamatan;
		this.active = active;
		this.userCreated = userCreated;
		this.timestampCreated = timestampCreated;
		this.userUpdated = userUpdated;
		this.timestampUpdate = timestampUpdate;
	}

	public int getIdKecamatan() {
		return idKecamatan;
	}

	public void setIdKecamatan(int idKecamatan) {
		this.idKecamatan = idKecamatan;
	}

	public int getIdKabupaten() {
		return idKabupaten;
	}

	public void setIdKabupaten(int idKabupaten) {
		this.idKabupaten = idKabupaten;
	}

	public String getNamaKabupaten() {
		return namaKabupaten;
	}

	public void setNamaKabupaten(String namaKabupaten) {
		this.namaKabupaten = namaKabupaten;
	}

	public String getKodeKecamatan() {
		return kodeKecamatan;
	}

	public void setKodeKecamatan(String kodeKecamatan) {
		this.kodeKecamatan = kodeKecamatan;
	}

	public String getNamaKecamatan() {
		return namaKecamatan;
	}

	public void setNamaKecamatan(String namaKecamatan) {
		this.namaKecamatan = namaKecamatan;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Integer getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(Integer userCreated) {
		this.userCreated = userCreated;
	}

	public Timestamp getTimestampCreated() {
		return timestampCreated;
	}

	public void setTimestampCreated(Timestamp timestampCreated) {
		this.timestampCreated = timestampCreated;
	}

	public Integer getUserUpdated() {
		return userUpdated;
	}

	public void setUserUpdated(Integer userUpdated) {
		this.userUpdated = userUpdated;
	}

	public Timestamp getTimestampUpdate() {
		return timestampUpdate;
	}

	public void setTimestampUpdate(Timestamp timestampUpdate) {
		this.timestampUpdate = timestampUpdate;
	}
}
