<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>List Students</title>
    <%--reference our CSS --%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>SRM - Student Relationship Manager</h2>
        </div>
        <div id="container">
            <div id="content">
                <%-- add student button --%>
                    <input type="button" value="Add Student" onclick="window.location.href='showFormForAdd';return false" class="add-button">
                    <a href="${pageContext.request.contextPath}/course/list" class="add-button" style="text-decoration: none">Course</a>
                    <a href="${pageContext.request.contextPath}/grade/listGrades" class="add-button" style="text-decoration: none">All Students Grades</a>
                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Address</th>
                        <th>City</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="tempStudent" items="${students}">
                        <%-- add update link with student id --%>
                        <c:url var="courseLink" value="/student/showStudentCourses">
                            <c:param name="studentId" value="${tempStudent.id}"/>
                        </c:url>
                        <%-- add grade link with student id --%>
                        <c:url var="gradeLink" value="/grade/showFormForAddGrade">
                            <c:param name="studentId" value="${tempStudent.id}"/>
                        </c:url>
                        <%-- add update link with student id --%>
                        <c:url var="updateLink" value="/student/showFormForUpdate">
                            <c:param name="studentId" value="${tempStudent.id}"/>
                        </c:url>
                        <%-- add delete link with student id --%>
                        <c:url var="deleteLink" value="/student/delete">
                            <c:param name="studentId" value="${tempStudent.id}"/>
                        </c:url>
                        <tr>
                            <td>${tempStudent.firstName}</td>
                            <td>${tempStudent.lastName}</td>
                            <td>${tempStudent.address}</td>
                            <td>${tempStudent.city}</td>
                            <td>${tempStudent.email}</td>
                            <td>
                                <%--display courses link--%>
                                <a href="${courseLink}">Courses</a>
                                |
                                        <%--display courses link--%>
                                    <a href="${gradeLink}">Add Grade</a>
                                    |
                                <%--display update link--%>
                                    <a href="${updateLink}">Update</a>
                                    |
                                <%--dispay delete link--%>
                                    <a href="${deleteLink}" onclick="if (!(confirm('Sure want to delete?'))) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div style="color: red">
                <p></p>
                ${flash}
            </div>
        </div>
    </div>
</body>
</html>