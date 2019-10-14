package com.alfazid.siasd.service;

import com.alfazid.siasd.dto.KabupatenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 08/09/19.
 */
@Service
public class KabupatenService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Page<KabupatenDto> findAll(Pageable pageable){
        String COUNT_SQL = "SELECT count(1) AS row_count FROM kabupaten a \n" +
                "JOIN provinsi b ON a.id_provinsi = b.id_provinsi";
        int total = jdbcTemplate.queryForObject(COUNT_SQL,int.class);
        String QUERY_SQL ="SELECT a.*,b.nama_provinsi from kabupaten a \n" +
                "JOIN provinsi b ON a.id_provinsi = b.id_provinsi limit "+pageable.getOffset()+","+pageable.getPageSize();

        List<KabupatenDto> kabupatenDtos = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL);

        for (Map row : rows) {
            KabupatenDto obj = new KabupatenDto();
            obj.setIdKabupaten(((Integer) row.get("id_kabupaten")));
            obj.setIdProvinsi(((Integer) row.get("id_provinsi")));
            obj.setNamaProvinsi(((String) row.get("nama_provinsi")));
            obj.setKodeKabupaten(((String) row.get("kode_kabupaten")));
            obj.setNamaKabupaten(((String) row.get("nama_kabupaten")));
            obj.setActive(((String) row.get("active")));
            kabupatenDtos.add(obj);
        }
        return new PageImpl<>(kabupatenDtos, pageable, total);
    }

    public Page<KabupatenDto> findBy(Pageable pageable,String field,String param){
        String COUNT_SQL = "SELECT count(1) AS row_count FROM kabupaten a \n" +
                "JOIN provinsi b ON a.id_provinsi = b.id_provinsi \n" +
                " WHERE "+field+" lIKE '%"+param+"%'";
        int total = jdbcTemplate.queryForObject(COUNT_SQL,int.class);

        String QUERY_SQL ="SELECT a.*,b.nama_provinsi from kabupaten a \n" +
                "JOIN provinsi b ON a.id_provinsi = b.id_provinsi" +
                "WHERE"+field+" lIKE '%"+param+"%' limit "+pageable.getOffset()+","+pageable.getPageSize();

        List<KabupatenDto> kabupatenDtos = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL);

        for (Map row : rows) {
            KabupatenDto obj = new KabupatenDto();
            obj.setIdKabupaten(((Integer) row.get("id_kabupaten")));
            obj.setIdProvinsi(((Integer) row.get("id_provinsi")));
            obj.setNamaProvinsi(((String) row.get("nama_provinsi")));
            obj.setKodeKabupaten(((String) row.get("kode_kabupaten")));
            obj.setNamaKabupaten(((String) row.get("nama_kabupaten")));
            obj.setActive(((String) row.get("active")));
            kabupatenDtos.add(obj);
        }

        return new PageImpl<>(kabupatenDtos, pageable, total);
    }
}
