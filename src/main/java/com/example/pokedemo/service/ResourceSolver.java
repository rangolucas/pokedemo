package com.example.pokedemo.service;

import com.example.pokedemo.model.Pokemon;
import com.example.pokedemo.model.PokemonType;
import com.example.pokedemo.repository.PokemonRepository;
import com.example.pokedemo.repository.PokemonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceSolver implements ApiResourceVisitor {

    private PokemonRepository pokemonRepository;
    private PokemonTypeRepository typeRepository;

    @Override
    public void visit(Pokemon pokemon) {
        Pokemon fetched = this.pokemonRepository.getByName(pokemon.getName());
        pokemon.setId(fetched.getId());
        pokemon.setHeight(fetched.getHeight());
        pokemon.setName(fetched.getName());
        pokemon.setTypes(fetched.getTypes());
    }

    @Override
    public void visit(PokemonType pokemonType) {
        PokemonType fetched = this.typeRepository.getByName(pokemonType.getName());
        pokemonType.setId(fetched.getId());
        pokemonType.setName(fetched.getName());
    }

    @Autowired
    public void setPokemonRepository(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Autowired
    public void setTypeRepository(PokemonTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }
}
