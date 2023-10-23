<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/22/2023
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Employee</title>
</head>
<body>
<h1>INERT NEW EMPLOYEE</h1>
<form action="control?action=insertEmployee" method="post">
    Name: <input name="name"><br/>
    Addess: <textarea name="address" cols="30" rows="3"></textarea><br/>
    Phone: <input name="phone"><br/>
    Email: <input name="email"><br/>
    DoB: <input name="dob"><br/>
    <input type="submit" value="Insert">
    <input type="reset" value="Clear">
</form>
</body>
</html>
