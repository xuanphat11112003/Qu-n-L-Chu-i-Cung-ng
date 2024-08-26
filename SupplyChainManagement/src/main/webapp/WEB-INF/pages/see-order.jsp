<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 

<link   href="<c:url value="/css/orderdetail.css"/>"  rel="stylesheet" />
<style>
    .bill {
        display: flex;
        flex-direction: row-reverse;
        flex-wrap: wrap;

        justify-content: center;
        align-items: center;

    }

    .containers {
        margin: 10px;
        width: 400px; /* Chiều rộng của containers là 20% của vùng chứa */
        padding: 10px;
        border: 6px solid #ddd;
        border-radius: 8px;
        .footer {
            text-align: center;
            margin-top: 20px;
        }
    }
    #overlay {
        display: none;
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: rgba(0, 0, 0, 0.5); /* Overlay màu đen với độ mờ 50% */
        z-index: 999;
    }
    #formContainer {
        display: none;
        position: fixed; /* Position it relative to the viewport */
        top: 50%; /* Center vertically */
        left: 50%; /* Center horizontally */
        transform: translate(-50%, -50%); /* Adjust positioning */
        background-color: #fff; /* White background */
        border: 1px solid #ccc; /* Border for the form */
        border-radius: 8px; /* Rounded corners */
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Shadow for better visibility */
        padding: 20px; /* Padding inside the form */
        width: 80%; /* Width of the form */
        max-width: 600px; /* Max width of the form */
        z-index: 1000; /* Ensure the form is on top of other content */
    }
    .form-group label {
        display: block;
        margin-bottom: 5px;
    }
    .form-group input {
        width: 100%;
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
    }

</style>
<div id="overlay"></div>

<div class ="d-flex flex-row-reverse">
    <c:url value="/orders" var="action" />
    <form class="row g-3" action="${action}">
        <div class="col-auto">
            <input type="text" class="form-control" id="kw" placeholder="Mã đơn hàng..." name="q">
        </div>
        <div class="col-auto">
        </div>
        <div class="col-auto">
            <select id ="date" name="dateFilter" class="form-control" >
                <option value="" label="-- lọc theo ngày --"></option>
                <option value="newest">Ngày mới nhất</option>
                <option value="oldest">Ngày cũ nhất</option>
            </select>
        </div>
        <div class="col-auto">
            <select id ="date" name="confirmationFilter" class="form-control" >
                <option value="" label="-- lọc theo xác nhận --"></option>
                <option value="confirmed">đã xác nhận</option>
                <option value="unconfirmed">chưa xác nhận</option>
            </select>
        </div>
        <div class="col-auto">
            <button class="btn btn-info" type="submit">Tìm kiếm</button>
        </div>
        <div class="col-auto">
            <a class="btn btn-secondary" style=" float: right;"href="<c:url value="/orders/add"/>" >
                Tạo Hóa Đơn
            </a>
        </div>
    </form>


</div>
<div class = "bill">
    <c:forEach var="entry" items="${groupedOrderDetails}">
        <div class="containers mt-5" >
            <!-- Invoice Header -->

            <c:forEach var="detail" items="${entry.value}" varStatus="status">
                <c:if test="${status.first}">
                    <div class="invoice-header text-center">
                        <h1>Invoice</h1>
                        <p>Supllier Name: ${detail[7]}</p>
                        <p>${detail[8]}</p>
                        <p>Phone: ${detail[9]} </p>
                    </div>

                    <!-- Invoice Details -->
                    <div class="row">
                        <div class="col-md-6 ">
                            <h4>Invoice Details</h4>
                            <p><strong>Invoice ID:</strong>  ${entry.key}</p>
                            <p><strong>Delivery Date:</strong> ${detail[5]}</p>
                            <p><strong>Expect Date:</strong> ${detail[4]}</p>
                        </div>
                    </div>

                    <!-- Invoice Table -->
                    <div class="invoice-table">
                        <h4 class="mb-3">Invoice Items</h4>
                        <table class="table table-bordered">
                            <thead>
                                <tr>     
                                    <th >Material Name</th>
                                    <th>Quantity</th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>${detail[1]}</td>
                                    <td>${detail[2]}</td>
                                    <c:set var="totalValue" value="${detail[3]}" />
                                    <c:set var="Active" value="${detail[6]}" />
                                    <c:set var="A" value="${detail[10]}" />
                                    <c:set var="ids" value="${detail[11]}" />

                                </tr>
                            </c:if>
                            <!-- Hiển thị các hàng còn lại -->
                            <c:if test="${!status.first}">
                                <tr>
                                    <td>${detail[1]}</td>
                                    <td>${detail[2]}</td>

                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <th colspan="3" class="text-end">total</th>
                            <td>${totalValue}</td>
                        </tr>

                    </tfoot>

                </table>
            </div>

            <!-- Footer -->
            <div class="footer">
                <c:choose>
                    <c:when test="${Active != false}">
                        <button type="button" class="btn btn-primary">Đã Xác Nhận</button>
                        <c:if test="${A != true}">
                            <div class="col-md-10 col-12">
                                <a class="btn btn-info m-1" href="<c:url value="/supplier/evaluate/add/${entry.key}/${ids}" />">Đánh giá nhà cung cấp</a>
                            </div>
                        </c:if>

                    </c:when>
                    <c:otherwise>
                        <c:url value="/api/updateStatus/${entry.key}" var="updateUrl" />

                        <button type="submit" class="btn btn-danger" onclick="confirmAndUpdateStatus('${updateUrl}', ${entry.key})">chưa xác nhận</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div id="formContainer" style="display: none;">
            <form id="updateForm">
                <div style="display: none;" id = "orderid">Code Order: </div>
                <div class="form-group">
                    <label for="entryDate">Ngày Nhập:</label>
                    <input type="date" id="entryDate" name="entryDate" required>
                </div>
                <div class="form-group">
                    <label for="warehouseName">Tên Kho:</label>
                    <select id ="wareH" class="form-control" required>
                        <option value=" " label="-- Chọn kho hàng --"></option>
                        <c:forEach var="war" items="${warehouse}">
                            <option value="${war.id}">${war.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <input type="hidden" id="hiddenInvoiceId" name="invoiceId">
                <button type="submit" class="btn btn-primary">Cập Nhật</button>
                <button type="button" class="btn btn-secondary" onclick="closeForm()">Hủy</button>
            </form>
        </div>
    </c:forEach>
</div>

<script>
    function confirmAndUpdateStatus(updateUrl, invoiceId) {
//        var confirmed = confirm("Bạn có chắc chắn muốn xác nhận không?");
        document.getElementById('overlay').style.display = 'block';
        document.getElementById('formContainer').style.display = 'block';
        document.getElementById('hiddenInvoiceId').value = invoiceId;
        document.getElementById('orderid').style.display = 'block';
        document.getElementById('orderid').innerText = "Code Order: " + invoiceId;

    }
    function closeForm() {
        // Ẩn lớp phủ và form
        document.getElementById('formContainer').style.display = 'none';
        document.getElementById('overlay').style.display = 'none';
    }
    document.getElementById('updateForm').addEventListener('submit', function (event) {
        event.preventDefault();
        var jsonData = {};
        const v = document.getElementById("entryDate").value.split("-");
        const v1 = document.getElementById("wareH").value;
        const v2 = document.getElementById('hiddenInvoiceId').value.toString();
        jsonData = {
            "orderid": v2,
            "entryDate": `\${v[2]}/\${v[1]}/\${v[0]}`,
            "warehouse": v1
        }

        var updateUrl = "<c:url value="/updateStatus" />";

        var formData = new FormData(this);

        fetch(updateUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(jsonData)
        }).then(response => {
            console.log(response);
            if (response.status === 200) {
                alert('Hợp đồng đã được tạo thành công!');
                window.location.reload();
                // Ẩn form và lớp phủ
            } else {
                alert("Cập nhật thất bại, vui lòng thử lại.");
            }
        })
                .catch(error => {
                    console.error('Error:', error);
                });
    });

</script>
