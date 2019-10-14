package com.alfazid.siasd.dto;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 31/08/19.
 */
public class GuruDto {
    private int idGuru;
    private String namaGuru;

    public GuruDto(int idGuru) {
        this.idGuru = idGuru;
    }

    public GuruDto(int idGuru, String namaGuru) {
        this.idGuru = idGuru;
        this.namaGuru = namaGuru;
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
}
