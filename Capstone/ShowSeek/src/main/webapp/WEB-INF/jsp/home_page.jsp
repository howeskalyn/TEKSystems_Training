<jsp:include page="include/header.jsp" />

<!--Header Image -->
<div class="card m-3 p-3 shadow">
    <img class="card-img-top" src="pub/images/show_header.jpeg" alt="Image of Crowd">
    <div class="card-body">
        <h5 class="card-title">Events Near You </h5>
        <h4 class="card-text" style="margin-bottom: 20px;">Search for events by your favorite artists!</h4>
        <a href="/events" class="btn btn-dark mb-2">Start Rockin'</a>
        <p class="card-text" style="font-family: Arial, Helvetica, sans-serif"><small class="text-muted">Last
                updated 2
                minutes ago</small></p>
    </div>
</div>

<!-- Event Cards -->
<h2 style="color: black; margin: 20px;">Trending Artists</h2>
<div class="row row-cols-1 row-cols-sm-3 g-3 ms-2">
    <div class="col">
        <div class="card bg-dark h-500 shadow">
            <img src="pub/images/harry.webp" class="card-img-top" alt="Harry Styles">
            <div class="card-body">
                <h5 class="card-title">Harry Styles</h5>
                <button class="btn btn-dark mt-3" type="button">Buy Tickets</button>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card bg-dark h-500 shadow">
            <img src="pub/images/duckwrth.jpeg" class="card-img-top" alt="Duckwrth.">
            <div class="card-body">
                <h5 class="card-title">Duckwrth.</h5>
                <button class="btn btn-dark mt-3" type="button">Buy Tickets</button>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card bg-dark h-500 shadow">
            <img src="pub/images/silk.jpeg" class="card-img-top" alt="Silk Sonic">
            <div class="card-body">
                <h5 class="card-title">Silk Sonic</h5>
                <button class="btn btn-dark mt-3" type="button">Buy Tickets</button>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card bg-dark h-500 shadow">
            <img src="pub/images/doja.webp" class="card-img-top" alt="Doja Cat">
            <div class="card-body">
                <h5 class="card-title">Doja Cat</h5>
                <button class="btn btn-dark mt-3" type="button">Buy Tickets</button>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card bg-dark h-500 shadow">
            <img src="pub/images/gvf.jpeg" class="card-img-top" alt="GVF">
            <div class="card-body">
                <h5 class="card-title">Greta Van Fleet</h5>
                <button class="btn btn-dark mt-3" type="button">Buy Tickets</button>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card bg-dark h-500 shadow">
            <img src="pub/images/remi.webp" class="card-img-top" alt="Remi Wolf">
            <div class="card-body">
                <h5 class="card-title">Remi Wolf</h5>
                <button class="btn btn-dark mt-3" type="button">Buy Tickets</button>
            </div>
        </div>
    </div>
</div>

<!-- Pagination -->
<nav>
    <ul class="pagination pagination-lg justify-content-center" id="pages" style="margin: 30px">
        <button class="btn btn-dark mt-3" onclick="pages()" type="button">Display Pages</button>
    </ul>
</nav>

<jsp:include page="include/footer.jsp" />