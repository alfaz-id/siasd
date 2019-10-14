package com.alfazid.siasd.dto;

import java.sql.Timestamp;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 08/09/19.
 */
public class KabupatenDto {
    private int idKabupaten;
    private Integer idProvinsi;
    private String namaProvinsi;
    private String kodeKabupaten;
    private String namaKabupaten;
    private String active;
    private Integer userCreated;
    private Timestamp timestampCreated;
    private Integer userUpdated;
    private Timestamp timestampUpdate;

    public KabupatenDto() {
    }

    public KabupatenDto(int idKabupaten, Integer idProvinsi, String namaProvinsi, String kodeKabupaten, String namaKabupaten, String active, Integer userCreated, Timestamp timestampCreated, Integer userUpdated, Timestamp timestampUpdate) {
        this.idKabupaten = idKabupaten;
        this.idProvinsi = idProvinsi;
        this.namaProvinsi = namaProvinsi;
        this.kodeKabupaten = kodeKabupaten;
        this.namaKabupaten = namaKabupaten;
        this.active = active;
        this.userCreated = userCreated;
        this.timestampCreated = timestampCreated;
        this.userUpdated = userUpdated;
        this.timestampUpdate = timestampUpdate;
    }

    public int getIdKabupaten() {
        return idKabupaten;
    }

    public void setIdKabupaten(int idKabupaten) {
        this.idKabupaten = idKabupaten;
    }

    public Integer getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(Integer idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    public String getKodeKabupaten() {
        return kodeKabupaten;
    }

    public void setKodeKabupaten(String kodeKabupaten) {
        this.kodeKabupaten = kodeKabupaten;
    }

    public String getNamaKabupaten() {
        return namaKabupaten;
    }

    public void setNamaKabupaten(String namaKabupaten) {
        this.namaKabupaten = namaKabupaten;
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
