package com.example.pokedemo.service;

import com.example.pokedemo.model.Pokemon;
import com.example.pokedemo.model.PokemonType;

public interface ApiResourceVisitor {
    void visit(Pokemon pokemon);
    void visit(PokemonType pokemonType);
}
