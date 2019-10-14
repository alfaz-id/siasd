package com.alfazid.siasd.dto;

import java.sql.Timestamp;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 31/08/19.
 */
public class MengajarDto {
    private int idSekolah;
    private int idMengajar;
    private int idGuru;
    private String namaGuru;
    private int idKelas;
    private String namaKelas;
    private int idMapel;
    private String namaMapel;
    private String tahunAjaran;
    private int semester;
    private String active;
    private Integer userCreated;
    private Timestamp timestampCreated;
    private Integer userUpdated;
    private Timestamp timestampUpdate;

    public MengajarDto() {
    }

    public MengajarDto(int idSekolah, int idMengajar, int idGuru, String namaGuru, int idKelas, String namaKelas, int idMapel, String namaMapel, String tahunAjaran, int semester, String active, Integer userCreated, Timestamp timestampCreated, Integer userUpdated, Timestamp timestampUpdate) {
        this.idSekolah = idSekolah;
        this.idMengajar = idMengajar;
        this.idGuru = idGuru;
        this.namaGuru = namaGuru;
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
        this.idMapel = idMapel;
        this.namaMapel = namaMapel;
        this.tahunAjaran = tahunAjaran;
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

    public int getIdMengajar() {
        return idMengajar;
    }

    public void setIdMengajar(int idMengajar) {
        this.idMengajar = idMengajar;
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

    public int getIdMapel() {
        return idMapel;
    }

    public void setIdMapel(int idMapel) {
        this.idMapel = idMapel;
    }

    public String getNamaMapel() {
        return namaMapel;
    }

    public void setNamaMapel(String namaMapel) {
        this.namaMapel = namaMapel;
    }

    public String getTahunAjaran() {
        return tahunAjaran;
    }

    public void setTahunAjaran(String tahunAjaran) {
        this.tahunAjaran = tahunAjaran;
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
