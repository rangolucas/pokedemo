package com.example.pokedemo.repository;

import com.example.pokedemo.client.PokeApiClient;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public abstract class CachedRepository<T> implements PokedexRepository<T> {

    private final PokeApiClient<T> client;

    public CachedRepository(PokeApiClient<T> client) {
        this.client = client;
    }

    @Override
    @Cacheable
    public List<T> getByPage(int limit, int offset) {
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
