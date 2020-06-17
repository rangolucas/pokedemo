package com.example.pokedemo.repository;

import com.example.pokedemo.model.Ability;
import org.springframework.stereotype.Repository;

@Repository
public class AbilityRepository extends NamedCachedRepository<Ability> {

    @Override
    public Class<Ability> getBoundEntity() {
        return Ability.class;
    }

    @Override
    public String getCategoryName() {
        return "ability";
    }
}
