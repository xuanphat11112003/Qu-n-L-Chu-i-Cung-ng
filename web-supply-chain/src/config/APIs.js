import axios from "axios"
import cookie from "react-cookies"

const BASE_URL = 'http://localhost:8080/SupplyChainManagement/api/'

export const endpoints = {
    'material': '/material',
    'login': '/login',
    'current-user':'/current-user',
    'supplier':'/supplier',
    'order' : '/orders',
    'warehouse':'/warehouse'
}


export const authAPIs = () => {
    return axios.create({
        baseURL: BASE_URL,
        headers: {
            'Authorization': cookie.load("access-token")
        }
    })
}

export default axios.create({
    baseURL: BASE_URL
});