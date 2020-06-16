package com.example.pokedemo.service;

import com.example.pokedemo.model.EvolutionChain;
import com.example.pokedemo.model.Pokemon;
import com.example.pokedemo.model.PokemonSpecies;
import com.example.pokedemo.model.PokemonType;

public interface ApiResourceVisitor {
    void visit(Pokemon pokemon);
    void visit(PokemonType pokemonType);
    void visit(PokemonSpecies pokemonSpecies);
    void visit(EvolutionChain evolutionChain);
}
