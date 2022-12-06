<jsp:include page="../include/header.jsp" />

<div class="container">
    <div class="row mt-3 mb-1">
        <h2>Create User</h2>
    </div>

    <!-- putting all errors at top for now -->
    <c:if test="${bindingResult.hasErrors()}">
        <c:forEach items="${bindingResult.getAllErrors()}" var="error">
            <p class="mb-0" style="color:red">${error.getDefaultMessage()}</p>
        </c:forEach>
    </c:if>

    <form action="/user/createuser" method="POST">

        <!-- hidden input field example -->
        <!-- <input type="hidden" name="id" value="10">  -->


        <div class="row">
            <div class="mb-3 col-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" value="${form.firstName}" name="firstName" class="form-control" id="firstName"
                    aria-describedby="firstNameHelp">
                <div id="firstNameHelp" class="form-text">Enter your first name</div>
            </div>

            <div class="mb-3 col-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" value="${form.lastName}" name="lastName" class="form-control" id="lastName"
                    aria-describedby="lastNameHelp">
                <div id="lastNameHelp" class="form-text">Enter your last name</div>
            </div>
        </div>

        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input type="email" value="${form.email}" name="email" class="form-control" id="exampleInputEmail1"
                aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else</div>
        </div>

        <div class="row">
            <div class="mb-3 col-6">
                <label for="password" class="form-label">Password</label>
                <input type="password" value="${form.password}" name="password" class="form-control" id="password"
                    aria-describedby="passwordHelp">
                <div id="passwordHelp" class="form-text">Enter your password</div>
            </div>

            <div class="mb-3 col-6">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <input type="password" value="${form.confirmPassword}" name="confirmPassword" class="form-control"
                    id="confirmPassword" </div>
            </div>
        </div>

        <div class="row">
            <div class="mb-3 col-4">
                <label for="phone" class="form-label">Phone</label>
                <input type="text" value="${form.phone}" name="phone" class="form-control" id="phone"
                    aria-describedby="phoneHelp">
                <div id="phoneHelp" class="form-text">Enter your phone number</div>
            </div>

            <div class="mb-3 col-4">
                <label for="zip" class="form-label">Zip</label>
                <input type="text" value="${form.zip}" name="zip" class="form-control" id="zip"
                    aria-describedby="zipHelp">
                <div id="zipHelp" class="form-text">Enter your zip code</div>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</div>

<jsp:include page="../include/footer.jsp" />