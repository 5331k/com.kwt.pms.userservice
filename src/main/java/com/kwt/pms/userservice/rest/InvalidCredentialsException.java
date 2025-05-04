/**
 * Author: Safdar Khan
 * Date: 04/05/2025
 */

package com.kwt.pms.userservice.rest;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}