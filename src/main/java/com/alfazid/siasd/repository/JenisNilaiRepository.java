/**
 * 
 */
package com.alfazid.siasd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.alfazid.siasd.model.JenisNilai;

/**
 * @author   mohirwanh@gmail.com
 * @web	     www.alfaz.id
 * @Date     Oct 13, 2019
 * @projects siasd @package com.alfazid.siasd.repository
 */
public interface JenisNilaiRepository extends JpaRepository<JenisNilai, Long>,PagingAndSortingRepository<JenisNilai,Long> {

//	Page<JenisNilai> findAll(int idSekolah);
//	Page<JenisNilai> findByName(Pageable pageable,String namaJenisNilai,int idSekolah);
}
