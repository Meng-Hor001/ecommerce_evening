package com.edu.kh.ecommcer_evening.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    // Build firewall
    @Bean
    public SecurityFilterChain apiSecurity (HttpSecurity http){

        // 1. Security Mechanism -> OAuth2 & JWT
        http.oauth2ResourceServer(
                oauth2-> oauth2
                        .jwt(Customizer.withDefaults())
        );

        // 2. Session Stateless
        // Session : configure to stateless
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // 3. Endpoint Security
        http.authorizeHttpRequests(request -> request
                .requestMatchers(HttpMethod.POST,"/api/v1/products").hasAnyRole("ADMIN", "BUSINESS")
                .requestMatchers(HttpMethod.DELETE,"/api/v1/products").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.GET,"/api/v1/products/**").authenticated()
                .anyRequest()
                .permitAll()
        );


        // 4. Disable CRSF (Cross Site Request Forgery) token
        http.csrf(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
