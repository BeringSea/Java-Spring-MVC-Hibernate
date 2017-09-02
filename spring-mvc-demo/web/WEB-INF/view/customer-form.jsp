<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer Registration Form</title>
    <style>
        .error {color: red}
    </style>
</head>
<body>
<i>Fill out the form. Asterisk (*) means required.</i>
<br><br>
    <form:form action="processForm" modelAttribute="customer">
        First name: <form:input path="firstName" />
        <br><br>
        Last name (*): <form:input path="lastName"/>
        <form:errors cssClass="error" path="lastName"/>
        <br><br>
        Free passes: <form:input path="freePasses"/>
        <form:errors cssClass="error" path="freePasses"/>
        <br><br>
        Postal code: <form:input path="postalCode"/>
        <form:errors path="postalCode" cssClass="error"/>
        <br><br>
        Course code: <form:input path="courseCode"/>
        <form:errors path="courseCode" cssClass="error"/>
        <br><br>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>