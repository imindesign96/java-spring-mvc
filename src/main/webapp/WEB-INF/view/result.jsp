<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Result - Table Users</title>
            <!-- Bootstrap CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        </head>

        <body>
            <div class="container mt-4">
                <h1 class="mb-4">Table users</h1>
                <a href="/admin/user/createUser" class="btn btn-primary float-end mb-3">Create a user</a>

                <div class="table-responsive">
                    <table class="table table-bordered table-hover">
                        <thead class="table-light">
                            <tr>
                                <th>ID</th>
                                <th>Email</th>
                                <th>Full Name</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.email}</td>
                                    <td>${user.fullName}</td>
                                    <td>
                                        <div class="d-flex gap-2">
                                            <button class="btn btn-success" onclick="viewUser(${user.id})">View</button>
                                            <button class="btn btn-warning"
                                                onclick="updateUser(${user.id})">Update</button>
                                            <button class="btn btn-danger"
                                                onclick="deleteUser(${user.id})">Delete</button>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Bootstrap JS and Popper.js (required for some Bootstrap features) -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
            <script>
                function viewUser(id) {
                    alert("Viewing user with ID: " + id);
                    // Thêm logic để chuyển hướng hoặc gọi API xem chi tiết
                }

                function updateUser(id) {
                    alert("Updating user with ID: " + id);
                    // Thêm logic để chuyển hướng hoặc gọi API cập nhật
                }

                function deleteUser(id) {
                    if (confirm("Are you sure you want to delete user with ID: " + id + "?")) {
                        alert("User with ID " + id + " deleted");
                        // Thêm logic để gọi API xóa
                    }
                }
            </script>
        </body>

        </html>