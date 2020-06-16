package com.example.pokedemo.repository;

import com.example.pokedemo.model.resource.ApiResource;
import com.example.pokedemo.client.PokeApiClient;
import com.example.pokedemo.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public abstract class CachedRepository<T extends ApiResource> implements PokedexRepository<T> {

    protected PokeApiClient<T> client;

    @Override
    @Cacheable("page")
    public List<T> getByPage(Page page) {
        int limit = page.getPageSize();
        int offset = page.getOffset();
        return this.client.fetchByPage(limit, offset, this);
    }

    @Override
    @Cacheable("url")
    public T getByUrl(String url) {
        return this.client.fetchByUrl(url, this.getBoundEntity());
    }

    public abstract Class<T> getBoundEntity();
    public abstract String getCategoryName();

    @Autowired
    public void setClient(PokeApiClient<T> client) {
        this.client = client;
    }
}
