<!-- library imports -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


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

            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
                crossorigin="anonymous">

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
                                <a class="nav-link" href="/artists">Artists</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/profile">Profile</a>
                            </li>
                        </ul>
                        <form class="d-flex">
                            <input class="form-control me-2" type="text" placeholder="Events or artists...">
                            <button class="btn btn-dark" type="button">Search</button>
                        </form>
                    </div>
                </div>
            </nav>