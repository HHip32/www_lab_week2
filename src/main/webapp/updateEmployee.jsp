<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/23/2023
  Time: 09:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
<h1>UPDATE EMPLOYEE</h1>
<form action="control?action=updateEmployee" method="post">
    Name: <input name="name" value="${updateEmployee.getFullName()}"><br/>
    Addess: <textarea name="address" cols="30" rows="3">${updateEmployee.getAddress()}</textarea><br/>
    Phone: <input name="phone" value="${updateEmployee.getPhone()}"><br/>
    Email: <input name="email" value="${updateEmployee.getEmail()}"><br/>
    DoB: <input name="dob" value="${updateEmployee.getDob()}"><br/>
    <input type="submit" value="Update">
    <input type="reset" value="Clear">
</form>
</body>
</html>
