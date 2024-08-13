<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">



    <div class="container text-light p-3 mb-3">
        <h1>Chào mừng đến với trang web của chúng tôi!</h1>
    </div>
</nav>  
<div>
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name == null}">


            <a href="<c:url value="/login"/>" >Đăng Nhập</a>

        </c:when>
        <c:when test="${pageContext.request.userPrincipal.name != null}">

            <a href="#">${pageContext.request.userPrincipal.name}</a>


            <a href="<c:url value="/logout" />">Đăng Xuất</a>

        </c:when>
    </c:choose>
</div>

