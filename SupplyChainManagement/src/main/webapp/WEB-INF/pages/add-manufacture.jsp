<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    .listChoose{

        position: absolute;
        top: 300px;
        width: 38%;
        border: 1px solid #ddd;
        margin-left: -13px;
        max-height: 60%;
        overflow-y: scroll;
    }
    .list-group{
        list-style-type: none;
        flex-direction: column;
        display: flex;
        gap: 10px;
    }
    .list-group-item {
        display: flex;
        padding: 10px;
        background-color: #f8f9fa; /* Màu nền */
    }
    .list-group-item span {
        flex: 1;
    }
    .list-group-item .quantity {
        margin-left: 15px;
    }
    #backgr{
        background-color: wheat;
        padding-left: 51px;
    }
</style>
<div class="container mt-5" id="backgr">
    <h1 class="text-center text-primary mt-1">QUẢN LÝ SẢN XUẤT SẢN PHẨM</h1>
    <div class="row">
        <!-- Phần chọn sản phẩm -->
        <div class="col-md-6">
            <div class="row">
                <h3>Chọn Sản Phẩm</h3>
                <select id="productSelect" class="form-control">
                    <c:forEach var="product" items="${product}">
                        <c:set var="isManufactureExists" value="false" />
                        <c:forEach var="manu" items="${manufacture}">
                            <c:if test="${manu.productId.id == product.id}">
                                <c:set var="isManufactureExists" value="true" />
                            </c:if>
                        </c:forEach>
                        <c:if test="${!isManufactureExists}">
                            <option value="${product.id}">${product.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Phần nút vật liệu -->
        <div class="col-md-6">
            <c:url value="/manufacture/add" var="action" />
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
            <h3>Chọn Vật Liệu</h3>
            <div id="materialButtons">
                <c:forEach var="material" items="${material}" >
                    <button style ="width: 120px; height: 50px; margin: 10px" type="button" class="btn btn-primary material-btn" data-id="${material.id}" data-name="${material.name}">
                        ${material.name}
                    </button>
                </c:forEach>
            </div>
        </div>
    </div>

    <!-- Phần hiển thị vật liệu đã chọn -->
    <div class="listChoose">
        <h3>Vật Liệu Được Chọn</h3>

        <span> Tên Sản phẩm <span style="margin-left: 30%"> số lượng</span></span>

        <ul id="selectedMaterials" class="list-group">

        </ul>
    </div>
    <div class="mt-4">
        <button id="submitButton" class="btn btn-success">Gửi Dữ Liệu</button>
    </div>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        // Xử lý sự kiện khi nhấn nút vật liệu
        document.querySelectorAll('.material-btn').forEach(button => {
            button.addEventListener('click', function () {
                var materialId = this.getAttribute('data-id');
                var materialName = this.getAttribute('data-name');

                var existingItem = document.querySelector(`#selectedMaterials li[data-id="\${materialId}"]`);

                if (existingItem) {
                    var quantityElement = existingItem.querySelector('.quantity');
                    var currentQuantity = parseInt(quantityElement.textContent);
                    quantityElement.textContent = currentQuantity + 1;
                } else {
                    var listItem = document.createElement('li');
                    listItem.className = 'list-group-item';
                    listItem.setAttribute('data-id', materialId);

                    listItem.innerHTML = `<span>\${materialName}</span><span style='margin-left: 15px' class="quantity">1</span> 
                    <button type="button" class="close" aria-label="Close" onclick="removeMaterial(this)">
                        <span aria-hidden="true">&times;</span>
                    </button>`;
                    document.getElementById('selectedMaterials').appendChild(listItem);
                }
            });
        });

        // Xử lý sự kiện khi nhấn nút gửi
        $('#submitButton').click(function () {
            var manufacture = {
                materials: []
            };

            $('#selectedMaterials li').each(function () {
                var materialId = $(this).data('id');
                var quantity = parseInt($(this).find('.quantity').text());

                manufacture.materials.push({
                    materialId: materialId,
                    quantity: quantity
                });
            });


            // Chuyển đổi dữ liệu thành JSON
            var productSelect = document.getElementById('productSelect').value;
            var productSelectInt = parseInt(productSelect, 10);
            var url = "<c:url value="/manufacture" />";
            console.log(productSelect);
            console.log("Dữ liệu JSON:", manufacture);
            manufacture = {...manufacture, productId: productSelectInt};
            console.log("Dữ liệu JSON:", manufacture);


            fetch(url, {// Thay thế bằng URL của máy chủ của bạn
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(manufacture)
            }).then(function (response) {
                console.log(response);
                if (!response.ok) {
                    throw new Error('Có lỗi xảy ra khi tạo hợp đồng. Vui lòng thử lại sau.');
                }
            }).then(function (data) {
                console.log('Response:', data);
                alert('Hợp đồng đã được tạo thành công!');
                window.location.reload();

            }).catch(function (error) {
                console.error('Error:', error);
                alert('Đã xảy ra lỗi khi tạo hợp đồng. Vui lòng thử lại!');
            });
        });
    });

    function removeMaterial(button) {
        button.closest('li').remove();
    }
</script>