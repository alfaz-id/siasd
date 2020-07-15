package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.entity.SiswaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 28/09/19.
 */
@Repository
public interface SiswaRepository extends JpaRepository<SiswaEntity,Integer>,PagingAndSortingRepository<SiswaEntity,Integer> {
    @Query(value = "SELECT c FROM SiswaEntity c WHERE c.idSekolah=:idSekolah")
    Page<SiswaEntity> findAll(Pageable pageable, @Param("idSekolah") int idSekolah);

    @Query(value = "SELECT c FROM SiswaEntity c WHERE c.idSekolah=:idSekolah AND c.namaLengkap LIKE %:name%")
    Page<SiswaEntity> findByName(Pageable pageable, @Param("idSekolah") int idSekolah, @Param("name") String name);

    @Query(value = "SELECT c FROM SiswaEntity  c WHERE c.idSekolah=:idSekolah AND c.active LIKE %:active%")
    Page<SiswaEntity> findActive(Pageable pageable, @Param("idSekolah") int idSekolah, @Param("active") String active);
}
