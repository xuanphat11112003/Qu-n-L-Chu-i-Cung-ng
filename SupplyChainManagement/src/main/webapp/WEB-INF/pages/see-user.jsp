
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="<c:url value="/js/Product.js" />"></script>
<style>
    .rounded-img {
        border-radius: 50%;
    }
    #backgr{
        background-color: rgba(173, 216, 230, 0.9);

    }
</style>
<section class="container" id="backgr">
    <div class="col-md-10 col-12">
        <a class="btn btn-info m-1" href="<c:url value="/user/add" />">Thêm người dùng</a>
    </div>



    <c:url value="/product" var="action" />
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
                <th></th>
                <th>Name</th>
                <th>Role</th>
                <th>Phone</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${user}" var="p">
                <tr id="user${p.id}">
                    <td>${p.id}</td>
                    <td>
                        <img width="120" src="${p.avatar}" alt="${p.name}" style="border-radius: 50%;"/>
                    </td>
                    <td>${p.username}</td>
                    <td>${p.user_role}</td>
                    <td>${p.phone}</td>
                    <td>
                        <c:url value="/user/add/${p.id}" var="u" />
                        <a href="${u}" class="btn btn-success">&#9997</a>

                        <c:url value="/user/${p.id}" var="uD" />
                        <button onclick="deleteU('${uD}', ${p.id})" class="btn btn-danger">&times;</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>



