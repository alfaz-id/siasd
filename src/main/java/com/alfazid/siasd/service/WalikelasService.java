package com.alfazid.siasd.service;

import com.alfazid.siasd.model.dto.WalikelasDto;
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
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 07/09/19.
 */
@Service
public class WalikelasService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Page<WalikelasDto> findAll(Pageable pageable,int idSekolah){
        String COUNT_SQL = "SELECT count(1) AS row_count FROM wali_kelas a \n" +
                "JOIN Guru b ON a.id_Guru = b.id_Guru\n" +
                "JOIN Kelas c ON a.id_Kelas=c.id_Kelas  WHERE a.id_Sekolah=?";
        int total = jdbcTemplate.queryForObject(COUNT_SQL,new Object[]{idSekolah},int.class);
        String QUERY_SQL ="SELECT a.*,b.nama_guru,c.nama_kelas from wali_kelas a \n" +
                "JOIN Guru b ON a.id_Guru = b.id_Guru\n" +
                "JOIN Kelas c ON a.id_Kelas=c.id_Kelas WHERE a.id_Sekolah=? limit "+pageable.getOffset()+","+pageable.getPageSize();

        List<WalikelasDto> walikelasDtos = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL,new Object[]{idSekolah});

        for (Map row : rows) {
            WalikelasDto obj = new WalikelasDto();
            obj.setIdSekolah(((Integer) row.get("id_sekolah")));
            obj.setIdWakel(((Integer) row.get("id_wakel")));
            obj.setIdGuru(((Integer) row.get("id_Guru")));
            obj.setNamaGuru(((String) row.get("nama_Guru")));
            obj.setIdKelas(((Integer) row.get("id_Kelas")));
            obj.setNamaKelas(((String) row.get("nama_Kelas")));
            obj.setTahunAjaran(((String) row.get("tahun_Ajaran")));
            obj.setSemester(((Integer) row.get("semester")));
            obj.setActive(((String) row.get("active")));
            walikelasDtos.add(obj);
        }

        return new PageImpl<>(walikelasDtos, pageable, total);
    }

    public Page<WalikelasDto> findBy(Pageable pageable,String field,String param,int idSekolah){
        String COUNT_SQL = "SELECT count(1) AS row_count FROM wali_kelas a \n" +
                "JOIN Guru b ON a.id_Guru = b.id_Guru\n" +
                "JOIN Kelas c ON a.id_Kelas=c.id_Kelas  WHERE a.id_Sekolah=?" +
                " AND "+field+" lIKE '%"+param+"%'";
        int total = jdbcTemplate.queryForObject(COUNT_SQL,new Object[]{idSekolah},int.class);

        String QUERY_SQL ="SELECT a.*,b.nama_guru,c.nama_kelas from wali_kelas a \n" +
                "JOIN Guru b ON a.id_Guru = b.id_Guru\n" +
                "JOIN Kelas c ON a.id_Kelas=c.id_Kelas  WHERE a.id_Sekolah=?" +
                " AND "+field+" lIKE '%"+param+"%' limit "+pageable.getOffset()+","+pageable.getPageSize();

        List<WalikelasDto> walikelasDtos = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL,new Object[]{idSekolah});

        for (Map row : rows) {
            WalikelasDto obj = new WalikelasDto();
            obj.setIdSekolah(((Integer) row.get("id_sekolah")));
            obj.setIdWakel(((Integer) row.get("id_wakel")));
            obj.setIdGuru(((Integer) row.get("id_Guru")));
            obj.setNamaGuru(((String) row.get("nama_Guru")));
            obj.setIdKelas(((Integer) row.get("id_Kelas")));
            obj.setNamaKelas(((String) row.get("nama_Kelas")));
            obj.setTahunAjaran(((String) row.get("tahun_Ajaran")));
            obj.setSemester(((Integer) row.get("semester")));
            obj.setActive(((String) row.get("active")));
            walikelasDtos.add(obj);
        }

        return new PageImpl<>(walikelasDtos, pageable, total);
    }
}
