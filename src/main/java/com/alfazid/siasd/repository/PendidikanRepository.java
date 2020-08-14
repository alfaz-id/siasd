package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.entity.Pendidikan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cigist on 14/08/20.
 */
@Repository
public interface PendidikanRepository extends JpaRepository<Pendidikan,String>,PagingAndSortingRepository<Pendidikan,String>{
    Page<Pendidikan> findByIdPendidikanAndActive(String idPendidikan,String active,Pageable pageable);
    Page<Pendidikan> findByNamaPendidikanContainingAndActive(String namaPendidikan,String active,Pageable pageable);
    Page<Pendidikan> findByActive(String active,Pageable pageable);
}
