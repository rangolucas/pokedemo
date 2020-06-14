package com.example.pokedemo.repository;

import com.example.pokedemo.client.PokeApiClient;
import com.example.pokedemo.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonRepository extends CachedRepository<Pokemon> {

    public PokemonRepository(@Autowired PokeApiClient<Pokemon> client) {
        super(client);
    }

    @Override
    public Class<Pokemon> getBoundEntity() {
        return Pokemon.class;
    }

    @Override
    public String getResourceName() {
        return "pokemon";
    }
}