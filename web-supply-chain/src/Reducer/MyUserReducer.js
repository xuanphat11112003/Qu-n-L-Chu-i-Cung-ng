import cookie from "react-cookies";

export const initialState = {
    loading: false,
    error: null,
    user: null
};

export const actionTypes = {
    LOGIN_REQUEST: 'LOGIN_REQUEST',
    LOGIN_SUCCESS: 'LOGIN_SUCCESS',
    LOGIN_FAILURE: 'LOGIN_FAILURE',
    LOGOUT: 'LOGOUT'
};

const MyUserReducer = (user, action) => {
    switch (action.type) {
        case actionTypes.LOGIN_REQUEST:
            return { ...user, loading: true, error: null };
        case actionTypes.LOGIN_SUCCESS:
            return { ...user, loading: false, user: action.payload };
        case actionTypes.LOGIN_FAILURE:
            return { ...user, loading: false, error: action.payload };
        case actionTypes.LOGOUT:
            cookie.remove('access-token');
            cookie.remove('user')
            return { ...user, user: null };
        default:
            return user;
    }

}
export default MyUserReducer;