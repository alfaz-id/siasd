package com.alfazid.siasd.model.dto;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 31/08/19.
 */
public class MapelDto {
    private int idMapel;
    private String namaMapel;

    public MapelDto() {
    }

    public MapelDto(int idMapel, String namaMapel) {
        this.idMapel = idMapel;
        this.namaMapel = namaMapel;
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
}
