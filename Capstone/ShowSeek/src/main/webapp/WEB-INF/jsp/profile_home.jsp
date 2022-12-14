<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="include/header.jsp" />

        <div class="row">

            <!-- User Info Card -->
            <div class="col-sm-6">
                <div class="card shadow p-3 mb-5 bg-white rounded">
                    <div class="row no-gutters">
                        <div class="col-md-4">
                            <img src="pub/images/person.png" alt="Person" style="height: 250px; margin-top: 20px;">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body" style="margin-left: 20px;">
                                <h2 style="color: black; margin: 0px; margin-bottom: 20px;">Welcome
                                    Back,<br>${user.first_name}
                                    ${user.last_name}</h2>
                                <p class="profile-content"> <i class="fa-solid fa-user"></i> ${user.email}</p>
                                <p class="profile-content"> <i class="fa-solid fa-phone"></i> ${user.phone}</p>
                                <p class="profile-content"> <i class="fa-solid fa-house"></i> ${user.zip}</p>

                                <a href="/settings" class="nav-link">
                                    <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">
                                        <i class="fa-solid fa-gear"></i> Settings
                                    </span>
                                </a>

                                <sec:authorize access="hasAnyAuthority('ADMIN')">
                                    <a href="/admin" class="nav-link">
                                        <span type="button"
                                            class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">
                                            <i class="fa-solid fa-lock"></i> Admin Access
                                        </span>
                                    </a>
                                </sec:authorize>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Fun Spotify Interactive Card -->
            <div class="col-sm-6">
                <div class="card shadow p-3 mb-5 bg-white rounded">
                    <div class="embed-responsive embed-responsive-4by3">
                        <h2 style="color: black; margin: 19px;">Based on Your History</h2>
                        <h5 style="color: #363130; margin: 19px;">
                            Take a minute to listen...</h5>
                        <iframe style="border-radius:12px; margin: 5px"
                            src="https://open.spotify.com/embed/track/4LRPiXqCikLlN15c3yImP7?utm_source=generator&theme=0"
                            width="100%" height="152" frameBorder="0" allowfullscreen=""
                            allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture"
                            loading="lazy"></iframe>
                    </div>
                </div>
            </div>

            <!-- User Events Card -->
            <div class="col-sm-6">
                <div class="card shadow p-3 mb-5 bg-white rounded">
                    <div class="row no-gutters">
                        <div class="col-md-4">
                            <img src="pub/images/speaker.png" alt="Speaker" style="height: 200px; margin-top: 20px;">
                        </div>

                        <div class="col-md-8">
                            <div class="card-body" style="margin-left: 0px; overflow-x:auto">
                                <h2 style="color: black; margin: 0px; margin-bottom: 20px;">Your Events</h2>

                                <table class="table table-dark table-striped table-hover" style="margin: 0px">
                                    <thead>
                                        <tr class="text-center">
                                            <th scope="col"><i class="fa-solid fa-person"></i></th>
                                            <th scope="col"><i class="fa-solid fa-location-dot"></i></th>
                                            <th scope="col"><i class="fa-solid fa-calendar"></i></th>
                                            <th scope="col"><i class="fa-solid fa-clock"></i></th>
                                            <th scope="col"><i class="fa-solid fa-dollar-sign"></i></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${userEvents}" var="userEvent">
                                            <tr>
                                                <td>${userEvent.artist}</td>
                                                <td>${userEvent.venue}</td>
                                                <td>${userEvent.date}</td>
                                                <td>${userEvent.time}pm</td>
                                                <td>$${userEvent.ticket_price}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                                <a href="/events" class="nav-link">
                                    <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">All
                                        Events</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- User Friends Card -->
            <div class="col-sm-6">
                <div class="card shadow p-3 mb-5 bg-white rounded">
                    <div class="row no-gutters">
                        <div class="col-md-4">
                            <img src="pub/images/friends.png" alt="Friends" style="height: 200px; margin-top: 20px;">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body" style="margin-left: 0px; overflow-x:auto">
                                <h2 style="color: black; margin: 0px; margin-bottom: 20px;">Your Friends</h2>

                                <table class="table table-dark table-striped table-hover" style="margin: 0px">
                                    <thead>
                                        <tr class="text-center">
                                            <th scope="col"><i class="fa-solid fa-person"></i></th>
                                            <th scope="col"><i class="fa-solid fa-envelope"></i></i></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${userFriends}" var="userFriend">
                                            <tr>
                                                <td>${userFriend.first_name} ${userFriend.last_name}</td>
                                                <td>${userFriend.email}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                                <a href="/usersearch" class="nav-link">
                                    <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">Add
                                        Friends</span>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <jsp:include page="include/footer.jsp" />