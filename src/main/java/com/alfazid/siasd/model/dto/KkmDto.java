/**
 * 
 */
package com.alfazid.siasd.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author   mohirwanh@gmail.com
 * @web	     www.alfaz.id
 * @Date     Oct 26, 2019
 * @projects siasd @package com.alfazid.siasd.model.dto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KkmDto {
	private int idKkm;
    private int idMapel;
    private String namaMapel;
    private int idKelas;
    private String namaKelas;
    private int nilaiKkm;
    private String predikat;
    private String active;
}
