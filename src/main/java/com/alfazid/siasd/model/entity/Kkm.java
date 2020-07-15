/**
 * 
 */
package com.alfazid.siasd.model.entity;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author mohirwanh@gmail.com
 * @web www.alfaz.id
 * @Date Oct 20, 2019
 * @projects siasd @package com.alfazid.siasd.model
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "kkm")
@ToString
public class Kkm {
	@Id
	@Basic
	@Column(name = "id_kkm", nullable = false, length = 11)
	private int idKkm;
	@Basic
	@Column(name = "id_mapel", nullable = false, length = 11)
	private int idMapel;
	@Basic
	@Column(name = "id_kelas", nullable = false, length = 11)
	private int idKelas;
	@Basic
	@Column(name = "nilai_kkm", nullable = false, length = 3)
	private int nilaiKkm;
	@Basic
	@Column(name = "predikat", nullable = false, length = 1)
	@NotEmpty
	private String predikat;
	@Basic
	@Column(name = "id_sekolah")
	private int idSekolah;
	@Basic
	@Column(name = "active")
	private String active;
	@Basic
	@Column(name = "user_created")
	private Integer userCreated;
	@Basic
	@Column(name = "timestamp_created")
	private Timestamp timestampCreated;
	@Basic
	@Column(name = "user_update")
	private Integer userUpdated;
	@Basic
	@Column(name = "timestamp_update")
	private Timestamp timestampUpdate;

}
