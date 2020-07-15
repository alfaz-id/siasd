package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdminRepository extends JpaRepository<User,Integer>, PagingAndSortingRepository<User,Integer> {
}
