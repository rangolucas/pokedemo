import * as React from "react";
import {PokemonList} from "./PokemonList";
import {Card} from "./Card";
import {Pokemon} from "../model/Pokemon";
import Modal from "react-bootstrap/Modal";
import Button from "react-bootstrap/Button";

interface IProps {
    pageNumber: number
}

export function Page(props: IProps) {
    const [pokemonList, setPokemonList] = React.useState<Pokemon[]>([]);
    const [selectedPokemon, setSelectedPokemon] = React.useState<Pokemon | null>(null);

    // React.useEffect(() => {
    //     let url: string = "http://localhost:8080/pokemon/?page=" + props.pageNumber
    //     fetch(url).then(response => response.json()).then(data => setPokemonList(data))
    // }, [props.pageNumber])

    function showModal(pokemon : Pokemon) {
        setSelectedPokemon(pokemon)
    }

    let pikachu : Pokemon = {
        name: "Pikachu", weight: 5, height: 5, id: 1, types: [{name: "electric", id: 1}]
    }
    let gyarados : Pokemon = {
        name: "Gyarados", weight: 5, height: 5, id: 300, types: [{name: "water", id: 300}]
    }

    let mock : Pokemon[] = [pikachu, gyarados]

    return (
        <>
            <Modal show={selectedPokemon}>
                <Modal.Body>
                    <Card pokemon={selectedPokemon}/>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={() => setSelectedPokemon(null)}>
                        Close
                    </Button>
                </Modal.Footer>
            </Modal>
            <PokemonList onItemClick={(item:Pokemon) => showModal(item)} pokemonList={mock}/>
        </>
    )
}