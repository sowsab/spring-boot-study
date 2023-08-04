package com.example.my.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationSuccessHandler authenticationSuccessHandler;
    private final AuthenticationFailureHandler authenticationFailureHandler;
    private final LogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(config -> config.disable());

//        httpSecurity.headers(config -> config
//                .frameOptions(frameOptionsConfig -> frameOptionsConfig
//                        .disable()
//                )
//        );
//
//        httpSecurity.authorizeHttpRequests(config -> config
//                .requestMatchers(PathRequest.toH2Console())
//                .permitAll()
//        );

        httpSecurity.authorizeHttpRequests(config -> config
                .requestMatchers("/css/**", "/js/**", "/assets/**", "/favicon.ico")
                .permitAll()
                .requestMatchers("/js/admin*.js", "/h2/**", "/temp/**")
                .hasRole("ADMIN")
        );

        httpSecurity.authorizeHttpRequests(config -> config
                .requestMatchers("/auth/**", "/api/*/auth/**")
                .permitAll()
                .requestMatchers("/admin/**", "/api/*/admin/**")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
        );

        httpSecurity.formLogin(config -> config
                // 로그인 페이지 매핑 주소
                .loginPage("/auth/login")
                // 로그인 api 요청시 사용할 주소
                .loginProcessingUrl("/api/v1/auth/login")
                // html의 name을 받게 설정해야한다
                // 로그인 아이디 파라미터명(input 태그 name)
                .usernameParameter("id")
                // 로그인 비밀번호 파라미터명(input 태그 name)
                .passwordParameter("password")
                // 로그인 처리 성공시 유저에게 보낼 내용
                .successHandler(authenticationSuccessHandler)
                // 로그인 처리 실패시 유저에게 보낼 내용
                .failureHandler(authenticationFailureHandler)
                // 모두 허용
                .permitAll()
        );

        httpSecurity.logout(config -> config
                .logoutUrl("/auth/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll()
        );

        return httpSecurity.getOrBuild();
    }

}
