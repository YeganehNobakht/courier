<!DOCTYPE html>

<html>
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>pending orders</title>
</head>
<body>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="model.OrderStatus" %>
<%@ page import="service.Courier" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    HttpSession session1 = request.getSession(false);
    PrintWriter writer = response.getWriter();
    String nationalCode = (String) (session1.getAttribute("name"));
    if (nationalCode == null) {
        writer.println("<h1>Please login first</h1>");
        request.getRequestDispatcher("employee.html").include(request, response);
    } else {
        String employeeId = (String) session1.getAttribute("username");
        List<OrderStatus> list = Courier.fetchOrderByEmployee(employeeId);
        if (list.size() != 0) {
            request.setAttribute("list", list);
%>
<div class="header">
    <h1>Chappar Courier</h1>
    <h6>Welcome <%=session.getAttribute("name")%>
    </h6>
</div>
<ul>
    <li><a class="active" href="logout">Logout</a></li>
    <li><a class="active" href="takeMoreOrder">Take Order</a></li>
</ul><br>
<center>
    <table border="1" width="90%">
        <tr>
            <th>trackingCode</th>
            <th>registerDate</th>
            <th>u.orderStates</th>
            <th>acceptDate</th>
            <th>sendingDate</th>
            <th>deliverDate</th>
        </tr>
        <c:forEach items="${list}" var="u">
            <tr>
                <td>${u.orderId}</td>
                <td>${u.registerDate}</td>
                <td>${u.orderStates}</td>
                <td>${u.acceptDate}</td>
                <td>${u.sendingDate}</td>
                <td>${u.deliverDate}</td>
            </tr>
        </c:forEach>
    </table>













    <div class="km-pay-state-style km-box-style2">
        <h2>To change the status of each order, enter the tracking number in the box below:</h2>
        <form name="takeOrderForm" action="changeState.jsp" method="post">
            <div class="container">
                <div class="box">
                    <label for="trck">Track Code</label>
                    <input type="text" placeholder="Enter Track Code Here" name="trck" id="trck" required><br>
                    <input type="radio" name="state" value="sending" id="sending">
                    <label for="sending">Sending</label><br>
                    <input type="radio" id="delivered" name="state" value="delivered">
                    <label for="delivered">Delivered</label><br>
                    <input type="hidden" name="startdate" id="todayDate"/>
                    <button type="submit" class="registerbtn">Accept</button>
                </div>
            </div>
        </form>
    </div>













<%--    <h2>To change the status of each order, enter the tracking number in the box below.</h2>--%>
<%--    <form name="takeOrderForm">--%>
<%--        <label for="id">Track Code</label>--%>
<%--        <input type="text" placeholder="Enter Track Code Here" name="id" id="id" required><br>--%>
<%--        <input type="radio" name="state" value="sending" id="sending">--%>
<%--        <label for="sending">Sending</label><br>--%>
<%--        <input type="radio" id="delivered" name="delivered" value="delivered">--%>
<%--        <label for="delivered">Delivered</label><br>--%>
<%--    </form>--%>
<%--    <input type="hidden" name="changeDate" id="todayDate"/>--%>
<%--    <a id="foo" href="changeState.jsp"><h1>accept</h1></a>--%>
</center>

<script type="text/javascript">
    function getDate() {
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; //January is 0!
        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd
        }
        if (mm < 10) {
            mm = '0' + mm
        }
        today = yyyy + "" + mm + "" + dd;

        document.getElementById("todayDate").value = today;
    }

    //call getDate() when loading the page
    getDate();
</script>

<%
        } else {
            writer.println("<center><h1>No order has been registered with your name.</h1></center>");
        }
    }
%>
</body>
</html>