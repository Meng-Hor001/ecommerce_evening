package com.edu.kh.ecommcer_evening.security;

import com.edu.kh.ecommcer_evening.repository.UserRepository;
import com.edu.kh.ecommcer_evening.security.model.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername {}", username );

        CustomUserDetails customUserDetails = userRepository
                .findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));

        log.info("customerUserDetail {}", customUserDetails);
        return customUserDetails;
    }
}
