package com.alfazid.siasd.model.dto;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 31/08/19.
 */
public class KelasDto {
    private int idKelas;
    private String namaKelas;

    public KelasDto() {

    }

    public KelasDto(int idKelas, String namaKelas) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
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
}
