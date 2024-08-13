<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
<<<<<<< HEAD
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
=======
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="#">Trang chủ</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Danh mục</a>
        </li>
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name == null}">
                
                <li>
                    <a href="<c:url value="/login"/>" >Login</a>
                </li>
            </c:when>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
                <li>
                    <a href="#">${pageContext.request.userPrincipal.name}</a>
                </li>
                <li>
                    <a href="<c:url value="/logout" />">Logout</a>
                </li>
            </c:when>
        </c:choose>
    </ul>
</nav>
>>>>>>> 73f473402519512d283afc13ec32a081b94a2390
