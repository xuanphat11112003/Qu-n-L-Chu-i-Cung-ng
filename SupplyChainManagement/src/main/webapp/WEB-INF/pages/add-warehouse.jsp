
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1 class="text-center text-primary mt-1">QUẢN LÝ NHÀ KHO</h1>
<c:url value="/warehouse/add" var="action" />
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<form:form method="post"  action="${action}" modelAttribute="warehouse">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="mb-3 mt-3">
        <label for="name" class="form-label">Tên nhà kho:</label>
        <form:input path="name" type="text" class="form-control" id="name" placeholder="Tên sản phẩm..." name="name" />

    </div>
    <div class="mb-3 mt-3">
        <label for="address" class="form-label">địa chỉ:</label>
        <form:input path="address" type="text" class="form-control" id="address" placeholder="địa chỉ..." name="address" />
    </div>
    
   





<div class="mb-3 mt-3">
    <form:hidden path="id" />
    
    <button class="btn btn-success" type="submit">

         <c:choose>
                <c:when test="${warehouse.id != null}">
                    <option value="${c.id}" selected>Cập nhật sản phẩm</option>
                </c:when>
                <c:otherwise>
                    Thêm sản phẩm
                </c:otherwise>
            </c:choose>
    </button>
</div>
</form:form>


