/**
 * 
 */
package com.alfazid.siasd.model;

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
 * @author   mohirwanh@gmail.com
 * @web	     www.alfaz.id
 * @Date     Oct 20, 2019
 * @projects siasd @package com.alfazid.siasd.model
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "kkm")
@ToString
public class Kkm extends CreatedAt {
	@Id
	@Basic
	@Column(name = "id_kkm",nullable = false,length = 11)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idKkm;
	@Basic
	@Column(name = "id_mapel",nullable = false,length = 11)
	private int idMapel;
	@Basic
	@Column(name = "id_kelas",nullable = false,length = 11)
	private int id_kelas;
	@Basic
	@Column(name = "nilai_kkm",nullable = false,length = 3)
	@NotEmpty
	private int nilaiKkm;
	@Basic
	@Column(name = "predikat",nullable = false,length = 1)
	@NotEmpty
	private String predikat;
	

}
