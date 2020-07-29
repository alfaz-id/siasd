package com.alfazid.siasd.utilities;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Created by cigist on 23/07/20.
 */
public interface BaseService<T> {
    void create(T input);
    Page<T> read(T input,BasePagintaion basePagintaion,Pageable pageable);
    void update(T input);
    void delete(String id);
    Optional<T> findById(String id);

}
