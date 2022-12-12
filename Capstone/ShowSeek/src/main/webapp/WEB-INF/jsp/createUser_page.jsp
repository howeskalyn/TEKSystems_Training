<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="include/header.jsp" />

    <h2 style="color:black; margin: 20px">Create User</h2>

    <!-- Create User Form -->
    <form action="/user/createuser" method="POST" style="margin: 20px">

        <div class="row">
            <div class="mb-3 col-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" value="${form.firstName}" name="firstName" class="form-control" id="firstName">
            </div>
            <c:if test="${bindingResult.hasFieldErrors('firstName')}">
                <c:forEach items="${bindingResult.getFieldErrors('firstName')}" var="error">
                    <p class="userCreate_errors">${error.getDefaultMessage()}</p>
                </c:forEach>
            </c:if>

            <div class="mb-3 col-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" value="${form.lastName}" name="lastName" class="form-control" id="lastName">
            </div>
            <c:if test="${bindingResult.hasFieldErrors('lastName')}">
                <c:forEach items="${bindingResult.getFieldErrors('lastName')}" var="error">
                    <p class="userCreate_errors">${error.getDefaultMessage()}</p>
                </c:forEach>
            </c:if>
        </div>

        <div class="mb-3 w-50">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input type="email" value="${form.email}" name="email" class="form-control" id="exampleInputEmail1"
                aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">Your email will not be shared.</div>
        </div>
        <c:if test="${bindingResult.hasFieldErrors('email')}">
            <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                <p class="userCreate_errors">${error.getDefaultMessage()}</p>
            </c:forEach>
        </c:if>

        <div class="row">
            <div class="mb-3 col-6 w-25">
                <label for="password" class="form-label">Password</label>
                <input type="password" value="${form.password}" name="password" class="form-control" id="password">
            </div>
            <c:if test="${bindingResult.hasFieldErrors('password')}">
                <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                    <p class="userCreate_errors">${error.getDefaultMessage()}</p>
                </c:forEach>
            </c:if>

            <div class="mb-3 col-6 w-25">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <input type="password" value="${form.confirmPassword}" name="confirmPassword" class="form-control"
                    id="confirmPassword">
            </div>
        </div>
        </div>

        <div class="row">
            <div class="mb-3 col-4 w-25">
                <label for="phone" class="form-label">Phone</label>
                <input type="text" value="${form.phone}" name="phone" class="form-control" id="phone"
                    aria-describedby="phoneHelp">
                <div id="phoneHelp" class="form-text">(Optional)</div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('phone')}">
                <c:forEach items="${bindingResult.getFieldErrors('phone')}" var="error">
                    <p class="userCreate_errors">${error.getDefaultMessage()}</p>
                </c:forEach>
            </c:if>

            <div class="mb-3 col-4 w-25">
                <label for="zip" class="form-label">Zip</label>
                <input type="text" value="${form.zip}" name="zip" class="form-control" id="zip">

                <c:if test="${bindingResult.hasFieldErrors('zip')}">
                    <c:forEach items="${bindingResult.getFieldErrors('zip')}" var="error">
                        <p class="userCreate_errors">${error.getDefaultMessage()}</p>
                    </c:forEach>
                </c:if>
            </div>

        </div>

        <div>
            <!-- this needs to redirect you to the login page -->
            <button type="submit" class="btn btn-dark">Submit</button>
        </div>
    </form>
    <jsp:include page="include/footer.jsp" />