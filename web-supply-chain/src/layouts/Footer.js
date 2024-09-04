// src/layout/Footer.js
import React from "react";
import { Container } from "react-bootstrap";

function Footer() {
  return (
    <footer className="bg-dark text-white mt-auto py-3 shadow-sm">
      <Container className="text-center">
        <p>© 2024 Supply Chain Management System. All rights reserved.</p>
      </Container>
    </footer>
  );
}

export default Footer;
