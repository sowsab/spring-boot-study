package com.example.site1.domain.main.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResMainDTO {

    private List<User> userList;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class User {
        // 모든 유저 가져오기
        private String id;

    }
}
