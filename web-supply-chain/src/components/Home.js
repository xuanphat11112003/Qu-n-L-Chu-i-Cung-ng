// src/components/Home.js
import React from "react";
import { Container, Row, Col, Card, Button } from "react-bootstrap";
import { Link } from "react-router-dom";

function Home() {
  return (
    <Container className="mt-4">
      <h2 className="text-center mb-4">Chọn Chức Năng Quản Lý</h2>
      <Row className="justify-content-center">
        <Col md={4} className="mb-4">
          <Card className="text-center shadow-sm">
            <Card.Body>
              <Card.Title>Mua Hàng</Card.Title>
              <Card.Text>
                Chọn sản phẩm và thực hiện quá trình mua hàng.
              </Card.Text>
              <Button variant="primary" as={Link} to="/material">
                Xem Thêm
              </Button>
            </Card.Body>
          </Card>
        </Col>
        <Col md={4} className="mb-4">
          <Card className="text-center shadow-sm">
            <Card.Body>
              <Card.Title>Tạo Đơn Hàng</Card.Title>
              <Card.Text>
                Tạo đơn hàng mới cho khách hàng.
              </Card.Text>
              <Button variant="primary" href="#create-order">
                Xem Thêm
              </Button>
            </Card.Body>
          </Card>
        </Col>
        <Col md={4} className="mb-4">
          <Card className="text-center shadow-sm">
            <Card.Body>
              <Card.Title>Quản Lý Sản Phẩm</Card.Title>
              <Card.Text>
                Xem và quản lý các sản phẩm hiện có.
              </Card.Text>
              <Button variant="primary" href="#manage-products">
                Xem Thêm
              </Button>
            </Card.Body>
          </Card>
        </Col>
        <Col md={4} className="mb-4">
          <Card className="text-center shadow-sm">
            <Card.Body>
              <Card.Title>Quản Lý Vật Liệu</Card.Title>
              <Card.Text>
                Quản lý các vật liệu sử dụng trong sản xuất.
              </Card.Text>
              <Button variant="primary" href="#manage-materials">
                Xem Thêm
              </Button>
            </Card.Body>
          </Card>
        </Col>
        <Col md={4} className="mb-4">
          <Card className="text-center shadow-sm">
            <Card.Body>
              <Card.Title>Nhà Cung Cấp</Card.Title>
              <Card.Text>
                Quản lý thông tin các nhà cung cấp.
              </Card.Text>
              <Button variant="primary" href="/supplier">
                Xem Thêm
              </Button>
            </Card.Body>
          </Card>
        </Col>
        <Col md={4} className="mb-4">
          <Card className="text-center shadow-sm">
            <Card.Body>
              <Card.Title>Quản Lý Tồn Kho</Card.Title>
              <Card.Text>
                Kiểm tra và quản lý hàng tồn kho.
              </Card.Text>
              <Button variant="primary" href="#inventory-management">
                Xem Thêm
              </Button>
            </Card.Body>
          </Card>
        </Col>
        <Col md={4} className="mb-4">
          <Card className="text-center shadow-sm">
            <Card.Body>
              <Card.Title>Vận Chuyển</Card.Title>
              <Card.Text>
                Quản lý và theo dõi thông tin vận chuyển.
              </Card.Text>
              <Button variant="primary" href="#shipping">
                Xem Thêm
              </Button>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
}

export default Home;
