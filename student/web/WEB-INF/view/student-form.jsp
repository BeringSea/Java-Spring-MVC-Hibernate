<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Save Student</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-style.css">
    <style>
        .error{color: red}
    </style>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>SRM - Student Relationship Manager</h2>
        </div>
    </div>
    <div id="container">
        <h3>Save Student</h3>
        <form:form action="saveStudent" modelAttribute="student"  method="post">
            <%-- associate data with student id --%>
            <form:hidden path="id"/>
            <table>
                <tbody>
                    <tr>
                        <td><label>First name:</label></td>
                        <td><form:input path="firstName"/></td>
                        <td>
                            <form:errors path="firstName" cssClass="error" />
                        </td>
                    </tr>
                    <tr>
                        <td><label>Last name:</label></td>
                        <td><form:input path="lastName"/></td>
                        <td>
                            <form:errors path="lastName" cssClass="error" />
                        </td>
                    </tr>
                    <tr>
                        <td><label>Address:</label></td>
                        <td><form:input path="address"/></td>
                        <td>
                            <form:errors path="address" cssClass="error" />
                        </td>
                    </tr>
                    <tr>
                        <td><label>City:</label></td>
                        <td><form:input path="city"/></td>
                        <td>
                            <form:errors path="city" cssClass="error" />
                        </td>
                    </tr>
                    <tr>
                        <td><label>Email:</label></td>
                        <td><form:input path="email"/></td>
                        <td>
                            <form:errors path="email" cssClass="error" />
                        </td>
                    </tr>
                    <%--<tr>--%>
                        <%--<td><label>Courses:</label></td>--%>
                        <%--<td>--%>
                            <%--<select name="courses" id="courses">--%>
                                <%--<c:forEach var="course" items="${courses}">--%>
                                    <%--<option value="${course.id}">${course.title}</option>--%>
                                <%--</c:forEach>--%>
                            <%--</select>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <tr>
                        <td><label>Add Course:</label></td>
                    </tr>
                </tbody>
            </table>
            <div id="list-div">
                <ul>
                    <c:forEach var="course" items="${courses}">
                        <%--${course.title}<form:checkbox path="courses" value="${course.title}"/>--%>
                        <li>
                            ${course.title}<input type="checkbox" id="check-style" name="lista[]" value="${course.id}">
                        </li>
                    </c:forEach>
                    <input type="hidden" name="lista[]" value="0">
                </ul>
            </div>
            <div id="button-move">
                <input type="submit" value="Save" class="save">
                <a href="${pageContext.request.contextPath}/student/list" class="add-button" style="text-decoration: none">Back to Student List</a>
            </div>
        </form:form>
    </div>
</body>
</html>