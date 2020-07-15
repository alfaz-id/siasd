package com.alfazid.siasd.repository;

import com.alfazid.siasd.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 09/10/19.
 */

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(String role);
}
