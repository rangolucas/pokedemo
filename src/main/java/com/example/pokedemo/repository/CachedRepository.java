package com.example.pokedemo.repository;

import com.example.pokedemo.client.NamedApiResource;
import com.example.pokedemo.client.PokeApiClient;
import com.example.pokedemo.model.Page;
import com.example.pokedemo.service.ResourceSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public abstract class CachedRepository<T extends NamedApiResource> implements PokedexRepository<T> {

    private PokeApiClient<T> client;
    private ResourceSolver visitor;

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
        T t = this.client.fetchByName(name, this);
        List<NamedApiResource> dependencies = t.getDependencies();
        dependencies.forEach(dep -> dep.accept(this.visitor));
        return t;
    }

    public abstract Class<T> getBoundEntity();
    public abstract String getResourceName();

    @Autowired
    public void setClient(PokeApiClient<T> client) {
        this.client = client;
    }

    @Autowired
    public void setVisitor(ResourceSolver visitor) {
        this.visitor = visitor;
    }
}
