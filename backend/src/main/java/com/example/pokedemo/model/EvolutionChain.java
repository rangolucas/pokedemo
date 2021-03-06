package com.example.pokedemo.model;

import com.example.pokedemo.model.resource.ApiResource;
import com.example.pokedemo.service.ApiResourceVisitor;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EvolutionChain extends ApiResource {

    private int id;
    private ChainLink chain;

    public List<SpeciesName> getPostEvolutions(PokemonSpecies species) {
        return this.chain.getPostEvolutions(species);
    }

    @Override
    public List<ApiResource> getDependencies() {
        return Collections.emptyList();
    }

    @Override
    public void accept(ApiResourceVisitor visitor) {
        visitor.visit(this);
    }

    public static class ChainLink implements Serializable {
        private static final long serialVersionUID = 1L;

        private SpeciesName species;
        @JsonProperty("evolves_to")
        private List<ChainLink> evolvesTo;

        public List<SpeciesName> getPostEvolutions(PokemonSpecies species) {
            if(this.species.name.equals(species.getName())) {
                return this.evolvesTo.stream().map(link -> link.species).collect(Collectors.toList());
            }
            List<SpeciesName> postEvolutions = new ArrayList<>();
            this.evolvesTo.forEach(link -> postEvolutions.addAll(link.getPostEvolutions(species)));
            return postEvolutions;
        }

        public SpeciesName getSpecies() {
            return species;
        }

        public void setSpecies(SpeciesName species) {
            this.species = species;
        }

        public void setName(SpeciesName species) {
            this.species = species;
        }

        public List<ChainLink> getEvolvesTo() {
            return evolvesTo;
        }

        public void setEvolvesTo(List<ChainLink> evolvesTo) {
            this.evolvesTo = evolvesTo;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChainLink getChain() {
        return chain;
    }

    public void setChain(ChainLink chain) {
        this.chain = chain;
    }

    /**
     * Created to avoid infinite recursion between PokemonSpecies -> EvolutionChain -> ChainLink
     */
    public static class SpeciesName implements Serializable {
        private static final long serialVersionUID = 1L;

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
