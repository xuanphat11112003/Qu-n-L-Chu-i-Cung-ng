// src/layout/Header.js
import React, { useContext, useState } from "react";
import { Badge, Button, Col, Container, Form, Image, Nav, Navbar, NavDropdown, Row } from 'react-bootstrap';
import { Link, useNavigate } from "react-router-dom";
import { MyUserContext } from "../App";
import { actionTypes } from "../Reducer/MyUserReducer";

function Header() {
  const [kw, setKw] = useState("");
  const nav = useNavigate();
  const [user,dispatch] = useContext(MyUserContext);

  const handleLogout = () =>{
    dispatch({"type": actionTypes.LOGOUT})
    nav("/login")
  }


  return (
    <Navbar bg="primary" variant="dark" expand="lg" className="shadow">
      <Container>
        <Navbar.Brand href="#">Supply Chain Management</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ms-auto">
            <Nav.Link href="#home" className="text-white">Home</Nav.Link>
            <Nav.Link href="#profile" className="text-white">Profile</Nav.Link>
            <Nav.Link href="#settings" className="text-white">Settings</Nav.Link>
            </Nav>
            {user.user === null ? <>
              <Link className='nav-link text-danger ' to="/login">&#0000; Đăng nhập</Link>

            </> : <>
              <Link className='nav-link text-success' to="/login">
                <Image src={user.avatar} width="25" roundedCircle />
                Chào {user.user.username}!</Link>
              <Button variant='danger' onClick={handleLogout}>Đăng xuất</Button>
            </>}
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Header;
