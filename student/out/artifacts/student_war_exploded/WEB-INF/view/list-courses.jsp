<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>List Courses</title>
    <%--reference our CSS --%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Course Relationship Manager</h2>
        </div>
        <div id="container">
            <div id="content">
                <input type="button" value="Add Course" onclick="window.location.href='showFormForAddCourse';return false" class="add-button">
                <table>
                    <tr>
                        <th>Title</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="tempCourse" items="${courses}">
                        <%-- add update link with student id --%>
                        <c:url var="updateLink" value="/course/showFormForUpdateCourse">
                            <c:param name="courseId" value="${tempCourse.id}"/>
                        </c:url>
                        <%-- add delete link with student id --%>
                        <c:url var="deleteLink" value="/course/deleteCourse">
                            <c:param name="courseId" value="${tempCourse.id}"/>
                        </c:url>
                        <tr>
                            <td>${tempCourse.title}</td>
                            <td>
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
            <div style="clear: both">
                <p>
                    <a href="${pageContext.request.contextPath}/student/list" class="add-button" style="text-decoration: none">Back to Student List</a>
                </p>
            </div>
        </div>
    </div>
</body>
</html>