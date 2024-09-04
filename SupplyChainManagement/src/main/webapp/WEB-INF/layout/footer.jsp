<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    footer {
    margin-top: 10%;
    background: linear-gradient(to bottom, rgba(255, 255, 255, 0.8), rgba(211, 211, 211, 0.8)); 
    color: #333;
    padding: 20px 0;
    width: 100%;
    position: relative; 
   
}

.footer-container {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.footer-logo {
    display: flex;
    align-items: center;
    margin-bottom: 20px;
}

.footer-logo img {
    width: 60px;
    margin-right: 10px;
}

.footer-info {
    text-align: center;
}

.footer-info h1 {
    font-size: 24px;
    margin: 0;
}

.footer-info p {
    margin: 5px 0 0;
}

.footer-columns {
    display: flex;
    justify-content: space-around;
    width: 100%;
    max-width: 1200px;
}

.footer-column {
    margin: 0 15px;
}

.footer-column h5 {
    margin-bottom: 15px;
    font-weight: bold;
}

.footer-column ul {
    list-style: none;
    padding: 0;
}

.footer-column ul li {
    margin-bottom: 10px;
}

.footer-column ul li a {
    color: #333;
    text-decoration: none;
}

.footer-column ul li a:hover {
    text-decoration: underline;
}
</style>
<footer>
    <div class="footer-container">
        <div class="footer-logo">
            <img src="https://eduplus.edu.vn/wp-content/uploads/2020/12/dhmohcm.png" alt="Logo">
            <div class="footer-info">
                <h1>Supply-Chain Admin &copy; 2024</h1>
                <p>Faculty of Information Technology, Ho Chi Minh City Open University.</p>
            </div>
        </div>

        <div class="footer-columns">
            <div class="footer-column">
                <h5>Thông Tin</h5>
                <ul>
                    <li><a href="#">Về chúng tôi</a></li>
                    <li><a href="#">Liên hệ</a></li>
                    <li><a href="#">Điều khoản dịch vụ</a></li>
                </ul>
            </div>

            <div class="footer-column">
                <h5>Hỗ Trợ</h5>
                <ul>
                    <li><a href="#">Câu hỏi thường gặp</a></li>
                    <li><a href="#">Hỗ trợ kỹ thuật</a></li>
                    <li><a href="#">Hướng dẫn sử dụng</a></li>
                </ul>
            </div>

            <div class="footer-column">
                <h5>Kết Nối</h5>
                <ul>
                    <li><a href="#">Facebook</a></li>
                    <li><a href="#">Twitter</a></li>
                    <li><a href="#">LinkedIn</a></li>
                </ul>
            </div>
        </div>
    </div>
</footer>
