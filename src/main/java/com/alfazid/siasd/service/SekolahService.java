package com.alfazid.siasd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alfazid.siasd.model.SekolahEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class SekolahService{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Page <SekolahEntity> findByValue(Pageable pageable,String field,String param){
        String COUNT_SQL = "SELECT count(1) AS row_count FROM sekolah  a \n" +
        " WHERE "+field+" lIKE '%"+param+"%'";
        int total = jdbcTemplate.queryForObject(COUNT_SQL,int.class);
        
        String QUERY_SQL = "SELECT a.* from sekolah a WHERE "+field+" lIKE '%"+param+"%' limit "+pageable.getOffset()+","+pageable.getPageSize();

        List<SekolahEntity> listSekolah = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL);
   
        for(Map row:rows){
            SekolahEntity entity = new SekolahEntity();
            entity.setIdSekolah( (Integer) row.get("id_sekolah"));
            entity.setKodeSekolah( (String) row.get("kode_sekolah"));
            entity.setNamaSekolah( (String) row.get("nama_sekolah"));
            entity.setTipeSekolah( (Integer) row.get("tipe_sekolah"));
            entity.setNomorIzinSekolah( (String) row.get("nomor_izin_sekolah"));
            entity.setAkreditasi( (String) row.get("akreditasi"));
            entity.setAlamat((String) row.get("alamat"));
            entity.setTelepon( (String) row.get("telepon"));
            entity.setActive( (String) row.get("active"));
            listSekolah.add(entity);
        }

        return new PageImpl<>(listSekolah,pageable,total);
    }
    
}