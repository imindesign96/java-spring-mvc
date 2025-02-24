<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Update Result</title>
            <!-- Bootstrap CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        </head>

        <body>
            <div class="container mt-4">
                <h1>Update Result</h1>
                <c:if test="${not empty userInfo}">
                    <div class="alert alert-success">
                        User updated successfully!<br>
                        ID: ${userInfo.id}<br>
                        Email: ${userInfo.email}<br>
                        Full Name: ${userInfo.fullName}<br>
                        Address: ${userInfo.address}<br>
                        PhoneNumber: ${userInfo.phone}
                    </div>
                </c:if>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">
                        ${error}
                    </div>
                </c:if>
                <a href="/admin/user" class="btn btn-secondary">Back to Users</a>
            </div>

            <!-- Bootstrap JS -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        </body>

        </html>