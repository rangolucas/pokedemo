import * as React from "react";
import {PokemonList} from "./PokemonList";
import {Pokemon} from "../model/Pokemon";

interface IProps {
    pageNumber: number
}

export function Page(props: IProps) {
    const [pokemonList, setPokemonList] = React.useState<Pokemon[]>([]);

    // React.useEffect(() => {
    //     let url: string = "http://localhost:8080/pokemon/?page=" + props.pageNumber
    //     fetch(url).then(response => response.json()).then(data => setPokemonList(data))
    // }, [props.pageNumber])

    let pikachu : Pokemon = {
        name: "Pikachu", weight: 5, height: 5, id: 1, types: [{name: "electric", id: 1}]
    }
    let gyarados : Pokemon = {
        name: "Gyarados", weight: 5, height: 5, id: 1, types: [{name: "water", id: 3}]
    }

    let mock : Pokemon[] = [pikachu, gyarados]

    return (
        <PokemonList pokemonList={mock}/>
    )
}