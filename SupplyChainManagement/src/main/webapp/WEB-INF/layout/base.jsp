
<%-- 
    Document   : base
    Created on : Jul 15, 2024, 7:38:30 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<style>
    body{
        background:
            linear-gradient(rgba(0, 128, 255, 0.5), rgba(255, 255, 255, 0.5)),
            url('https://trangtuyensinh.com.vn/wp-content/uploads/2022/02/chuong-trinh-dao-tao-nganh-logistics-va-quan-ly-chuoi-cung-ung-trang-tuyen-sinh.jpg');
/*        background-blend-mode: darken;*/
        background-size: cover;
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: center;
        margin: 0;
        padding: 0;
        min-height: 100vh;

    }
    html,body{
        height: 100%;
    }
    footer{
        position: fixed;
        bottom: 0px;
        width: 100%;
    }
    
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title" />
        </title>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="<c:url value="/js/main.js" />"></script>
        <link rel="stylesheet" href="<c:url value='/css/styles.css' />">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <tiles:insertAttribute name="header" />

        <div class="container">
            <tiles:insertAttribute name="content" />
        </div>

        <tiles:insertAttribute name="footer" />
    </body>
</html>
