import React, { useContext, useEffect, useState } from 'react';
import { Navigate, useNavigate } from 'react-router-dom';
import { Form, Button, Spinner, Alert } from 'react-bootstrap';
import APIs, { authAPIs, endpoints } from '../config/APIs';
import { MyUserContext } from '../App';
import cookie from "react-cookies";
import { actionTypes } from '../Reducer/MyUserReducer';

const Login = () => {
    const [user,dispatch] = useContext(MyUserContext);
    const [userName, setUserName] = useState("");
    const[password,setPassword]=useState("");
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        dispatch({ type: actionTypes.LOGIN_REQUEST });

        try {
            const res = await APIs.post(endpoints['login'], {
                "username": userName, 
                "password": password 
            });
            cookie.save("access-token", res.data)

            let user = await authAPIs().get(endpoints['current-user']);
            cookie.save("user",user.data)
            dispatch({ type: actionTypes.LOGIN_SUCCESS, payload: user.data });
             // Redirect to dashboard on successful login
        } catch (error) {
            dispatch({ type: actionTypes.LOGIN_FAILURE, payload: error.message });
        }
    };

    useEffect(() => {
        if (user && user.user !== null) {
            navigate("/");
        }
    }, [user]);

    return(
        <div className="d-flex justify-content-center align-items-center" style={{ height: '100vh' }}>
            <Form onSubmit={handleSubmit} className="p-4 border rounded" style={{ width: '400px', backgroundColor: '#fff' }}>
                <h3 className="text-center mb-4">Đăng Nhập</h3>
                {user.loading && <Spinner animation="border" variant="primary" className="d-block mx-auto mb-3" />}
                
                {user.error && <Alert variant="danger" className="text-center">{user.error}</Alert>}
                
                <Form.Group controlId="formUserName" className="mb-3">
                    <Form.Label>Tên đăng nhập</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Nhập tên đăng nhập"
                        value={userName}
                        onChange={(e) => setUserName(e.target.value)}
                        required
                    />
                </Form.Group>

                <Form.Group controlId="formPassword" className="mb-3">
                    <Form.Label>Mật khẩu</Form.Label>
                    <Form.Control
                        type="password"
                        placeholder="Nhập mật khẩu"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </Form.Group>

                <Button variant="primary" type="submit" className="w-100" disabled={user.loading}>
                    Đăng Nhập
                </Button>
            </Form>
        </div>
    );
}
export default Login