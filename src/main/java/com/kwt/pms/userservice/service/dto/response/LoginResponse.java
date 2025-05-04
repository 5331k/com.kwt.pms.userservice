/**
 * Author: Safdar Khan
 * Date: 03/05/2025
 */

package com.kwt.pms.userservice.service.dto.response;


import lombok.Data;
import java.util.Set;

@Data
public class LoginResponse {
    private Long userId;
    private String username;
    private Set<String> roles;
    private Set<String> permissions;
}
