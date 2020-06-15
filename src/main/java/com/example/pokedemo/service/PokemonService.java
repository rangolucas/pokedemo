package com.example.pokedemo.service;

import com.example.pokedemo.model.EvolutionChain;
import com.example.pokedemo.model.Page;
import com.example.pokedemo.model.Pokemon;
import com.example.pokedemo.model.PokemonSpecies;
import com.example.pokedemo.repository.PokemonRepository;
import com.example.pokedemo.repository.PokemonSpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PokemonSpeciesRepository pokemonSpeciesRepository;

    public PokemonService(
            @Autowired PokemonRepository pokemonRepository,
            @Autowired PokemonSpeciesRepository pokemonSpeciesRepository) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonSpeciesRepository = pokemonSpeciesRepository;
    }

    public Pokemon getPokemon(String name) {
        return this.pokemonRepository.getByName(name);
    }

    public List<Pokemon> getByPage(Page page) {
        return this.pokemonRepository.getByPage(page);
    }

    @Nullable
    public Pokemon getPreEvolution(String pokemonName) {
        PokemonSpecies species = this.pokemonSpeciesRepository.getByName(pokemonName);
        PokemonSpecies evolvesFromSpecies = species.getEvolvesFromSpecies();
        if(evolvesFromSpecies == null) {
            return null;
        }
        return this.pokemonRepository.getByName(evolvesFromSpecies.getName());
    }

    public List<Pokemon> getPostEvolutions(String pokemonName) {
        PokemonSpecies species = this.pokemonSpeciesRepository.getByName(pokemonName);
        EvolutionChain evolutionChain = species.getEvolutionChain();
        List<EvolutionChain.SpeciesName> postEvolutionSpecies = evolutionChain.getPostEvolutions(species);
        List<Pokemon> postEvolutions = new ArrayList<>();
        postEvolutionSpecies.forEach(pokemonSpecies -> {
            Pokemon evolution = this.pokemonRepository.getByName(pokemonSpecies.getName());
            postEvolutions.add(evolution);
        });
        return postEvolutions;
    }
}
