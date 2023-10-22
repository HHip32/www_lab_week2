<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/22/2023
  Time: 01:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
</head>
<body>
<form action="control?action=insertCustomer" method="post">
    Name: <input name="name"><br/>
    Addess: <input name="address"><br/>
    Email: <input name="email"><br/>
    Phone: <input name="phone"><br/>

    <input type="submit" value="Insert">
    <input type="reset" value="Clear">
</form>
</body>
</html>
