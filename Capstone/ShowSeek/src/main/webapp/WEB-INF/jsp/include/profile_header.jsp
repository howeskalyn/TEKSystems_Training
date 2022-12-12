<jsp:include page="header.jsp" />

<div class="container-fluid">
    <div class="row flex-nowrap">
        <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark border-top border-light">
            <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
                <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
                    <h2 style="margin-top: 10px">Hey Rocker!</h2>
                    <li class="nav-item">
                        <a href="/profile" class="nav-link align-middle px-0">
                            <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">
                                <i class="fa-regular fa-user"></i> Profile</span>
                        </a>
                    </li>

                    <li>
                        <a href="/profileEvents" class="nav-link px-0 align-middle">
                            <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">
                                <i class="fa-solid fa-music"></i> Saved Events</span></a>
                    </li>

                    <li>
                        <a href="/profileFriends" class="nav-link px-0 align-middle">
                            <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">
                                <i class="fa-solid fa-users"></i> Friends</span> </a>
                    </li>

                    <li>
                        <a href="/user/logout" class="nav-link px-0 align-middle">
                            <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">
                                <i class="fa-solid fa-right-from-bracket"></i>Logout</span> </a>
                    </li>
                </ul>
            </div>
        </div>