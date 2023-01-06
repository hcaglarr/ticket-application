package com.hcaglar.ticketapplication.repository;

import com.hcaglar.ticketapplication.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 6.01.2023
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
