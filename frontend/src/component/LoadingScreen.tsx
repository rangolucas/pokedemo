import * as React from 'react';
import '../style/LoadingScreen.css'
import piplup from '../assets/piplup.png';

interface IProps {
}

export function LoadingScreen(props : IProps) {
    return(
        <img className="piplup" src={piplup} alt="loading..."/>
    )
}