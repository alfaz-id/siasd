/**
 * 
 */
package com.alfazid.siasd.dto;

import java.sql.Timestamp;

/**
 * @author mohirwanh@gmail.com  www.alfaz.id
 *
 * Sep 22, 2019
 *
 * erapot 
 * com.alfazid.siasd.dto
 */
public class DesaDto {
	private int idDesa;
    private Integer idKecamatan;
    private String namaKecamatan;
    private String kodeDesa;
    private String namaDesa;
    private String active;
    private Integer userCreated;
    private Timestamp timestampCreated;
    private Integer userUpdated;
    private Timestamp timestampUpdate;
    
    
	public DesaDto() {
		super();
	}
	public DesaDto(int idDesa, Integer idKecamatan, String namaKecamatan, String kodeDesa, String namaDesa,
			String active, Integer userCreated, Timestamp timestampCreated, Integer userUpdated,
			Timestamp timestampUpdate) {
		super();
		this.idDesa = idDesa;
		this.idKecamatan = idKecamatan;
		this.namaKecamatan = namaKecamatan;
		this.kodeDesa = kodeDesa;
		this.namaDesa = namaDesa;
		this.active = active;
		this.userCreated = userCreated;
		this.timestampCreated = timestampCreated;
		this.userUpdated = userUpdated;
		this.timestampUpdate = timestampUpdate;
	}
	public int getIdDesa() {
		return idDesa;
	}
	public Integer getIdKecamatan() {
		return idKecamatan;
	}
	public String getNamaKecamatan() {
		return namaKecamatan;
	}
	public String getKodeDesa() {
		return kodeDesa;
	}
	public String getNamaDesa() {
		return namaDesa;
	}
	public String getActive() {
		return active;
	}
	public Integer getUserCreated() {
		return userCreated;
	}
	public Timestamp getTimestampCreated() {
		return timestampCreated;
	}
	public Integer getUserUpdated() {
		return userUpdated;
	}
	public Timestamp getTimestampUpdate() {
		return timestampUpdate;
	}
	public void setIdDesa(int idDesa) {
		this.idDesa = idDesa;
	}
	public void setIdKecamatan(Integer idKecamatan) {
		this.idKecamatan = idKecamatan;
	}
	public void setNamaKecamatan(String namaKecamatan) {
		this.namaKecamatan = namaKecamatan;
	}
	public void setKodeDesa(String kodeDesa) {
		this.kodeDesa = kodeDesa;
	}
	public void setNamaDesa(String namaDesa) {
		this.namaDesa = namaDesa;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public void setUserCreated(Integer userCreated) {
		this.userCreated = userCreated;
	}
	public void setTimestampCreated(Timestamp timestampCreated) {
		this.timestampCreated = timestampCreated;
	}
	public void setUserUpdated(Integer userUpdated) {
		this.userUpdated = userUpdated;
	}
	public void setTimestampUpdate(Timestamp timestampUpdate) {
		this.timestampUpdate = timestampUpdate;
	}
    
    

}
