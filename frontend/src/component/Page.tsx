import * as React from "react";
import {PokemonList} from "./PokemonList";
import "../style/Page.css";
import {Pokemon} from "../model/Pokemon";
import Modal from "react-bootstrap/Modal";
import {LoadingScreen} from "./LoadingScreen";
import {config} from "../config/config"
import {InfoBox} from "./InfoBox";
import ReactPaginate from "react-paginate";

export function Page() {
    const [pokemonList, setPokemonList] = React.useState<Pokemon[]>([]);
    const [selectedPokemon, setSelectedPokemon] = React.useState<Pokemon | null>(null);
    const [pageNumber, setPageNumber] = React.useState<number>(0);
    const [loading, setLoading] = React.useState<boolean>(true);

    function handlePageChanged(data : any) {
        setLoading(true)
        setPageNumber(data.selected)
    }

    React.useEffect(() => {
        let url: string = config.apiUrl + config.pokemonPath + "?page=" + (pageNumber+1)
        console.log(url)
        fetch(url).then(response => response.json()).then(data => {
            setPokemonList(data)
            setLoading(false)
        })
    }, [pageNumber])

    return loading ? <LoadingScreen/> : (
        <>
            <ReactPaginate
                breakClassName={'page-item'}
                breakLinkClassName={'page-link'}
                containerClassName={'pagination'}
                pageClassName={'page-item'}
                pageLinkClassName={'page-link'}
                previousClassName={'page-item'}
                previousLinkClassName={'page-link'}
                nextClassName={'page-item'}
                nextLinkClassName={'page-link'}
                activeClassName={'active'}
                forcePage={pageNumber}
                pageCount={48}
                marginPagesDisplayed={2}
                pageRangeDisplayed={5}
                onPageChange={handlePageChanged}
            />
            <Modal onHide={() => setSelectedPokemon(null)} show={selectedPokemon != null} dialogClassName="modal-width">
                <Modal.Body>
                    <InfoBox pokemon={selectedPokemon} onItemClick={(pokemon : Pokemon) => setSelectedPokemon(pokemon)}/>
                </Modal.Body>
                <Modal.Footer>
                    <div style={{marginRight: "auto"}}className="info">Click on a pokemon to see its info.</div>
                </Modal.Footer>
            </Modal>
            <PokemonList onItemClick={(item : Pokemon) => setSelectedPokemon(item)} pokemonList={pokemonList}/>
        </>
    )
}