<!-- library import -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ShowSeek</title>
    </head>

    <body>

        <!-- testing User table -->
        <!-- <div style="border: solid; padding: 20px;">
            <form method="get" action="/table/test">
                User Email: <input type="text" name="email" value="${email}">
                <button type="submit">Search</button>
            </form>
            <h2>Users</h2>
            <table border="1" cellpadding="5">
                <th style="text-align: left;">ID</th>
                <th style="text-align: left;">First Name</th>
                <th style="text-align: left;">Last Name</th>
                <th style="text-align: left;">Email</th>
                <th style="text-align: left;">Phone</th>
                <th style="text-align: left;">Zip Code</th>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.first_name}</td>
                    <td>${user.last_name}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>${user.zip}</td>
                </tr>
            </table>
        </div> -->

        <br>

        <!-- testing return Event from User table -->
        <div style="border: solid; padding: 20px;">
            <form method="get" action="/table/test">
                User Email: <input type="text" name="email" value="${email}">
                <button type="submit">Search</button>
            </form>
            <h2>Events</h2>
            <table border="1" cellpadding="5">
                <th style="text-align: left;">ID</th>
                <th style="text-align: left;">Venue</th>
                <th style="text-align: left;">Zip Code</th>
                <th style="text-align: left;">Date</th>
                <th style="text-align: left;">Time</th>
                <th style="text-align: left;">Ticket Price</th>
                <th style="text-align: left;">Artist</th>
                <c:forEach items="${userEvents}" var="userEvent">
                    <tr>
                        <td>${userEvent.id}</td>
                        <td>${userEvent.venue}</td>
                        <td>${userEvent.zip}</td>
                        <td>${userEvent.date}</td>
                        <td>${userEvent.time}</td>
                        <td>${userEvent.ticket_price}</td>
                        <td>${userEvent.artist}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <br>

        <!-- testing Friend table -->
        <div style="border: solid; padding: 20px;">
            <form method="get" action="/friend">
                Friend ID: <input type="text" name="id" value="${id}">
                <button type="submit">Search</button>
            </form>
            <h2>Friend</h2>
            <table border="1" cellpadding="5">
                <th style="text-align: left;">ID</th>
                <th style="text-align: left;">User ID</th>
                <th style="text-align: left;">Friend ID</th>
                <tr>
                    <td>${friend.id}</td>
                    <td>${friend.user_id}</td>
                    <td>${friend.friend_id}</td>
                </tr>
            </table>
        </div>
        <br>

        <!-- testing Event table -->
        <div style="border: solid; padding: 20px;">
            <form method="get" action="/event">
                Event venue: <input type="text" name="venue" value="${venue}">
                <button type="submit">Search</button>
            </form>
            <h2>Events</h2>
            <table border="1" cellpadding="5">
                <th style="text-align: left;">ID</th>
                <th style="text-align: left;">Venue</th>
                <th style="text-align: left;">Zip Code</th>
                <th style="text-align: left;">Date</th>
                <th style="text-align: left;">Time</th>
                <th style="text-align: left;">Ticket Price</th>
                <th style="text-align: left;">Artist</th>
                <c:forEach items="${events}" var="event">
                    <tr>
                        <td>${event.id}</td>
                        <td>${event.venue}</td>
                        <td>${event.zip}</td>
                        <td>${event.date}</td>
                        <td>${event.time}</td>
                        <td>${event.ticket_price}</td>
                        <td>${event.artist}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <br>

        <!-- testing Ticket_Purchase table
        <div style="border: solid; padding: 20px;">
            <form method="get" action="/ticket">
                Ticket Purchase EventID: <input type="text" name="eventID" value="${eventID}">
                <button type="submit">Search</button>
            </form>
            <h2>Ticket Purchases</h2>
            <table border="1" cellpadding="5">
                <th style="text-align: left;">ID</th>
                <th style="text-align: left;">Event ID</th>
                <th style="text-align: left;">User ID</th>
                <th style="text-align: left;">Quantity</th>
                <c:forEach items="${tickets}" var="ticket">
                    <tr>
                        <td>${ticket.id}</td>
                        <td>${ticket.event_id}</td>
                        <td>${ticket.user_id}</td>
                        <td>${ticket.quantity}</td>
                    </tr>
                </c:forEach>
            </table>
        </div> -->

        <!-- testing return Event from Ticket_Purchase table -->
        <div style="border: solid; padding: 20px;">
            <form method="get" action="/ticket">
                Ticket Purchase EventID: <input type="text" name="eventID" value="${eventID}">
                <button type="submit">Search</button>
            </form>
            <h2>Events</h2>
            <table border="1" cellpadding="5">
                <th style="text-align: left;">ID</th>
                <th style="text-align: left;">Venue</th>
                <th style="text-align: left;">Zip Code</th>
                <th style="text-align: left;">Date</th>
                <th style="text-align: left;">Time</th>
                <th style="text-align: left;">Ticket Price</th>
                <th style="text-align: left;">Artist</th>
                <tr>
                    <td>${event2.id}</td>
                    <td>${event2.venue}</td>
                    <td>${event2.zip}</td>
                    <td>${event2.date}</td>
                    <td>${event2.time}</td>
                    <td>${event2.ticket_price}</td>
                    <td>${event2.artist}</td>
                </tr>
            </table>
        </div>

    </body>

    </html>