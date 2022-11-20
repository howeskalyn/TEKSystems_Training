<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Insert title here</title>
    </head>

    <body>

        <h1>Create a new course</h1>

        <c:if test="${not empty error}">
            <p style="color:red">${error}</p>
        </c:if>

        <form action="/courseSubmit">
            Course Name : <input type="text" name="courseName">
            <br>
            Instructor Name : <input type="text" name="instructorName">
            <br>
            <button type="submit">Submit</button>
        </form>

    </body>

    </html>