package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.entity.MapelEntity;
import com.alfazid.siasd.model.dto.MapelDto;
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
public interface MapelRepository extends JpaRepository<MapelEntity,Integer>,PagingAndSortingRepository<MapelEntity,Integer> {
    @Query(value = "SELECT c FROM MapelEntity c WHERE c.idSekolah=:idSekolah AND c.namaMapel LIKE %:name%")
    Page<MapelEntity> findByName(Pageable pageable, @Param("idSekolah") int idSekolah, @Param("name") String name);

    @Query(value = "SELECT c FROM MapelEntity c WHERE c.idSekolah=:idSekolah AND c.active=:active")
    Page<MapelEntity> findActive(Pageable pageable, @Param("idSekolah") int idSekolah, @Param("active") String active);

    @Query(value = "SELECT c FROM MapelEntity c WHERE c.idSekolah=:idSekolah")
    Page<MapelEntity> findAll(Pageable pageable, @Param("idSekolah") int idSekolah);

    @Query(value = "SELECT new com.alfazid.siasd.model.dto.MapelDto (c.idMapel,c.namaMapel) FROM MapelEntity c WHERE c.idSekolah=:idSekolah")
    List<MapelDto> findMapel(@Param("idSekolah") int idSekolah);

}
