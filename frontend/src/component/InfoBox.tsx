import {Pokemon} from "../model/Pokemon";
import * as React from "react";
import '../style/InfoBox.css'
import {config} from "../config/config";
import Loader from "react-loader-spinner";
import Card from "react-bootstrap/Card";
import ListGroup from "react-bootstrap/ListGroup";
import TypesToBadge from "../util/TypesToBadge";

interface IProps {
    pokemon: Pokemon | null
    onItemClick : Function
}

export function InfoBox(props: IProps) {

    const [preEvolution, setPreEvolution] = React.useState<Pokemon | null>(null);
    const [postEvolutions, setPostEvolutions] = React.useState<Pokemon[] | null>(null);

    React.useEffect(() => {
        if (props.pokemon) {
            let url = config.apiUrl + config.preEvolutionPath + props.pokemon.name;
            fetch(url).then(response => response.json()).then(data => {
                setPreEvolution(data)
            })
            url = config.apiUrl + config.postEvolutionsPath + props.pokemon.name
            fetch(url).then(response => response.json()).then(data => setPostEvolutions(data))
        }
    }, [props.pokemon])

    if (!preEvolution || !postEvolutions) return <div className="wrapper"><Loader type="Oval" color="grey" height={100} width={100}/></div>;

    let onClick = (toDisplay : Pokemon) : any => {
        setPreEvolution(null)
        setPostEvolutions(null)
        props.onItemClick(toDisplay);
    }

    return (
        <div className="wrapper">
            {preEvolution.name && <div className="card">
                <Card.Title>
                    <span className="evo-title">Preevolution</span>
                </Card.Title>
                <div className="clickable card" onClick={() => onClick(preEvolution)}>
                    <img src={preEvolution?.sprite} alt=""/> {normalizeName(preEvolution?.name)}
                </div>
            </div>}
            <div className="card">
                <Card.Img alt="" variant="top" src={props.pokemon?.sprite}/>
                <Card.Title>{normalizeName(props.pokemon?.name)} {props.pokemon?.types.map(t => TypesToBadge(t))}</Card.Title>
                <ListGroup variant="flush">
                    <ListGroup.Item>
                        <div className="abilities">
                            {props.pokemon?.abilities.map((ability) => <div key={ability}>- {ability}</div>)}
                        </div>
                    </ListGroup.Item>
                </ListGroup>
            </div>
            {postEvolutions.length>0 && <div className="card">
                <Card.Title>
                    <span className="evo-title">Postevolutions</span>
                </Card.Title>
                {postEvolutions.map((poke) =>
                <div className="clickable card" key={poke.name} onClick={() => onClick(poke)}>
                    <img alt="" src={poke.sprite}/> {normalizeName(poke.name)}
                </div>)}
            </div>}
        </div>
    )
}

function normalizeName(name : string | undefined) {
    return name ? name.charAt(0).toUpperCase() + name.substr(1) : "";
}