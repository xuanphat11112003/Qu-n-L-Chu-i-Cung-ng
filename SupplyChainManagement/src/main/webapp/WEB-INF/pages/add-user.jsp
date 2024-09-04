<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:url value="/user/add" var="action" />
<c:url value="/user/edit" var="editUrl">
    <c:param name="id" value="${user.id}" />
    <c:param name="showPassword" value="true" />
</c:url>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<c:choose>
    <c:when test="${not empty user.id}">
        <c:set var="action1" value="${editUrl}" />
    </c:when>
    <c:otherwise>
        <c:set var="action1" value="${action}" />
    </c:otherwise>
</c:choose>
<style>
    #backgr{
        background-color: whitesmoke;
        padding: 10px

    }
</style>
<div class="container" id = "backgr">
    <h2>Add New User</h2>

    <form:form method="post" action="${action1}" modelAttribute="user" enctype="multipart/form-data">
        <form:errors path="*" element="div" cssClass="alert alert-danger" />

        <div class="form-group">
            <form:label path="username">Username:</form:label>
            <form:input path="username" class="form-control" />
            <form:errors path="username" cssClass="text-danger" />
        </div>
        <c:set var="showPassword" value="${param.showPassword != 'false'}" />
        <c:set var="userHasId" value="${user.id != null}" />
        <c:choose>
            <c:when test="${userHasId && showPassword}">
                <div style="display: block;">
                    <!-- Nội dung của phần tử -->
                </div>
            </c:when>
            <c:otherwise>
                <div style="display: none;">
                    <!-- Nội dung của phần tử -->
                </div>
            </c:otherwise>
        </c:choose>

        <!-- Kiểm tra nếu user.id tồn tại thì sẽ ẩn ô nhập mật khẩu -->
        <c:choose>
            <c:when test="${user.id != null}">
                <!-- Nút đổi mật khẩu -->
                <button type="button" class="btn btn-info" id="changePasswordBtn" onclick="navigateToEdit()"  style="${param.showPassword != 'true'   ? 'display: block;' : 'display: none;'}">Đổi mật khẩu</button>

                <!-- Ô nhập mật khẩu bị ẩn ban đầu hoặc hiển thị dựa trên tham số showPassword -->
                <div class="form-group" id="passwordField" style="${param.showPassword == 'true' ? 'display: block;' : 'display: none;'}">
                    <form:label path="password">Password:</form:label>
                    <form:input path="password" type="password" class="form-control" />
                    <form:errors path="password" cssClass="text-danger" />
                </div>
            </c:when>
            <c:otherwise>
                <!-- Ô nhập mật khẩu luôn hiển thị khi thêm user mới -->
                <div class="form-group">
                    <form:label path="password">Password:</form:label>
                    <form:input path="password" type="password" class="form-control" />
                    <form:errors path="password" cssClass="text-danger" />
                </div>
            </c:otherwise>
        </c:choose>

        <!-- Các trường nhập khác -->
        <div class="form-group">
            <form:label path="email">Email:</form:label>
            <form:input path="email" type="email" class="form-control" />
            <form:errors path="email" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <form:label path="adress">Address:</form:label>
            <form:input path="adress"  class="form-control" />
            <form:errors path="adress" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <form:label path="phone">phone:</form:label>
            <form:input path="phone" class="form-control" />
            <form:errors path="phone" cssClass="text-danger" />
        </div>

        <div class="form-group">
            <form:label path="name">Full Name:</form:label>
            <form:input path="name" class="form-control" />
            <form:errors path="name" cssClass="text-danger" />
        </div>

        <div class="form-group">
            <form:label path="userRole">Role:</form:label>
            <form:select path="userRole" class="form-control">
                <form:option value="" label="Select Role"/>
                <form:option value="ROLE_USER" label="User"/>
                <form:option value="ROLE_ADMIN" label="Admin"/>
                <form:option value="ROLE_AGENCY" label="Agency"/>
            </form:select>
            <form:errors path="userRole" cssClass="text-danger" />
        </div>
        <div class="mb-3 mt-3">
            <label for="file" class="form-label">Ảnh sản phẩm</label>
            <form:input path="file" accept=".png,.jpg" type="file" class="form-control" id="file" name="file" />
            <c:if test="${user.id != null}">
                <img src="${user.avartar}" alt="${user.name}" width="120" />
            </c:if>
        </div>
        <div class="mb-3 mt-3">
            <form:hidden path="id" />
            <form:hidden path="avartar"/>

            <button class="btn btn-success" type="submit">
                <c:choose>
                    <c:when test="${user.id != null}">
                        Cập nhật user
                    </c:when>
                    <c:otherwise>
                        Thêm sản phẩm
                    </c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>
</div>

<script>
    function navigateToEdit() {
        window.location.href = "${editUrl}";
    }
</script>
