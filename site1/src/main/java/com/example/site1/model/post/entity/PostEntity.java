package com.example.site1.model.post.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostEntity {
    @Id
    @Column(name = "idx", nullable = false, unique = true)
    private Integer postIdx;

    @Column(name = "title", nullable = false)
    private String postTitle;

    @Column(name = "content", nullable = false)
    private String postContent;

    @Column(name = "user_idx", nullable = false)
    private Integer postUserIdx;
    

}
