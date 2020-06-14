package com.example.pokedemo.controller;

import com.example.pokedemo.dto.DtoMapper;
import com.example.pokedemo.dto.PokemonDto;
import com.example.pokedemo.model.Pokemon;
import com.example.pokedemo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;
    private final DtoMapper dtoMapper;

    public PokemonController(@Autowired PokemonService pokemonService, @Autowired DtoMapper dtoMapper) {
        this.pokemonService = pokemonService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/{name}")
    public PokemonDto getPokemon(@PathVariable("name") String name) {
        Pokemon pokemon = this.pokemonService.getPokemon(name);
        return this.dtoMapper.mapToDto(pokemon);
    }
}
