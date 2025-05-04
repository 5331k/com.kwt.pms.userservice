/**
 * Author: Safdar Khan
 * Date: 03/05/2025
 */

package com.kwt.pms.userservice.service.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}