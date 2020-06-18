import * as React from 'react';
import './style/App.css';
import {Page} from "./component/Page";

function App() {

    return (
        <>
            <div className="header"/>

            <div className="bg">
                <Page/>
            </div>
        </>
    );
}

export default App;
