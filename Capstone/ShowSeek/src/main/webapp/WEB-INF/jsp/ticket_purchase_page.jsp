<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="include/header.jsp" />

    <h2 style="color:black; margin: 20px">Ticket Purchase</h2>
    <h5 style="color:rgb(68, 65, 65); margin: 20px">We'll bill you later <i class="fa-solid fa-face-smile-wink"></i>
    </h5>

    <!-- Ticket Purchase Form -->
    <form action="/ticketpurchase" method="POST" onsubmit="return validateForm()" style="margin: 20px">

        <label for="eventID" class="form-label">Select Event</label>
        <select class="form-select" name="eventID" id="eventID" required>
            <c:forEach items="${events}" var="event">
                <option value="${event.id}">${event.artist} at ${event.venue}</option>
            </c:forEach>
        </select>

        <c:if test="${bindingResult.hasFieldErrors('event_id')}">
            <c:forEach items="${bindingResult.getFieldErrors('event_id')}" var="error">
                <p class="userCreate_errors" style="margin-top: 20px;">${error.getDefaultMessage()}</p>
            </c:forEach>
        </c:if>

        <div class="row" style="margin-top: 20px;">
            <div class="mb-3 col-3">
                <label for="quantity" class="form-label">Quantity</label>
                <input type="text" value="${form.quantity}" name="quantity" class="form-control" id="quantity" required
                    pattern="^0*[1-9]\d*$" title="Please enter a quantity over 0.">
            </div>
        </div>

        <c:if test="${bindingResult.hasFieldErrors('quantity')}">
            <c:forEach items="${bindingResult.getFieldErrors('quantity')}" var="error">
                <p class="userCreate_errors">${error.getDefaultMessage()}</p>
            </c:forEach>
        </c:if>

        <div>
            <button type="submit" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">Submit</button>
        </div>
    </form>

    <!-- Internal JS -->
    <script>
        function validateForm() {
            window.open("/completepurchase");
        }
    </script>

    <jsp:include page="include/footer.jsp" />