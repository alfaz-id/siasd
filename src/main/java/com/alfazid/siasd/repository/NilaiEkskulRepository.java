package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.NilaiEkskulEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by cigist on 31/07/19.
 */
public interface NilaiEkskulRepository extends JpaRepository<NilaiEkskulEntity,Integer>,PagingAndSortingRepository<NilaiEkskulEntity,Integer> {
}
