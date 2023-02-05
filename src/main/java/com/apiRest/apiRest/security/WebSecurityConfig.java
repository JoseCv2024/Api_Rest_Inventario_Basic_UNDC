package com.apiRest.apiRest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;


//WebSecurityConfig

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {
    
    private final UserDetailsService userDetailsService;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {

        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");

        return http
            .cors()
            .and()
            .csrf().disable()
            .authorizeHttpRequests()
            //.antMatchers("api/**") //listarProducto
            //.permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .addFilter(jwtAuthenticationFilter)
            .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }

/*     @Bean
    public UserDetailsService() {
    // BD USUARIO --Consultar If - else---
    UsuarioDto userObj = new UsuarioDto();

    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.withUsername("admin")
                            .password(passwordEncoder().encode("admin"))
                            .roles("ADMIN")
                            .build());  

    return manager;
} */

@Bean
AuthenticationManager authManager(HttpSecurity http) throws Exception {

     return http.getSharedObject(AuthenticationManagerBuilder.class)
     .userDetailsService(userDetailsService)
     .passwordEncoder(passwordEncoder())
     .and()
     .build();
}

@Bean
PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}


}



/*   protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
            .inMemoryAuthentication()
            .withUser("angeles").password("{noop}"+"123").roles("USER")
            .and()
            .withUser("junior").password("{noop}"+"123").roles("ADMIN");
    } */