package com.example.ToDoList.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/todolist/**") // Specify the mapping pattern for which CORS should be enabled
                        .allowedOrigins("http://localhost:63342") // Specify the allowed origin (frontend domain)
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify the allowed HTTP methods
                        .allowCredentials(true); // Allow sending cookies with the request (if needed)
            }
        };
    }
}
