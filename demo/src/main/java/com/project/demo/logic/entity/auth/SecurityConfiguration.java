package com.project.demo.logic.entity.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfiguration(
            JwtAuthenticationFilter jwtAuthenticationFilter,
            AuthenticationProvider authenticationProvider
    ) {
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/**").permitAll()

<<<<<<< HEAD

=======
                        // Permisos para productos
>>>>>>> a1c0723f618234ad8abd45e372c238c4f140857e
                        .requestMatchers(HttpMethod.GET, "/api/products/**").hasAnyRole("USER", "SUPER_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/products/**").hasRole("SUPER_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("SUPER_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("SUPER_ADMIN")

<<<<<<< HEAD

=======
                        // Permisos para categorías
>>>>>>> a1c0723f618234ad8abd45e372c238c4f140857e
                        .requestMatchers(HttpMethod.GET, "/api/categories/**").hasAnyRole("USER", "SUPER_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/categories/**").hasRole("SUPER_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/categories/**").hasRole("SUPER_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/categories/**").hasRole("SUPER_ADMIN")

<<<<<<< HEAD
                        .requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("SUPER_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/users/**").hasRole("SUPER_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/users/**").hasRole("SUPER_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("SUPER_ADMIN")

=======
>>>>>>> a1c0723f618234ad8abd45e372c238c4f140857e
                        // Todo lo demás requiere autenticación
                        .anyRequest().authenticated()
                )
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
