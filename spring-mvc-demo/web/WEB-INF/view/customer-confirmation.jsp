<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer Confirmation</title>
</head>
<body>
    Customer First name: ${customer.firstName}
    <br>
    Customer Last name: ${customer.lastName}
    <br>
    Free passes: ${customer.freePasses}
    <br>
    Postal code: ${customer.postalCode}
    <br>
    Course code: ${customer.courseCode}
</body>
</html>