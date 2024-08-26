
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="<c:url value="/js/Material.js" />"></script>
<section class="container">
    <div class="col-md-10 col-12">
        <a class="btn btn-info m-1" href="<c:url value="/supplier/add" />">Thêm Nhà Cung Cấp</a>
    </div>
    <c:url value="/supplier/index" var="action" />
    <c:url value="/supplier/evaluate" var="action" />
    <form action="${action}">
        <div class="d-flex ">  
            <div >
                <input type="text" class="form-control" id="kw" placeholder="Từ khóa..." name="name">
            </div>
            <div class="">
                <button class="btn btn-info" type="submit">Tìm kiếm</button>
            </div>
        </div>
    </form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Feedback</th>
                <th>Detail</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${supllier}" var="p">
                <tr id="supplierl${p.id}">
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.address}</td>
                    <td>${p.phone}</td>
                    <td>
                        <form action="${action}">
                            <div>
                                <!-- Hidden input field to send a default value for parameter "p" -->
                                <input type="hidden" name="name" value="${p.id}">
                                <button class="btn btn-info" type="submit">Xem Đánh Giá</button>
                            </div>
                        </form>
                    </td>
                    <td>
                        <c:url value="/supplier/add/${p.id}" var="u" />
                        <a href="${u}" class="btn btn-success">&#9997</a>

                        <c:url value="/supplier/${p.id}" var="uD" />
                        <button onclick="deleteMaterial('${uD}', ${p.id})" class="btn btn-danger">&times;</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>



