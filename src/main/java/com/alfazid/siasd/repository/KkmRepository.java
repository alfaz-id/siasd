/**
 * 
 */
package com.alfazid.siasd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.alfazid.siasd.model.Kkm;

/**
 * @author   mohirwanh@gmail.com
 * @web	     www.alfaz.id
 * @Date     Oct 20, 2019
 * @projects siasd @package com.alfazid.siasd.repository
 */
@Repository
public interface KkmRepository extends JpaRepository<Kkm, Integer>,PagingAndSortingRepository<Kkm, Integer> {

}
