import {Pokemon} from "../model/Pokemon";
import * as React from "react";
import '../style/InfoBox.css'
import {config} from "../config/config";
import Loader from "react-loader-spinner";

interface IProps {
    pokemon: Pokemon | null
}

export function Card(props: IProps) {

    const [loading, setLoading] = React.useState<boolean>(false);
    const [preEvolution, setPreEvolution] = React.useState<Pokemon | null>(null);
    const [postEvolutions, setPostEvolutions] = React.useState<Pokemon[]>([]);

    React.useEffect(() => {
        if (props.pokemon) {
            setLoading(true)

            let url = config.apiUrl + config.preEvolutionPath + props.pokemon.name;
            fetch(url).then(response => response.json()).then(data => {
                setPreEvolution(data)
                console.log(data)
            })
            url = config.apiUrl + config.postEvolutionsPath + props.pokemon.name
            fetch(url).then(response => response.json()).then(data => setPostEvolutions(data))

            setLoading(false)
        }
    }, [props.pokemon])

    if (loading) return <div className="wrapper"><Loader type="Oval" color="grey" height={100} width={100}/></div>;

    return (
        <div className="wrapper">
            <div>

            </div>
        </div>
    )
}