package com.osnel97.springsmartshop.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer{

@Override
public void addCorsMappings(CorsRegistry corsRegistry) {
corsRegistry.addMapping("/**")
//.allowedOrigins("http://localhost:4200")
.allowedOrigins("*")
.allowedMethods("GET", "POST", "PUT", "DELETE")
.allowedHeaders("*");
}


@Bean
public PasswordEncoder passwordEncoder() {
return new BCryptPasswordEncoder();
}

}

