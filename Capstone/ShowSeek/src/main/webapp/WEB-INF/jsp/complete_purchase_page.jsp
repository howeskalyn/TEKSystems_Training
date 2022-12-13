<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="include/header.jsp" />

    <!--Header Image -->
    <div class="card m-3 p-3 shadow col-lg-10 mx-auto">
        <img class="card-img-top" style="height: 20vw" src="pub/images/cheer.webp" alt="Cheering Crowd">
        <div class="card-img-overlay">
            <h1 style="color: black; margin: 30px">Thanks, ${user.first_name}!</h1>
        </div>
    </div>

    <div class="card-body" style="margin: 20px;">
        <h3 style="color: black; font-family: 'Norwester', sans-serif;">Your Events</h3>

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
                    <tr class="text-center">
                        <td>${userEvent.artist}</td>
                        <td>${userEvent.venue}</td>
                        <td>${userEvent.date}</td>
                        <td>${userEvent.time}pm</td>
                        <td>$${userEvent.ticket_price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="/ticketpurchase" class="nav-link">
            <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">Buy More Tickets!</span>
        </a>
    </div>

    <a href="/events" class="nav-link" style="margin-left: 20px;">
        <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">All
            Events</span>



        <jsp:include page="include/footer.jsp" />