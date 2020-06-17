package com.example.pokedemo.repository;

import com.example.pokedemo.model.EvolutionChain;
import org.springframework.stereotype.Repository;

@Repository
public class EvolutionChainRepository extends ApiResourceRepository<EvolutionChain> {

    @Override
    public Class<EvolutionChain> getBoundEntity() {
        return EvolutionChain.class;
    }

    @Override
    public String getCategoryName() {
        return "evolution-chain";
    }
}
