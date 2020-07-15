package com.alfazid.siasd.service;

import com.alfazid.siasd.model.dto.MengajarDto;
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
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 01/09/19.
 */
@Service
public class MengajarService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Page<MengajarDto> findAll(Pageable pageable,int idSekolah){
        String COUNT_SQL = "SELECT count(1) AS row_count FROM Mengajar a JOIN Guru b ON a.id_Guru = b.id_Guru\n" +
                " JOIN Kelas c ON a.id_Kelas=c.id_Kelas JOIN Mapel d ON a.id_Mapel = d.id_Mapel WHERE a.id_Sekolah=?";
        int total = jdbcTemplate.queryForObject(COUNT_SQL,new Object[]{idSekolah},int.class);
        String QUERY_SQL ="SELECT a.id_Sekolah,a.id_Mengajar,a.id_Guru,b.nama_Guru,a.id_Kelas,c.nama_Kelas,a.id_Mapel,d.nama_Mapel,a.tahun_Ajaran ,a.semester,a.active,a.user_Created,a.timestamp_Created,a.user_Updated,a.timestamp_Update  FROM Mengajar a JOIN Guru b ON a.id_Guru = b.id_Guru\n" +
                "JOIN Kelas c ON a.id_Kelas=c.id_Kelas JOIN Mapel d ON a.id_Mapel = d.id_Mapel WHERE a.id_Sekolah=? limit "+pageable.getOffset()+","+pageable.getPageSize();

        List<MengajarDto> mengajarDtos = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL,new Object[]{idSekolah});

        for (Map row : rows) {
            MengajarDto obj = new MengajarDto();
            obj.setIdSekolah(((Integer) row.get("id_Sekolah")));
            obj.setIdMengajar(((Integer) row.get("id_Mengajar")));
            obj.setIdGuru(((Integer) row.get("id_Guru")));
            obj.setNamaGuru(((String) row.get("nama_Guru")));
            obj.setIdKelas(((Integer) row.get("id_Kelas")));
            obj.setNamaKelas(((String) row.get("nama_Kelas")));
            obj.setIdMapel(((Integer) row.get("id_Mapel")));
            obj.setNamaMapel(((String) row.get("nama_Mapel")));
            obj.setTahunAjaran(((String) row.get("tahun_Ajaran")));
            obj.setSemester(((Integer) row.get("semester")));
            obj.setActive(((String) row.get("active")));
            mengajarDtos.add(obj);
        }

        return new PageImpl<>(mengajarDtos, pageable, total);
    }

    public Page<MengajarDto> findBy(Pageable pageable,String field,String param,int idSekolah){
        String COUNT_SQL = "SELECT count(1) AS row_count FROM Mengajar a JOIN Guru b ON a.id_Guru = b.id_Guru\n" +
                " JOIN Kelas c ON a.id_Kelas=c.id_Kelas JOIN Mapel d ON a.id_Mapel = d.id_Mapel WHERE a.id_Sekolah=?" +
                " AND "+field+" lIKE '%"+param+"%'";
        int total = jdbcTemplate.queryForObject(COUNT_SQL,new Object[]{idSekolah},int.class);

        String QUERY_SQL ="SELECT a.id_Sekolah,a.id_Mengajar,a.id_Guru,b.nama_Guru,a.id_Kelas,c.nama_Kelas,a.id_Mapel,d.nama_Mapel,a.tahun_Ajaran ,a.semester,a.active,a.user_Created,a.timestamp_Created,a.user_Updated,a.timestamp_Update  FROM Mengajar a JOIN Guru b ON a.id_Guru = b.id_Guru\n" +
                "JOIN Kelas c ON a.id_Kelas=c.id_Kelas JOIN Mapel d ON a.id_Mapel = d.id_Mapel WHERE a.id_Sekolah=?" +
                " AND "+field+" lIKE '%"+param+"%' limit "+pageable.getOffset()+","+pageable.getPageSize();

        List<MengajarDto> mengajarDtos = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(QUERY_SQL,new Object[]{idSekolah});

        for (Map row : rows) {
            MengajarDto obj = new MengajarDto();
            obj.setIdSekolah(((Integer) row.get("id_Sekolah")));
            obj.setIdMengajar(((Integer) row.get("id_Mengajar")));
            obj.setIdGuru(((Integer) row.get("id_Guru")));
            obj.setNamaGuru(((String) row.get("nama_Guru")));
            obj.setIdKelas(((Integer) row.get("id_Kelas")));
            obj.setNamaKelas(((String) row.get("nama_Kelas")));
            obj.setIdMapel(((Integer) row.get("id_Mapel")));
            obj.setNamaMapel(((String) row.get("nama_Mapel")));
            obj.setTahunAjaran(((String) row.get("tahun_Ajaran")));
            obj.setSemester(((Integer) row.get("semester")));
            obj.setActive(((String) row.get("active")));
            mengajarDtos.add(obj);
        }

        return new PageImpl<>(mengajarDtos, pageable, total);
    }
}
