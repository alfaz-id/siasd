package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.entity.KabupatenEntity;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 08/09/19.
 */
public interface KabupatenRepository extends CrudRepository<KabupatenEntity,Integer>,PagingAndSortingRepository<KabupatenEntity,Integer> {
	 @Query(value = "SELECT c.idKabupaten FROM KabupatenEntity c WHERE c.kodeKabupaten =:kode")
	 String existByKode(@Param("kode") String kode);
	 @Query(value = "SELECT new com.alfazid.siasd.model.entity.KabupatenEntity (c.idKabupaten,c.namaKabupaten) FROM KabupatenEntity c")
	 List<KabupatenEntity> findKabupaten();
}
