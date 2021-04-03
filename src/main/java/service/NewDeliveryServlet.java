package service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NewDeliveryServlet")
public class NewDeliveryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session.getAttribute("name") != null) {
            writer.println("Welcome "+session.getAttribute("name"));
            writer.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<link rel=\"stylesheet\" href=\"styles/firstpagestyle.css\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>delivery</title>\n" +
                    "    <script src=\"scripts/AddressSelection.js\"></script>\n" +
                    "    <script src=\"scripts/newDelivery.js\"></script>\n" +
                    "</head>\n" +
                    "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>\n" +
                    "<body onload=\"resetSelection()\">\n" +
                    "\n" +
                    "<form name=\"form\" id=\"form\" class=\"content\"  action=\"submit\"\n" +
                    "       method=\"post\">\n" +
                    "    <input type=\"hidden\" value=\"false\" name=\"hidden\" id=\"hidden\">\n" +
                    "    <div class=\"container\">\n" +
                    "        <hr>\n" +
                    "\n" +
                    "        <label ><b>Origin</b></label><br>\n" +
                    "        <select id=\"originProvince\" name=\"originProvince\" size=\"1\" onchange=\"originMakeSubmenu(this.value)\">\n" +
                    "            <option value=\"\" disabled selected>Choose State</option>\n" +
                    "            <option>Tehran</option>\n" +
                    "            <option>Isfahan</option>\n" +
                    "            <option>Alborz</option>\n" +
                    "        </select>\n" +
                    "        <select id=\"originCity\" name=\"originCity\" size=\"1\" >\n" +
                    "            <option value=\"\" disabled selected>Choose City</option>\n" +
                    "            <option></option>\n" +
                    "        </select><br>\n" +
                    "        <input type=\"text\" placeholder=\"Enter Street\" name=\"street\" id=\"originstreet\" size=\"1\" required>\n" +
                    "        <input type=\"text\" placeholder=\"Enter Block\" name=\"block\" id=\"originblock\" size=\"1\" required>\n" +
                    "\n" +
                    "        <label ><b>Destination</b></label><br>\n" +
                    "        <select id=\"destinationProvince\" name=\"destinationProvince\" size=\"1\" onchange=\"destinationMakeSubmenu(this.value)\">\n" +
                    "            <option value=\"\" disabled selected>Choose State</option>\n" +
                    "            <option>Tehran</option>\n" +
                    "            <option>Isfahan</option>\n" +
                    "            <option>Alborz</option>\n" +
                    "        </select>\n" +
                    "        <select id=\"destinationCity\" name=\"destinationCity\" size=\"1\" >\n" +
                    "            <option value=\"\" disabled selected>Choose City</option>\n" +
                    "            <option></option>\n" +
                    "        </select><br>\n" +
                    "        <input type=\"text\" placeholder=\"Enter Street\" name=\"street\" id=\"desstreet\" size=\"1\" required>\n" +
                    "        <input type=\"text\" placeholder=\"Enter Block\" name=\"block\" id=\"desblock\" size=\"1\" required>\n" +
                    "\n" +
                    "        <label for=\"recPhone\"><b>Recipient's mobile number</b></label>\n" +
                    "        <input type=\"text\" placeholder=\"Enter Phone Number\" name=\"recPhone\" id=\"recPhone\" required>\n" +
                    "\n" +
                    "        <label for=\"recName\"><b>Recipient's Name</b></label>\n" +
                    "        <input type=\"text\" placeholder=\"Enter Name\" name=\"recName\" id=\"recName\" required>\n" +
                    "\n" +
                    "        <label for=\"weight\"><b>Package Weight</b></label>\n" +
                    "        <input type=\"number\" placeholder=\"Enter Package Weight\" name=\"weight\" id=\"weight\"  required><br>\n" +
                    "\n" +
                    "        <input type=\"radio\" id=\"radioButton1\" name=\"radioButton\" value=\"Documentary\" />\n" +
                    "        <label for=\"radioButton1\">Documentary</label><br>\n" +
                    "        <input type=\"radio\" id=\"radioButton2\" name=\"radioButton\" value=\"Non-documented\" />\n" +
                    "        <label for=\"radioButton2\">Non-documented</label><br>\n" +
                    "\n" +
                    "        <label><b>Package Size</b></label><br>\n" +
                    "        <input type=\"text\" placeholder=\"Enter Package Length\" name=\"length\" id=\"length\" >\n" +
                    "        <input type=\"text\" placeholder=\"Enter Package Width\" name=\"width\" id=\"width\" >\n" +
                    "        <input type=\"text\" placeholder=\"Enter Package Height\" name=\"weight\" id=\"height\" ><br>\n" +
                    "\n" +
                    "        <label for=\"content\"><b>Package Content</b></label>\n" +
                    "        <select name=\"content\" id=\"content\" required>\n" +
                    "            <option value=\"document\">Document</option>\n" +
                    "            <option value=\"PC\">PC</option>\n" +
                    "            <option value=\"furniture\">Home Furniture</option>\n" +
                    "        </select>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "        <button class=\"open-button\" onclick=\"openForm()\" onsubmit=\"submit_true()\" >Get price</button>\n" +
                    "        <div class=\"form-popup\" id=\"myForm\">\n" +
                    "            <div class=\"form-container\">\n" +
                    "                <h>Choose an option:</h><br>\n" +
                    "                <input type=\"radio\" id=\"premium\" name=\"prc\" value=\"premium\">\n" +
                    "                <label for=\"premium\"><h>Premium</h></label><br>\n" +
                    "                <p class = \"parag\" id=\"premiumPriceResult\" >price per Kg: 20000T</p>\n" +
                    "                <p class = \"parag\">delivery day: 1 day</p>\n" +
                    "                <input type=\"radio\" id=\"gold\" name=\"prc\" value=\"gold\">\n" +
                    "                <label for=\"gold\">Gold</label><br>\n" +
                    "                <p class = \"parag\" id=\"goldPriceResult\" >price per Kg: 14000T</p>\n" +
                    "                <p class = \"parag\">delivery day: 3 days</p>\n" +
                    "                <input type=\"radio\" id=\"silver\" name=\"prc\" value=\"silver\">\n" +
                    "                <label for=\"silver\">Silver</label>\n" +
                    "                <p class = \"parag\" id=\"silverPriceResult\" >price per Kg: 10000T</p>\n" +
                    "                <p class = \"parag\">delivery day: 4 days</p>\n" +
                    "                <button type=\"button\" class=\"btn cancel\" onclick=\"closeForm()\">Close</button>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "        <input type=\"hidden\" name=\"startdate\" id=\"todayDate\"/>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "    </div><hr>\n" +
                    "\n" +
                    "    <label ><b>Summation</b></label>\n" +
                    "    <label id=\"queryString\"></label>\n" +
                    "    <input type=\"text\" value=\"\" id=\"result\"/>\n" +
                    "    <input type=\"hidden\" id=\"actualResult\"/>\n" +
                    "\n" +
                    "    <button type=\"submit\" class=\"registerbtn\" onclick=\"_validate();submit_false()\" disabled=\"true\" id=\"submit\">Submit</button>\n" +
                    "    </div>\n" +
                    "</form>\n" +
                    "\n" +
                    "<script src=\"scripts/newDelivery.js\"></script>\n" +
                    "<script src=\"scripts/Validity.js\"></script>\n" +
                    "<script type=\"text/javascript\">\n" +
                    "    function getDate()\n" +
                    "    {\n" +
                    "        var today = new Date();\n" +
                    "        var dd = today.getDate();\n" +
                    "        var mm = today.getMonth()+1; //January is 0!\n" +
                    "        var yyyy = today.getFullYear();\n" +
                    "        if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm}\n" +
                    "        today = yyyy+\"\"+mm+\"\"+dd;\n" +
                    "\n" +
                    "        document.getElementById(\"todayDate\").value = today;\n" +
                    "    }\n" +
                    "\n" +
                    "    //call getDate() when loading the page\n" +
                    "    getDate();\n" +
                    "</script>\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>");

        }else{
            writer.println("Please login first");
            request.getRequestDispatcher("customer.html").include(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
