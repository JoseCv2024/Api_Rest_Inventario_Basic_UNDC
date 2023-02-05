package com.apiRest.apiRest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsconfigurer(){
        return new WebMvcConfigurer() {
            
            @Override
            public void addCorsMappings(CorsRegistry registry){

                registry.addMapping("/api/**")
				.allowedOrigins("https://inventario-basic-ng15.azurewebsites.net") 
				//.allowedOrigins("http://localhost:5000")
				.allowedMethods("*");
                
                registry.addMapping("/login") 
						.allowedOrigins("https://inventario-basic-ng15.azurewebsites.net") 
						.allowedMethods("*")
						.exposedHeaders("*");

				//Local: http://localhost:4200 swagger
                
                //Web Angular: https://inventario-basic-ng15.azurewebsites.net 
            }
        };
    }
}
