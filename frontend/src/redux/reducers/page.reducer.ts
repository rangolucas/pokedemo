import {ADD_PAGE} from "../actions/page.action";
import {IPage} from "../../model/IPage";

export interface PagesState {
    pages: IPage[]
}

const initialState: PagesState = {
    pages: [],
};

export function PagesReducer(state = initialState, action : any) {
    switch (action.type) {
        case ADD_PAGE:
            return {
                ...state,
                pages: state.pages.concat(action.page)
            };

        default:
            return state;
    }
}