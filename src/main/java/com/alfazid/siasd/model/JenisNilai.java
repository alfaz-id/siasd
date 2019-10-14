/**
 * 
 */
package com.alfazid.siasd.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author   mohirwanh@gmail.com
 * @web	     www.alfaz.id
 * @Date     Oct 13, 2019
 * @projects siasd @package com.alfazid.siasd.model
 */

@Entity
@Table(name = "jenis_nilai")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JenisNilai {
    @Column(name = "id_sekolah")
    private int idSekolah;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_jenis_nilai")
    private int idJenisNilai;
    @Column(name = "nama_jenis_nilai")
    @Length(min = 3, message = "*Minimal panjang 3 karakter")
    @NotEmpty(message = "*Inputan tidak boleh kosong")
    private String namaJenisNilai;
    @Column(name = "active")
    @NotEmpty(message = "*Inputan tidak boleh kosong")
    private String active;
    @Column(name = "user_created")
    private Integer userCreated;
    @Column(name = "timestamp_created")
    private Timestamp timestampCreated;
    @Column(name = "user_updated")
    private Integer userUpdated;
    private Timestamp timestampUpdated;
    private Timestamp timestampUpdate;
}
