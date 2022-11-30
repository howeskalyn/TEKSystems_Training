<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Student</title>

        <style>
            .input {
                margin: 10px;
            }
        </style>
    </head>

    <body>

        <!-- <h1>Search for Student</h1> -->

        <!-- SEARCH FOR STUDENT -->
        <!-- form to collect info -->
        <!-- <form method="get" action="/student">
            Student Name: <input type="text" name="first_name" value="${first_name_key}">
            <br>
            <button type="submit" style="margin:20px;">Search by First Name</button>
        </form>

        <h2>Students</h2>
        <table border="1" cellpadding="5">
            <th style="text-align: left;">ID</th>
            <th style="text-align: left;">First Name</th>
            <th style="text-align: left;">Last Name</th>
            <th style="text-align: left;">City</th>
            <th style="text-align: left;">State</th>
            <th style="text-align: left;">Zip Code</th>

            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.first_name}</td>
                    <td>${student.last_name}</td>
                    <td>${student.city}</td>
                    <td>${student.state}</td>
                    <td>${student.zip}</td>
                </tr>
            </c:forEach>
        </table> -->

        <!-- ADD STUDENT -->
        <h1>Add a New Student</h1>

        <c:if test="${not empty error}">
            <p style="color:red">${error}</p>
        </c:if>

        <form action="/studentSubmit">
            First Name: <input type="text" name="first_name">
            <br>
            Last Name: <input type="text" name="last_name">
            <br>
            City: <input type="text" name="city">
            <br>
            State: <input type="text" name="state">
            <br>
            Zip Code: <input type="text" name="zip">
            <br>

            <button type="submit">Submit</button>
        </form>

        <!-- show a success message in green saying student saved -->

    </body>

    </html>