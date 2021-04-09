<!DOCTYPE html>

<html>
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Users</title>
</head>
<body>

<%@page import="model.data.NewDeliveryDao" %>
<%@ page import="model.NewDelivery" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    HttpSession session1 = request.getSession(false);
    if (session1.getAttribute("name") == null) {
        request.getRequestDispatcher("employee.html").include(request, response);
    } else {
        List<NewDelivery> list = NewDeliveryDao.getAllRecords();
        request.setAttribute("list", list);
%>
<div class="header">
    <h1>Chappar Courier</h1>
    <h6>Welcome <%=session.getAttribute("name")%>
    </h6>
</div>
<ul>
    <li><a class="active" href="logout">Logout</a></li>
</ul><br>
<center>
    <table border="1" width="90%">
        <tr>
            <th>trackingCode</th>
            <th>originAddress</th>
            <th>destinationAddress</th>
            <th>RecipientsPhone</th>
            <th>RecipientsName</th>
            <th>packageType</th>
            <th>packageWeight</th>
            <th>sendType</th>
        </tr>
        <c:forEach items="${list}" var="u">
            <tr>
                <td>${u.trackingCode}</td>
                <td>${u.originAddress}</td>
                <td>${u.destinationAddress}</td>
                <td>${u.recipientsPhone}</td>
                <td>${u.recipientsName}</td>
                <td>${u.packageType}</td>
                <td>${u.packageWeight}</td>
                <td>${u.sendType}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div class="km-pay-state-style km-box-style2">
        <h2>To accept the order, enter the order tracking code in the box below:</h2>
        <form name="takeOrderForm" action="accepted" method="post">
            <div class="container">
                <div class="box">
                    <label for="trck">Track Code</label>
                    <input type="text" placeholder="Enter Track Code Here" name="trck" id="trck" required><br>

                    <input type="hidden" name="startdate" id="todayDate"/>
                    <button type="submit" class="registerbtn">Accept</button>
                </div>
            </div>
        </form>
    </div>
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
</body>
<%
    }
%>
</html>