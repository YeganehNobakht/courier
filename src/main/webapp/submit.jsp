<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <meta charset="UTF-8">
    <title>submit</title>
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
    <h6>Welcome <%=session.getAttribute("name")%>
    </h6>
</div>
<ul>
    <li><a class="active" href="logout">Logout</a></li>
    <li><a class="active" href="trackCode.jsp">Track Order</a></li>
    <li><a class="active" href="customerService.jsp">Service</a></li>
</ul>
<div class="km-pay-state-style km-box-style2">
    <div class="KM_wrapperStatusCart"><img src="images/submit.png"></div>
    <div>Order with tracking code <%=session.getAttribute("trackingCode")%> was successfully registered</div>
<%--    <div class="KM_wrapperFollowUpOrder">--%>
<%--        <a class="KM_FollowUpOrderLink" href="trackOrder" target="_blank">Tracking Order</a>--%>
<%--        <a class="KM_returnHome" href="service">Return to home page</a></div>--%>
<%--</div>--%>
</div>
<%
    }
%>
</body>
</html>