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
        <a tabindex="0" role="button" aria-disabled="false" title="Pending Orders" href="pendingOrders.jsp">
            <div class="item-img"><img src="images/pendingOrder.png" alt="" style="width: 500px; height: 300px; "></div>
            <center>Pending Orders</center>
        </a>
    </div>
    <div class="column">
        <a tabindex="0" role="button" aria-disabled="false" title="Take More Order" href="takeMoreOrder.jsp">
            <div class="item-img"><img src="images/takeMoreOrder.png" alt="" style="width: 500px; height: 300px; "></div>
            <center>Take More Orders</center>
        </a>

    </div>
</div>
<%
    }
%>
</body>
</html>