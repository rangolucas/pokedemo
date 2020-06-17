package com.example.pokedemo.repository;

import com.example.pokedemo.model.PokemonSpecies;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonSpeciesRepository extends NamedApiResourceRepository<PokemonSpecies> {

    @Override
    public Class<PokemonSpecies> getBoundEntity() {
        return PokemonSpecies.class;
    }

    @Override
    public String getCategoryName() {
        return "pokemon-species";
    }
}
