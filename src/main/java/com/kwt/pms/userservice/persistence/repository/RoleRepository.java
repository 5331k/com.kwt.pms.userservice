package com.kwt.pms.userservice.persistence.repository;

import com.kwt.pms.userservice.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}