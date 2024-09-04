<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    #backgrOrder{
         background-color: rgba(173, 216, 230, 1.0);
    }
</style>

<div class="container mt-5" id ="backgrOrder">
    <h2 class="text-center">Tạo Đơn Hàng Nhập</h2>
    <form id="orderForm">
        <div class="form-group">
            <label for="expectDate">Ngày Dự Kiến:</label>
            <input type="date" id="expectDate" name="expectDate" class="form-control" />
        </div>
        <div class="form-group">
            <label for="deliveryDate">Ngày Giao Hàng:</label>
            <input type="date" id="deliveryDate" name="deliveryDate" class="form-control" />
        </div>
        <div class="form-group">
            <label for="paymentOpt">Điều kiện thanh toán:</label>
            <select id ="bank" class="form-control" required>
                <option value=" " label="-- Chọn diều kiện thanh toán --"></option>
                <c:forEach var="payment" items="${paymentOpt}">
                    <option value="${payment}">${payment}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="Supplier">Nhà Cung Cấp:</label>         
            <select id ="supplier" class="form-control" onchange="loadMaterials()" required>
                <option value=" " label="-- Chọn nhà cung cấp --"></option>
                <c:forEach var="suppliers" items="${supplier}">
                    <option value="${suppliers.id}">${suppliers.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group text-right" class="form-control" >
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
        <button class="btn btn-primary" type="submit" onclick="Create(event)">Tạo Đơn Hàng</button>
    </form>
</div>
<div id="counter" data-value="1" style="display: none;"></div>

<script>

    var jsonData = {
        details: []
    };
    let materialMap = new Map();
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
                        
                     \${Array.from(materialMap).map(([id, { name, price }]) => `<option value="\${id}">\${name} - \${price}</option>`).join('')}
                        
                </select>
            </td>
            <td>
                <input type="number" step="1.0" id="details[\${productIndex}].quantity" class="form-control" onchange="setDetailsQuantity(\${productIndex})" required />
            </td>
            <td>
                <button type="button" class="btn btn-danger remove-btn">Xóa</button>
            </td>
        `

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
        if (jsonData.details.length === 0 || jsonData.details.some(detail => !detail.materialId || !detail.quantity)) {
            alert('Vui lòng thêm ít nhất một sản phẩm vào đơn hàng trước khi tạo.');
            return;
        }
        
        e.preventDefault();
        
        const expectDate = new Date(document.getElementById("expectDate").value);
        const deliveryDate = new Date(document.getElementById("expectDate").value);
        const v3 = document.getElementById("bank").value;
        if (!expectDate || !deliveryDate || !v3.trim()) {
            alert('Vui lòng điền đầy đủ thông tin: Ngày dự kiến, Ngày giao hàng và Điều kiện thanh toán.');
            return;
        }
        
        

            if (expectDate > deliveryDate) {
                alert('Ngày dự kiến không thể lớn hơn ngày giao hàng. Vui lòng kiểm tra lại.');
                return;
            }
        var url = "<c:url value="/api/orders/add" />";
        const v = document.getElementById("expectDate").value.split("-");
        const v1 = document.getElementById("deliveryDate").value.split("-");
        jsonData = {
            ...jsonData, expectDate: `\${v[2]}/\${v[1]}/\${v[0]}`,
            payment: v3 ,
            deliveryDate: `\${v1[2]}/\${v1[1]}/\${v1[0]}`
        }
        console.log(url);
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(jsonData)
        }).then(function (response) {
            console.log(response);
            if (!response.ok) {
                throw new Error('Có lỗi xảy ra khi tạo hợp đồng. Vui lòng thử lại sau.');
            }
        }).then(function (data) {
                    console.log('Response:', data);
                    alert('Hợp đồng đã được tạo thành công!');
                    window.location.reload();

                })
                .catch(function (error) {
                    console.error('Error:', error);
                    alert('Đã xảy ra lỗi khi tạo hợp đồng. Vui lòng thử lại!');
                });


    }
    const loadMaterials = () => {
        let supplierId = document.getElementById("supplier").value;
        const tbody = document.getElementById("materials");
        const rows = tbody.getElementsByTagName('tr');
        if (rows.length > 0) {  
            document.querySelectorAll("select[id^='details']").forEach(function (materialSelect, index) {     
                var url = "<c:url value="/api/getMaterialsBySupplier?q="/>";
                console.log(materialSelect);
                materialSelect.innerHTML = '<option value="" label="-- Chọn sản phẩm --"></option>';

                if (supplierId) {

                    fetch(url + supplierId)
                            .then(response => response.json())
                            .then(data => {
                                materialMap.clear();
                                data.forEach(function (material) {
                                    materialMap.set(material.id, { name: material.name, price: material.price });
                                    console.log(material.name);
                                    var option = document.createElement("option");
                                    option.value = material.id;
                                    option.text = material.name + '-' + material.price;
                                    materialSelect.add(option);
                                });
                            })
                            .catch(error => console.error('Error:', error));
                }
            });
        } else {
            alert("Vui lòng thêm sản phẩm trước.");
            document.getElementById("supplier").value = " ";
        }
    }
</script>