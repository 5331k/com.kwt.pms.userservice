/**
 * Author: Safdar Khan
 * Date: 03/05/2025
 */

package com.kwt.pms.userservice.rest;

import com.kwt.pms.userservice.service.AuthService;
import com.kwt.pms.userservice.service.dto.request.LoginRequest;
import com.kwt.pms.userservice.service.dto.response.LoginResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private static final Logger logger = LogManager.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request, HttpSession session) {
        logger.info("Request rcvd for login");
        LoginResponse response = authService.login(request);
        session.setAttribute("user", response);
        logger.info("Session: " + session.getId() + ", response: " + response);
        return ResponseEntity.ok(response);  // ← return the actual response object
    }

    @GetMapping("/me")
    public ResponseEntity<LoginResponse> getCurrentUser(HttpSession session) {
        logger.info("Request rcvd for me");
        LoginResponse user = (LoginResponse) session.getAttribute("user");
        logger.info("Session: " + session.getId() + ", User: " + user);
        if (user == null) {
            logger.info("Unauthorized user");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out");
    }
}
