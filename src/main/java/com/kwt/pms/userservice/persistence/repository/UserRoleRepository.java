package com.kwt.pms.userservice.persistence.repository;


import com.kwt.pms.userservice.persistence.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUserId(Long userId);
}