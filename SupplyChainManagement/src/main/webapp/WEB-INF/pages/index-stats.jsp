<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<style>
    .chart-container {
        position: absolute;
        width: 50%; /* Chiếm toàn bộ chiều rộng của cột chứa */
        height: 300px; /* Chiều cao tùy chỉnh của biểu đồ */
    }
    .table-container {
        position: absolute;
        width: 50%;
        right : 5px;
        height: 200px;
        overflow-x: auto; /* Đảm bảo có thanh cuộn ngang nếu cần */
    }
    .table {
        width: 100%; /* Đảm bảo bảng chiếm toàn bộ chiều rộng của bảng chứa */
         /* Đảm bảo các cột có kích thước đồng nhất */
    }
    .row1{
        position: relative;
        height: 320px;
        width: 100%;
        border: 1px solid #000;
        padding: 10px;
        margin: 10px 0;
        box-sizing: border-box;
    }
    .btn-container {
    position: absolute;
    bottom: 10px; /* Khoảng cách từ đáy */
    right: 10px; /* Khoảng cách từ cạnh phải */
}
</style>

<div class="row1">
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
                    <th>Tên nhà cung  cấp</th>
                    <th>Đánh Giá Giao Hàng</th>
                    <th>Đánh Giá Chất Lượng</th>
                    <th>Đánh Giá Về Giá Cả</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dto" items="${superFor}">
                    <tr>
                        <td>${dto[0]}</td>
                        <td>${dto[1]}</td>
                        <td>${dto[2]}</td>
                        <td>${dto[3]}</td>

                    </tr>
                </c:forEach>
                   
            </tbody>
        </table>
       
    </div>
     <div class="btn-container">
            <a class="btn btn-info m-1" href="<c:url value="/stats/detail" />">xem chi tiết</a>
      </div>
</div>


<script>
    window.onload = function () {
        // Dữ liệu cho biểu đồ
        let labels = [];
        let data = [];
        var i = 0;
    <c:forEach items="${superFor}" var="r">
        labels.push('${r[0]}');
        var i = (${r[1]} +${r[2]} +${r[3]}) / 3;
        data.push(i);
    </c:forEach>
        console.log(data);

        // Lấy context của canvas để vẽ biểu đồ
        const ctx = document.getElementById('myChart').getContext('2d');

        // Tạo biểu đồ
        new Chart(ctx, {
            type: 'pie', // Loại biểu đồ
            data: {
                labels: labels,
                datasets: [{
                        label: '# Doanh thu',
                        data: data,
                        borderWidth: 1
                    }]
            }, // Dữ liệu của biểu đồ
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
