<%@ page import="vn.edu.iuh.fit.backend.services.CustomerService" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/22/2023
  Time: 01:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<%
    CustomerService services = new CustomerService();
    List<Customer> lst = services.getAllCustomer();

//        List<Customer> lst1 = session.getAttribute("customers");
%>
<h1>List Customer</h1>
<table width="80%" align="center">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Email</th>
        <th><a href="insertCustomer.jsp">Insert</a> </th>
    </tr>
    <% for(Customer customer:lst){%>
    <tr>
        <td><%=customer.getId()%></td>
        <td><%=customer.getName()%></td>
        <td><%=customer.getAddress()%></td>
        <td><%=customer.getPhone()%></td>
        <td><%=customer.getEmail()%></td>
        <td>
            <a href="control?action=update&id=<%=customer.getId()%>">Update</a>
            <a href="control?action=delete&id=<%=customer.getId()%>">Delete</a>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
