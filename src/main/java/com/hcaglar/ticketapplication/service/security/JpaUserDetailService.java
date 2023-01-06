package com.hcaglar.ticketapplication.service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 6.01.2023
 */
@Service
public class JpaUserDetailService implements UserDetailsService {
    private final UserServiceImpl userService;

    public JpaUserDetailService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userService.findUserByEmail(email);
    }
}
