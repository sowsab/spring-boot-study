package com.example.site1.domain.main.dto;

import java.util.List;

import com.example.site1.model.post.entity.PostEntity;
import com.example.site1.model.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ResMainApiDTO {
    
    private List<User> userList;
    
    public static ResMainApiDTO of(List<UserEntity> userEntityList) {
        return ResMainApiDTO.builder()
        .userList(User.fromEntityList(userEntityList))
        .build();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class User {
        private Integer idx;
        private String id;
        private String password;
        private List<Post> postList;

        public static User fromEntity(UserEntity userEntity) {
            return User.builder()
            .idx(userEntity.getUserIdx())
            .id(userEntity.getUserId())
            .password(userEntity.getUserPassword())
            .postList(Post.fromEntityList(userEntity.getPostEntityList())
            )
            .build();
        }

        public static List<User> fromEntityList(List<UserEntity> userEntityList) {
            return userEntityList
                .stream()
                .map((userEntity) -> User.fromEntity(userEntity))
                .toList();
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Post {
        private Integer idx;
        private String title;
        private String content;

        // 객체가 없으므로 static이 필요하다
        public static Post fromEntity(PostEntity postEntity){
            return Post.builder()
            .idx(postEntity.getPostIdx())
            .title(postEntity.getPostTitle())
            .content(postEntity.getPostContent())
            .build();
        }

        public static List<Post> fromEntityList(List<PostEntity> postEntityList) {
            return postEntityList
                    .stream()
                    .map((postEntity) -> Post.fromEntity(postEntity))
                    .toList();
        }

    }

}
