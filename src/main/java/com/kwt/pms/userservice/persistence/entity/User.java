/**
 * Author: Safdar Khan
 * Date: 03/05/2025
 */

package com.kwt.pms.userservice.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user", schema = "base")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "base.user_user_id_seq", allocationSize = 1)
    private Long userId;

    private String userName;
    private String userPassword;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean isActive = true;
    private Boolean isBlocked = false;
    private Timestamp resetPasswordDate;
    private String modifiedUser;
    private Timestamp tsChanged;

    @PreUpdate
    protected void onUpdate() {
        this.tsChanged = new Timestamp(System.currentTimeMillis());
    }
}