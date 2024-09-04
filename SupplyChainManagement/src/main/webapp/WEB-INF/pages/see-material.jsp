
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="<c:url value="/js/Material.js" />"></script>
<style>
    section{
        background-color: rgba(173, 216, 230, 0.9);
        padding: 10px;
    }
</style>
<section class="container">
    <div class="col-md-10 col-12">
        <a class="btn btn-info m-1" href="<c:url value="/material/add" />">Thêm sản phẩm</a>
    </div>
    <c:url value="/material/index" var="action" />
    <form action="${action}">
        <div class="d-flex ">  
            <div >

                <input type="text" class="form-control" id="kw" placeholder="Từ khóa..." name="q">
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
                <th>Price</th>
                <th>Supplier</th>
                <th>Detail</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${material}" var="p">
                <tr id="material${p.id}">
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.price}VNĐ</td>
                    <td>${p.supplierId.name}</td>
                    <td>
                        <c:url value="/material/add/${p.id}" var="u" />
                        <a href="${u}" class="btn btn-success">&#9997</a>

                        <c:url value="/api/material/${p.id}" var="uD" />
                        <button onclick="deleteMaterial('${uD}', ${p.id})" class="btn btn-danger">&times;</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>



