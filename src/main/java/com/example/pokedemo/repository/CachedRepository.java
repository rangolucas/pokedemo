package com.example.pokedemo.repository;

import com.example.pokedemo.client.NamedApiResource;
import com.example.pokedemo.client.PokeApiClient;
import com.example.pokedemo.model.Page;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public abstract class CachedRepository<T> implements PokedexRepository<T> {

    private final PokeApiClient<T> client;

    public CachedRepository(PokeApiClient<T> client) {
        this.client = client;
    }

    @Override
    @Cacheable
    public List<T> getByPage(Page page) {
        int limit = page.getPageSize();
        int offset = page.getOffset();
        return this.client.fetchByPage(limit, offset, this);
    }

    @Override
    @Cacheable
    public T getByName(String name) {
        return this.client.fetchByName(name, this);
    }

    public abstract Class<T> getBoundEntity();
    public abstract String getResourceName();
}
