package com.example.pokedemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value("${pokeapi.baseurl}")
    private String baseUrl;

    public String getBaseUrl() {
        return this.baseUrl;
    }
}
