import { useEffect, useReducer, useState } from "react";
import { Link, useNavigate, useSearchParams } from "react-router-dom";
import APIs, { authAPIs, endpoints } from "../config/APIs";
import { Alert, Button, Col, Form, Modal, Row, Spinner } from "react-bootstrap";
import conFirmOrder, { initialState } from "../Reducer/confirmOrderReducer";


const OrderBill = () => {
    const [bill, setbill] = useState([]);
    const [loading, setLoading] = useState(true);
    const [activeIndex, setActiveIndex] = useState(0);
    const [q] = useSearchParams();
    const [kw, setkw] = useState("");
    const [selectDate, setDate] = useState(null);
    const nav = useNavigate();
    const [state, dispatch] = useReducer(conFirmOrder, initialState);
    const [warehouseName, setWarehouseName] = useState(null);
    const [dateInto, setDateInto] = useState(null);
    const [error, setError] = useState(null);


    const handleSubmit = (e) => {
        e.preventDefault();
        let url = `/orderimport`;
        if (kw != null)
            url = `${url}?q=${kw}`;
        nav(`${url}`)
    }

    const loadBill = async () => {

        try {
            let url = `${endpoints['order']}`;
            switch (activeIndex) {
                case 1:
                    url = `${url}?confirmationFilter=unconfirmed`;
                    break;
                case 2:
                    url = `${url}?confirmationFilter=confirmed`;
                    break;
                case 3:
                    url = `${url}?evaluate=confirmed`;
                    break;
            }
            if (kw != "") {
                url = `${url}&q=${kw}`;
            }
            if (selectDate != null)
                if (activeIndex != 0)
                    url = `${url}&dateFilter=${selectDate}`;
                else
                    url = `${url}?dateFilter=${selectDate}`;
            console.log(url);
            console.log(selectDate);

            let res = await authAPIs().get(url);
            console.log(res.data);
            const billsArray = Object.entries(res.data).map(([key, value]) => ({
                key,
                items: Array.isArray(value) ? value : []
            }));
            console.log(billsArray)

            setbill(billsArray);
        } catch (ex) {
            console.info(ex);
        } finally {
            setLoading(false); // Đặt loading thành false khi dữ liệu đã được tải xong
        }
    };
    useEffect(() => {
        loadBill();
    }, [activeIndex, q, selectDate]);

    const handleClick = (index) => {
        setActiveIndex(index);
    };

    const openModal = async (orderId) => {
        let url = `${endpoints['warehouse']}`;
        try {

            let res = await authAPIs().get(url);

            console.log(res.data);
            dispatch({ type: 'SET_ORDER_ID', payload: { orderId, warehouse: res.data } });

        } catch (error) {
            console.info(error);
        } finally {
            dispatch({ type: 'TOGGLE_ACTIVE' });
        }

    };

    const closeModal = () => {
        dispatch({ type: 'TOGGLE_ACTIVE' });
    };

    const handleWarehouseSubmit = async (e) => {
        e.preventDefault();
        const formatDate = (dateStr) => {
            const [year, month, day] = dateStr.split("-"); // Tách chuỗi bằng dấu "-"
            return `${day}/${month}/${year}`; // Đổi định dạng thành dd/MM/yyyy
        };
        let url = `/updateStatus`
        if (dateInto != null && warehouseName != '') {
            const date = formatDate(dateInto);
            let json =  {
                orderid: state.items.orderId,
                warehouse: warehouseName,
                entryDate: date,
            }
            try {
                let res = await authAPIs().post(url, json);
                if (res.status === 201 || res.status === 200) {
                    dispatch({ type: 'TOGGLE_ACTIVE' });
                }
            } catch (error) {
                setError(error);
            } finally {
                window.location.reload();
            }


        }
        else {
            setError("Lỗi!: Chưa điền đủ thông tin")
        }

    }

    return (
        <>
            <div>
                <nav className="nav justify-content-end">
                    <ul className="nav nav-tabs">
                        <li class="nav-item" >
                            <Link className="nav-link" to="/material" >Vật Liệu</Link>
                        </li>
                        <li class="nav-item" aria-current="page">
                            <Link className="nav-link active" to="#">Đơn Hàng</Link>
                        </li>
                    </ul>
                </nav>

            </div>
            <div className="d-flex align-items-center">
                <Form onSubmit={handleSubmit} className="d-flex me-3">
                    <Row className="flex-nowrap">
                        <Col xs="auto">
                            <Form.Control
                                type="text"
                                placeholder="Tìm mã đơn hàng..."
                                className="mr-sm-2"
                                value={kw}
                                onChange={e => setkw(e.target.value)}
                            />
                        </Col>
                        <Col xs="auto">
                            <Button type="submit">Tìm</Button>
                        </Col>
                    </Row>
                </Form>
                <select id="dateSelect" className="btn btn-secondary dropdown-toggle" onChange={e => setDate(e.target.value)}>
                    <option value="">--FillterDate--</option>
                    <option value="latest">Ngày mới nhất</option>
                    <option value="oldest">Ngày cũ nhất</option>
                </select>
            </div>

            <div className="nav nav-pills nav-fill">
                <button
                    className={`nav-link ${activeIndex === 0 ? 'active' : ''} btn`}
                    onClick={() => handleClick(0)}
                >
                    All
                </button>
                <button
                    className={`nav-link ${activeIndex === 1 ? 'active' : ''} btn`}
                    onClick={() => handleClick(1)}
                >
                    Chưa Xác Nhận
                </button>
                <button
                    className={`nav-link ${activeIndex === 2 ? 'active' : ''} btn`}
                    onClick={() => handleClick(2)}
                >
                    Đã Xác Nhận
                </button>
                <button
                    className={`nav-link ${activeIndex === 3 ? 'active' : ''} btn`}
                    onClick={() => handleClick(3)}
                >
                    đã đánh giá
                </button>
            </div>
            <Modal show={state.active} onHide={closeModal} centered>
                <Modal.Header closeButton>
                    <Modal.Title>Nhập Thông Tin Kho Hàng</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onSubmit={handleWarehouseSubmit}>
                        <p>Code Order: {state.items.orderId}</p>
                        <Form.Group controlId="formWarehouseName">
                            {error && <Alert variant="danger" className="text-center">{error}</Alert>}
                            <Form.Label>Tên Kho Hàng</Form.Label>
                            <Form.Control
                                as="select"
                                placeholder="Nhập tên kho hàng"
                                value={warehouseName || ''}
                                onChange={(e) => setWarehouseName(e.target.value)}
                                required
                            >
                                <option value="">----Chọn kho hàng-----</option>
                                {state.items.warehouse.map((warehouse) =>
                                    <option key={warehouse.id} value={warehouse.id}>
                                        {warehouse.name}
                                    </option>
                                )}
                            </Form.Control>
                            <Form.Label>Tên Kho Hàng</Form.Label>
                            <Form.Control
                                type="Date"
                                placeholder="Ngày nhập vào kho"
                                value={dateInto}
                                onChange={(e) => setDateInto(e.target.value)}

                                required
                            />
                        </Form.Group>
                        <Button variant="primary" type="submit" className="mt-3" onClick={e => handleWarehouseSubmit(e)}>
                            Lưu Thông Tin
                        </Button>
                        <Button variant="danger" type="submit" className="mt-3" onClick={() => closeModal()}>
                            Đóng
                        </Button>
                    </Form>
                </Modal.Body>
            </Modal>
            <div className="bill mt-5">
                {loading ? (
                    <div className="text-center">
                        <Spinner animation="border" role="status">
                            <span className="visually-hidden">Loading...</span>
                        </Spinner>
                    </div>
                ) : bill.length === 0 ? (
                    <p className="text-center">No bills found.</p>
                ) : (
                    // Thêm nội dung để hiển thị khi có dữ liệu trong bills
                    bill.map((entry) => (
                        <div className="containers mt-5 border border-primary rounded p-3 mb-4" key={entry.key}>
                            <div className="invoice-header text-center">
                                <h1>Invoice</h1>

                                {entry.items && entry.items[0] && (
                                    <p>Supplier Name: {entry.items[0].supplierName}</p>
                                )}

                            </div>
                            <div className="row">
                                <div className="col-md-6">
                                    <p><strong>Invoice ID:</strong> {entry.key}</p>
                                    <p><strong>deliveryDate:</strong> {entry.items[0].deliveryDate}</p>
                                    <p><strong>expectDate:</strong> {entry.items[0].expectDate}</p>
                                    {/* Other invoice details */}
                                </div>
                            </div>

                            <div className="invoice-table">
                                <h4 className="mb-3">Invoice Items</h4>
                                <table className="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th>Material Name</th>
                                            <th>Quantity</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        {entry.items && entry.items.map((item, index) => (
                                            <tr key={index}>
                                                <td>{item.materialName}</td>
                                                <td>{item.quantity}</td>

                                            </tr>
                                        ))}
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <th colSpan="2" className="text-end">Total</th>
                                            <td>{entry.items ? entry.items.reduce((total, item) => total + (item.quantity * item.totalPrice), 0) : 0}</td>
                                        </tr>
                                    </tfoot>
                                </table>
                                {entry.items && entry.items[0] && entry.items[0].active === false ? (
                                    <div className="d-flex justify-content-end mb-3">

                                        <button type="button" className="btn btn-danger" onClick={() => openModal(entry.key)}>
                                            xác nhận đơn hàng
                                        </button>

                                    </div>
                                ) : entry.items && entry.items[0] && entry.items[0].activeEvaluate === false ? (
                                    <div className="d-flex justify-content-end mb-3">
                                        <Link className="nav-link text-danger" to={`/evluateSupplier?kw=${encodeURIComponent(entry.items[0].supplierId)}&q=${encodeURIComponent(entry.key)}`}>
                                            <button type="button" className="btn btn-primary">
                                                đánh giá nhà cung cấp
                                            </button>
                                        </Link>
                                    </div>
                                ) : (
                                    <div className="d-flex justify-content-end mb-3">
                                        <Link className="nav-link text-danger" to="/orderimport/add">
                                            <button type="button" className="btn btn-success">
                                                xem đánh giá
                                            </button>
                                        </Link>
                                    </div>
                                )
                                }
                            </div>
                        </div>

                    ))
                )}

            </div>
        </>
    )

}
export default OrderBill;