import {Pokemon} from "../model/Pokemon";
import * as React from "react";
import {EntryBox} from "./EntryBox";
import "../style/PokemonList.css";

interface IProps {
    pokemonList: Pokemon[]
}

export function PokemonList(props: IProps) {

    return (
        <div>
            {props.pokemonList.map(pokemon => (
                <EntryBox pokemon={pokemon} key={pokemon.id}/>
            ))}
        </div>
    )

}