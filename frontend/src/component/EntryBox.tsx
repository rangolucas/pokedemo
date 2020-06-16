import * as React from "react";
import {Pokemon} from "../model/Pokemon";
import '../style/EntryBox.css';

interface IProps {
    pokemon: Pokemon
}

export function EntryBox(props: IProps) {
    const pokemon: Pokemon = props.pokemon

    return(
        <div className="box">
            <span className="id">{pokemon.id}</span>
            Name: {pokemon.name}<br/>
        </div>
    )
}