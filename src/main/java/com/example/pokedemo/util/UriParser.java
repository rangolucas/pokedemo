package com.example.pokedemo.util;

import com.example.pokedemo.AppConfig;
import com.example.pokedemo.SpringContext;
import com.example.pokedemo.exception.PokedexException;

public class UriParser {

    private UriParser() {
        super();
    }

    public static String toResourcePath(String uri) {
        String baseUrl = SpringContext.getBean(AppConfig.class).getBaseUrl();
        if(!uri.startsWith(baseUrl)) {
            throw new PokedexException("Unexpected resource URI: " + uri);
        }

        int baseUrlLength = baseUrl.length();
        return '/' + uri.substring(baseUrlLength);
    }
}
