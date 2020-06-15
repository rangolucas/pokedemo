package com.example.pokedemo.model;

import com.example.pokedemo.model.resource.ApiResource;
import com.example.pokedemo.model.resource.NamedApiResource;
import com.example.pokedemo.service.ApiResourceVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pokemon extends NamedApiResource {

    private long id;
    private String name;
    private int height;
    private List<TypeDetail> types;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public List<ApiResource> getDependencies() {
        List<ApiResource> dependencies = new ArrayList<>();
        this.types.forEach(typeDetail -> dependencies.add(typeDetail.getType()));
        return dependencies;
    }

    @Override
    public void accept(ApiResourceVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<TypeDetail> getTypes() {
        return types;
    }

    public void setTypes(List<TypeDetail> types) {
        this.types = types;
    }

    public static class TypeDetail {
        private int slot;
        private PokemonType type;

        public int getSlot() {
            return slot;
        }

        public void setSlot(int slot) {
            this.slot = slot;
        }

        public PokemonType getType() {
            return type;
        }

        public void setType(PokemonType type) {
            this.type = type;
        }
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return id == pokemon.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
