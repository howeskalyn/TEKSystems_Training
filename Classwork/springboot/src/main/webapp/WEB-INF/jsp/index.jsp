<!-- library for loop usage & other control structures -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Webapp</title>

    </head>

    <body>

        <!-- ${name} matches w/ value added in IndexController -->
        <h1>Hello ${name}</h1>

        <form method="get" action="/">
            Search: <input type="text" name="search" value="${search}">
            <button type="submit">Search</button>

            <br style="margin: 10px;">

            Search by Instructor: <input type="text" name="instructor" value="${instructor}">
            <button type="submit">Search</button>
        </form>

        <!-- put in table for UI purposes -->
        <h2>Courses by Name</h2>
        <table border="1" cellpadding="5">
            <th style="text-align: left;">ID</th>
            <th style="text-align: left;">Name</th>
            <th style="text-align: left;">Instructor</th>
            <c:forEach items="${courses}" var="course">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.name}</td>
                    <td>${course.instructor}</td>
                </tr>
            </c:forEach>
        </table>

        <h2>Courses by Instructor</h2>
        <table border="1" cellpadding="5">
            <th style="text-align: left;">ID</th>
            <th style="text-align: left;">Name</th>
            <th style="text-align: left;">Instructor</th>
            <c:forEach items="${icourses}" var="icourse">
                <tr>
                    <td>${icourse.id}</td>
                    <td>${icourse.name}</td>
                    <td>${icourse.instructor}</td>
                </tr>
            </c:forEach>
        </table>

    </body>

    </html>