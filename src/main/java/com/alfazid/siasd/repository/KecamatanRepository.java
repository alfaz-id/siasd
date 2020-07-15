package com.alfazid.siasd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.alfazid.siasd.model.entity.KecamatanEntity;

public interface KecamatanRepository extends JpaRepository<KecamatanEntity, Integer>,PagingAndSortingRepository<KecamatanEntity, Integer>{

	 @Query(value = "SELECT c.idKecamatan FROM KecamatanEntity c WHERE c.kodeKecamatan =:kode")
	 String existByKode(@Param("kode") String kode);
	 @Query(value = "SELECT new com.alfazid.siasd.model.entity.KecamatanEntity (c.idKecamatan,c.namaKecamatan) FROM KecamatanEntity c")
	 List<KecamatanEntity> findKecamatan();
}
