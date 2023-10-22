<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/22/2023
  Time: 02:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update Customer</title>
</head>
<body>
<form action="control?action=updateCustomer" method="post">
    Name: <input name="name" value="${customerUpdate.getName()}"><br/>
    Addess: <input name="address" value="${customerUpdate.getAddress()}"><br/>
    Phone: <input name="phone" value="${customerUpdate.getPhone()}"><br/>
    Email: <input name="email" value="${customerUpdate.getEmail()}"><br/>
    <input type="submit" value="Update">
    <input type="reset" value="Clear">
</form>
</body>
</html>
