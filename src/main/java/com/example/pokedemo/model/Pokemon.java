package com.example.pokedemo.model;

import java.util.List;
import java.util.Objects;

public class Pokemon {

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
