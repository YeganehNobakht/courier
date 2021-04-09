<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <meta charset="UTF-8">
    <title>service</title>
</head>
<body>
<%
    HttpSession session1 = request.getSession(false);
    if (session1.getAttribute("name") == null) {
        request.getRequestDispatcher("employee.html").include(request, response);
    } else {
%>
<div class="header">
    <h1>Chappar Courier</h1>
    <h6>Welcome <%=session.getAttribute("name")%>
    </h6>
</div>
<ul>
    <li><a class="active" href="logout">Logout</a></li>
</ul>
<div class="row">

    <div class="column">
        <a tabindex="0" role="button" aria-disabled="false" title="Employee Information" href="employeeInfo.jsp">
            <div class="item-img"><img src="images/employee.png" alt="" style="width: 500px; height: 300px; "></div>
            <center>Employee Information</center>
        </a>
    </div>
    <div class="column">
        <a tabindex="0" role="button" aria-disabled="false" title="Customer Information" href="customerInfo.jsp">
            <div class="item-img"><img src="images/customer.jpg" alt="" style="width: 500px; height: 300px; "></div>
            <center>Customer Information</center>
        </a>

    </div>
</div>
<%
    }
%>
</body>
</html>