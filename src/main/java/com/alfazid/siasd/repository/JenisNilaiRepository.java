/**
 * 
 */
package com.alfazid.siasd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.alfazid.siasd.model.entity.JenisNilai;
import org.springframework.stereotype.Repository;

/**
 * @author   mohirwanh@gmail.com
 * @web	     www.alfaz.id
 * @Date     Oct 13, 2019
 * @projects siasd @package com.alfazid.siasd.repository
 */

@Repository
public interface JenisNilaiRepository extends JpaRepository<JenisNilai, Integer>,PagingAndSortingRepository<JenisNilai,Integer> {

	Page<JenisNilai> findByNamaJenisNilai(Pageable pageable,String namaJenisNilai);
}
