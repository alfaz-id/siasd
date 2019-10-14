package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.SekolahEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 13/10/19.
 */
public interface SekolahRepository extends JpaRepository<SekolahEntity,Long>,PagingAndSortingRepository<SekolahEntity,Long> {
}
