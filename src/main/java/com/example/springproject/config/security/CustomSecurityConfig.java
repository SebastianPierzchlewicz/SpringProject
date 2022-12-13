package com.example.springproject.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class CustomSecurityConfig {
    private static final String USER_ROLE ="USER";
    private static final String RDITOR_ROLE ="EDITO";
    private static final String ADMIN_ROLE ="ADMIN";

    @Bean
    public SecurityFilterChain filderChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((authz) -> authz
                        .mvcMatchers("/ocena-film").authenticated()
                        .mvcMatchers("/admin/**").hasAnyRole(RDITOR_ROLE,ADMIN_ROLE)
                        .anyRequest().permitAll()
        )
                .formLogin(login->login
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(logout->logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout/**", HttpMethod.GET.name()))
                        .logoutSuccessUrl("/login?logout").permitAll());
        http.csrf().ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"));
        http.headers().frameOptions().sameOrigin();
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().mvcMatchers(
                "/img/**",
                "/scripts/**",
                "/styles/**"
        );
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
