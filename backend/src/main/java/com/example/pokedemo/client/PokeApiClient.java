package com.example.pokedemo.client;

import com.example.pokedemo.exception.ResourceNotFoundException;
import com.example.pokedemo.model.resource.ApiResource;
import com.example.pokedemo.model.resource.ApiResourceList;
import com.example.pokedemo.repository.ApiResourceRepository;
import com.example.pokedemo.service.DependencySolver;
import com.example.pokedemo.util.UriParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokeApiClient<T extends ApiResource> {

    private static final String FETCH_BY_PAGE_URI = "/{resourceName}/?limit={limit}&offset={offset}";

    private RestTemplate restTemplate;
    private DependencySolver visitor;

    public List<T> fetchByPage(int limit, int offset, ApiResourceRepository<T> repository) {
        String resourceName = repository.getCategoryName();
        ApiResourceList apiResourceList = this.restTemplate.getForEntity(
                FETCH_BY_PAGE_URI, ApiResourceList.class, resourceName, limit, offset).getBody();
        List<ApiResourceList.Result> results = apiResourceList.getResults();
        List<T> retrieved = new ArrayList<>();
        results.forEach(result -> retrieved.add(repository.getByUrl(result.getUrl(), true)));
        return retrieved;
    }

    public T fetchByName(String resourceName, ApiResourceRepository<T> repository) {
        String url = String.format("/%s/%s", repository.getCategoryName(), resourceName);
        return repository.getByUrl(url, false);
    }

    @Cacheable(cacheNames = "url")
    public T fetchByUrl(String url, Class<T> entity, boolean uriIsAbsolute) {
        if(uriIsAbsolute) {
            url = UriParser.toResourcePath(url);
        }
        return this.fetchForEntity(url, entity);
    }

    private T fetchForEntity(String resourcePath, Class<T> entity, String... params) {
        ResponseEntity<T> response = this.restTemplate.getForEntity(resourcePath, entity, params);

        if(response.getStatusCode().is4xxClientError()) {
            throw new ResourceNotFoundException(response.toString());
        }

        T resource = response.getBody();
        resource.solveDependencies(this.visitor);
        return resource;
    }

    @Autowired
    public void setDependencySolver(DependencySolver visitor) {
        this.visitor = visitor;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
