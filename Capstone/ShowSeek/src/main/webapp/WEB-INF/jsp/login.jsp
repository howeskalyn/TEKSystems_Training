<jsp:include page="include/header.jsp" />

<div class="row">
    <div class="col-sm-6">
        <div class="card shadow p-3 mb-5 bg-white rounded">
            <div class="card-body">
                <h3 class="card-title" style="color: black; margin: 10px; font-family: 'Norwester', sans-serif;">Login
                    to View</h3>
                <form action="/user/loginpost" method="POST">

                    <div class="mt-2 mb-3" style="margin: 10px">
                        <label for="username" class="form-label">Email</label>
                        <input type="username" name="username" class="form-control" id="username"
                            aria-describedby="emailHelp">
                        <div id="emailHelp" class="form-text">Enter your email</div>
                    </div>
                    <div class="mt-2 mb-3" style="margin: 10px">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" name="password" class="form-control" idx="password"
                            aria-describedby="passwordHelp">
                        <div id="passwordHelp" class="form-text">Enter your password</div>
                    </div>

                    <button type="submit" class="btn btn-dark" style="margin: 10px">Submit</button>
                </form>
            </div>
        </div>
    </div>

    <div class="col-sm-6">
        <div class="card shadow p-3 mb-5 bg-white rounded">
            <div class="card-body">
                <h5 class="card-title" style="color: black; margin: 10px">Not a Member?</h5>
                <h3 class="card-title" style="color: black; margin: 10px; font-family: 'Norwester', sans-serif;">Join
                    ShowSeek</h3>
                <img src="https://media.istockphoto.com/id/1189205501/photo/cheering-crowd-of-unrecognized-people-at-a-rock-music-concert-concert-crowd-in-front-of.jpg?s=170667a&w=0&k=20&c=-1jrEGONqubjj5mdXqI7s4V-7OgpFvRdkR4bGWy8ANc="
                    class="card-img-top" style="height: 190px;" alt="Crowd">
                <a href="/user/createuser" class="btn btn-dark" style="margin: 10px">Create User</a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />