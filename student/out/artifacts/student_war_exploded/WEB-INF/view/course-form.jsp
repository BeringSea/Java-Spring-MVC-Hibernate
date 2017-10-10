<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <h2>CRM - Course Relationship Manager</h2>
    </div>
</div>
<div id="container">
    <h3>Save Course</h3>
    <form:form action="saveCourse" modelAttribute="course" method="post">
        <%-- associate data with student id --%>
        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>Course title:</label></td>
                <td><form:input path="title"/></td>
                <td>
                    <form:errors path="title" cssClass="error"/>
                </td>
            </tr>
            </tbody>
        </table>
        <div id="button-move">
            <input type="submit" value="Save" class="save">
            <a href="${pageContext.request.contextPath}/student/list" class="add-button" style="text-decoration: none">Back to Student List</a>
        </div>
    </form:form>
</div>
</body>
</html>