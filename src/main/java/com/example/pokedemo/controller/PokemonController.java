package com.example.pokedemo.controller;

import com.example.pokedemo.dto.DtoMapper;
import com.example.pokedemo.dto.PokemonDto;
import com.example.pokedemo.exception.PokedexException;
import com.example.pokedemo.model.Page;
import com.example.pokedemo.model.Pokemon;
import com.example.pokedemo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/pre-evolution/{name}")
    public PokemonDto getPreEvolution(@PathVariable("name") String pokemonName) {
        Pokemon preEvolution = this.pokemonService.getPreEvolution(pokemonName);
        return this.dtoMapper.mapToDto(preEvolution);
    }

    @GetMapping("/post-evolutions/{name}")
    public List<PokemonDto> getPostEvolutions(@PathVariable("name") String pokemonName) {
        List<Pokemon> postEvolutions = this.pokemonService.getPostEvolutions(pokemonName);
        return postEvolutions.stream().map(this.dtoMapper::mapToDto).collect(Collectors.toList());
    }

    @GetMapping
    public List<PokemonDto> getPage(@RequestParam int page) throws PokedexException {
        List<Pokemon> pokemonList = this.pokemonService.getByPage(new Page(page));
        return pokemonList.stream().map(this.dtoMapper::mapToDto).collect(Collectors.toList());
    }
}
