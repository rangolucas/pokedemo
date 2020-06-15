package com.example.pokedemo.dto;

import java.util.List;
import java.util.Objects;

public class PokemonDto {

    private int id;
    private String name;
    private int weight;
    private int height;
    private List<PokemonTypeDto> types;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<PokemonTypeDto> getTypes() {
        return types;
    }

    public void setTypes(List<PokemonTypeDto> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "PokemonDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", types=" + types +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonDto that = (PokemonDto) o;
        return id == that.id &&
                weight == that.weight &&
                height == that.height &&
                Objects.equals(name, that.name) &&
                Objects.equals(types, that.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight, height, types);
    }
}
