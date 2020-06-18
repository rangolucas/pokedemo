package com.example.pokedemo.config;

import com.example.pokedemo.exception.ApiErrorHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AppConfig {

    @Value("${pokeapi.baseurl}")
    private String baseUrl;

    @Value("${pageSize}")
    private int pageSize;

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        String rootUri = this.getBaseUrl();
        return builder
                .rootUri(rootUri)
                .errorHandler(new ApiErrorHandler())
                .build();
    }
}
