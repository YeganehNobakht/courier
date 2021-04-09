
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
String name = (String) session1.getAttribute("name");
if ( name== null) {
request.getRequestDispatcher("customer.html").include(request, response);
} else {
%>
<div class="header">
    <h1>Chappar Courier</h1>
</div>
<ul>
    <li><a class="active" href="index.jsp">Home</a></li>
</ul>
<div class="row">

    <div class="column">
        <a tabindex="0" role="button" aria-disabled="false" title="New Delivery" href="newDelivery.jsp">
            <center><img src="images/newD.jpg" alt="" style="width: 500px; height: 150px; "></center>
            <center>Pending Orders</center></a>
    </div>
    <div class="column">
        <a tabindex="0" role="button" aria-disabled="false" title="Track Order" href="trackCode.jsp">
            <center> <img src="images/tracking.png" alt="" style="width: 500px; height: 150px; "></center>
            <center>Track Order</center></a>

    </div>
</div>
<%
}
%>
</body>
</html>