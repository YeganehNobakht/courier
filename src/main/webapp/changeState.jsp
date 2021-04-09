<!DOCTYPE html>

<html>
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>change</title>
</head>
<body>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.OrderStatus" %>
<%@ page import="service.Courier" %>
<%@ page import="model.OrderStates" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%
    HttpSession session1 = request.getSession(false);
    String name = (String)(session1.getAttribute("name"));
    if (name == null) {
        request.getRequestDispatcher("employee.html").include(request, response);
    }
    else{
        int trackingCode = Integer.parseInt(request.getParameter("trck"));
        String changeState = request.getParameter("state");
        String date = request.getParameter("startdate");
        OrderStatus orderStatus = Courier.fetchOrderStatusByTrackCode(trackingCode);
        if (changeState.equalsIgnoreCase("sending")){
            orderStatus.setSendingDate(date);
            orderStatus.setOrderStates(OrderStates.SENDING);
        }else{
            orderStatus.setDeliverDate(date);
            orderStatus.setOrderStates(OrderStates.DELIVERED);
        }
        Courier.updateOrderStatus(orderStatus);

%>
<div class="header">
    <h1>Chappar Courier</h1>
    <h6>Welcome <%=session.getAttribute("name")%>
    </h6>
</div>
<ul>
    <li><a class="active" href="logout">Logout</a></li>
    <li><a class="active" href="takeMoreOrder">Take Order</a></li>
    <li><a class="active" href="pendingOrders.jsp">Pending Order</a></li>
</ul>
<div class="km-pay-state-style km-box-style2">
<div class="KM_wrapperStatusCart"><img src="images/change.png"></div>
<div>Order state with tracking code <%=trackingCode%> was successfully change</div>
<%--<div class="KM_wrapperFollowUpOrder">--%>
<%--    <a class="KM_FollowUpOrderLink" href="takeMoreOrder" target="_blank">Take More Orders</a>--%>
<%--    <a class="KM_returnHome" href="employeeServices">Return To Home Page</a></div>--%>
</div>
</div>
<%

    }
%>
</body>
</html>



























