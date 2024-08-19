<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<style>
    #sidebar {
    background-color: #f8f9fa;
    height: 100vh;
    position: fixed;
    left: -250px; /* Khởi đầu nằm ngoài màn hình */
    width: 250px; /* Chiều rộng của thanh bên */
    transition: left 0.3s ease; /* Hiệu ứng chuyển động khi mở/đóng */
    z-index: 1000;
}
#sidebar.open {
    left: 0; /* Hiển thị thanh bên */
}
#sidebar .nav-link {
    padding: 5px;
    font-size: 1rem;
}
#sidebar-toggle {
    position: fixed;
    top: 70px;
    left: 10px;
    z-index: 1001; /* Đảm bảo nút nằm trên thanh bên */
}
.nav-item{
    margin: 3px;
}
</style>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">



    <div class="container text-light p-3 mb-3">
        <h1>Chào mừng đến với trang web của chúng tôi!</h1>
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
                <div class="position-sticky">
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
                            <a class="btn nav-link alert-primary" href="<c:url value="/product" />">
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
                            <a class="btn nav-link alert-primary" href="<c:url value="/" />">
                                Người Dùng
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="btn nav-link alert-primary" href="<c:url value="/" />">
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
<script>
    document.getElementById('sidebar-toggle').addEventListener('click', function() {
        var sidebar = document.getElementById('sidebar');
        if (sidebar.classList.contains('open')) {
            sidebar.classList.remove('open');
        } else {
            sidebar.classList.add('open');
        }
    });
</script>


