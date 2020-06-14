package com.example.pokedemo.client;

import java.net.URI;

public class NamedApiResource {

    private String name;
    private URI url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }
}
