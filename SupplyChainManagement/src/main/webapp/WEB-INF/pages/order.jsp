<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="container mt-5">
    <h2 class="text-center">Tạo Đơn Hàng Nhập</h2>
    <form id="orderForm">
        <div class="form-group">
            <label for="expectDate">Ngày Dự Kiến:</label>
            <input type="date" id="expectDate" name="expectDate" class="form-control" />
        </div>
        <div class="form-group">
            <label for="deliveryDate">Ngày Dự Kiến:</label>
            <input type="date" id="deliveryDate" name="deliveryDate" class="form-control" />
        </div>
        <div class="form-group">
            <label for="totalCost">Tổng Chi Phí:</label>
            <input type="number" step="0.01" id="totalCost" name="totalCost" class="form-control" />
        </div>
        <div class="form-group text-right">
            <button type="button" class="btn btn-success" id="addProductBtn">Thêm Sản Phẩm</button>
        </div>
        <div class="form-group">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Mã sản phẩm</th>
                        <th>Số lượng</th>
                        <th>Thao tác</th>
                    </tr>
                </thead>
                <tbody id ="materials">

                </tbody>
            </table>
        </div>
        <button class="btn btn-primary" onclick="Create(event)">Tạo Đơn Hàng</button>
    </form>
</div>
<div id="counter" data-value="1" style="display: none;"></div>
<!-- <script src="<c:url value="/js/order.js" />"></script>-->
<script>

    var jsonData = {
        details: []
    };
//let materials 
//function setMaterial(material){
//    materials= material;
//}
    let productIndex = 0;

    document.addEventListener('DOMContentLoaded', function () {

        console.log(productIndex);
        // Xử lý thêm sản phẩm
        document.getElementById('addProductBtn').addEventListener('click', function () {
            const tbody = document.getElementById('materials');
            jsonData = {...jsonData, details: [...jsonData.details, {
                        materialId: null,
                        quantity: null
                    }]};

            // Tạo dòng mới
            const newRow = document.createElement('tr');
            newRow.classList.add('materials');
            newRow.innerHTML = `
            <td>
                <select id="details[\${productIndex}].materialId" class="form-control" onchange="setDetailsMaterial(\${productIndex})" required>
                    <option value="" label="-- Chọn sản phẩm --"></option>
    <c:forEach var="material" items="${materials}">
                        <option value="${material.id}">${material.name}-${material.price}</option>
    </c:forEach>
                </select>
            </td>
            <td>
                <input type="number" step="1.0" id="details[\${productIndex}].quantity" class="form-control" onchange="setDetailsQuantity(\${productIndex})" required />
            </td>
            <td>
                <button type="button" class="btn btn-danger remove-btn">Xóa</button>
            </td>
        `;

            // Thêm dòng mới vào bảng
            tbody.appendChild(newRow);
            productIndex++;
        });

        // Xử lý xóa sản phẩm
        document.getElementById('materials').addEventListener('click', function (event) {
            if (event.target.classList.contains('remove-btn')) {
                const row = event.target.closest('tr');
                const index = Array.from(row.parentNode.children).indexOf(row);
                console.log(index);
                jsonData.details.splice(index, 1);
                row.remove();
                productIndex--;
            }
        });
    });
    const setDetailsMaterial = (index) => {
        const value = document.getElementById(`details[\${index}].materialId`).value;

        jsonData.details[index].materialId = parseInt(value, 10);

    }
    const setDetailsQuantity = (index) => {
        if (jsonData.details[index]) {
            let value = document.getElementById(`details[\${index}].quantity`).value;
            jsonData.details[index].quantity = parseInt(value, 10);
        } else {
            console.error(`Index ${index} không tồn tại trong jsonData.details`);
        }
//        jsonData.details[index].quantity = document.getElementById(`details[${index}].quantity`).value;

    }
    
    const Create = (e) => {
        e.preventDefault();

        var v = document.getElementById("expectDate").value.split("-");
        var v1 = document.getElementById("deliveryDate").value.split("-");
        var url = "<c:url value="/orders/add" />";

        
        jsonData = {
            ...jsonData, expectDate: `\${v[2]}/\${v[1]}/\${v[0]}`,
            totalCost: document.getElementById("totalCost").value,
             deliveryDate: `\${v1[2]}/\${v1[1]}/\${v1[0]}`
        }
        console.log(url);
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(jsonData)
        }).then(function (response) { console.log(response);
                    if (!response.ok) {
                        throw new Error('Có lỗi xảy ra khi tạo hợp đồng. Vui lòng thử lại sau.');
                    }
                })
                .then(function (data) {
                    console.log('Response:', data);
                    alert('Hợp đồng đã được tạo thành công!');
                    
                })
                .catch(function (error) {
                    console.error('Error:', error);
                    alert('Đã xảy ra lỗi khi tạo hợp đồng. Vui lòng thử lại!');
                });


    }
</script>