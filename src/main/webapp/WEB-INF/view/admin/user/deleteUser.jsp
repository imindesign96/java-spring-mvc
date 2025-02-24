<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Delete User ${id}</title>
                <!-- Bootstrap CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
            </head>

            <body>
                <div class="container mt-4">
                    <h1 class="mb-4">Delete User ${id}</h1>
                    <div class="alert alert-danger" role="alert">
                        Bạn có muốn xoá thông tin User có id : ${id} này không?
                    </div>
                    <form:form method="POST" action="/admin/user/delete" modelAttribute="deleteUser">
                        <div class="mb-3">
                            <label for="id" class="form-label">Id: ${id}</label>
                            <form:input path="id" cssClass="form-control" id="id" readonly="true" />
                        </div>
                        <!-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> -->
                        <button type="submit" class="btn btn-primary w-100">Confirm</button>
                    </form:form>
                </div>

                <!-- Bootstrap JS -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
            </body>

            </html>