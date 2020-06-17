package com.example.pokedemo.model;

import com.example.pokedemo.model.resource.ApiResource;
import com.example.pokedemo.model.resource.NamedApiResource;
import com.example.pokedemo.service.ApiResourceVisitor;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pokemon extends NamedApiResource {

    private long id;
    private String name;
    private int height;
    private int weight;
    private Sprites sprites;
    private List<TypeDetail> types;
    private List<AbilityDetail> abilities;

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
        this.abilities.forEach(abilityDetail -> dependencies.add(abilityDetail.getAbility()));
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<TypeDetail> getTypes() {
        return types;
    }

    public void setTypes(List<TypeDetail> types) {
        this.types = types;
    }

    public List<AbilityDetail> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilityDetail> abilities) {
        this.abilities = abilities;
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

    public static class Sprites {
        @JsonProperty("back_default")
        private String backDefault;
        @JsonProperty("front_default")
        private String frontDefault;

        public String getBackDefault() {
            return backDefault;
        }

        public void setBackDefault(String backDefault) {
            this.backDefault = backDefault;
        }

        public String getFrontDefault() {
            return frontDefault;
        }

        public void setFrontDefault(String frontDefault) {
            this.frontDefault = frontDefault;
        }
    }

    public static class AbilityDetail {
        private Ability ability;

        public Ability getAbility() {
            return ability;
        }

        public void setAbility(Ability ability) {
            this.ability = ability;
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
