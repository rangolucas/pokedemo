package com.example.pokedemo.model.resource;

import com.example.pokedemo.service.ApiResourceVisitor;
import com.example.pokedemo.service.DependencySolver;

import java.util.List;
import java.util.Objects;

public abstract class ApiResource {

    private String url;

    public void solveDependencies(DependencySolver solver) {
        List<ApiResource> dependencies = this.getDependencies();
        dependencies.forEach(dep -> dep.accept(solver));
    }

    public abstract List<ApiResource> getDependencies();
    public abstract void accept(ApiResourceVisitor visitor);

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiResource that = (ApiResource) o;
        return Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
