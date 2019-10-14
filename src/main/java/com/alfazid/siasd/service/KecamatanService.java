package com.alfazid.siasd.service;

import com.alfazid.siasd.dto.KecamatanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class KecamatanService {
	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	public Page<KecamatanDto> findAll(Pageable pageable){
		String COUNT_SQL = "SELECT count(1) AS row_count FROM kecamatan a " +
				"JOIN kabupaten b ON a.id_kabupaten=b.id_kabupaten ";
		int total = jdbcTemplate.queryForObject(COUNT_SQL,int.class);
		String QUERY_SQL ="SELECT a.*,b.nama_kabupaten FROM kecamatan a\n" +
				"JOIN kabupaten b ON a.id_kabupaten=b.id_kabupaten limit "+pageable.getOffset()+","+pageable.getPageSize();

		List<KecamatanDto> kecamatanDtos = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL);

		for (Map row : rows) {
			KecamatanDto obj = new KecamatanDto();
			obj.setIdKecamatan(((Integer) row.get("id_kecamatan")));
			obj.setIdKabupaten(((Integer) row.get("id_kabupaten")));
			obj.setNamaKabupaten(((String) row.get("nama_kabupaten")));
			obj.setKodeKecamatan(((String) row.get("kode_kecamatan")));
			obj.setNamaKecamatan(((String) row.get("nama_kecamatan")));
			obj.setActive(((String) row.get("active")));
			kecamatanDtos.add(obj);
		}
		return new PageImpl<>(kecamatanDtos, pageable, total);
	}

	public Page<KecamatanDto> findBy(Pageable pageable,String field,String param){
		String COUNT_SQL = "SELECT count(1) AS row_count FROM kecamatan a " +
				"JOIN kabupaten b ON a.id_kabupaten=b.id_kabupaten \n"+
				" WHERE "+field+" lIKE '%"+param+"%'";
		int total = jdbcTemplate.queryForObject(COUNT_SQL,int.class);

		String QUERY_SQL ="SELECT a.*,b.nama_kabupaten FROM kecamatan a " +
				"JOIN kabupaten b ON a.id_kabupaten=b.id_kabupaten \n"+
				"WHERE"+field+" lIKE '%"+param+"%' limit "+pageable.getOffset()+","+pageable.getPageSize();

		List<KecamatanDto> kecamatanDtos = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL);

		for (Map row : rows) {
			KecamatanDto obj = new KecamatanDto();
			obj.setIdKecamatan(((Integer) row.get("id_kecamatan")));
			obj.setIdKabupaten(((Integer) row.get("id_kabupaten")));
			obj.setNamaKabupaten(((String) row.get("nama_kabupaten")));
			obj.setKodeKecamatan(((String) row.get("kode_kecamatan")));
			obj.setNamaKecamatan(((String) row.get("nama_kecamatan")));
			obj.setActive(((String) row.get("active")));
			kecamatanDtos.add(obj);
		}
		return new PageImpl<>(kecamatanDtos, pageable, total);
	}

}
