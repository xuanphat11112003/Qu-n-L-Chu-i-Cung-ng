export const initialState = {
    active: false,
    items: {
        orderId: 0,
        warehouse: []
    }
};

function conFirmOrder(state, action) {
    switch (action.type) {
        case 'TOGGLE_ACTIVE':
            return { ...state, active: !state.active };
        case 'SET_ORDER_ID':
            return { ...state, items: { ...action.payload } };
        default:
            return state;
    }
}
export default conFirmOrder;