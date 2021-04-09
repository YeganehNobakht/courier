<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.OrderStatus" %>
<%@ page import="model.data.OrderStatusDao" %>
<%@ page import="model.OrderStates" %>
<%@ page import="model.data.NewDeliveryDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <title>Accepted</title>
</head>
<body>
<%
    HttpSession session1 = request.getSession(false);
    if (session1.getAttribute("name") == null) {
        request.getRequestDispatcher("employee.html").include(request, response);
    }
    else{
        String username = (String) session.getAttribute("username");
        String date = request.getParameter("startdate");
        int trackingCode = Integer.parseInt(request.getParameter("trck"));
        OrderStatus orderStatus = OrderStatusDao.fetchOrderByTrackingCode(trackingCode);
        PrintWriter writer = response.getWriter();
        if (orderStatus != null) {
            orderStatus.setEmployeeId(username);
            orderStatus.setAcceptDate(date);
            orderStatus.setOrderStates(OrderStates.ACCEPTED);
            OrderStatusDao. update(orderStatus);
            NewDeliveryDao.delete(trackingCode);

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
    <div class="KM_wrapperStatusCart"><img src="images/submit.png"></div>
    <div>Order with tracking code <%=trackingCode%> was successfully accept</div>
    <div class="KM_wrapperFollowUpOrder">
        <a class="KM_FollowUpOrderLink" href="takeMoreOrder" target="_blank">Take More Orders</a>
        <a class="KM_returnHome" href="employeeServices">Return To Home Page</a></div>
</div>
</div>

<%

        }else {
            writer.println("<script type=\"text/javascript\">\n" +
                    "    alert(\"Incorrect track code\");\n" +
                    "</script>");
            request.getRequestDispatcher("/takeMoreOrder").include(request, response);
        }
    }
%>
</body>
</html>
