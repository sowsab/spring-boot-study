package com.example.site1.domain.second.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResSecondDTO {

    private List<Post> postList;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    // 종속이 되어있지만 별개의 관계임을 알리기 위해 static을 붙어야 한다
    public static class Post {
        private String title;
        private String content;
        private User user;

        @NoArgsConstructor
        @AllArgsConstructor
        @Getter
        public static class User {
            private Integer idx;
        }

    }

}
