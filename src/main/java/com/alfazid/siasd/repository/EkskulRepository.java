package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.EkskulEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by cigist on 31/07/19.
 */
public interface EkskulRepository extends JpaRepository<EkskulEntity,Integer>,PagingAndSortingRepository<EkskulEntity,Integer> {
    @Query(value = "SELECT c FROM EkskulEntity c WHERE c.idSekolah=:idSekolah AND c.namaEkskul LIKE %:name%")
    Page<EkskulEntity> findByName(Pageable pageable, @Param("idSekolah") int idSekolah, @Param("name") String name);

    @Query(value = "SELECT c FROM EkskulEntity  c WHERE c.idSekolah=:idSekolah AND c.active LIKE %:active%")
    Page<EkskulEntity> findActive(Pageable pageable, @Param("idSekolah") int idSekolah, @Param("active") String active);

    @Query(value = "SELECT c FROM EkskulEntity c WHERE c.idSekolah=:idSekolah")
    Page<EkskulEntity> findAll(Pageable pageable, @Param("idSekolah") int idSekolah);

}
