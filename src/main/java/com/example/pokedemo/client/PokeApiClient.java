package com.example.pokedemo.client;

import com.example.pokedemo.AppConfig;
import com.example.pokedemo.model.resource.ApiResource;
import com.example.pokedemo.model.resource.ApiResourceList;
import com.example.pokedemo.repository.CachedRepository;
import com.example.pokedemo.service.DependencySolver;
import com.example.pokedemo.util.UriParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokeApiClient<T extends ApiResource> {

    private final WebClient client;
    private DependencySolver visitor;

    public PokeApiClient(@Autowired AppConfig appConfig) {
        this.client = WebClient.create(appConfig.getBaseUrl());
    }

    public List<T> fetchByPage(int limit, int offset, CachedRepository<T> repository) {
        ApiResourceList apiResourceList = this.fetchResourceList(repository.getCategoryName(), limit, offset);
        List<ApiResource> results = apiResourceList.getResults();
        List<T> retrieved = new ArrayList<>();
        results.forEach(result -> retrieved.add(repository.getByUrl(result.getUrl())));
        return retrieved;
    }

    public T fetchByName(String categoryName, String resourceName, Class<T> entity) {
        String resourcePath = String.format("%s/%s", categoryName, resourceName);
        return fetchByUrl0(resourcePath, entity);
    }

    public T fetchByUrl(String url, Class<T> entity) {
        String resourcePath = UriParser.toResourcePath(url);
        return fetchByUrl0(resourcePath, entity);
    }

    private T fetchByUrl0(String resourcePath, Class<T> entity) {
        T resource = this.client.get().uri(resourcePath).retrieve().bodyToMono(entity).block();
        resource.solveDependencies(this.visitor);
        return resource;
    }

    private ApiResourceList fetchResourceList(String resourceName, int limit, int offset) {
        String resourcePath = resourceName + "/?limit={limit}&offset={offset}";
        return this.client.get().uri(resourcePath, limit, offset).retrieve().bodyToMono(ApiResourceList.class).block();
    }

    @Autowired
    public void setDependencySolver(DependencySolver visitor) {
        this.visitor = visitor;
    }
}
