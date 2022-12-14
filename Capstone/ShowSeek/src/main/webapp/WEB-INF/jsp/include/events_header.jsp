<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="../include/header.jsp" />

        <div class="container-fluid">
            <div class="row flex-nowrap">
                <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark border-top border-light">
                    <div
                        class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
                        <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start"
                            id="menu">

                            <sec:authorize access="isAuthenticated()">
                                <h2 style="margin-top: 10px; margin: 0px; padding-top: 10px;">Welcome ${user.first_name}
                                </h2>
                                <li class="nav-item">
                                    <a href="/" class="nav-link align-middle px-0">
                                        <span type="button"
                                            class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">
                                            <i class="fa-solid fa-sign-out"></i> Logout</span>
                                    </a>
                                </li>
                            </sec:authorize>

                            <sec:authorize access="!isAuthenticated()">
                                <h2 style="margin-top: 10px; margin: 0px; padding-top: 10px;">Welcome Guest</h2>
                            </sec:authorize>

                            <h4 style="margin-top: 20px; color: rgb(163, 157, 157)">Sort Events By: </h4>

                            <li class="nav-item">
                                <a href="/events" class="nav-link align-middle px-0">
                                    <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">
                                        <i class="fa-solid fa-calendar"></i> - Date (Prev-Now)</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/eventsprice" class="nav-link align-middle px-0">
                                    <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">
                                        <i class="fa-solid fa-dollar-sign"></i> - Price (Low-High)</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/eventsartist" class="nav-link align-middle px-0">
                                    <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">
                                        <i class="fa-solid fa-person"></i> - Artist (A-Z)</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/eventsvenue" class="nav-link align-middle px-0">
                                    <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">
                                        <i class="fa-solid fa-location-dot"></i> - Venue( A-Z)</span>
                                </a>
                            </li>

                        </ul>
                    </div>
                </div>
                <!-- event cards ordered by date -->
                <div class="row row-cols-4 row-cols-sm-3 w-75 mx-auto">
                    <c:forEach items="${events}" var="event">
                        <div class="col">
                            <div class="card h-200 w-60 shadow" style="margin: 10px;">
                                <img src="${event.image}" class="card-img-top" alt="Promo Image">
                                <div class="card-body">
                                    <h5 class="card-title" style="color: black;">${event.artist}</h5>
                                    <p class="card-text m-2" style="font-family: Arial, Helvetica, sans-serif"><i
                                            class="fa-solid fa-location-dot"></i> ${event.venue}</p>
                                    <p class="card-text m-2" style="font-family: Arial, Helvetica, sans-serif"><i
                                            class="fa-solid fa-calendar"></i> ${event.date}</p>
                                    <p class="card-text m-2" style="font-family: Arial, Helvetica, sans-serif"><i
                                            class="fa-solid fa-dollar-sign"></i> ${event.ticket_price}</p>

                                    <sec:authorize access="isAuthenticated()">
                                        <a href="/ticketpurchase" class="nav-link">
                                            <span type="button"
                                                class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">Buy
                                                Tickets</span>
                                        </a>
                                    </sec:authorize>

                                </div>
                            </div>
                        </div>

                    </c:forEach>
                </div>
            </div>
        </div>