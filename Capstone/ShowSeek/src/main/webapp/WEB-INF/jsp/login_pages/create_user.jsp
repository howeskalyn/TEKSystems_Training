<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>

        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
    </head>

    <body>

        <div class="container">
            <div class="row mt-3 mb-1">
                <h2>Create User</h2>
            </div>

            <form action="/user/createuser">
                <div class="row">
                    <div class="mb-3 col-3">
                        <label for="firstName" class="form-label">First Name</label>
                        <input type="text" name="firstName" class="form-control" id="firstName"
                            aria-describedby="firstNameHelp">
                        <div id="firstNameHelp" class="form-text">Enter your first name</div>
                    </div>

                    <div class="mb-3 col-3">
                        <label for="lastName" class="form-label">Last Name</label>
                        <input type="text" name="lastName" class="form-control" id="lastName"
                            aria-describedby="lastNameHelp">
                        <div id="lastNameHelp" class="form-text">Enter your last name</div>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail1"
                        aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else</div>
                </div>

                <div class="row">
                    <div class="mb-3 col-6">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" name="password" class="form-control" id="password"
                            aria-describedby="passwordHelp">
                        <div id="passwordHelp" class="form-text">Enter your password</div>
                    </div>

                    <div class="mb-3 col-6">
                        <label for="confirmPassword" class="form-label">Confirm Password</label>
                        <input type="password" name="confirmPassword" class="form-control" id="confirmPassword" </div>
                    </div>
                </div>

                <div class="row">
                    <div class="mb-3 col-4">
                        <label for="phone" class="form-label">Phone</label>
                        <input type="text" name="phone" class="form-control" id="phone" aria-describedby="phoneHelp">
                        <div id="phoneHelp" class="form-text">Enter your phone number</div>
                    </div>

                    <div class="mb-3 col-4">
                        <label for="zip" class="form-label">Zip</label>
                        <input type="text" name="zip" class="form-control" id="zip" aria-describedby="zipHelp">
                        <div id="zipHelp" class="form-text">Enter your zip code</div>
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>

    </body>

    </html>