<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="include/header.jsp" />

    <!-- Ajax Usage -->
    <script>
        $(document).ready(
            function () {
                $('button[type=button').click(function () {
                    console.log("user clicked : " + this.value);

                    $.ajax({
                        url: "/addfriendCall", // the mapped function in controller
                        data: {
                            clickedValue: this.value
                        },
                        success: function (data) {
                            console.log("Server Success.");
                            console.log(data);
                        },
                        error: function (data) {
                            console.log("AJAX Call Failure.");
                            console.log(data);
                        }
                    });

                    // alerts of friend added & reloads
                    alert('Friend Added!');
                    window.location.reload();
                });
            }
        );
    </script>

    <div class="row">
        <div class="col-md-8 mx-auto">
            <div class="card shadow p-3 mb-5 bg-white rounded">
                <h2 style="color: black;">Add Friends!</h2>

                <!-- Search for User -->
                <form action="/usersearch" method="get" style="margin: 20px">

                    <div class="row">
                        <div class="mb-3 col-3">
                            <label for="inputName" class="form-label">Enter a name...</label>
                            <input type="text" value="${inputName}" name="inputName" class="form-control"
                                id="inputName">
                        </div>
                        <div class="m-3 col-3">
                            <button type="submit" class="s-1 d-none d-sm-inline btn btn-dark mt-3 text-white">Search <i
                                    class="fa-solid fa-magnifying-glass"></i></button>
                        </div>
                    </div>

                </form>

                <!-- Add Friend -->
                <form action="/usersearch" method="get" style="margin: 20px">

                    <table class="table table-dark table-striped table-hover" style="margin: 0px">
                        <thead>
                            <tr class="text-center">
                                <th scope="col"><i class="fa-solid fa-person"></i></th>
                                <th scope="col"><i class="fa-solid fa-envelope"></i></i></th>
                                <th scope="col"><i class="fa-solid fa-plus"></i></i></th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr class="text-center">
                                    <td>${user.first_name} ${user.last_name}</td>
                                    <td>${user.email}</td>
                                    <td>
                                        <button type="button" value="${user.id}" name="friendID" id="friendID"
                                            class="s-1 d-none d-sm-inline btn btn-dark text-white">Add
                                            Friend</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </form>

            </div>
        </div>
    </div>

    <jsp:include page="include/footer.jsp" />