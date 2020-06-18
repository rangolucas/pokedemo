import {PokemonType} from "../model/PokemonType";
import bug from "../assets/bug.png";
import dark from "../assets/dark.png";
import dragon from "../assets/dragon.png";
import electric from "../assets/electric.png";
import fairy from "../assets/fairy.png";
import fighting from "../assets/fighting.png";
import fire from "../assets/fire.png";
import flying from "../assets/flying.png";
import ghost from "../assets/ghost.png";
import grass from "../assets/grass.png";
import ground from "../assets/ground.png";
import ice from "../assets/ice.png";
import normal from "../assets/normal.png";
import poison from "../assets/poison.png";
import psychic from "../assets/psychic.png";
import rock from "../assets/rock.png";
import shadow from "../assets/shadow.png";
import steel from "../assets/steel.png";
import unknown from "../assets/unknown.png";
import water from "../assets/water.png";
import React from "react";

export default function (type : PokemonType) {
    const map: any = {
        "bug": bug,
        "dark": dark,
        "dragon": dragon,
        "electric": electric,
        "fairy": fairy,
        "fighting": fighting,
        "fire": fire,
        "flying": flying,
        "ghost": ghost,
        "grass": grass,
        "ground": ground,
        "ice": ice,
        "normal": normal,
        "poison": poison,
        "psychic": psychic,
        "rock": rock,
        "shadow": shadow,
        "steel": steel,
        "unknown": unknown,
        "water": water,
    }

    return <div key={type.name} className="badge"><img src={map[type.name]} alt={type.name}/></div>;
}