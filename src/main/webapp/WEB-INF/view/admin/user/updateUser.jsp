<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Update user information</title>


        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <!-- <link href="css/demo.css" rel="stylesheet"> -->
    </head>

    <body>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 col-12 mx-auto">
                    <h2>Update user information</h2>
                    <hr />
                    <form:form method="POST" action="/admin/user/update" modelAttribute="updateUser">

                        <!-- Password -->
                        <div class="mb-3" style="display: none">
                            <label for="id" class="form-label">Id:</label>
                            <form:input path="id" cssClass="form-control" id="id" readonly="true" />
                        </div>


                        <!-- Email -->
                        <div class="mb-3">
                            <label for="email" class="form-label">Email:</label>
                            <form:input path="email" cssClass="form-control" id="email" disabled="true" />
                        </div>


                        <!-- Phone number -->
                        <div class="mb-3">
                            <label for="phone" class="form-label">Phone number:</label>
                            <form:input path="phone" cssClass="form-control" id="phone" />
                        </div>

                        <!-- Full Name -->
                        <div class="mb-3">
                            <label for="fullName" class="form-label">Full Name:</label>
                            <form:input path="fullName" cssClass="form-control" id="fullName" />
                        </div>

                        <!-- Address -->
                        <div class="mb-3">
                            <label for="address" class="form-label">Address:</label>
                            <form:input path="address" cssClass="form-control" id="address" />
                        </div>

                        <!-- Submit button -->
                        <button type="submit" class="btn btn-primary w-100">Update</button>
                    </form:form>
                </div>
            </div>

        </div>

    </body>

    </html>