package com.example.pokedemo.repository;

import com.example.pokedemo.model.PokemonType;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonTypeRepository extends NamedApiResourceRepository<PokemonType> {

    @Override
    public Class<PokemonType> getBoundEntity() {
        return PokemonType.class;
    }

    @Override
    public String getCategoryName() {
        return "type";
    }
}
