/**
 * Author: Safdar Khan
 * Date: 03/05/2025
 */

package com.kwt.pms.userservice.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permission", schema = "base")
public class Permission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
}