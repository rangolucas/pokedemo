package com.example.pokedemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
}
