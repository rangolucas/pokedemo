import { createStore } from 'redux'
import {PagesReducer} from "./reducers/page.reducer";

export const store = createStore(PagesReducer)