package travora.travora.configaration;

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
                registry.addMapping("/**") // Allow all paths
                        .allowedOrigins("http://localhost:3000") // Allow frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow methods
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow cookies/session data
            }
        };
    }
}
