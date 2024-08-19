


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-primary mt-1">QUẢN LÝ SẢN PHẨM</h1>
<c:url value="/add-product" var="action" />
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<form:form method="post"  action="${action}" modelAttribute="product">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="mb-3 mt-3">
        <label for="name" class="form-label">Tên sản phẩm:</label>
        <form:input path="name" type="text" class="form-control" id="name" placeholder="Tên sản phẩm..." name="name" />

    </div>
    <div class="mb-3 mt-3">
        <label for="price" class="form-label">Giá sản phẩm:</label>
        <form:input path="price" type="number" class="form-control" id="price" placeholder="Giá sản phẩm..." name="price" />
    </div>
    <div class="mb-3 mt-3">
        <label for="detail" class="form-label">mô tả sản phẩm:</label>
        <form:input path="detail" type="text" class="form-control" id="detail" placeholder="mô tả sản phẩm..." name="detail" />
    </div>





<div class="mb-3 mt-3">
    <form:hidden path="id" />
    
    <button class="btn btn-success" type="submit">

         <c:choose>
                <c:when test="${product.id != null}">
                    <option value="${c.id}" selected>Cập nhật sản phẩm</option>
                </c:when>
                <c:otherwise>
                    Thêm sản phẩm
                </c:otherwise>
            </c:choose>
    </button>
</div>
</form:form>


