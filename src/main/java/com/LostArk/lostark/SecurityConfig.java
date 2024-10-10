package com.LostArk.lostark;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Security 사용가능하게함
public class SecurityConfig {

    
    @Bean // 어떤페이지를 로그인 검사할지 설정가능
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable()); // csrf 보안 끔
        http.authorizeHttpRequests((authorize) ->
                // 밑에 URL permitAll() 는 모든 허용
                authorize.requestMatchers("/**").permitAll()
        );
        return http.build();
    }
}
