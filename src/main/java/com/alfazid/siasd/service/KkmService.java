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

import com.alfazid.siasd.model.dto.KkmDto;

/**
 * @author   mohirwanh@gmail.com
 * @web	     www.alfaz.id
 * @Date     Oct 20, 2019
 * @projects siasd @package com.alfazid.siasd.service
 */

@Service
public class KkmService {
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	public Page<KkmDto> findAll(Pageable pageable,Integer idSekolah){
		String COUNT_SQL = "SELECT count(1) AS row_count FROM kkm a join mapel b on a.id_mapel= b.id_mapel "
				+ "join kelas c on a.id_kelas=c.id_kelas WHERE a.id_sekolah="+idSekolah;
		int total = jdbcTemplate.queryForObject(COUNT_SQL,int.class);
		String QUERY_SQL ="SELECT a.*,b.nama_mapel,c.nama_kelas FROM kkm a join mapel b on a.id_mapel= b.id_mapel "
				   + "join kelas c on a.id_kelas=c.id_kelas WHERE a.id_sekolah="+idSekolah+""
					+ " limit "+pageable.getOffset()+","+pageable.getPageSize();

		List<KkmDto> kkmDtos = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL);

		for (Map row : rows) {
			KkmDto obj = new KkmDto();
			obj.setIdKkm((Integer) row.get("id_kkm"));
			obj.setIdMapel((Integer) row.get("id_mapel"));
			obj.setNamaMapel((String) row.get("nama_mapel"));
			obj.setIdKelas((Integer) row.get("id_kelas"));
			obj.setNamaKelas((String) row.get("nama_kelas"));
			obj.setNilaiKkm((Integer)row.get("nilai_kkm"));
			obj.setPredikat((String) row.get("predikat"));
			obj.setActive(((String) row.get("active")));
			kkmDtos.add(obj);
		}
		return new PageImpl<>(kkmDtos, pageable, total);
	}

	public Page<KkmDto> findBy(Pageable pageable,String field,String param,Integer idSekolah){
		String COUNT_SQL = "SELECT count(1) AS row_count FROM kkm a join mapel b on a.id_mapel= b.id_mapel "
							+ "join kelas c on a.id_kelas=c.id_kelas "
							+" WHERE a.id_sekolah="+idSekolah+" and  "+field+" lIKE '%"+param+"%'";
		int total = jdbcTemplate.queryForObject(COUNT_SQL,int.class);

		String QUERY_SQL ="SELECT a.*,b.nama_mapel,c.nama_kelas FROM kkm a join mapel b on a.id_mapel= b.id_mapel "
						+ "join kelas c on a.id_kelas=c.id_kelas "
						+" WHERE a.id_sekolah="+idSekolah+" and  "+field+" lIKE '%"+param+"%' limit "+pageable.getOffset()+","+pageable.getPageSize();

		List<KkmDto> kkmDtos = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL);

		for (Map row : rows) {
			KkmDto obj = new KkmDto();
			obj.setIdKkm((Integer) row.get("id_kkm"));
			obj.setIdMapel((Integer) row.get("id_mapel"));
			obj.setNamaMapel((String) row.get("nama_mapel"));
			obj.setIdKelas((Integer) row.get("id_kelas"));
			obj.setNamaKelas((String) row.get("nama_kelas"));
			obj.setNilaiKkm((Integer)row.get("nilai_kkm"));
			obj.setPredikat((String) row.get("predikat"));
			obj.setActive(((String) row.get("active")));
			kkmDtos.add(obj);
		}
		return new PageImpl<>(kkmDtos, pageable, total);
	}
}
