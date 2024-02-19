package com.backend.hackathon.hackathon_grup6.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String[] WHITE_LIST_URL = {
            "/authenticate",
            "/swagger-resources",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"};
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    public SecurityConfiguration(JwtAuthenticationFilter jwtAuthFilter, AuthenticationProvider authenticationProvider) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.authenticationProvider = authenticationProvider;
        System.out.println("security configuration ----------------------------------------------------");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req
                                .requestMatchers(WHITE_LIST_URL).permitAll()
                                .requestMatchers("/courses/{courseId}/lessons").hasAnyRole("USER", "ADMIN")
                                .requestMatchers(POST, "/courses").hasAnyRole("ADMIN", "TEACHER")
                                .requestMatchers("/courses/**", "/profilesByName/**").hasAnyRole("ADMIN", "TEACHER")
                                .requestMatchers(POST,
                                        "/courses/availables", "/courses/students/details",
                                        "/courses/search", "/courses/recent",
                                        "/courses/category&language",
                                        "/courses/category", "/courses/language",
                                        "/category").hasAnyRole("ADMIN", "TEACHER", "STUDENT")
                                .requestMatchers(POST, "/courses/categories").hasAnyRole("ADMIN", "TEACHER")
                                .requestMatchers(HttpMethod.DELETE, "/courses/categories/{{categoryId}}").hasAnyRole("ADMIN", "TEACHER")
                                .requestMatchers(POST, "/courses/enroll").hasAnyRole("STUDENT")
                                .requestMatchers(HttpMethod.GET, "/courses/{courseId}/students/{studentId}/details").hasAnyRole("STUDENT")
                                .requestMatchers(POST, "/courses/{courseId}/lessons").hasAnyRole("TEACHER")
                                .requestMatchers(HttpMethod.PUT, "/courses/students/{studentId}/reviews/{reviewId}/updates").hasAnyRole("STUDENT")
                                .requestMatchers(HttpMethod.GET, "/courses/{courseId}/reviews").hasAnyRole("USER", "ADMIN", "TEACHER", "STUDENT")
                                .requestMatchers(HttpMethod.GET, "/courses/{courseId}/students").hasAnyRole("ADMIN", "TEACHER")
                                .requestMatchers(HttpMethod.GET, "/courses/top-rated").hasAnyRole("USER", "ADMIN", "TEACHER", "STUDENT")
                                .requestMatchers(POST, "/courses/lessons/{lessonId}/students/{studentId}/completed").hasAnyRole("STUDENT")
                                .requestMatchers(HttpMethod.GET, "/courses/{courseId}/students/{studentId}/lessons").hasAnyRole("STUDENT")
                                .requestMatchers(HttpMethod.GET, "/courses/top-completed").hasAnyRole("USER", "ADMIN", "TEACHER", "STUDENT")
                                .requestMatchers(HttpMethod.GET, "/courses").hasAnyRole("USER", "ADMIN", "TEACHER", "STUDENT")
                                .requestMatchers(HttpMethod.GET, "/courses/students/{studentId}/student-completed").hasAnyRole("USER", "ADMIN", "TEACHER", "STUDENT")
                                .requestMatchers(POST, "/courses/{courseId}/students/{studentId}/reviews").hasAnyRole("USER", "ADMIN", "TEACHER", "STUDENT")
                                .requestMatchers(HttpMethod.GET, "/courses/students/{studentId}/with-reviews").hasAnyRole("USER", "ADMIN", "TEACHER", "STUDENT")
                                .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
