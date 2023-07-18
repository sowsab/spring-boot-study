package com.example.site1.domain.post.dto;

import com.example.site1.model.post.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ResPostDTO {
    
    private Integer postIdx;
    private String postTitle;
    private String postContent;
    private Integer postUserIdx;

    public static ResPostDTO fromEntity (PostEntity postEntity) {
        // return new ResPostDTO(postEntity.getPostIdx(), postEntity.getPostTitle(), postEntity.getPostContent(), postEntity.getPostUserIdx());

        return ResPostDTO.builder()
            .postIdx(postEntity.getPostIdx())
            .postTitle(postEntity.getPostTitle())
            .postContent(postEntity.getPostContent())
            .postUserIdx(postEntity.getPostUserIdx())
            .build();

    }


}