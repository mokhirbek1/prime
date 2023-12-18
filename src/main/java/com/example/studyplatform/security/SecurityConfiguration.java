package com.example.studyplatform.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration
{
    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity httpSecurity ) throws Exception
    {
        return httpSecurity
                .authorizeHttpRequests(
                        registry -> registry
                                .requestMatchers( "/", "/auth/login", "/auth/register", "/css/**", "/js/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .formLogin(
                        loginConfig -> loginConfig
                                .loginPage( "/auth/login" )
                                .loginProcessingUrl( "/auth/login" )
                                .usernameParameter( "phoneNumber" )
                                .passwordParameter( "password" )
                                .defaultSuccessUrl( "/auth/home", true )
                )
                .logout(
                        logoutConfig -> logoutConfig
                                .logoutSuccessUrl( "/auth/login" )
                                .logoutRequestMatcher( new AntPathRequestMatcher( "/auth/logout" ) )
                )
                .rememberMe(
                        rememberMeConfig -> rememberMeConfig
                                .rememberMeCookieName( "rememberMe" )
                                .rememberMeParameter( "rememberMe" )
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }
}
