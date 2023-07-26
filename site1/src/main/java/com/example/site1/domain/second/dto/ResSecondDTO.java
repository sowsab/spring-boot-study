package com.example.site1.domain.second.dto;

import com.example.site1.model.post.entity.PostEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ResSecondDTO {

    private String title;
    private String content;
    private Integer userIdx;

    public static ResSecondDTO fromEntity(PostEntity postEntity) {
        return ResSecondDTO.builder()
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .userIdx(postEntity.getUserIdx())
                .build();
    }

}
