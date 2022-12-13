<jsp:include page="include/header.jsp" />

<!--Header Image -->
<div class="card m-3 p-3 shadow col-lg-10 mx-auto">
    <img class="card-img-top" style="height: 20vw" src="pub/images/show_header.jpeg" alt="Image of Crowd">
    <div class="card-body">
        <h5 class="card-title">Events Near You </h5>
        <h4 class="card-text" style="margin-bottom: 20px;">Search for events by your favorite artists!</h4>
        <a href="/events" class="btn btn-dark mb-2">Start Rockin'</a>
        <p class="card-text" style="font-family: Arial, Helvetica, sans-serif"><small class="text-muted">Last
                updated 2
                minutes ago</small></p>
    </div>
</div>

<!-- Artist Cards -->
<h2 style="color: black; margin: 30px;">Trending Artists</h2>
<div class="row row-cols-1 row-cols-md-3 mx-auto g-3 ms-2">
    <div class="col">
        <div class="card bg-dark h-500 shadow">
            <img src="pub/images/harry.webp" class="card-img-top" alt="Harry Styles">
            <div class="card-body">
                <h5 class="card-title">Harry Styles</h5>
                <a href="/events" class="nav-link">
                    <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">Buy Tickets</span>
                </a>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card bg-dark h-500 shadow">
            <img src="pub/images/duckwrth.jpeg" class="card-img-top" alt="Duckwrth.">
            <div class="card-body">
                <h5 class="card-title">Duckwrth.</h5>
                <a href="/events" class="nav-link">
                    <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">Buy Tickets</span>
                </a>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card bg-dark h-500 shadow">
            <img src="pub/images/silk.jpeg" class="card-img-top" alt="Silk Sonic">
            <div class="card-body">
                <h5 class="card-title">Silk Sonic</h5>
                <a href="/events" class="nav-link">
                    <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">Buy Tickets</span>
                </a>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card bg-dark h-500 shadow">
            <img src="pub/images/doja.webp" class="card-img-top" alt="Doja Cat">
            <div class="card-body">
                <h5 class="card-title">Doja Cat</h5>
                <a href="/events" class="nav-link">
                    <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">Buy Tickets</span>
                </a>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card bg-dark h-500 shadow">
            <img src="pub/images/gvf.jpeg" class="card-img-top" alt="GVF">
            <div class="card-body">
                <h5 class="card-title">Greta Van Fleet</h5>
                <a href="/events" class="nav-link">
                    <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">Buy Tickets</span>
                </a>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card bg-dark h-500 shadow">
            <img src="pub/images/remi.webp" class="card-img-top" alt="Remi Wolf">
            <div class="card-body">
                <h5 class="card-title">Remi Wolf</h5>
                <a href="/events" class="nav-link">
                    <span type="button" class="ms-1 d-none d-sm-inline btn btn-dark mt-3 text-white">Buy Tickets</span>
                </a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />