/**
 * Author: Safdar Khan
 * Date: 04/05/2025
 */

package com.kwt.pms.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // For development; enable in production
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/login",
                        "/api/auth/logout").permitAll().requestMatchers(
                        "/api/auth/me").permitAll().anyRequest().authenticated()).sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)).formLogin(
                        form -> form.disable()).httpBasic(basic -> basic.disable());

        return http.build();
    }
}
