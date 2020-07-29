package com.alfazid.siasd.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cigist on 04/08/19.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wali_kelas", schema = "")
public class WaliKelasEntity {
    @Column(name = "id_sekolah")
    private int idSekolah;
    @Id
    @Column(name = "id_wakel")
    private int idWakel;
    @Column(name = "id_kelas")
    private Integer idKelas;
    @Column(name = "id_guru")
    private Integer idGuru;
    @Column(name = "tahun_ajaran")
    private String tahunAjaran;
    @Column(name = "semester")
    private Integer semester;
    @Column(name = "active")
    private String active;
    @Column(name = "user_created")
    private Integer userCreated;
    @Column(name = "timestamp_created")
    private Timestamp timestampCreated;
    @Column(name = "user_updated")
    private Integer userUpdated;
    @Column(name = "timestamp_update")
    private Timestamp timestampUpdate;
}
