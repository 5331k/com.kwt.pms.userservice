/**
 * Author: Safdar Khan
 * Date: 09/04/2025
 */

package com.kwt.pms.userservice.persistence.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.sql.Timestamp;

@MappedSuperclass
@Data
public class BaseEntity {

    String createdUser;
    Timestamp tsCreated;

    @PrePersist
    protected void onCreate() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.tsCreated = now;
    }

}
