package com.example.pokedemo.model;

import com.example.pokedemo.model.resource.ApiResource;
import com.example.pokedemo.model.resource.NamedApiResource;
import com.example.pokedemo.service.ApiResourceVisitor;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PokemonSpecies extends NamedApiResource {

    private int id;
    private String name;
    @JsonProperty("evolves_from_species")
    @Nullable
    private PokemonSpecies evolvesFromSpecies;
    @JsonProperty("evolution_chain")
    private EvolutionChain evolutionChain;

    @Override
    public List<ApiResource> getDependencies() {
        List<ApiResource> dependencies = new ArrayList<>();
        if(this.evolvesFromSpecies != null) {
            dependencies.add(this.evolvesFromSpecies);
        }
        dependencies.add(this.evolutionChain);
        return dependencies;
    }

    @Override
    public void accept(ApiResourceVisitor visitor) {
        visitor.visit(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public PokemonSpecies getEvolvesFromSpecies() {
        return evolvesFromSpecies;
    }

    public void setEvolvesFromSpecies(PokemonSpecies evolvesFromSpecies) {
        this.evolvesFromSpecies = evolvesFromSpecies;
    }

    public EvolutionChain getEvolutionChain() {
        return evolutionChain;
    }

    public void setEvolutionChain(EvolutionChain evolutionChain) {
        this.evolutionChain = evolutionChain;
    }
}
