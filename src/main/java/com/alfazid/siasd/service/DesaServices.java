/**
 *
 */
package com.alfazid.siasd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alfazid.siasd.dto.DesaDto;

/**
 * @author mohirwanh@gmail.com  www.alfaz.id
 *
 * Sep 22, 2019
 *
 * erapot
 * com.alfazid.erapot.service
 */

@Service
public class DesaServices {
	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	public Page<DesaDto> findAll(Pageable pageable){
		String COUNT_SQL = "SELECT count(1) AS row_count FROM desa a join kecamatan b on a.id_kecamatan=b.id_kecamatan";
		int total = jdbcTemplate.queryForObject(COUNT_SQL,int.class);
		String QUERY_SQL ="SELECT b.nama_kecamatan,a.* from desa a join kecamatan b on a.id_kecamatan=b.id_kecamatan"
					+ " limit "+pageable.getOffset()+","+pageable.getPageSize();

		List<DesaDto> desaDtos = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL);

		for (Map row : rows) {
			DesaDto obj = new DesaDto();
			obj.setIdDesa(((Integer) row.get("id_desa")));
			obj.setIdKecamatan(((Integer) row.get("id_kecamatan")));
			obj.setNamaKecamatan(((String) row.get("nama_kecamatan")));
			obj.setKodeDesa(((String) row.get("kode_desa")));
			obj.setNamaDesa(((String) row.get("nama_desa")));
			obj.setActive(((String) row.get("active")));
			desaDtos.add(obj);
		}
		return new PageImpl<>(desaDtos, pageable, total);
	}

	public Page<DesaDto> findBy(Pageable pageable,String field,String param){
		String COUNT_SQL = "SELECT count(1) AS row_count FROM desa a join kecamatan b on a.id_kecamatan=b.id_kecamatan \n"+
							" WHERE "+field+" lIKE '%"+param+"%'";
		int total = jdbcTemplate.queryForObject(COUNT_SQL,int.class);

		String QUERY_SQL ="SELECT b.nama_kecamatan,a.* from desa a join kecamatan b on a.id_kecamatan=b.id_kecamatan \n"+
						"WHERE"+field+" lIKE '%"+param+"%' limit "+pageable.getOffset()+","+pageable.getPageSize();

		List<DesaDto> desaDtos = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL);

		for (Map row : rows) {
			DesaDto obj = new DesaDto();
			obj.setIdDesa(((Integer) row.get("id_desa")));
			obj.setIdKecamatan(((Integer) row.get("id_kecamatan")));
			obj.setNamaKecamatan(((String) row.get("nama_kecamatan")));
			obj.setKodeDesa(((String) row.get("kode_desa")));
			obj.setNamaDesa(((String) row.get("nama_desa")));
			obj.setActive(((String) row.get("active")));
			desaDtos.add(obj);
		}
		return new PageImpl<>(desaDtos, pageable, total);
	}
}
