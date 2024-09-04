<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<style>
    .chart-container {
        margin: 10px;

    }
    .chart-container1 {
        margin: 10px;
    }
    .table-container {
        width: 50%;
        right : 5px;
        height: 100%;
        overflow-x: auto;
        width: 50%;

    }
    .table {
        width: 100%;
        margin-left:  50px;

    }
    .row1{
        
        justify-content: center;
        margin-bottom: 100px;
        background-color: whitesmoke;
        margin: 10px;
        padding: 10px;
        height: 330px;
    }
    

    .btn-container {
        position: absolute;
        bottom: 10px; /* Khoảng cách từ đáy */
        right: 10px; /* Khoảng cách từ cạnh phải */
    }
    .row2{
        display: flex;
        justify-content: center;
        margin-bottom: 100px;
       background-color: whitesmoke;
        margin: 10px;
        padding: 10px;
    }
    #r2{
         display: none;
         height: 250px;
    }
</style>
<div class ="container"> 
    <div>
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
    </div>
    <div>

        <form action="${action}">
            <div>
                <!-- Hidden input field to send a default value for parameter "p" -->
                <input type="hidden" name="name" value="">
                <button class="btn btn-info" type="submit" >Xem tất cả</button>
            </div>
        </form>
    </div>
</div>

<div class="row1" id="r1">
    <div class="col-md-6 col-12">
        <div class="chart-container">
            <canvas id="myChart"></canvas>
        </div>
    </div>

    <div class="table-container">
        <!-- Bảng thống kê của bạn ở đây -->
        <table class="table">
            <thead>
                <tr>
                    <th>chi tiết</th>
                    <th>Tên nhà cung  cấp</th>
                    <th>Đánh Giá Giao Hàng</th>
                    <th>Đánh Giá Chất Lượng</th>
                    <th>Đánh Giá Về Giá Cả</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dto" items="${superFor}">
                    <tr>
                        <td>
                            <form action="${action}">
                                <div>
                                    <!-- Hidden input field to send a default value for parameter "p" -->
                                    <input type="hidden" name="name" value="${dto[0]}">
                                    <button class="btn btn-info" type="submit" >Xem Đánh Giá</button>
                                </div>
                            </form>
                        </td>
                        <td>${dto[0]}</td>
                        <td>${dto[1]}</td>
                        <td>${dto[2]}</td>
                        <td>${dto[3]}</td>

                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </div>
</div>
<div class="row2" id="r2">
    <div class="col-md-6 col-12">
        <div class="chart-container">
            <canvas id="myChart1"></canvas>
        </div>
    </div>

    <div class="table-container">
        <!-- Bảng thống kê của bạn ở đây -->
        <table class="table">
            <thead>
                <tr>
                    <th>Tháng</th>
                    <th>Đánh Giá Giao Hàng</th>
                    <th>Đánh Giá Chất Lượng</th>
                    <th>Đánh Giá Về Giá Cả</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dto" items="${superFor1}">
                    <tr>
                        <td>${dto[1]}</td>
                        <td>${dto[3]}</td>
                        <td>${dto[4]}</td>
                        <td>${dto[5]}</td>

                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </div>
</div>



<script>
    const Detail = () => {
        document.getElementById('r1').style.display = 'none';
        document.getElementById('r2').style.display = 'block';
        
    };
    const All = () => {
        document.getElementById('r1').style.display = 'block';
        document.getElementById('r2').style.display = 'none';
    };
    window.onload = function () {
        const urlParams = new URLSearchParams(window.location.search);
        const nameParam = urlParams.get('name');

        if (nameParam) {
        // Nếu có tham số "name", ẩn r2 và hiện r1
            document.getElementById('r1').style.display = 'none';
            document.getElementById('r2').style.display = 'block';
        } else {
        // Nếu không có tham số "name", ẩn r1 và hiện r2
            document.getElementById('r1').style.display = 'block';
            document.getElementById('r2').style.display = 'none';
        }
        // Dữ liệu cho biểu đồ
        let labels = [];
        let data = [];
        let labels1 = [];
        let data1 = {
            labels: [],
            datasets: []
        };

        let data2 = [];
        let data3 = [];

        // Lấy dữ liệu cho biểu đồ đầu tiên
    <c:forEach items="${superFor}" var="r">
        labels.push('${r[0]}');
        var avgRating = (${r[1]} + ${r[2]} + ${r[3]}) / 3;
        data.push(${r[1]});
        data2.push(${r[2]});
        data3.push(${r[3]});
    </c:forEach>

        // Lấy dữ liệu cho biểu đồ thứ hai
    <c:forEach items="${superFor1}" var="r1">
        {
            // Tạo một block scope mới để tránh lỗi khai báo lại
            const labelValue = '${r1[0]}'; // Lấy giá trị từ server
            const newData = (${r1[3]} + ${r1[4]} + ${r1[5]}) / 3; // Lấy giá trị từ server

            // Kiểm tra xem dataset đã tồn tại chưa
            let existingDataset = data1.datasets.find(dataset => dataset.label === labelValue);

            if (!existingDataset) {
                // Nếu chưa có dataset nào với label này, tạo mới
                existingDataset = {
                    label: labelValue,
                    data: [],
                    fill: false,
                    tension: 1.0
                };
                data1.datasets.push(existingDataset);
            }

            // Thêm dữ liệu vào dataset hiện tại
            existingDataset.data.push(newData);

            // Thêm label mới vào data1.labels nếu chưa có
            if (!data1.labels.includes('${r1[1]}')) {
                data1.labels.push('${r1[1]}');
            }
        }
    </c:forEach>

        console.log(data1);

        // Tạo biểu đồ đầu tiên
        const ctx = document.getElementById('myChart').getContext('2d');
        new Chart(ctx, {
            type: 'bar', // Loại biểu đồ
            data: {
                labels: labels,
                datasets: [{
                        label: 'giao hàng',
                        data: data,
                        borderWidth: 1
                    }, {
                        label: 'chất lượng',
                        data: data2,
                        borderWidth: 1
                    }, {
                        label: 'giá cả',
                        data: data3,
                        borderWidth: 1
                    }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true // Trục Y bắt đầu từ 0
                    }
                }
            }
        });

        // Tạo biểu đồ thứ hai
        const ctx1 = document.getElementById('myChart1').getContext('2d');
        new Chart(ctx1, {
            type: 'line', // Loại biểu đồ
            data: data1,
            options: {
                scales: {
                    y: {
                        beginAtZero: true // Trục Y bắt đầu từ 0
                    }
                }
            }
        });
    };
</script>



