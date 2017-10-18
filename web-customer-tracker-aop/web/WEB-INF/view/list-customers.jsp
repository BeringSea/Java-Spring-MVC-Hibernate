<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>List Customers</title>
    <%-- reference our css files --%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
    <body>
        <div id="wrapper">
           <div id="header">
               <h2>CRM - Customer Relationship Manager</h2>
           </div>
            <div id="container">
                <div id="content">
                    <%--add button to add Customer--%>
                        <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button">
                    <!-- add our html table here -->
                    <table>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email Name</th>
                            <th>Action</th>
                        </tr>
                            <c:forEach var="tempCustomer" items="${customers}">
                                <%--construct "update" link with customer id--%>
                                <c:url var="updateLink" value="/customer/showFormForUpdate">
                                    <c:param name="customerId" value="${tempCustomer.id}"/>
                                </c:url>
                                <%--construct "delete" link with customer id--%>
                                <c:url var="deleteLink" value="/customer/delete">
                                    <c:param name="customerId" value="${tempCustomer.id}"/>
                                </c:url>
                                <tr>
                                    <td>${tempCustomer.firstName}</td>
                                    <td>${tempCustomer.lastName}</td>
                                    <td>${tempCustomer.email}</td>
                                    <%--display update link--%>
                                    <td><a href="${updateLink}">Update</a>
                                        |
                                        <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this Customer'))) return false">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>