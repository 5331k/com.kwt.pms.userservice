/**
 * Author: Safdar Khan
 * Date: 03/05/2025
 */

package com.kwt.pms.userservice.service;


import com.kwt.pms.common.auth.LoginResponse;
import com.kwt.pms.userservice.persistence.entity.RolePermission;
import com.kwt.pms.userservice.persistence.entity.Role;
import com.kwt.pms.userservice.persistence.entity.Permission;
import com.kwt.pms.userservice.persistence.entity.User;
import com.kwt.pms.userservice.persistence.entity.UserRole;
import com.kwt.pms.userservice.persistence.repository.*;
import com.kwt.pms.userservice.rest.InvalidCredentialsException;
import com.kwt.pms.userservice.service.dto.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final Logger logger = LogManager.getLogger(AuthService.class);

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;
    private final RolePermissionRepository rolePermissionRepository;
    private final PermissionRepository permissionRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByUserName(request.getUsername())
                .orElseThrow(() -> new InvalidCredentialsException("Incorrect username"));

        if (!passwordEncoder.matches(request.getPassword(), user.getUserPassword())) {
            throw new InvalidCredentialsException("Incorrect password");
        }
        logger.info("Creds matched!");
        List<UserRole> userRoles = userRoleRepository.findByUserId(user.getUserId());
        List<Integer> roleIds = userRoles.stream().map(UserRole::getRoleId).toList();

        Set<String> roles = roleRepository.findAllById(roleIds).stream()
                .map(Role::getName).collect(Collectors.toSet());

        List<RolePermission> rolePermissions = rolePermissionRepository.findByRoleIdIn(roleIds);
        Set<Integer> permissionIds = rolePermissions.stream()
                .map(RolePermission::getPermissionId).collect(Collectors.toSet());

        Set<String> permissions = permissionRepository.findAllById(permissionIds).stream()
                .map(Permission::getName).collect(Collectors.toSet());

        LoginResponse response = new LoginResponse();
        response.setUserId(user.getUserId());
        response.setUsername(user.getUserName());
        response.setRoles(roles);
        response.setPermissions(permissions);
        return response;
    }
}