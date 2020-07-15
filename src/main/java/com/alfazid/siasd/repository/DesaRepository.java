/**
 * 
 */
package com.alfazid.siasd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alfazid.siasd.model.entity.DesaEntity;

/**
 * @author mohirwanh@gmail.com  www.alfaz.id
 *
 * Sep 22, 2019
 *
 * erapot 
 * com.alfazid.erapot.repository
 */

@Repository
public interface DesaRepository extends CrudRepository<DesaEntity, Integer>,PagingAndSortingRepository<DesaEntity,Integer> {
	 @Query(value = "SELECT c.idDesa FROM DesaEntity c WHERE c.kodeDesa =:kode")
	 String existByKode(@Param("kode") String kode);
	 @Query(value = "SELECT new com.alfazid.siasd.model.entity.DesaEntity (c.idDesa,c.namaDesa) FROM DesaEntity c")
	 List<DesaEntity> findDesa();
}
