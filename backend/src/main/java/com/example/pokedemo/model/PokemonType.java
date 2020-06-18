package com.example.pokedemo.model;

import com.example.pokedemo.model.resource.ApiResource;
import com.example.pokedemo.model.resource.NamedApiResource;
import com.example.pokedemo.service.ApiResourceVisitor;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PokemonType extends NamedApiResource {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public List<ApiResource> getDependencies() {
        return Collections.emptyList();
    }

    @Override
    public void accept(ApiResourceVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "PokemonType{" +
                "name='" + this.getName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonType that = (PokemonType) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
