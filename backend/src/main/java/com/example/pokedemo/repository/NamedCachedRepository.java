package com.example.pokedemo.repository;

import com.example.pokedemo.model.resource.NamedApiResource;
import org.springframework.cache.annotation.Cacheable;

public abstract class NamedCachedRepository<T extends NamedApiResource> extends CachedRepository<T> {

    @Cacheable("named")
    public T getByName(String name) {
        return this.client.fetchByName(this.getCategoryName(), name, this.getBoundEntity());
    }
}
