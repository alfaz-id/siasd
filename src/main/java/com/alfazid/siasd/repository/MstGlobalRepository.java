/**
 * 
 */
package com.alfazid.siasd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alfazid.siasd.model.GlobalEntity;

/**
 * @author   mohirwanh@gmail.com
 * @web	     www.alfaz.id
 * @Date     Oct 27, 2019
 * @projects siasd @package com.alfazid.siasd.repository
 */
@Repository
public interface MstGlobalRepository extends JpaRepository<GlobalEntity, Integer>,PagingAndSortingRepository<GlobalEntity, Integer>{

	@Query("SELECT a FROM GlobalEntity a WHERE a.typeMaster = :type")
    public List<GlobalEntity> findByTypeMaster(@Param("type") String type);
}
