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

import com.alfazid.siasd.dto.KkmDto;
import com.alfazid.siasd.model.GlobalEntity;

/**
 * @author   mohirwanh@gmail.com
 * @web	     www.alfaz.id
 * @Date     Oct 27, 2019
 * @projects siasd @package com.alfazid.siasd.service
 */
@Service
public class MstGlobalService {
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	public Page<GlobalEntity> findAll(Pageable pageable,String kodeGlobal){
		String COUNT_SQL = "SELECT count(1) AS row_count FROM global WHERE kode_global="+kodeGlobal;
		int total = jdbcTemplate.queryForObject(COUNT_SQL,int.class);
		String QUERY_SQL ="SELECT * FROM global WHERE kode_global="+kodeGlobal+""
					+ " limit "+pageable.getOffset()+","+pageable.getPageSize();

		List<GlobalEntity> globalEntities = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL);

		for (Map row : rows) {
			GlobalEntity obj = new GlobalEntity();
			obj.setIdGlobal((Integer) row.get("id_global"));
			obj.setKodeGlobal((String) row.get("kode_global"));
			obj.setKeterangan((String) row.get("keterangan"));
			obj.setActive(((String) row.get("active")));
			globalEntities.add(obj);
		}
		return new PageImpl<>(globalEntities, pageable, total);
	}

	public Page<GlobalEntity> findBy(Pageable pageable,String field,String param,String kodeGlobal){
		String COUNT_SQL = "SELECT count(1) AS row_count FROM global WHERE kode_global="+kodeGlobal+" and  "+field+" lIKE '%"+param+"%'";
		int total = jdbcTemplate.queryForObject(COUNT_SQL,int.class);

		String QUERY_SQL ="SELECT * FROM global WHERE kode_global="+kodeGlobal+" and  "+field+" lIKE '%"+param+"%' limit "+pageable.getOffset()+","+pageable.getPageSize();
		List<GlobalEntity> globalEntities = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL);

		for (Map row : rows) {
			GlobalEntity obj = new GlobalEntity();
			obj.setIdGlobal((Integer) row.get("id_global"));
			obj.setKodeGlobal((String) row.get("kode_global"));
			obj.setKeterangan((String) row.get("keterangan"));
			obj.setActive(((String) row.get("active")));
			globalEntities.add(obj);
		}
		return new PageImpl<>(globalEntities, pageable, total);
	}
}
