package com.example.my.config.security.auth;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.my.common.dto.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    // 객체를 json으로 변환해줄 코드
    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        // 옛날에 쓰던 자바 코드 그대로 사용 한다나 뭐라나
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding("UTF-8");
        // api를 쓰기로 해서 json 사용한다 선언
        response.setContentType("application/json");

        ResponseDTO<Object> responseDTO = ResponseDTO.builder()
        .code(0)
        .message("로그인에 성공했습니다")
        .build();

        String body = objectMapper.writeValueAsString(responseDTO);

        response.getWriter().print(body);


    }
    
}
