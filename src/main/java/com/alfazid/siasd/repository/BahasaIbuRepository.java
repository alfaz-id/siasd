package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.entity.BahasaIbu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cigist on 23/07/20.
 */

@Repository
public interface BahasaIbuRepository extends JpaRepository<BahasaIbu,String>,PagingAndSortingRepository<BahasaIbu,String>{
    Page<BahasaIbu> findByIdBahasaIbuAndActive(String idBahasaIbu,String active,Pageable pageable);
    Page<BahasaIbu> findByNamaBahasaIbuContainingAndActive(String namaBahasaIbu,String active,Pageable pageable);
    Page<BahasaIbu> findByActive(String active,Pageable pageable);
}
