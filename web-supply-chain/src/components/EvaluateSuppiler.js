import React, { useState } from 'react';
import { useNavigate, useSearchParams } from 'react-router-dom';
import { authAPIs, endpoints } from '../config/APIs';

const EvaluateSupplier = () => {
    const [deliveryRating, setDeliveryRating] = useState(0);
    const [qualityRating, setQualityRating] = useState(0);
    const [priceRating, setPriceRating] = useState(0);
    const [comment, setComment] = useState("");
    const [error, setError] = useState("");
    const nav = useNavigate();
    const [q] = useSearchParams();

    const handleSubmit = async (e) => {
        e.preventDefault();
        let supId = q.get('kw');
        let orderId = q.get('q');
        let url = `${endpoints['supplier']}/evaluate/${orderId}/${supId}`;
        const data = {
            deliveryRating: deliveryRating,
            qualityRating: qualityRating,
            priceRating: priceRating,
            comment: comment
        };
        try {
            let res = await authAPIs().post(url, data);
            if (res.status === 201 || res.status === 200) {
                setError("");
            } else {
                setError("Không thể gửi đánh giá. Vui lòng thử lại.");
            }
        } catch (error) {
            console.info(error);
            setError("Đã xảy ra lỗi khi gửi đánh giá.");
        }finally{
            nav(`\orderimport`);
        }
    };

    return (
        <>
            <div className="rating-container">
                <div className="rating-section">
                    <h4 className="rating-title">Đánh giá giao hàng</h4>
                    <div className="slider-container">
                        <input
                            type="range"
                            min="0"
                            max="100"
                            value={deliveryRating}
                            onChange={e => setDeliveryRating(e.target.value)}
                            className="slider"
                        />
                        <div className="slider-track">
                            <div className="slider-fill" style={{ width: `${deliveryRating}%` }}></div>
                        </div>
                    </div>
                    <p className="rating-value">{deliveryRating}%</p>
                </div>

                <div className="rating-section">
                    <h4 className="rating-title">Đánh giá chất lượng</h4>
                    <div className="slider-container">
                        <input
                            type="range"
                            min="0"
                            max="100"
                            value={qualityRating}
                            onChange={e => setQualityRating(e.target.value)}
                            className="slider"
                        />
                        <div className="slider-track">
                            <div className="slider-fill" style={{ width: `${qualityRating}%` }}></div>
                        </div>
                    </div>
                    <p className="rating-value">{qualityRating}%</p>
                </div>

                <div className="rating-section">
                    <h4 className="rating-title">Đánh giá về giá cả</h4>
                    <div className="slider-container">
                        <input
                            type="range"
                            min="0"
                            max="100"
                            value={priceRating}
                            onChange={e => setPriceRating(e.target.value)}
                            className="slider"
                        />
                        <div className="slider-track">
                            <div className="slider-fill" style={{ width: `${priceRating}%` }}></div>
                        </div>
                    </div>
                    <p className="rating-value">{priceRating}%</p>
                </div>
            </div>
            <div className="mb-3">
                <label className="form-label">Nhận xét</label>
                <textarea
                    className="form-control"
                    rows="3"
                    value={comment}
                    onChange={(e) => setComment(e.target.value)}
                />
            </div>
            <button onClick={handleSubmit} className="btn btn-primary">Gửi Đánh Giá</button>
            {error && <p className="text-danger">{error}</p>}
        </>
    );
};

export default EvaluateSupplier;
