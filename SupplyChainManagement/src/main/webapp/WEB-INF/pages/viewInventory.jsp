<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    /* CSS cho toàn bộ phần section */
    .backgr {
        display: flex; /* Sắp xếp các thẻ theo hàng ngang */
        justify-content: space-around; /* Khoảng cách đều giữa các thẻ */
        padding: 20px; /* Khoảng cách bên trong section */
        background: linear-gradient(to right, rgba(0, 51, 204, 0.9), rgba(102, 179, 255, 0.9)); /* Hiệu ứng gradient nền */
        border-radius: 10px; /* Bo tròn các góc */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Hiệu ứng đổ bóng */
        margin: 20px auto; /* Căn giữa và khoảng cách phía trên/dưới */
        max-width: 800px; /* Giới hạn chiều rộng tối đa */
    }

    /* CSS cho mỗi thẻ chứa thông tin tồn kho */
    .backgr div {
        background-color: white; /* Nền màu trắng cho mỗi thẻ */
        padding: 20px; /* Khoảng cách bên trong mỗi thẻ */
        border-radius: 10px; /* Bo tròn các góc của thẻ */
        text-align: center; /* Căn giữa nội dung */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Hiệu ứng đổ bóng cho thẻ */
        width: 45%; /* Đặt chiều rộng cho mỗi thẻ */
    }

    /* CSS cho tiêu đề */
    h4 {
        margin-bottom: 15px; /* Khoảng cách dưới tiêu đề */
        color: #0033cc; /* Màu xanh dương đậm */
    }

    /* CSS cho nút bấm */
    button {
        padding: 10px 20px; /* Khoảng cách bên trong nút */
        background-color: #007bff; /* Màu nền xanh dương */
        color: white; /* Màu chữ trắng */
        border: none; /* Bỏ viền nút */
        border-radius: 5px; /* Bo tròn góc nút */
        cursor: pointer; /* Đổi con trỏ khi hover vào nút */
        transition: background-color 0.3s ease; /* Hiệu ứng chuyển màu khi hover */
    }

    /* Hiệu ứng khi hover vào nút */
    button:hover {
        background-color: #0056b3; /* Đổi màu nền khi hover */
    }
</style>


<section class="backgr">
    <!-- Phần Sản Phẩm Tồn Kho -->
    <div>
        <h4>Vật Liệu Tồn Kho</h4>
        <!-- Nút bấm chuyển sang trang chi tiết sản phẩm tồn kho -->
        <a href="<c:url value="/inventory/materialStock/detail"/>">
            <button type="button">Xem Chi Tiết</button>
        </a>
    </div>

    <!-- Phần Vật Liệu Tồn Kho -->
    <div>
        <h4>Sản Phẩm Tồn Kho</h4>
        <!-- Nút bấm chuyển sang trang chi tiết vật liệu tồn kho -->
        <a href="viewMaterialDetails.jsp">
            <button type="button">Xem Chi Tiết</button>
        </a>
    </div>
</section>


