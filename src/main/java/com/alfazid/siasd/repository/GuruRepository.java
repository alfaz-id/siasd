package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.entity.GuruEntity;
import com.alfazid.siasd.model.dto.GuruDto;
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
public interface GuruRepository extends JpaRepository<GuruEntity,Integer>,PagingAndSortingRepository<GuruEntity,Integer> {
    @Query(value = "SELECT c FROM GuruEntity c WHERE c.idSekolah=:idSekolah AND c.namaGuru LIKE %:name%")
    Page<GuruEntity> findByName(Pageable pageable, @Param("idSekolah") int idSekolah, @Param("name") String name);

    @Query(value = "SELECT c FROM GuruEntity c WHERE c.idSekolah=:idSekolah AND  c.nip LIKE %:nip%")
    Page<GuruEntity> findByNip(Pageable pageable, @Param("idSekolah") int idSekolah, @Param("nip") String nip);

    @Query(value = "SELECT c FROM GuruEntity c WHERE c.idSekolah=:idSekolah AND c.alamat LIKE %:alamat%")
    Page<GuruEntity> findByAlamat(Pageable pageable, @Param("idSekolah") int idSekolah, @Param("alamat") String alamat);

    @Query(value = "SELECT c FROM GuruEntity c WHERE c.idSekolah=:idSekolah AND c.telepon LIKE %:tlp%")
    Page<GuruEntity> findByTelp(Pageable pageable, @Param("idSekolah") int idSekolah, @Param("tlp") String tlp);

    @Query(value = "SELECT c FROM GuruEntity c WHERE c.idSekolah=:idSekolah AND c.active LIKE %:active%")
    Page<GuruEntity> findActive(Pageable pageable, @Param("idSekolah") int idSekolah, @Param("active") String active);

    @Query(value = "SELECT c FROM GuruEntity c WHERE c.idSekolah=:idSekolah")
    Page<GuruEntity> findAll(Pageable pageable, @Param("idSekolah") int idSekolah);

    @Query(value = "SELECT new com.alfazid.siasd.model.dto.GuruDto(c.idGuru,c.namaGuru) FROM GuruEntity c WHERE c.idSekolah=:idSekolah")
    List<GuruDto> findGuru(@Param("idSekolah") int idSekolah);
    
    GuruEntity findByNip(String nip);
}
