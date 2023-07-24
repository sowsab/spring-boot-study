package com.example.site1.model.user.entity;

import java.util.List;

import com.example.site1.model.post.entity.PostEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false, unique = true)
    private Integer userIdx;

    @Column(name = "id", nullable = false)
    private String userId;

    @Column(name = "password", nullable = false)
    private String userPassword;

    @OneToMany(mappedBy = "userEntity")
    private List<PostEntity> postEntityList;
    
}
