package com.alfazid.siasd.model.entity;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cigist on 04/08/19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "bahasa_ibu", schema = "")
public class BahasaIbu{
    @Id
    @Column(name = "id_bahasa_ibu",length = 36,nullable = false)
    private String idBahasaIbu;
    @Column(name = "nama_bahasa_ibu",length = 60,nullable = false)
    private String namaBahasaIbu;
    @Column(name = "active",length = 1,nullable = false)
    private String active;
    @Column(name = "created_by",length = 36)
    private String createdBy;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "update_by",length = 36)
    private String updatedBy;
    @Column(name = "update_at")
    private Timestamp updateAt;
}
