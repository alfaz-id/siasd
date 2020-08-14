package com.alfazid.siasd.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by cigist on 14/08/20.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pendidikan")
public class Pendidikan {
    @Id
    @Column(name = "id_pendidikan",length = 36,nullable = false)
    private String idPendidikan;
    @Column(name = "nama_pendidikan",length = 30,nullable = false)
    private String namaPendidikan;
    @Column(name = "active",length = 1,nullable = false)
    private String active;
    @Column(name = "created_by",length = 36)
    private String createdBy;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_by",length = 36)
    private String updatedBy;
    @Column(name = "updated_at")
    private Timestamp updateAt;
}
