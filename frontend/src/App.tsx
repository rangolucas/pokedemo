import * as React from 'react';
import './style/App.css';
import {Page} from "./component/Page";

function App() {
    const[pageNumber, setPageNumber] = React.useState<number>(1);

    return (
        <>
            <div style={{backgroundColor: "red", height: 130}}>
                <div className="header"/>
            </div>
            <div className="App">
                <Page pageNumber={1}/>
            </div>
        </>
    );
}

export default App;
