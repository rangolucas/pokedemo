package com.example.pokedemo.model.resource;

public abstract class NamedApiResource extends ApiResource {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
