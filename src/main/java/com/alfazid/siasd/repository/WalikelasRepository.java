package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.entity.WaliKelasEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 07/09/19.
 */
public interface WalikelasRepository extends CrudRepository<WaliKelasEntity,Integer>,PagingAndSortingRepository<WaliKelasEntity,Integer> {
    @Query(value = "SELECT c FROM WaliKelasEntity c WHERE c.idSekolah=:idSekolah")
    Page<WaliKelasEntity> findAll(Pageable pageable, @Param("idSekolah") int idSekolah);
}
