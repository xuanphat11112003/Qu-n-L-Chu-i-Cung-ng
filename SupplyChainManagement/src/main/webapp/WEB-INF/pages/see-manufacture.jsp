<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    .product-container {
        margin-bottom: 20px;
    }
    .product-title {
        font-size: 1.5rem;
        font-weight: bold;
        margin-bottom: 10px;
    }

    .list-group {
        display: flex;
        flex-direction: column;
        padding: 8px 0;
        /*        border-bottom: 1px solid #ddd;*/
        padding: 8px 0;
    }
    .list-group-item{
        width: 100%;
        display: flex;
        padding: 10px;

    }
    .list-group-item:last-child {
        border-bottom: 1px solid;
    }

    .material-name {
        flex: 1;
    }
    .material-quantity {
        width: 100px;
        text-align: center;
    }
</style>

<div >
    <a class="btn btn-info m-1" href="<c:url value="/manufacture/add" />">Thêm Công Thức Sản Xuất</a>
</div>
<section class="container">
    <div class="container mt-4">

        <div class="row">
            <c:forEach var="entry" items="${gruop}">
                <div class="col-md-12 product-container">
                    <div class="product-title">${entry.key}</div>
                    <ul class="list-group">
                        <c:forEach var="detail" items="${entry.value}">
                            <li class="list-group-item">
                                <span class="material-name">${detail.material}</span>
                                <span class="material-quantity">${detail.amout}</span>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </c:forEach>
        </div>
        <c:url value="/api/material/${p.id}" var="uD" />
        <button onclick="deleteMaterial('${uD}', ${p.id})" class="btn btn-danger">Xóa</button>
    </div>

</section>
