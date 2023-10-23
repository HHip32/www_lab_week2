<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Employee" %>
<%@ page import="vn.edu.iuh.fit.backend.services.EmployeeService" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/22/2023
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<%
    EmployeeService employeeService = new EmployeeService();
    List<Employee> lst = employeeService.getAll();

%>
<h1>List Employee</h1>
<table width="80%" align="center">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Email</th>
        <th>DoB</th>
        <th>Status</th>
        <th><a href="insertEmployee.jsp">Insert</a> </th>
    </tr>
    <% for(Employee employee:lst){%>
    <tr>
        <td><%=employee.getId()%></td>
        <td><%=employee.getFullName()%></td>
        <td><%=employee.getAddress()%></td>
        <td><%=employee.getPhone()%></td>
        <td><%=employee.getEmail()%></td>
        <td><%=employee.getDob()%></td>
        <td><%=employee.getStatus()%></td>
        <td>
            <a href="control?action=updateEmployee&id=<%=employee.getId()%>">Update</a>
            <a href="control?action=deleteEmployee&id=<%=employee.getId()%>">Delete</a>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
