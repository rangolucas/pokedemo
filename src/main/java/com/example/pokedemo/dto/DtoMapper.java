package com.example.pokedemo.dto;

import com.example.pokedemo.model.Pokemon;
import com.example.pokedemo.model.PokemonType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoMapper {

    private final ModelMapper modelMapper;

    public DtoMapper(@Autowired ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PokemonDto mapToDto(Pokemon pokemon) {
        PokemonDto dto = this.modelMapper.map(pokemon, PokemonDto.class);
        List<Pokemon.TypeDetail> types = pokemon.getTypes();
        List<PokemonTypeDto> typeDtos = new ArrayList<>();
        types.forEach(typeDetail -> {
            PokemonType type = typeDetail.getType();
            PokemonTypeDto typeDto = this.mapToDto(type);
            typeDtos.add(typeDto);
        });
        dto.setTypes(typeDtos);
        return dto;
    }

    public PokemonTypeDto mapToDto(PokemonType type) {
        return this.modelMapper.map(type, PokemonTypeDto.class);
    }
}
