<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <meta charset="UTF-8">
    <title>trackCode</title>
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
    <li><a class="active" href="customerService.jsp">Service</a></li>
</ul>
<div class="content">
    <form  method="post" action="TrackOrder">

        <div class="modal-img">
            <img src="images/trackCode1.png" style="width: 256px;height: 256px;" alt="">
        </div>
            <center>
            <input type="text" name="customerTrack" placeholder="Enter Your Track Code">
            <button type="submit">Tracking</button>
            </center>
            <br><br>
    </form>
</div>
<%
    }
%>
</body>
</html>