package com.kwt.pms.userservice.persistence.repository;


import com.kwt.pms.userservice.persistence.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}