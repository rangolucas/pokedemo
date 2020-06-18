import {IPage} from "../../model/IPage";

export const ADD_PAGE = "SET_PAGE";

export const addPage = (page : IPage) => {
    return {
        type: ADD_PAGE,
        page: page,
    }
}