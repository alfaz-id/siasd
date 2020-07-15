package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.entity.ProvinsiEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 08/09/19.
 */
public interface ProvinsiRepository extends CrudRepository<ProvinsiEntity,Integer>,PagingAndSortingRepository<ProvinsiEntity,Integer>{
    @Query(value = "SELECT c FROM ProvinsiEntity c WHERE c.namaProvinsi LIKE %:value% ")
    Page<ProvinsiEntity> findBy(Pageable pageable, @Param("value") String value);
    @Query(value = "SELECT c FROM ProvinsiEntity c WHERE c.active LIKE %:value% ")
    Page<ProvinsiEntity> findAvtive(Pageable pageable, @Param("value") String value);
    @Query(value = "SELECT c FROM ProvinsiEntity c WHERE c.kodeProvinsi =:value")
    Page<ProvinsiEntity> findKode(Pageable pageable, @Param("value") int value);

    @Query(value = "SELECT c.idProvinsi FROM ProvinsiEntity c WHERE c.kodeProvinsi =:kode")
    String existByKode(@Param("kode") int kode);

    @Query(value = "SELECT new com.alfazid.siasd.model.entity.ProvinsiEntity (c.idProvinsi,c.namaProvinsi) FROM ProvinsiEntity c")
    List<ProvinsiEntity> findProvinsi();
}
