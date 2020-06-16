import {PokemonType} from "./PokemonType";

export interface Pokemon {
    id: number
    name: string
    weight: number
    height: number
    sprite: string
    types: PokemonType[]
}