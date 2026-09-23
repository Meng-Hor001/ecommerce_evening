package com.edu.kh.ecommcer_evening.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;

    // Build data of users (in memory)
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails userAdmin = User
                .builder()
                .username("admin")
                .password(passwordEncoder.encode("qwer"))
                .roles("ADMIN")
                .build();

        UserDetails userNormal = User
                .builder()
                .username("user")
                .password(passwordEncoder.encode("qwer"))
                .roles("NORMAL")
                .build();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(userAdmin);
        manager.createUser(userNormal);

        return manager;
    }

    // Build firewall
    @Bean
    public SecurityFilterChain apiSecurity (HttpSecurity http){
        // TODO : what you want to build
        http.authorizeHttpRequests(request -> request
                .requestMatchers("/api/v1/products/**").authenticated()
                .anyRequest()
                .permitAll()
        );


        // Disable CRSF (Cross Site Request Forgery) token
        http.csrf(AbstractHttpConfigurer::disable);

        // Security Mechanism : HTTP Basic Authentication
        http.httpBasic(Customizer.withDefaults());

        // Session : configure to stateless
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        return http.build();
    }
}
