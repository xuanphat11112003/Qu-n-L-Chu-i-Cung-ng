<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/orders/add" var="action" />
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<div class="container">
    <h2>Tạo Đơn Hàng</h2>
    <form:form action="${action}" method="post" modelAttribute="importOrder">
        <form:errors path="*" element="div" cssClass="alert alert-danger" />
        <div class="form-group">
            <label for="expectDate">Ngày Dự Kiến:</label>
            <form:input path="expectDate" class="form-control" type="date" id="expectDate" />
        </div>
        <div class="form-group">
            <label for="totalPrice">Tổng Giá:</label>
            <form:input path="totalPrice" class="form-control" type="number" step="0.01" id="totalPrice" />
        </div>
        <div class="form-group">
            <label for="totalCost">Tổng Chi Phí:</label>
            <form:input path="totalCost" class="form-control" type="number" step="0.01" id="totalCost" />
        </div>
        <div id="products">
            <!-- Hiển thị các sản phẩm -->
            <c:forEach var="detail" items="${details}" varStatus="status">
                <div class="product">
                    <label for="material-${status.index}">Mã sản phẩm:</label>
                    <form:select path="details[${status.index}].materialId" class="form-control" id="material-${status.index}" >
                        <c:forEach var="material" items="${materials}">
                            <option value="${material.id}" ${material.id == detail.materialId.id ? 'selected' : ''}>
                                ${material.name} - ${material.price}
                            </option>
                        </c:forEach>
                    </form:select>
                    <br>
                    <label for="quantity-${status.index}">Số lượng:</label>
                    <form:input path="details[${status.index}].quantity" id="quantity-${status.index}" class="form-control" type="number" />
                    <br>
                    <label for="price-${status.index}">Giá:</label>
                    <form:input path="details[${status.index}].price" id="price-${status.index}" class="form-control" />
                    <br>
                    <button type="button" onclick="removeProduct(${status.index})" class="btn btn-danger">Xóa</button>
                    <hr />
                </div>
            </c:forEach>
        </div>
        <h3>Chi Tiết Đơn Hàng</h3>
        <button type="button" id="addProduct" class="btn btn-success">Thêm sản phẩm</button>
        <br><br>
        <button type="submit" class="btn btn-primary">Tạo Đơn Hàng</button>
    </form:form>
</div>

<script>
    let productIndex = ${details.size()};

    document.getElementById('addProduct').addEventListener('click', function () {
        const productDiv = document.createElement('div');
        productDiv.className = 'product';

        productDiv.innerHTML = `
            <label for="material-${productIndex}">Mã sản phẩm:</label>
            <select name="details[${productIndex}].materialId" id="material-${productIndex}" class="form-control">
                <c:forEach var="material" items="${materials}">
                    <option value="${material.id}">${material.name}- ${material.price}</option>
                </c:forEach>
            </select>
            <br>
            <label for="quantity-${productIndex}">Số lượng:</label>
            <input type="number" name="details[${productIndex}].quantity" id="quantity-${productIndex}" class="form-control" />
            <br>
            <label for="price-${productIndex}">Giá:</label>
            <input type="text" name="details[${productIndex}].price" id="price-${productIndex}" class="form-control" />
            <br>
            <button type="button" onclick="removeProduct(${productIndex})" class="btn btn-danger">Xóa</button>
            <hr />
        `;

        document.getElementById('products').appendChild(productDiv);
        productIndex++;
    });

    function removeProduct(index) {
        const productDiv = document.querySelector(`#products .product:nth-child(${index + 1})`);
        if (productDiv) {
            productDiv.remove();
        }
    }
</script>
