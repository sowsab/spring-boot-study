package com.example.site1.model.post.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.site1.model.post.entity.PostEntity;


@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {

    @Query(value = "select * from post where title = ?", nativeQuery = true)
    void getPostList(String title);
    
    // select * from post where idx = ?
    Optional<PostEntity> findByIdx(Integer idx);

    // select * from post where title = ?
    List<PostEntity> findByTitle(String title);

    // select * from post where content = ?
    List<PostEntity> findByContent(String content);

    // select * from post where user_idx = ?
    List<PostEntity> findByUserEntity_Idx(Integer userIdx);
    
    // select *
    // from post
    // where title =?
    // or content = ?
    List<PostEntity> findByTitleOrContent(String title, String content);

    // select *
    // from post
    // where title like '%?%'
    // or content like '%?%'
    List<PostEntity> findByTitleContainingOrContentContaining(String title, String content);

}
