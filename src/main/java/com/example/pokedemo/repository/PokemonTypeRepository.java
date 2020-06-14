package com.example.pokedemo.repository;

import com.example.pokedemo.client.PokeApiClient;
import com.example.pokedemo.model.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;

public class PokemonTypeRepository extends CachedRepository<PokemonType> {

    public PokemonTypeRepository(@Autowired PokeApiClient<PokemonType> client) {
        super(client);
    }

    @Override
    public Class<PokemonType> getBoundEntity() {
        return PokemonType.class;
    }

    @Override
    public String getResourceName() {
        return "type";
    }
}
