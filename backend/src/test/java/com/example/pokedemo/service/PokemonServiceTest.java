package com.example.pokedemo.service;

import com.example.pokedemo.exception.PokedexException;
import com.example.pokedemo.exception.ResourceNotFoundException;
import com.example.pokedemo.model.EvolutionChain;
import com.example.pokedemo.model.Page;
import com.example.pokedemo.model.Pokemon;
import com.example.pokedemo.model.PokemonSpecies;
import com.example.pokedemo.repository.PokemonRepository;
import com.example.pokedemo.repository.PokemonSpeciesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.AdditionalMatchers;
import org.mockito.ArgumentMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokemonServiceTest {
    private final PokemonRepository pokemonRepository;
    private final PokemonSpeciesRepository pokemonSpeciesRepository;
    private final Pokemon pichu;
    private final Pokemon pikachu;
    private PokemonService service;

    public PokemonServiceTest() {
        this.pichu = new Pokemon();
        this.pichu.setName("pichu");
        this.pichu.setId(10);

        this.pikachu = new Pokemon();
        this.pikachu.setName("pikachu");

        this.pokemonRepository = mock(PokemonRepository.class);
        this.pokemonSpeciesRepository = mock(PokemonSpeciesRepository.class);
        this.populateRepositories();
    }

    @BeforeEach
    void setUp() {
        this.service = new PokemonService(this.pokemonRepository, this.pokemonSpeciesRepository);
    }

    @Test
    void testGetPokemonName() {
        String expectedName = "pichu";
        Pokemon pikachu = this.service.getPokemon(expectedName);
        Assertions.assertEquals(expectedName, pikachu.getName());
    }

    @Test
    void testGetPokemonWrongName() {
        Assertions.assertThrows(PokedexException.class, () -> this.service.getPokemon("digimon"));
    }

    @Test
    void testGetPokemonId() {
        int expectedId = 10;
        Pokemon pikachu = this.service.getPokemon("pichu");
        Assertions.assertEquals(expectedId, pikachu.getId());
    }

    @Test
    void testNoPreevolution() {
        Pokemon preEvolution = this.service.getPreEvolution("pichu");
        Assertions.assertNull(preEvolution);
    }

    @Test
    void testPostEvolutions() {
        List<Pokemon> postEvolutions = this.service.getPostEvolutions("pichu");
        Assertions.assertEquals(1, postEvolutions.size());
        Assertions.assertEquals("pikachu", postEvolutions.get(0).getName());
    }

    @Test
    void testGetByPage() {
        List<Pokemon> retrieved = this.service.getByPage(new Page(1, 20));
        List<Pokemon> expected = new ArrayList<>();
        expected.add(this.pichu);
        expected.add(this.pikachu);

        Assertions.assertEquals(expected, retrieved);
    }

    private void populateRepositories() {
        PokemonSpecies pichuSpecies = new PokemonSpecies();
        pichuSpecies.setName(this.pichu.getName());
        PokemonSpecies pikachuSpecies = new PokemonSpecies();
        pikachuSpecies.setName(this.pikachu.getName());
        pikachuSpecies.setEvolvesFromSpecies(pichuSpecies);

        EvolutionChain.ChainLink pikachuLink = new EvolutionChain.ChainLink();
        EvolutionChain.SpeciesName pikachuSpeciesName = new EvolutionChain.SpeciesName();
        pikachuSpeciesName.setName(pikachuSpecies.getName());
        pikachuLink.setSpecies(pikachuSpeciesName);

        List<EvolutionChain.ChainLink> pichuEvolutionLinks = new ArrayList<>();
        pichuEvolutionLinks.add(pikachuLink);
        EvolutionChain.ChainLink pichuLink = new EvolutionChain.ChainLink();
        EvolutionChain.SpeciesName pichuSpeciesName = new EvolutionChain.SpeciesName();
        pichuSpeciesName.setName(pichuSpecies.getName());
        pichuLink.setSpecies(pichuSpeciesName);
        pichuLink.setEvolvesTo(pichuEvolutionLinks);

        EvolutionChain evolutionChain = new EvolutionChain();
        evolutionChain.setChain(pichuLink);

        pichuSpecies.setEvolvesFromSpecies(null);
        pichuSpecies.setEvolutionChain(evolutionChain);

        List<Pokemon> pokemonByPage = new ArrayList<>();
        pokemonByPage.add(this.pichu);
        pokemonByPage.add(this.pikachu);

        Page page = new Page(1, 20);
        when(this.pokemonRepository.getByName("pichu")).thenReturn(this.pichu);
        when(this.pokemonRepository.getByName("pikachu")).thenReturn(this.pikachu);
        when(this.pokemonRepository.getByPage(page)).thenReturn(pokemonByPage);
        when(this.pokemonRepository.getByName(
                AdditionalMatchers.not(
                        AdditionalMatchers.or(
                                ArgumentMatchers.same("pikachu"),
                                ArgumentMatchers.same("pichu")))))
                .thenThrow(ResourceNotFoundException.class);
        when(this.pokemonSpeciesRepository.getByName("pichu")).thenReturn(pichuSpecies);
    }
}
