package com.example.pokedemo.service;

import com.example.pokedemo.model.Ability;
import com.example.pokedemo.model.EvolutionChain;
import com.example.pokedemo.model.Pokemon;
import com.example.pokedemo.model.PokemonSpecies;
import com.example.pokedemo.model.PokemonType;
import com.example.pokedemo.repository.AbilityRepository;
import com.example.pokedemo.repository.EvolutionChainRepository;
import com.example.pokedemo.repository.PokemonRepository;
import com.example.pokedemo.repository.PokemonSpeciesRepository;
import com.example.pokedemo.repository.PokemonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DependencySolver implements ApiResourceVisitor {

    private PokemonRepository pokemonRepository;
    private PokemonTypeRepository typeRepository;
    private PokemonSpeciesRepository pokemonSpeciesRepository;
    private EvolutionChainRepository evolutionChainRepository;
    private AbilityRepository abilityRepository;

    @Override
    public void visit(Pokemon pokemon) {
        Pokemon fetched = this.pokemonRepository.getByName(pokemon.getName());
        pokemon.setId(fetched.getId());
        pokemon.setHeight(fetched.getHeight());
        pokemon.setTypes(fetched.getTypes());
    }

    @Override
    public void visit(PokemonType pokemonType) {
        PokemonType fetched = this.typeRepository.getByName(pokemonType.getName());
        pokemonType.setId(fetched.getId());
    }

    @Override
    public void visit(PokemonSpecies pokemonSpecies) {
        PokemonSpecies fetched = this.pokemonSpeciesRepository.getByName(pokemonSpecies.getName());
        pokemonSpecies.setId(fetched.getId());
        pokemonSpecies.setEvolvesFromSpecies(fetched.getEvolvesFromSpecies());
        pokemonSpecies.setEvolutionChain(fetched.getEvolutionChain());
    }

    @Override
    public void visit(EvolutionChain evolutionChain) {
        EvolutionChain fetched = this.evolutionChainRepository.getByUrl(evolutionChain.getUrl());
        evolutionChain.setId(fetched.getId());
        evolutionChain.setChain(fetched.getChain());
    }

    @Override
    public void visit(Ability ability) {
        Ability fetched = this.abilityRepository.getByName(ability.getName());
        ability.setId(fetched.getId());
    }

    @Autowired
    public void setPokemonRepository(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Autowired
    public void setTypeRepository(PokemonTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Autowired
    public void setPokemonSpeciesRepository(PokemonSpeciesRepository pokemonSpeciesRepository) {
        this.pokemonSpeciesRepository = pokemonSpeciesRepository;
    }

    @Autowired
    public void setEvolutionChainRepository(EvolutionChainRepository evolutionChainRepository) {
        this.evolutionChainRepository = evolutionChainRepository;
    }

    @Autowired
    public void setAbilityRepository(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }
}
