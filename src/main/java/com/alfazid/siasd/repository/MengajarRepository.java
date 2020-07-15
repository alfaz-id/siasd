package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.entity.MengajarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by cigist on 31/07/19.
 */
public interface MengajarRepository extends JpaRepository<MengajarEntity,Integer>,PagingAndSortingRepository<MengajarEntity,Integer> {
//    @Query(value = "SELECT new com.alfazid.siasd.model.dto.MengajarDto(a.idSekolah,a.idMengajar,a.idGuru,b.namaGuru,a.idKelas,c.namaKelas,a.idMapel,d.namaMapel,a.tahunAjaran" +
//            ",a.semester,a.active,a.userCreated,a.timestampCreated,a.userUpdated,a.timestampUpdate ) FROM MengajarEntity a JOIN GuruEntity b ON a.idGuru = b.idGuru " +
//            "JOIN KelasEntity c ON a.idKelas=c.idKelas JOIN MapelEntity d ON a.idMapel = d.idMapel WHERE a.idSekolah=:idSekolah",
//            countQuery="SELECT COUNT (a) FROM MengajarEntity a JOIN GuruEntity b ON a.idGuru = b.idGuru " +
//                    "JOIN KelasEntity c ON a.idKelas=c.idKelas JOIN MapelEntity d ON a.idMapel = d.idMapel WHERE a.idSekolah=:idSekolah")
//    Page<MengajarDto> findAll(Pageable pageable,@Param("idSekolah") int idSekolah);
}
