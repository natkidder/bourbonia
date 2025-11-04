package com.bezkoder.spring.jpa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
//  https://www.geeksforgeeks.org/authentication-and-authorization-in-spring-boot-3-0-with-spring-security/
public class SecurityConfig {

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// CSRF means cross-site request forgery
		/* An HTTP OPTIONS request simply asks what capabilities the HTTP request mapping has */
        http
        	.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
            		.requestMatchers(HttpMethod.GET, "/**").permitAll()
            		.requestMatchers(HttpMethod.POST, "/**").permitAll()
            		.requestMatchers(HttpMethod.PUT, "/**").permitAll()
            		.requestMatchers(HttpMethod.DELETE, "/**").permitAll()
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() 
                .anyRequest().authenticated()
            )
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(csrf -> csrf.disable()); // Assuming a stateless, token-based authentication scheme.
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000","http://localhost:4200")); // Your frontend URL
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	
	/*
	 * OAuth 2.0 in tandem with Google
	    @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                .authorizeHttpRequests(authorizeRequests ->
                    authorizeRequests
                        .requestMatchers("/", "/error").permitAll() // Allow public access to home and error pages
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .oauth2Login(oauth2Login ->
                    oauth2Login
                        .defaultSuccessUrl("/secured", true) // Redirect to /secured after successful login
                        .failureUrl("/loginFailure") // Handle login failures
                );
            return http.build();
        }
*/
}