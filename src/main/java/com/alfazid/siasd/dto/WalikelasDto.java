package com.alfazid.siasd.dto;

import java.sql.Timestamp;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 07/09/19.
 */
public class WalikelasDto {
    private int idSekolah;
    private int idWakel;
    private int idKelas;
    private String namaKelas;
    private int idGuru;
    private String namaGuru;
    private String tahunAjaran;
    private int semester;
    private String active;
    private Integer userCreated;
    private Timestamp timestampCreated;
    private Integer userUpdated;
    private Timestamp timestampUpdate;

    public WalikelasDto() {
    }

    public WalikelasDto(int idSekolah, int idWakel, int idKelas, String namaKelas, int idGuru, String namaGuru, String tahuAjaran, int semester, String active, Integer userCreated, Timestamp timestampCreated, Integer userUpdated, Timestamp timestampUpdate) {
        this.idSekolah = idSekolah;
        this.idWakel = idWakel;
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
        this.idGuru = idGuru;
        this.namaGuru = namaGuru;
        this.tahunAjaran = tahuAjaran;
        this.semester = semester;
        this.active = active;
        this.userCreated = userCreated;
        this.timestampCreated = timestampCreated;
        this.userUpdated = userUpdated;
        this.timestampUpdate = timestampUpdate;
    }

    public int getIdSekolah() {
        return idSekolah;
    }

    public void setIdSekolah(int idSekolah) {
        this.idSekolah = idSekolah;
    }

    public int getIdWakel() {
        return idWakel;
    }

    public void setIdWakel(int idWakel) {
        this.idWakel = idWakel;
    }

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public int getIdGuru() {
        return idGuru;
    }

    public void setIdGuru(int idGuru) {
        this.idGuru = idGuru;
    }

    public String getNamaGuru() {
        return namaGuru;
    }

    public void setNamaGuru(String namaGuru) {
        this.namaGuru = namaGuru;
    }

    public String getTahunAjaran() {
        return tahunAjaran;
    }

    public void setTahunAjaran(String tahuAjaran) {
        this.tahunAjaran = tahuAjaran;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
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
