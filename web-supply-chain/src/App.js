// import logo from './logo.svg';
import './App.css';

import Home from './components/Home';
import Footer from './layouts/Footer';
import Header from './layouts/Header';
import Sidebar from './layouts/Sidebar';
import OrderMaterial from './components/OrderMaterial';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { createContext, useEffect, useReducer } from 'react';
import MyUserReducer, { actionTypes, initialState } from './Reducer/MyUserReducer';
import Login from './components/Login';
import cookie from 'react-cookies';
import OrderImport from './components/CreateOrderImport';
import OrderBill from './components/OrderBill';
import EvaluateSupplier from './components/EvaluateSuppiler';
import IndexSupplier from './components/IndexSupplier';
export const MyUserContext = createContext();

function App() {
  const [user, dispatch] = useReducer(MyUserReducer, initialState);
  useEffect (()=>{
    const setuser = cookie.load('user');
    if(setuser){
      dispatch({
        type : actionTypes.LOGIN_SUCCESS,
        payload: setuser
      })
    }
  },[]);

  return (
    <MyUserContext.Provider value={[user, dispatch]}>
      <BrowserRouter>
        <div>
          <div>
            <Header />
            <div className="main-container">
              <Sidebar />
              <div className="content">
                <Routes>
                  <Route path='/' element={<Home />} />
                  <Route path='/material' element={<OrderMaterial />} />
                  <Route path='/login' element={<Login />} />
                  <Route path ='/orderimport/add' element={<OrderImport/>}/>
                  <Route path ='/orderimport' element={<OrderBill/>}/>
                  <Route path = '/evluateSupplier' element={<EvaluateSupplier/>}/>
                  <Route path = '/Supplier' element={<IndexSupplier/>}/>
                </Routes>
              </div>
            </div>
            <Footer />
          </div>
        </div>
      </BrowserRouter>
    </MyUserContext.Provider>
  );
}

export default App;
