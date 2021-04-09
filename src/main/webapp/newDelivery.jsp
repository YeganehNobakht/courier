<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <meta charset="UTF-8">
    <title>delivery</title>
    <script src="scripts/AddressSelection.js"></script>
    <script src="scripts/newDelivery.js"></script>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<body onload="resetSelection()">
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

<form name="form" id="form" class="content"  action="submit"
       method="post">
    <input type="hidden" value="false" name="hidden" id="hidden">
    <div class="container">
        <hr>

        <label ><b>Origin</b></label><br>
        <select id="originProvince" name="originProvince" size="1" onchange="originMakeSubmenu(this.value)">
            <option value="" disabled selected>Choose State</option>
            <option>Tehran</option>
            <option>Isfahan</option>
            <option>Alborz</option>
        </select>
        <select id="originCity" name="originCity" size="1" >
            <option value="" disabled selected>Choose City</option>
            <option></option>
        </select><br>
        <input type="text" placeholder="Enter Street" name="street" id="originstreet" size="1" required>
        <input type="text" placeholder="Enter Block" name="block" id="originblock" size="1" required>

        <label ><b>Destination</b></label><br>
        <select id="destinationProvince" name="destinationProvince" size="1" onchange="destinationMakeSubmenu(this.value)">
            <option value="" disabled selected>Choose State</option>
            <option>Tehran</option>
            <option>Isfahan</option>
            <option>Alborz</option>
        </select>
        <select id="destinationCity" name="destinationCity" size="1" >
            <option value="" disabled selected>Choose City</option>
            <option></option>
        </select><br>
        <input type="text" placeholder="Enter Street" name="street" id="desstreet" size="1" required>
        <input type="text" placeholder="Enter Block" name="block" id="desblock" size="1" required>

        <label for="recPhone"><b>Recipient's mobile number</b></label>
        <input type="text" placeholder="Enter Phone Number" name="recPhone" id="recPhone" required>

        <label for="recName"><b>Recipient's Name</b></label>
        <input type="text" placeholder="Enter Name" name="recName" id="recName" required>

        <label for="weight"><b>Package Weight</b></label>
        <input type="number" placeholder="Enter Package Weight" name="weight" id="weight"  required><br>

        <input type="radio" id="radioButton1" name="radioButton" value="Documentary" />
        <label for="radioButton1">Documentary</label><br>
        <input type="radio" id="radioButton2" name="radioButton" value="Non-documented" />
        <label for="radioButton2">Non-documented</label><br>

        <label><b>Package Size</b></label><br>
        <input type="text" placeholder="Enter Package Length" name="length" id="length" >
        <input type="text" placeholder="Enter Package Width" name="width" id="width" >
        <input type="text" placeholder="Enter Package Height" name="weight" id="height" ><br>

        <label for="content"><b>Package Content</b></label>
        <select name="content" id="content" required>
            <option value="document">Document</option>
            <option value="PC">PC</option>
            <option value="furniture">Home Furniture</option>
        </select>





        <button class="open-button" onclick="openForm()" onsubmit="submit_true()" >Get price</button>
        <div class="form-popup" id="myForm">
            <div class="form-container">
                <h>Choose an option:</h><br>
                <input type="radio" id="premium" name="prc" value="premium">
                <label for="premium"><h>Premium</h></label><br>
                <p class = "parag" id="premiumPriceResult" >price per Kg: 20000T</p>
                <p class = "parag">delivery day: 1 day</p>
                <input type="radio" id="gold" name="prc" value="gold">
                <label for="gold">Gold</label><br>
                <p class = "parag" id="goldPriceResult" >price per Kg: 14000T</p>
                <p class = "parag">delivery day: 3 days</p>
                <input type="radio" id="silver" name="prc" value="silver">
                <label for="silver">Silver</label>
                <p class = "parag" id="silverPriceResult" >price per Kg: 10000T</p>
                <p class = "parag">delivery day: 4 days</p>
                <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
            </div>
        </div>
        <input type="hidden" name="startdate" id="todayDate"/>



    </div><hr>

    <label ><b>Summation</b></label>
    <label id="queryString"></label>
    <input type="text" value="" id="result"/>
    <input type="hidden" id="actualResult"/>

    <button type="submit" class="registerbtn" onclick="_validate();submit_false()" disabled="true" id="submit">Submit</button>
    </div>
</form>

<script src="scripts/newDelivery.js"></script>
<script src="scripts/Validity.js"></script>
<script type="text/javascript">
    function getDate()
    {
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; //January is 0!
        var yyyy = today.getFullYear();
        if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm}
        today = yyyy+""+mm+""+dd;

        document.getElementById("todayDate").value = today;
    }

    //call getDate() when loading the page
    getDate();
</script>
<%
    }
%>
</body>

</html>