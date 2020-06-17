package com.example.pokedemo.repository;

import com.example.pokedemo.model.Pokemon;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonRepository extends NamedApiResourceRepository<Pokemon> {

    @Override
    public Class<Pokemon> getBoundEntity() {
        return Pokemon.class;
    }

    @Override
    public String getCategoryName() {
        return "pokemon";
    }
}