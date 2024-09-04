import { useEffect, useRef, useState } from "react";
import { authAPIs, endpoints } from "../config/APIs";


const SupplierReview = () => {
    const [suppliers, setSuppliers] = useState([]);
    const [selectedSupplier, setSelectedSupplier] = useState(null);
    const [showModal, setShowModal] = useState(false);
    const [evaluate, setEvaluate] = useState([]);
    const [page, setpage] = useState(1);
    const revierwEndRef = useRef(null);
    const [hasmore, sethasmore] = useState(true);

    const loadSuppliers = async () => {
        const url = `${endpoints['supplier']}/rate`;
        try {
            const res = await authAPIs().get(url);
            setSuppliers(res.data);
        } catch (error) {
            console.info(error);
        }
    };
    const handleScroll = () => {
        console.log("selectedSupplier");
        if (revierwEndRef.current) {
            const { scrollTop, clientHeight, scrollHeight } = revierwEndRef.current;
            if (scrollTop + clientHeight >= scrollHeight - 10) {
                setpage(page + 1);
                handleSelectSupplier(selectedSupplier);
            }



        }
    }
    useEffect(() => {
        if (showModal) {
            console.log("a");
            const container = revierwEndRef.current;
            console.log(container)
            console.log(hasmore);
            if (hasmore === true) {
                console.log("b");
                container.addEventListener("scroll", handleScroll);
            }
            return () => {
                if (container) {
                    container.removeEventListener('scroll', handleScroll);
                }
            };
        }
    }, [page, showModal,hasmore]);

    useEffect(() => {
        loadSuppliers();
    }, []);

    const handleSelectSupplier = async (supplier) => {

        let url = `${endpoints['supplier']}/evaluate?name=${supplier[6]}&page=${page}`;
        try {
            let res = await authAPIs().get(url);
            const supplierId = supplier[6];
            console.log(res.data[1])
            console.log(res.data);
            if (res.data &&  Array.isArray(res.data[supplierId])) {
                if (page === 1) {
                    setEvaluate( res.data );
                } else {
                    setEvaluate(current => ({
                        ...current,
                        [supplierId]: [...current[supplierId] , ...res.data[supplierId]]
                    }));
                }
            } else {
                console.error("Dữ liệu trả về không khớp với định dạng mong đợi:", res.data);
                sethasmore(false);
            }
        } catch (error) {
            console.info(error);
        } finally {
            setSelectedSupplier(supplier);
            setShowModal(true);
        }


    };

    const handleCloseModal = () => {
        setShowModal(false);
        setSelectedSupplier(null);
        setpage(1);
        sethasmore(true);
    };

    return (
        <div className="supplier-review-container">
            <h2>Danh sách nhà cung cấp</h2>
            <div className="supplier-list">
                {suppliers.length === 0 ? (
                    <p>Không có nhà cung cấp nào.</p>
                ) : (
                    suppliers.map((supplier, index) => (
                        <div
                            key={index}
                            className="supplier-card"
                            onClick={() => handleSelectSupplier(supplier)}
                        >
                            <h3>{supplier[0]}</h3>
                            <p>Địa chỉ: {supplier[4]}</p>
                            <p>Điện thoại: {supplier[5]}</p>
                        </div>
                    ))
                )}
            </div>

            {showModal && selectedSupplier && (
                <div className="modal-overlay" onClick={handleCloseModal}>
                    <div className="modal-content" onClick={(e) => e.stopPropagation()}>
                        <button className="modal-close" onClick={handleCloseModal}>
                            &times;
                        </button>
                        <h2 style={{
                            backgroundColor: '#007bff',
                            color: 'white',
                            padding: '10px',
                            margin: 0
                        }}>
                            {selectedSupplier[0]}
                        </h2>
                        <div className="rating-item">
                            <p>Đánh giá chất lượng: {selectedSupplier[1]}</p>
                            <div className="rating-bar" style={{ width: `${selectedSupplier[1]}%` }}>

                            </div>
                        </div>
                        <div className="rating-item">
                            <p>Đánh giá giá cả: {selectedSupplier[2]}</p>
                            <div className="rating-bar" style={{ width: `${selectedSupplier[2]}%` }}></div>
                        </div>
                        <div className="rating-item">
                            <p>Đánh giá giao hàng: {selectedSupplier[3]}</p>
                            <div className="rating-bar" style={{ width: `${selectedSupplier[3]}%` }}></div>
                        </div>
                        <div className="review-list" ref={revierwEndRef}>
                            {selectedSupplier && selectedSupplier.length === 0 ? (
                                <div className="loading-spinner">Loading...</div>
                            ) : (
                                evaluate[selectedSupplier[6]].map((entry, index) => (
                                    <div key={index} className="review-item">
                                        <p> {entry.comment}</p>
                                        <p> {entry.evaluationDate}</p>
                                    </div>
                                ))
                            )}
                            <div style={{ height: '1px' }}></div>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
};

export default SupplierReview;
