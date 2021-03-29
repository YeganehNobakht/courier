package service;

import data.EntityDao;
import model.NewDelivery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "SubmitServlet")
public class SubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session.getAttribute("name") != null) {
            writer.println("Welcome " + session.getAttribute("name"));
            String originProvince = request.getParameter("originProvince");
           String originCity = request.getParameter("originCity");
           String originStreet = request.getParameter("street");
           String originBlock = request.getParameter("block");

           String originAddress = originProvince+", "+originCity+"', "+originStreet+", "+originBlock;

           String destinationProvince = request.getParameter("destinationProvince");
           String destinationCity = request.getParameter("destinationCity");
           String desStreet = request.getParameter("desstreet");
           String desBlock = request.getParameter("desblock");

           String desAddress = destinationProvince+", "+destinationCity+"', "+desStreet+", "+desBlock;

           String recPhone = request.getParameter("recPhone");
           String recName = request.getParameter("recName");
           int weight = Integer.parseInt(request.getParameter("weight"));
           String packageType = request.getParameter("radioButton");
           String packageSize = request.getParameter("nDocOption");
           String sendType = request.getParameter("prc");
           Date dateOfRegistration = Date.valueOf(request.getParameter("date-of-registration"));

           NewDelivery newDelivery = new NewDelivery(originAddress,desAddress,recPhone,recName,packageType,weight,packageSize,sendType,dateOfRegistration);

            int trackingCode = 0;
            if (EntityDao.getMaxReserveNumber() != null) {
                trackingCode = EntityDao.getMaxReserveNumber()+1;
                newDelivery.setTrackingCode(trackingCode);
            } else {
                trackingCode = 10001;
                newDelivery.setTrackingCode(trackingCode);
            }

            EntityDao.save(newDelivery);
            writer.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<link rel=\"stylesheet\" href=\"firstpagestyle.css\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>submit</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"km-pay-state-style km-box-style2\">\n" +
                    "    <div class=\"KM_wrapperStatusCart\"><img src=\"submit.png\"></div>\n" +
                    "    <div>Order \"trackingCode\" was successfully registered</div>\n" +
                    "    <div class=\"KM_wrapperFollowUpOrder\">\n" +
                    "        <a class=\"KM_FollowUpOrderLink\" href=\"trackOrder\" target=\"_blank\">Tracking Order</a>\n" +
                    "        <a class=\"KM_returnHome\" href=\"service\">Return to home page</a></div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</body>\n" +
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
