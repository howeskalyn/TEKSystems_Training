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

        <!-- jsp if & for loop -->
        <c:if test="${not empty error}">
            <c:forEach items="${errors}" var="error">
                <p style="color:red">${error}</p>
            </c:forEach>
        </c:if>

        <!-- thymeleaf for loop -->
        <table style="border: 1px solid black">
            <tr th:each="error: ${errors}">
                <td th:text="${error}" />
            </tr>
        </table>

        <form action="/courseSubmit">
            Course Name : <input type="text" name="courseName">
            <br>
            Instructor Name : <input type="text" name="instructorName">
            <br>
            <button type="submit">Submit</button>
        </form>

    </body>

    </html>