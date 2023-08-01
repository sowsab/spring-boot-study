package com.example.site1.model.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.site1.model.user.entity.UserEntity;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    
    // 리파지토리야 유저의 idx를 줄테니까
    // 해당 idx를 가진 UserEntity를 리턴해줘
    // UserEntity findByIdx(Integer idx);

    // 리파지토리야 유저의 idx를 줄테니까
    // 해당 idx를 가진 UserEntity를 리턴해줘 
    Optional<UserEntity> findByIdx(Integer idx);   
    
    // 리파지토리야 유저의 id를 줄테니까
    // 해당 id를 가진 UserEntity를 리턴해줘
    Optional<UserEntity> findById(String id);

    List<UserEntity> findByPassword(String password);

    Optional<UserEntity> findByIdxAndId(Integer idx, String id);

    List<UserEntity> findByIdContaining(String id);
}
