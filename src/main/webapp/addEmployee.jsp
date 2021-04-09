<!DOCTYPE html>

<html>
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/formStyle.css">
    <link rel="stylesheet" href="styles/firstpagestyle.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
    <script src="scripts/formValidity.js"></script>
    <script src="scripts/AddressSelection.js"></script>
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
<form id="RegForm" action="addEmployee" method="post">
    <p>
        <label for="name1">Name <span>(required, at least 3 characters)</span></label>
        <input id="name1" placeholder="Enter Name" name="name1">
    </p>
    <p>
        <label for="lastName1">Last Name<span>(required)</span></label>
        <input placeholder="Enter Last Name" name="lastName1" id="lastName1" >
    </p>
    <p>
        <label for="email1">E-Mail<span>(required)</span></label>
        <input id="email1" name="email1">
    </p>
    <p>
        <label for="username1">username<span>(required)</span></label>
        <input name="username1"  placeholder="Enter Username" id="username1">
    </p>

    <p>
        <label for="psw1">Password<span>(required)</span></label>
        <input placeholder="Enter Password" name="psw1" id="psw1" >
    </p>
    <p>
        <label for="mobileNumber">Phone<span>(required)</span></label>
        <input placeholder="Enter mobile number" name="mobileNumber" id="mobileNumber" >
    </p>
    <p>
        <label >Address</label><br>
        <select id="province" name="province" size="1" onchange="makeSubmenu(this.value)">
            <option value="" disabled selected>Choose State</option>
            <option>Tehran</option>
            <option>Isfahan</option>
            <option>Alborz</option>
        </select>

        <select id="citySelect" name="citySelect" size="1" >
            <option value="" disabled selected>Choose City</option>
            <option></option>
        </select>
    </p>
    <p>
        <label for="customerStreet">Street(required)</label>
        <input  placeholder="Enter Street" name="customerStreet" id="customerStreet" size="50%" required>
    </p>
    <p>
        <label for="customerBlock">Street<span>(required)</span></label>
        <input placeholder="Enter Block" name="customerBlock" id="customerBlock" size="50%" required>
    </p>
    <p>
    <p>
        <button type="submit" class="registerbtn" >Register</button>
    </p>
</form>

</body>
<%
    }
%>
</html>