package com.kwt.pms.userservice.persistence.repository;

import com.kwt.pms.userservice.persistence.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
    List<RolePermission> findByRoleIdIn(List<Integer> roleIds);
}