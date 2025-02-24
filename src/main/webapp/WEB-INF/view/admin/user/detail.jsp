<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>User Detail ${id}</title>
            <!-- Bootstrap CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        </head>

        <body>
            <div class="container mt-4">
                <h1 class="mb-4">User Detail ${id}</h1>

                <ul class="list-group">
                    <li class="list-group-item">Id: ${id}</li>
                    <li class="list-group-item">Email: ${email}</li>
                    <li class="list-group-item">Full Name: ${fullName}</li>
                    <li class="list-group-item">Address: ${address}</li>
                </ul>

            </div>

        </body>

        </html>