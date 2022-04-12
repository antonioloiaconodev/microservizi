package antonioloiacono.tesi.msvideogame.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Value("${api.cross-origin.urls}")
    private String API_CROSS_ORIGIN_URLS;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/hidden/videogames/**")
                .allowedOrigins(API_CROSS_ORIGIN_URLS)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
    }

}