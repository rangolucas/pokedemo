package com.example.pokedemo.client;

import com.example.pokedemo.service.ApiResourceVisitor;

import java.net.URI;
import java.util.List;

public abstract class NamedApiResource {

    private String name;
    private URI url;

    public abstract List<NamedApiResource> getDependencies();
    public abstract void accept(ApiResourceVisitor visitor);

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
