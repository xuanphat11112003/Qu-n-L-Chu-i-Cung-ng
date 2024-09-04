<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
        .backgr {
             background: linear-gradient(to right, rgba(108, 132, 204, 0.9), rgba(102, 179, 255, 0.9));
            width: 100%;
      
            padding: 20px;
            height: 300px;
            position: relative;
        }
        .table {
            
            margin-bottom: 20px; 
            position: absolute;
            width: 95%
        }
        .table th, .table td {
            text-align: center; 
        }
        .table-striped tbody tr:nth-of-type(odd) {
            background-color: #cdeafb; 
        }
        .table-hover tbody tr:hover {
            background-color: #e0e0e0; 
        }
        .table-bordered th, .table-bordered td {
            border: 1px solid #dee2e6; 
        }
        .container {
            max-width: 1200px;
        }
    </style>

<section class = "backgr">
    <div class="container mt-4">
        <h2 class="mb-4">Material Stock Details</h2>

        <!-- Table to display the material stock details -->
        <table class="table table-bordered table-striped table-hover">
            <thead>
                <tr>
                    <th>Material ID</th>
                    <th>Material Name</th>
                    <th>Warehouse ID</th>
                    <th>Warehouse Name</th>
                    <th>Total Amount</th>
                </tr>
            </thead>
            <tbody>
                <!-- Iterate over the materialStock list -->
                <c:forEach var="stock" items="${materialStock}">
                    <tr>
                        <td><c:out value="${stock[1]}"/></td> <!-- Material ID -->
                        <td><c:out value="${stock[2]}"/></td> <!-- Material Name -->
                        <td><c:out value="${stock[3]}"/></td> <!-- Warehouse ID -->
                        <td><c:out value="${stock[4]}"/></td> <!-- Warehouse Name -->
                        <td><c:out value="${stock[0]}"/></td> <!-- Total Amount -->
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</section>