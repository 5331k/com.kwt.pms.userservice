/**
 * Author: Safdar Khan
 * Date: 04/05/2025
 */

package com.kwt.pms.userservice.rest;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}