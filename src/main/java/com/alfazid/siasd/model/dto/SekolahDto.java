package com.alfazid.siasd.model.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SekolahDto{
    private int idSekolah;
    private String kodeSekolah;
    private String namaSekolah;
    private Integer tipeSekolah;
    private String nomorIzinSekolah;
    private String akreditasi;
    private String alamat;
    private String telepon;
    private String active;
    private Integer userCreated;
    private Timestamp timestampCreated;
    private Integer userUpdated;
    private Timestamp timestampUpdate;
}