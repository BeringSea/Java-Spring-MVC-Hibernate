<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
        <h2>SGT - Student Grade Tracker</h2>
    </div>
    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <th>Name and Last name</th>
                    <th>Course</th>
                    <th>Period</th>
                    <th>Mark</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="tempGrade" items="${grades}">
                    <%--add link for delete student grade--%>
                    <c:url var="gradeLink" value="/grade/deleteGrade">
                        <c:param name="gradeId" value="${tempGrade.id}"/>
                    </c:url>
                    <tr>
                        <td>${tempGrade.student_name_lastname}</td>
                        <td>${tempGrade.course_title}</td>
                        <td>${tempGrade.period}</td>
                        <td>${tempGrade.mark}</td>
                        <td>
                            <a href="${gradeLink}" onclick="if (!(confirm('Sure want to delete?'))) return false">Delete</a>
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