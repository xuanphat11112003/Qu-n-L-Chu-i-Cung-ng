<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        #sidebar {
            background: linear-gradient(to bottom, rgba(0, 51, 204, 0.9), rgba(102, 179, 255, 0.9)) !important;
            height: 100vh;
            position: fixed;
            left: -250px;
            width: 250px;
            transition: left 0.3s ease;
            z-index: 1000;
            top:110px;
        }

        #sidebar.open {
            left: 0;
        }

        #sidebar .nav-link {
            padding: 5px;
            font-size: 1rem;
        }

        #sidebar-toggle {
            position: fixed;
            top: 70px;
            left: 10px;
            z-index: 1001;
        }

        .nav-item {
            margin: 3px;
        }

        .navbar {
            background: linear-gradient(to right, rgba(0, 51, 204, 0.9), rgba(102, 179, 255, 0.9)) !important;
            color: white;
        }

        .container-fluid {
            margin-left: 250px; /* Adjusted for sidebar */
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">



    <div class="container text-light p-3 mb-3">
        <h1>SUPPLY CHAIN ADMIN </h1>
    </div>
    <div class="d-flex p-2">
    <s:authorize access="hasAnyRole('USER', 'ADMIN')">
            <a class="nav-link" href="<c:url value="/" />">
                <span class="ms-1 font-weight-bold text-white">Xin chào ${pageContext.request.userPrincipal.name.toUpperCase()}</span>
            </a>

            <a class="btn btn-danger" href="<c:url value="/logout" />">
                Đăng xuất
            </a>

    </s:authorize>
</div>
</nav>
<button id="sidebar-toggle" class="btn btn-primary">☰</button>
<div class="container-fluid">
        <div class="row">
            <!-- Thanh Bên -->
            <nav id="sidebar" class="col-md-3 col-lg-2 d-md-block bg-light sidebar">
                <div class="sidebar-sticky">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class=" btn nav-link alert alert-primary" href="<c:url value="/" />">
                                Trang chủ
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="btn nav-link alert-primary" href="<c:url value="/orders" />">
                                Mua hàng
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="btn nav-link alert-primary" href="<c:url value="/" />">
                                Đơn Hàng
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="btn nav-link alert-primary" href="<c:url value="/" />">
                                Đại Lý
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="btn nav-link alert-primary" href="<c:url value="/" />">
                                Sản Xuất
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="btn nav-link alert-primary" href="<c:url value="/" />">
                                Vận Chuyển
                            </a>
                        </li>
                        <li class=" nav-item">
                            <a class=" btn nav-link alert-primary" href="<c:url value="/" />">
                                Tồn Kho
                            </a>
                        </li>
                        <li class=" nav-item">
                            <a class="btn nav-link alert-primary" href="<c:url value="/" />">
                                Nhà Cung Cấp
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="btn nav-link alert-primary" href="<c:url value="/" />">
                                Kho Hàng
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="btn nav-link alert-primary" href="<c:url value="/user/index" />">
                                Người Dùng
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="btn nav-link alert-primary" href="<c:url value="/product" />">
                                Sản Phẩm
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="btn nav-link alert-primary" href="<c:url value="/" />">
                                Nguyên Vật Liệu
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="btn nav-link alert-primary" href="<c:url value="/" />">
                                Báo Cáo Thống Kê
                            </a>
                        </li>
                        <!-- Thêm các mục khác tại đây -->
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</body>
<script>
    document.getElementById('sidebar-toggle').addEventListener('click', function() {
        var sidebar = document.getElementById('sidebar');
        if (sidebar.classList.contains('open')) {
            sidebar.classList.remove('open');
        } else {
            sidebar.classList.add('open');
        }
    });
    document.addEventListener('scroll', function() {
        var sidebarToggle = document.getElementById('sidebar-toggle');
        var scrollTop = window.pageYOffset || document.documentElement.scrollTop;

        if (scrollTop > 100) { // Thay đổi giá trị này tùy thuộc vào vị trí bạn muốn nút di chuyển
            sidebarToggle.style.top = '0'; // Đưa nút lên cùng với cạnh trên của trang
            sidebar.style.top = '50px';
        } else {
            sidebarToggle.style.top = '70px'; // Đặt lại vị trí ban đầu khi cuộn lên trên
            sidebar.style.top = '110px';
        }
    });
</script>
</html>


