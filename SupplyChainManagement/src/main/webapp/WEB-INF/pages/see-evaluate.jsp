<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="container">
    <h2>Đánh giá nhà cung cấp: ${supFor[0].nameSupplier}</h2>

   
    <c:if test="${not empty supFor}">
        <table class="table table-bordered">
            <thead>
                <tr>
                    
                    <th>Đánh giá giao hàng</th>
                    <th>Đánh giá chất lượng</th>
                    <th>Đánh giá giá cả</th>
                    <th>Bình luận</th>
                    <th>Ngày đánh giá</th>
                    <th>Mã đơn nhập hàng</th>
                </tr>
            </thead>
            <tbody>
                <!-- Lặp qua danh sách đánh giá để hiển thị thông tin -->
                <c:forEach var="dto" items="${supFor}">
                    <tr>
                        
                        <td>${dto.deliveryRating}</td>
                        <td>${dto.qualityRating}</td>
                        <td>${dto.priceRating}</td>
                        <td>${dto.comment}</td>
                        <!-- Sử dụng fmt:formatDate để định dạng ngày -->
                        <td><fmt:formatDate value="${dto.evaluationDate}" pattern="dd/MM/yyyy" /></td>
                        <td>${dto.importorder}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <!-- Hiển thị thông báo nếu không có đánh giá nào -->
    <c:if test="${empty supFor}">
        <div class="alert alert-info" role="alert">
            Không có đánh giá nào cho nhà cung cấp.
        </div>
    </c:if>
</div>
