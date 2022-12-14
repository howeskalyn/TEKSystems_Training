<!-- library imports -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>ShowSeek</title>

            <!-- using external css & js -->
            <link rel="stylesheet" href="/pub/index.css">
            <script src="pub/index.js"></script>

            <!-- font awesome -->
            <script src="https://kit.fontawesome.com/e951204ff9.js" crossorigin="anonymous"></script>

            <!-- Bootstrap -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
                crossorigin="anonymous">

            <!-- JQuery -->
            <script src="https://code.jquery.com/jquery-3.6.1.js"
                integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>

            <style>
                .btn {
                    background-color: #FF6E51;
                }
            </style>
        </head>

        <body>

            <!-- Navigation Bar -->
            <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
                <div class="container-fluid">
                    <img src="/pub/images/LogoFINAL.png" alt="Logo" style="height: 100px">
                    <h1>ShowSeek</h1>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse ms-5 justify-content-end" id="mynavbar">
                        <ul class="navbar-nav me-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="/">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/events">Events</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/profile">Profile</a>
                            </li>
                            <sec:authorize access="isAuthenticated()">
                                <li class="nav-item">
                                    <a class="nav-link" href="/usersearch">Add Friends</a>
                                </li>
                            </sec:authorize>
                            <sec:authorize access="isAuthenticated()">
                                <li class=" nav-item">
                                    <a class="nav-link" href="/user/logout">Logout</a>
                                </li>
                            </sec:authorize>
                            <sec:authorize access="!isAuthenticated()">
                                <li class=" nav-item">
                                    <a class="nav-link" href="/user/login">Login</a>
                                </li>
                            </sec:authorize>
                        </ul>
                        <form class="d-flex">
                            <input class="form-control me-2" type="text" placeholder="Events or artists...">
                            <button class="btn btn-dark" type="button">Search</button>
                        </form>
                    </div>
                </div>
            </nav>