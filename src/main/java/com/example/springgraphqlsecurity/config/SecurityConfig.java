package com.example.springgraphqlsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.Map;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityWebFilterChain authorization(ServerHttpSecurity httpSecurity) {
        return httpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(aes -> aes.anyExchange().permitAll())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    MapReactiveUserDetailsService authentication() {
        var users = Map.of(
                        "gordienkoee", new String[]{"USER"},
                        "admin", "ADMIN,USER".split(","))
                .entrySet()
                .stream()
                .map(entry -> User.withDefaultPasswordEncoder()
                        .username(entry.getKey())
                        .password("password")
                        .roles(entry.getValue())
                        .build())
                .toList();
        return new MapReactiveUserDetailsService(users);
    }
}
