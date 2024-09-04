// src/components/Sidebar.js
import React, { useEffect, useState } from "react";
import { Nav } from "react-bootstrap";

  function Sidebar() {
    const [isSticky, setIsSticky] = useState(false);

    const handleScroll = () => {

      if (window.scrollY > 0) {
        setIsSticky(true);
      } else {
        setIsSticky(false);
      }
    };

    useEffect(() => {

      window.addEventListener("scroll", handleScroll);
      return () => {

        window.removeEventListener("scroll", handleScroll);}
    }, []);

  return (
    <div className={`sidebar ${isSticky ? 'sticky' : ''}`}>
      <Nav className="flex-column">
        <Nav.Link className="nav-link custom-nav-link" href="/orderimport">Mua Hàng</Nav.Link>
        <Nav.Link className="nav-link custom-nav-link" href="/orderimport/add">Tạo Đơn Hàng</Nav.Link>
        <Nav.Link className="nav-link custom-nav-link" href="#manage-products">Quản Lý Sản Phẩm</Nav.Link>
        <Nav.Link className="nav-link custom-nav-link" href="/material">Xem Vật Liệu</Nav.Link>
        <Nav.Link className="nav-link custom-nav-link" href="#suppliers">Nhà Cung Cấp</Nav.Link>
        <Nav.Link className="nav-link custom-nav-link" href="#inventory-management">Quản Lý Tồn Kho</Nav.Link>
        <Nav.Link className="nav-link custom-nav-link" href="#shipping">Vận Chuyển</Nav.Link>
      </Nav>
    </div>
  );
}

export default Sidebar;
