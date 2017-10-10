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
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>GRM - Grade Relationship Manager</h2>
    </div>
</div>
<div id="container">
    <form:form action="saveGrade" modelAttribute="student" method="post">
        <%-- associate data with student id --%>
        <input type="hidden" name="studentId" value="${student.id}">
        <table style="width: inherit">
            <tbody>
            <tr>
                <th>Add Student Grade - ${student.firstName} ${student.lastName}</th>
                <th>Email - ${student.email}</th>
                <th>Address - ${student.address}</th>
                <th>City - ${student.city}</th>
            </tr>
            <tr>
                <td></td>
            </tr>
            <tr>
                <td>
                    <p></p>
                </td>
            </tr>
            <tr>
                <td><label>Course title:</label></td>
                <td>
                    <select name="ddlCourse" class="add-button-ddl">
                        <option value="">Select ...</option>
                        <c:forEach var="course" items="${courses}">
                            <option value="${course.id}">${course.title}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Period:</label></td>
                <td>
                    <select name="ddlPeriod" class="add-button-ddl">
                        <option value="">Select ...</option>
                        <option value="January">January</option>
                        <option value="June">June</option>
                        <option value="September">September</option>
                        <option value="October">October</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Course mark:</label></td>
                <td>
                    <select name="ddlGrade" class="add-button-ddl">
                        <option value="">Select ...</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
                </td>
            </tr>
            </tbody>
        </table>
        <div id="button-move">
            <input type="submit" value="Save" class="save">
            <a href="${pageContext.request.contextPath}/student/list" class="add-button" style="text-decoration: none">Back to Student List</a>
        </div>
    </form:form>
</div>${flash}
</body>
</html>