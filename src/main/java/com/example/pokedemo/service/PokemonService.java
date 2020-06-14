package com.example.pokedemo.service;

import com.example.pokedemo.model.Page;
import com.example.pokedemo.model.Pokemon;
import com.example.pokedemo.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(@Autowired PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon getPokemon(String name) {
        return this.pokemonRepository.getByName(name);
    }

    public List<Pokemon> getByPage(Page page) {
        return this.pokemonRepository.getByPage(page);
    }
}
