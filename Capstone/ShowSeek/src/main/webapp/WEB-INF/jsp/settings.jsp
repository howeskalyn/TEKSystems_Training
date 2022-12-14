<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="include/header.jsp" />

    <div class="row">

        <!-- Change Password Card -->
        <div class="col-md-8 mx-auto">
            <div class="card shadow p-3 mb-5 bg-white rounded">
                <h2 style="color: black"> Settings for ${user.first_name} ${user.last_name} </h2>

                <form action="/settings" method="POST" style="margin: 20px">
                    <h4 style="color: black">Change Password</h4>
                    <div class="row">
                        <div class="mb-3 col-6 w-25">
                            <label for="password" class="form-label">New Password</label>
                            <input type="password" value="${form.password}" name="password" class="form-control"
                                id="password">
                        </div>
                        <c:if test="${bindingResult.hasFieldErrors('password')}">
                            <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                                <p class="userCreate_errors">${error.getDefaultMessage()}</p>
                            </c:forEach>
                        </c:if>
                    </div>

                    <div>
                        <button type="submit" class="btn btn-dark">Submit</button>
                    </div>
                </form>

            </div>
        </div>
    </div>

    <jsp:include page="include/footer.jsp" />