package com.example.pokedemo.repository;

import com.example.pokedemo.model.resource.NamedApiResource;

public abstract class NamedApiResourceRepository<T extends NamedApiResource> extends ApiResourceRepository<T> {

    public T getByName(String name) {
        return this.client.fetchByName(name, this);
    }
}
