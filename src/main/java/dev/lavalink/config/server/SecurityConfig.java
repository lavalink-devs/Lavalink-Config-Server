package dev.lavalink.config.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .formLogin(form -> form.loginPage("/login").permitAll())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/style.css", "/lavalink.svg").permitAll()
                .anyRequest().authenticated())
            .build();
    }
}
