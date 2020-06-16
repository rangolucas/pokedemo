import * as React from "react";
import {Pokemon} from "../model/Pokemon";
import '../style/EntryBox.css';

interface IProps {
    pokemon: Pokemon
    onClick: Function
}

export function EntryBox(props: IProps) {
    const pokemon: Pokemon = props.pokemon
    return(
        <div onClick={() => props.onClick(pokemon)} className="box">
            <div className="id">{pokemon.id}</div>
            <img className="sprite" src={"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"}/>
            <div className="name">{pokemon.name}</div>
            <div className="weight">{pokemon.weight}<span style={{fontSize: 10.5}}> kg</span></div>
            <div className="types">{pokemon.types.map(t => t.name).join(" / ")}</div>
        </div>
    )
}