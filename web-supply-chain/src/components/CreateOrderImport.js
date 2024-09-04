import { useEffect, useState } from "react";
import APIs, { authAPIs, endpoints } from "../config/APIs";
import 'bootstrap/dist/css/bootstrap.min.css';

const OrderImport = () => {
    const [supplier, setsup] = useState([]);
    const [payment, setpayment] = useState([]);
    const [selectedSupplier, setSelectedSupplier] = useState("");
    const [selectedPayment, setSelectedPayment] = useState("");
    const [materials, setMaterials] = useState([]);
    const [orderDetails, setOrderDetails] = useState({ details: [{ materialId: "", quantity: 1 }] });

    const LoadOrderImport = async () => {
        let url = `${endpoints['supplier']}`;
        let link = `${endpoints['order']}/payment`
        try {
            let res = await authAPIs().get(url);
            setsup(res.data);
            let pay = await authAPIs().get(link);
            setpayment(pay.data);
        } catch (ex) {
            console.info(ex);
        }
    }

    const LoadMaterial = async () => {
        if (selectedSupplier) {
            let url = `/getMaterialsBySupplier?q=${selectedSupplier}`;
            try {
                let res = await APIs.get(url);
                setMaterials(res.data);
            } catch (ex) {
                console.log(ex);
            }
        }
    }

    useEffect(() => {
        LoadOrderImport();
    }, []);

    useEffect(() => {
        LoadMaterial();
    }, [selectedSupplier]);

    const handleSupplierChange = (e) => {
        const selectedId = e.target.options[e.target.selectedIndex].dataset.id;
        setSelectedSupplier(selectedId);
    };

    const handleOrderChange = (index, e) => {
        const { name, value } = e.target;
        const updatedOrderDetails = { ...orderDetails };
        updatedOrderDetails.details[index][name] = parseInt(value, 10) || 0; // Hoặc sử dụng một giá trị mặc định khác

        setOrderDetails(updatedOrderDetails);

    };
    const addOrderRow = () => {
        setOrderDetails((preventDetail) => ({
            ...preventDetail, details: [...preventDetail.details, {
                materialId: "",
                quantity: 1,
            }]
        }));
    };

    const removeOrderRow = (index) => {
        const updatedOrderDetails = orderDetails.filter((_, i) => i !== index);
        setOrderDetails(updatedOrderDetails);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        const deliveryDate = document.getElementById("deliveryDate").value;
        const estimatedDate = document.getElementById("estimatedDate").value;
        const payment = document.getElementById("paymentSelect").value;
        const formatDate = (dateStr) => {
            const [year, month, day] = dateStr.split("-"); // Tách chuỗi bằng dấu "-"
            return `${day}/${month}/${year}`; // Đổi định dạng thành dd/MM/yyyy
        };
        const formattedDeliveryDate = formatDate(deliveryDate);
        const formattedEstimatedDate = formatDate(estimatedDate);

        setOrderDetails((preventDetail) => ({
            ...preventDetail, expectDate: formattedEstimatedDate,
            deliveryDate: formattedDeliveryDate, payment: payment
        }));
        console.log("Order Details:", orderDetails);


    };
    useEffect(() => {
        const createOrderImport = async () => {
            let url = `${endpoints['order']}/add`;
            if (orderDetails !== null) {
                try {
                    let res = await APIs.post(url, orderDetails);
                    if (res.status === 201 || res.status === 200) {
                        const proceed = window.confirm("Order created successfully! Do you want to go to the order page?");
                        if (proceed) {
                            window.location.href = '/'; 
                        } else {
                            window.location.reload();
                        }
                    } else {
                        alert("Failed to create order. Please try again."); 
                    }
                } catch (error) {
                    console.error("Error creating order:", error);
                    alert("An error occurred while creating the order."); 
                }
            }
        };
    
        if (orderDetails.deliveryDate && orderDetails.expectDate && orderDetails.payment) {
            createOrderImport();
        }
    }, [orderDetails]);

    return (
        <div className="container mt-4">
            <h1>Create Import Order</h1>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label htmlFor="deliveryDate">Delivery Date:</label>
                    <input
                        type="date"
                        id="deliveryDate"
                        className="form-control"
                    // value={deliveryDate}
                    // onChange={(e) => setDeliveryDate(e.target.value)}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="estimatedDate">Estimated Date:</label>
                    <input
                        type="date"
                        id="estimatedDate"
                        className="form-control"
                    // value={estimatedDate}
                    // onChange={(e) => setEstimatedDate(e.target.value)}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="paymentSelect">Select Payment:</label>
                    <select id="paymentSelect" className="form-control" name="payment" value={selectedPayment} onChange={e => setSelectedPayment(e.target.value)}>
                        <option value="">--Select a Payment--</option>
                        {payment.map((payment, index) => (
                            <option key={index} value={payment}>
                                {payment}
                            </option>
                        ))}
                    </select>
                </div>

                <div className="form-group">
                    <label htmlFor="supplierSelect">Select Supplier:</label>
                    <select id="supplierSelect" className="form-control" name="supplier" value={selectedSupplier} onChange={handleSupplierChange}>
                        <option value="">--Select a Supplier--</option>
                        {supplier.map((sup, index) => (
                            <option key={index} value={sup.id} data-id={sup.id}>
                                {sup.name}
                            </option>
                        ))}
                    </select>
                </div>

                <div className="mt-4">
                    <button type="button" className="btn btn-primary mb-3" onClick={addOrderRow}>
                        Add Product
                    </button>
                    <table className="table table-bordered">
                        <thead>
                            <tr>
                                <th>Material</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {orderDetails.details.map((detail, index) => (
                                <tr key={index}>
                                    <td>
                                        <select
                                            className="form-control"
                                            name="materialId"
                                            value={detail.materialId}
                                            onChange={(e) => handleOrderChange(index, e)}
                                        >
                                            <option value="">--Select Material--</option>
                                            {materials.map((mat) => (
                                                <option key={mat.id} value={mat.id}>
                                                    {mat.name}
                                                </option>
                                            ))}
                                        </select>
                                    </td>
                                    <td>
                                        {materials.find(mat => mat.id == detail.materialId)?.price || 0}
                                    </td>
                                    <td>
                                        <input
                                            type="number"
                                            className="form-control"
                                            name="quantity"
                                            value={detail.quantity}
                                            onChange={(e) => handleOrderChange(index, e)}
                                        />
                                    </td>
                                    <td>
                                        {(materials.find(mat => mat.id == detail.materialId)?.price || 0) * detail.quantity}
                                    </td>
                                    <td>
                                        <button
                                            type="button"
                                            className="btn btn-danger"
                                            onClick={() => removeOrderRow(index)}
                                        >
                                            Remove
                                        </button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>



                <button type="submit" className="btn btn-success">Submit Order</button>
            </form>
        </div>
    )
}

export default OrderImport;
