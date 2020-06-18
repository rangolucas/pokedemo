import * as React from "react";
import {Pokemon} from "../model/Pokemon";
import '../style/EntryBox.css';
import swordsicon from '../assets/swords.png'
import TypesToBadge from "../util/TypesToBadge";

interface IProps {
    pokemon: Pokemon
    onClick: Function
}

export function EntryBox(props: IProps) {
    const pokemon: Pokemon = props.pokemon
    return(
        <div onClick={() => props.onClick(pokemon)} className="box">
            <div className="id">{pokemon.id}</div>
            <img className="sprite" src={pokemon.sprite} alt=""/>
            <div className="name">{pokemon.name} </div>
            <div className="smalltext">{pokemon.weight}<span style={{fontSize: 10.5}}> kg</span></div>
            <div className="types">{pokemon.types.map(t => TypesToBadge(t))}</div>
            <img className="swords" src={swordsicon} alt=""/>
            <div className="ability-wrapper">
                <div className="abilities">{pokemon.abilities.map(ability => <div key={ability} className="ability">{ability}</div>)}</div>
            </div>
        </div>
    )
}