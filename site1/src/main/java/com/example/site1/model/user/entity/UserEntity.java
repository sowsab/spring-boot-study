package com.example.site1.model.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserEntity {
    @Id
    @Column(name = "idx", nullable = false, unique = true)
    private Integer userIdx;

    @Column(name = "id", nullable = false)
    private String userId;

    @Column(name = "password", nullable = false)
    private String userPassword;

    
}
