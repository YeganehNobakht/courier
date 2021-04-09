package servlet;

import model.data.CustomerDao;
import model.NewDelivery;
import model.OrderStates;
import model.OrderStatus;
import service.Courier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SubmitServlet")
public class SubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        if (session.getAttribute("name") != null) {
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
           String dateOfRegistration = request.getParameter("startdate");
           String usernamae = (String) session.getAttribute("username");

           NewDelivery newDelivery = new NewDelivery(originAddress,desAddress,recPhone,recName,packageType,weight,packageSize,sendType,dateOfRegistration,usernamae);
            int trackingCode = Courier.generateTrackingCode(newDelivery);
            request.setAttribute("trackingCode", "trackingCode");
            String username = (String) session.getAttribute("username");

            OrderStatus orderStatus = new OrderStatus(trackingCode,dateOfRegistration, OrderStates.REGISTERED,username);
            CustomerDao.save(orderStatus);
            CustomerDao.save(newDelivery);

            request.getRequestDispatcher("submit.jsp").include(request, response);
          }else{
            request.getRequestDispatcher("customer.html").include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
