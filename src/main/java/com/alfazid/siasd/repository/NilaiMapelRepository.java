package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.NilaiMapelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by cigist on 31/07/19.
 */
public interface NilaiMapelRepository extends JpaRepository<NilaiMapelEntity,Integer>,PagingAndSortingRepository<NilaiMapelEntity,Integer> {
}
