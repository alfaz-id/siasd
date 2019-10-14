package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.KelasEntity;
import com.alfazid.siasd.dto.KelasDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by cigist on 31/07/19.
 */
public interface KelasRepository extends JpaRepository<KelasEntity,Integer>,PagingAndSortingRepository<KelasEntity,Integer> {
    @Query(value = "SELECT c FROM KelasEntity c WHERE c.idSekolah=:idSekolah AND c.namaKelas LIKE %:name%")
    Page<KelasEntity> findByName(Pageable pageable, @Param("idSekolah") int idSekolah, @Param("name") String name);

    @Query(value = "SELECT c FROM KelasEntity c WHERE c.idSekolah=:idSekolah AND c.active =:active")
    Page<KelasEntity> findActive(Pageable pageable, @Param("idSekolah") int idSekolah, @Param("active") String active);

    @Query(value = "SELECT c FROM KelasEntity c WHERE c.idSekolah=:idSekolah")
    Page<KelasEntity> findAll(Pageable pageable, @Param("idSekolah") int idSekolah);

    @Query(value = "SELECT new com.alfazid.siasd.dto.KelasDto (c.idKelas,c.namaKelas) FROM KelasEntity c WHERE c.idSekolah=:idSekolah")
    List<KelasDto> findKelas(@Param("idSekolah") int idSekolah);

}
