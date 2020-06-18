import * as React from 'react';
import '../style/LoadingScreen.css'
import piplup from '../assets/piplup.png';
import sadPoke from '../assets/sad.png';
import "react-loader-spinner/dist/loader/css/react-spinner-loader.css"
import Loader from 'react-loader-spinner'

interface IProps {
    error : boolean
}

export function AltScreen(props : IProps) {
    return(
        <div className="loading">
            <div className="container">
                <img className="piplup" src={props.error ? sadPoke : piplup} alt={props.error ? "ERROR" : "loading..."}/>
                <div className="prompt">
                    {props.error ? "Oops.. there has been an error" :
                        <Loader
                            type="ThreeDots"
                            color="grey"
                            height={100}
                            width={100}
                        />
                    }
                </div>
            </div>
        </div>
    )
}