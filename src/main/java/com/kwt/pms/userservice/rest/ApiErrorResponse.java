/**
 * Author: Safdar Khan
 * Date: 04/05/2025
 */

package com.kwt.pms.userservice.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class ApiErrorResponse {
    private int status;
    private String error;
    private String message;
    private ZonedDateTime timestamp;
}