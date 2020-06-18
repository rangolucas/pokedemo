import * as React from 'react';
import '../style/LoadingScreen.css'
import piplup from '../assets/piplup.png';
import "react-loader-spinner/dist/loader/css/react-spinner-loader.css"
import Loader from 'react-loader-spinner'

interface IProps {
}

export function LoadingScreen(props : IProps) {
    return(
        <div className="loading">
            <div className="container">
                <img className="piplup" src={piplup} alt="loading..."/>
                <div className="prompt">
                    <Loader
                        type="ThreeDots"
                        color="grey"
                        height={100}
                        width={100}
                    />
                </div>
            </div>
        </div>
    )
}