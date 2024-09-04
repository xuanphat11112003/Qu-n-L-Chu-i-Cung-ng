import { useEffect, useState } from "react";
import APIs, { endpoints } from "../config/APIs";
import { load } from "react-cookies";
import { Container, Row, Col, Card, Spinner, Form, Button } from "react-bootstrap";
import { Link, useNavigate, useSearchParams } from "react-router-dom";

const OrderMaterial = () => {
    const [materials, setMaterials] = useState(null);
    const [loading, setLoading] = useState(true);
    const [q] = useSearchParams();
    const [kw, setKw] = useState("");
    const [page, setpage] = useState(1);
    const nav = useNavigate();
    const [hasmore, sethasmore] = useState(true);

    const submit = (e) => {
        e.preventDefault();
        nav(`/material/?kw=${kw}`)
    }

    const LoadMaterial = async () => {
        try {
            let url = `${endpoints['material']}?page=${page}`;
            let k = q.get('kw');

            if (k !== null) {
                setpage(1);
                url = `${url}&q=${k}`;
            }
            let res = await APIs.get(url);
            console.log(res.data);
            if (Array.isArray(res.data) && res.data.length === 0){
                console.log("a");
                sethasmore(false);
            }
            if (page === 1)
                setMaterials(res.data);
            else
                if (hasmore === true)
                    setMaterials(current => [...current, ...res.data]);


        }
        catch (ex) {
            console.error(ex);

        } finally {
            setLoading(false);
        }
    }

    const handleScroll = () => {
        const lastElement = document.querySelector('.last-element-class');
        if (lastElement) {
            const rect = lastElement.getBoundingClientRect();
            
            if (rect.bottom +80 <= window.innerHeight) {
                console.log(rect.bottom);
                console.log(window.innerHeight); // Khoảng cách với cuối cửa sổ trình duyệt
                if (hasmore) {
                    setpage(prevPage => prevPage + 1); // Cập nhật trang số
                }
            }
        }
    };


    useEffect(() => {
        LoadMaterial();
    }, [q,page]);

    useEffect(() => {
        if (hasmore === true)
            window.addEventListener("scroll", handleScroll);
        return () => {
            window.removeEventListener("scroll", handleScroll);
        };
    }, [page, hasmore]);


    if (loading)
        return <Spinner animation="grow" variant="primary" />;

    return (
        <>
            <nav className="nav justify-content-end">
                <ul className="nav nav-tabs">
                    <li class="nav-item" aria-current="page">
                        <Link className="nav-link active" to="#" >Vật Liệu</Link>
                    </li>
                    <li class="nav-item">
                        <Link className="nav-link" to="/orderimport">Đơn Hàng</Link>
                    </li>
                </ul>
            </nav>

            <div>
                <Form inline onSubmit={submit}>
                    <Row>
                        <Col xs="auto">
                            <Form.Control
                                type="text"
                                placeholder="Tìm nguyên vật liệu..."
                                className=" mr-sm-2"
                                value={kw}
                                onChange={e => setKw(e.target.value)}
                            />
                        </Col>
                        <Col xs="auto">
                            <Button type="submit">Tìm</Button>
                        </Col>
                    </Row>
                </Form>
                <Link className='nav-link text-danger ' to="/orderimport/add">
                    <button type="button" class="btn btn-primary">
                        Tạo đơn hàng
                    </button>

                </Link>
            </div>
            <Container className="mt-4">
                <h2 className="text-center mb-4">Danh Sách Vật Liệu</h2>
                <table className="custom-table" striped>
                    <thead >
                        <tr>
                            <th>ID</th>
                            <th>Tên</th>
                            <th>Giá</th>
                            <th>Nhà Cung Cấp</th>
                        </tr>
                    </thead>
                    <tbody>
                        {materials.map((material,index) => (
                            <tr key={material.id} className={index === materials.length - 1 ? 'last-element-class' : ''}>
                                <td>{material.id}</td>
                                <td>{material.name}</td>
                                <td>{material.price} VNĐ</td>
                                <td>{material.supplierName}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </Container>
            {hasmore && page > 1 &&( // Hiển thị loading khi đang tải thêm dữ liệu
                <div className="text-center">
                    <Spinner animation="border" role="status">
                        <span className="visually-hidden">Loading...</span>
                    </Spinner>
                </div>
            )}
        </>
    );
}
export default OrderMaterial;