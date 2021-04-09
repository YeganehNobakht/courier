package servlet;

import data.NewDeliveryDao;
import data.OrderStatusDao;
import model.OrderStates;
import model.OrderStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AcceptOrderServlet")
public class AcceptOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session.getAttribute("name") != null) {
            String username = (String) session.getAttribute("username");
            String date = request.getParameter("startdate");
            //writer.println("Welcome " + session.getAttribute("name"));
            int trackingCode = Integer.parseInt(request.getParameter("trck"));
            OrderStatus orderStatus = OrderStatusDao.fetchOrderByTrackingCode(trackingCode);
            if (orderStatus != null) {
                orderStatus.setEmployeeId(username);
                orderStatus.setAcceptDate(date);
                orderStatus.setOrderStates(OrderStates.ACCEPTED);
                OrderStatusDao. update(orderStatus);
                NewDeliveryDao.delete(trackingCode);
                request.getRequestDispatcher("/accepted").forward(request, response);
            }else {
                    writer.println("Incorrect track code");
                    request.getRequestDispatcher("/takeMoreOrder").include(request, response);
                }
        } else {
            writer.println("Please login first");
            request.getRequestDispatcher("customer.html").include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
