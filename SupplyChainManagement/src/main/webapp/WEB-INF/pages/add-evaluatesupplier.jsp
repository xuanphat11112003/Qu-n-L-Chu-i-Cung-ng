<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    .form-range {
        width: 100%;
    }

    /* Styling for the range input */
    input[type="range"] {
        -webkit-appearance: none; /* Remove default styling in WebKit browsers */
        width: 100%;
        height: 8px; /* Height of the slider track */
        background: transparent; /* Remove default background */
        border-radius: 5px;
        outline: none;
        opacity: 0.7; /* Default opacity */
        transition: opacity .2s; /* Smooth transition for opacity */
    }

    /* WebKit browsers (Chrome, Safari) */
    input[type="range"]::-webkit-slider-thumb {
        -webkit-appearance: none; /* Remove default styling */
        width: 20px; /* Width of the thumb */
        height: 20px; /* Height of the thumb */
        border-radius: 50%; /* Make it round */
        background: #4CAF50; /* Color of the thumb */
        cursor: pointer; /* Change cursor to pointer */
        transition: background .2s; /* Smooth transition for thumb color */
    }

    input[type="range"]::-webkit-slider-runnable-track {
        width: 100%;
        height: 8px; /* Height of the track */
        background: #ddd; /* Color of the track */
        border-radius: 5px;
    }

    /* Firefox */
    input[type="range"]::-moz-range-thumb {
        width: 20px; /* Width of the thumb */
        height: 20px; /* Height of the thumb */
        border-radius: 50%; /* Make it round */
        background: #4CAF50; /* Color of the thumb */
        cursor: pointer; /* Change cursor to pointer */
        transition: background .2s; /* Smooth transition for thumb color */
    }

    input[type="range"]::-moz-range-track {
        width: 100%;
        height: 8px; /* Height of the track */
        background: #ddd; /* Color of the track */
        border-radius: 5px;
    }

    /* Styling for the range input when hovered */
    input[type="range"]:hover {
        opacity: 1; /* Full opacity when hovered */
    }

    input[type="range"]:focus::-webkit-slider-thumb {
        background: #45a049; /* Darker color when focused */
    }

    input[type="range"]:focus::-moz-range-thumb {
        background: #45a049; /* Darker color when focused */
    }

    /* Custom color for the filled portion */
    .form-range::-webkit-slider-runnable-track {
        background: linear-gradient(to right, #4CAF50 0%, #4CAF50 var(--range-value), #ddd var(--range-value), #ddd 100%);
    }

    .form-range::-moz-range-track {
        background: linear-gradient(to right, #4CAF50 0%, #4CAF50 var(--range-value), #ddd var(--range-value), #ddd 100%);
    }
</style>

<h1 class="text-center text-primary mt-1">QUẢN LÝ SẢN PHẨM</h1>
<c:url value="/supplier/evaluate/id/${oid}/${sid}" var="action" />

<form id="evaluationForm" onsubmit="return false;">

    <div class="mb-3 mt-3">
        <label for="deliveryRating" class="form-label">Đánh Giá Giao Hàng:</label>
        <input type="range" min="0" max="100" step="1" class="form-range" id="deliveryRating" name="deliveryRating" oninput="updateOutput(this)" />
        <output for="deliveryRating">0</output>%
    </div>

    <div class="mb-3 mt-3">
        <label for="qualityRating" class="form-label">Đánh Giá Chất Lượng:</label>
        <input type="range" min="0" max="100" step="1" class="form-range" id="qualityRating" name="qualityRating" oninput="updateOutput(this)" />
        <output for="qualityRating">0</output>%
    </div>

    <div class="mb-3 mt-3">
        <label for="priceRating" class="form-label">Đánh Giá Về Giá Cả:</label>
        <input type="range" min="0" max="100" step="1" class="form-range" id="priceRating" name="priceRating" oninput="updateOutput(this)" />
        <output for="priceRating">0</output>%
    </div>

    <div class="mb-3 mt-3">
        <label for="comment" class="form-label">Nhận Xét:</label>
        <input type="text" class="form-control" id="comment" name="comment" placeholder="mô tả sản phẩm..." />
    </div>

    <div class="mb-3 mt-3">
        <input type="hidden" name="orderId" value="${oid}" />
        <input type="hidden" name="supplier" value="${sup}" />

        <button id="submitBtn" class="btn btn-success" type="button" onclick="submitForm()">
            Đánh giá
        </button>
    </div>
</form>

<script>
    function updateOutput(element) {
        const output = element.nextElementSibling;
        output.value = element.value;
    }

    function submitForm() {
        const form = document.getElementById('evaluationForm');
        const formData = new FormData(form);

        // Tạo đối tượng JSON từ dữ liệu form
        const data = {
            deliveryRating: formData.get('deliveryRating'),
            qualityRating: formData.get('qualityRating'),
            priceRating: formData.get('priceRating'),
            comment: formData.get('comment')
        };

        fetch('${action}', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then()
        .then(data => {
            console.log('Success:', data);
            // Hiển thị thông báo và chuyển hướng nếu người dùng đồng ý
            if (window.confirm('Lưu thành công. Bạn có muốn trở về trang chủ không?')) {
                window.location.href = 'http://localhost:8080/SupplyChainManagement/'; // Thay đổi URL này nếu cần
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            // Hiển thị thông báo lỗi nếu có
        });
    }
</script>
