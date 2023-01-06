package com.hcaglar.ticketapplication.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author Hüseyin ÇAĞLAR
 * @version 1.0
 * @since 5.01.2023
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorize ->
                        authorize.antMatchers("/", "/webjars/**", "/css/**", "/img/**").permitAll()
                )
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin(login ->
                        login.loginProcessingUrl("/login")
                                .loginPage("/account/login")
                                .successForwardUrl("/")
                                .permitAll()
                                .failureUrl("/account/login")
                                .defaultSuccessUrl("/"))
                .logout(logout ->
                        logout.logoutSuccessUrl("/account/login")
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                                .permitAll()
                ).csrf();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
