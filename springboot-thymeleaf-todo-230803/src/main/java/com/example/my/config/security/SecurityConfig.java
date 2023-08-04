package com.example.my.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.my.config.security.auth.CustomAuthenticationFailureHandler;
import com.example.my.config.security.auth.CustomAuthenticationSuccessHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // csrff 보안 해제 (실무에서는 보안 적용 권장)
        httpSecurity.csrf(
            // 매개변수 이름은 알아서, config 추천, 결국 csrf를 끈다는 소리이다
            config -> config.disable()  
        );

        // 요청 주소 인증 및 인가 세팅
        httpSecurity.authorizeHttpRequests(
            config -> config
                .requestMatchers("/css/**", "/js/**", "/img/**")
                // 위에 해당하는 주소를 인증 및 인가 없이 접속 가능하도록 함
                .permitAll()
                .requestMatchers("/auth/**", "/api/*/auth/**")
                .permitAll()
                .requestMatchers("/admin/**", "/api/*/auth/**")
                // 위에 해당하느 주소는 AMDIN 권한이 있는 사람만 접근할 수 있다
                // .hasAuthority("ROLE_ADMIN")
                .hasRole("ADMIN")
                .anyRequest() // 나머지 모든 주소
                // 위에 해당하는 주소는 로그인(인증)이 되어 있어야 한다
                .authenticated()
        );

        httpSecurity.formLogin(
            config -> config
                // 실제 로그인 컨트롤러 메소드 경로를 넣는다
                .loginPage("/auth/login")
                // 가상의 주소를 넣는다, 원래 쓰던 로그인 명령을 실행되게 하는 주소를 제거해야 한다
                .loginProcessingUrl("/api/v1/auth/login")
                .usernameParameter("id")
                .passwordParameter("password")
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)
                .permitAll()
        );

        return httpSecurity.getOrBuild();
    } 

}
