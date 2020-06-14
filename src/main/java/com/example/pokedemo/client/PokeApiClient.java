package com.example.pokedemo.client;

import com.example.pokedemo.AppConfig;
import com.example.pokedemo.repository.CachedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokeApiClient<T extends NamedApiResource> {

    private final WebClient client;

    public PokeApiClient(@Autowired AppConfig appConfig) {
        this.client = WebClient.create(appConfig.getBaseUrl());
    }

    public List<T> fetchByPage(int limit, int offset, CachedRepository<T> repository) {
        NamedApiResourceList namedApiResourceList = this.fetchResourceList(repository.getResourceName(), limit, offset);
        List<NamedApiResource> results = namedApiResourceList.getResults();
        List<T> retrieved = new ArrayList<>();
        results.forEach(result -> retrieved.add(repository.getByName(result.getName())));
        return retrieved;
    }

    public T fetchByName(String name, CachedRepository<T> cachedRepository) {
        String resourceName = cachedRepository.getResourceName();
        Class<T> boundEntity = cachedRepository.getBoundEntity();
        String resourcePath = String.format("%s/%s", resourceName, name);
        return this.client.get().uri(resourcePath).retrieve().bodyToMono(boundEntity).block();
    }

    private NamedApiResourceList fetchResourceList(String resourceName, int limit, int offset) {
        String resourcePath = resourceName + "/?limit={limit}&offset={offset}";
        return this.client.get().uri(resourcePath, limit, offset).retrieve().bodyToMono(NamedApiResourceList.class).block();
    }
}
