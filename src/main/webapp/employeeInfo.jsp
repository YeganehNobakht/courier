<!DOCTYPE html>

<html>
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Users</title>
</head>
<body>

<%@page import="data.NewDeliveryDao" %>
<%@ page import="model.NewDelivery" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.Employee" %>
<%@ page import="data.EmployeeDao" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    HttpSession session1 = request.getSession(false);
    if (session1.getAttribute("name") == null) {
        request.getRequestDispatcher("manager.html").include(request, response);
    } else {
        List<Employee> list = EmployeeDao.getAllRecords();
        request.setAttribute("list", list);
%>
<div class="header">
    <h1>Chappar Courier</h1>
    <h6>Welcome <%=session.getAttribute("name")%>
    </h6>
</div>
<ul>
    <li><a class="active" href="logout">Logout</a></li>
    <li><a class="active" href="managerServices.jsp">Service</a></li>
</ul><br>
<center>
    <table border="1" width="90%">
        <tr>
            <th>username</th>
            <th>password</th>
            <th>name</th>
            <th>lastName</th>
            <th>email</th>
            <th>phone</th>
            <th>address</th>
        </tr>
        <c:forEach items="${list}" var="u">
            <tr>
                <td>${u.username}</td>
                <td>${u.password}</td>
                <td>${u.name}</td>
                <td>${u.lastName}</td>
                <td>${u.email}</td>
                <td>${u.phone}</td>
                <td>${u.address}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div class="km-pay-state-style km-box-style2">
        <h2>Click the button below to add a new employee</h2>
        <button type="submit" class="registerbtn" onclick=window.location.href='addEmployee.jsp';>Add </button>
    </div>
</center>
</body>
<%
    }
%>
</html>