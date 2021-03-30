package service;

import data.EntityDao;
import model.NewDelivery;
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

@WebServlet(name = "TrackOrderServlet")
public class TrackOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session.getAttribute("name") != null) {
            writer.println("Welcome " + session.getAttribute("name"));
            int trackingCode = Integer.parseInt(request.getParameter("customerTrack"));
            OrderStatus orderStatus = EntityDao.fetchOrderByTrackingCode(trackingCode);
            if (orderStatus!=null){
                if (orderStatus.getAcceptDate() == null){
                    writer.println("<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<link rel=\"stylesheet\" href=\"trackStyle.css\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>track</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "\n" +
                            "<ol class=\"progress\" data-steps=\"4\">\n" +
                            "    <li class=\"done\">\n" +
                            "        <span class=\"name\">Registered</span>\n" +
                            "        <span class=\"step\"><span>1</span></span>\n" +
                            "    </li>\n" +
                            "    <li >\n" +
                            "        <span class=\"name\">Accepted</span>\n" +
                            "        <span class=\"step\"><span>2</span></span>\n" +
                            "    </li>\n" +
                            "    <li >\n" +
                            "        <span class=\"name\">Sending</span>\n" +
                            "        <span class=\"step\"><span>3</span></span>\n" +
                            "    </li>\n" +
                            "    <li>\n" +
                            "        <span class=\"name\">Delivered</span>\n" +
                            "        <span class=\"step\"><span>4</span></span>\n" +
                            "    </li>\n" +
                            "</ol>\n" +
                            "</body>\n" +
                            "</html>");
                }
                if (orderStatus.getAcceptDate() !=null && orderStatus.getSendingDate() == null){
                    writer.println("<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<link rel=\"stylesheet\" href=\"trackStyle.css\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>track</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "\n" +
                            "<ol class=\"progress\" data-steps=\"4\">\n" +
                            "    <li class=\"done\">\n" +
                            "        <span class=\"name\">Registered</span>\n" +
                            "        <span class=\"step\"><span>1</span></span>\n" +
                            "    </li>\n" +
                            "    <li class=\"active\">\n" +
                            "        <span class=\"name\">Accepted</span>\n" +
                            "        <span class=\"step\"><span>2</span></span>\n" +
                            "    </li>\n" +
                            "    <li >\n" +
                            "        <span class=\"name\">Sending</span>\n" +
                            "        <span class=\"step\"><span>3</span></span>\n" +
                            "    </li>\n" +
                            "    <li>\n" +
                            "        <span class=\"name\">Delivered</span>\n" +
                            "        <span class=\"step\"><span>4</span></span>\n" +
                            "    </li>\n" +
                            "</ol>\n" +
                            "</body>\n" +
                            "</html>");
                }
                if (orderStatus.getSendingDate() != null && orderStatus.getDeliverDate() == null){
                    writer.println("<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<link rel=\"stylesheet\" href=\"trackStyle.css\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>track</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "\n" +
                            "<ol class=\"progress\" data-steps=\"4\">\n" +
                            "    <li class=\"done\">\n" +
                            "        <span class=\"name\">Registered</span>\n" +
                            "        <span class=\"step\"><span>1</span></span>\n" +
                            "    </li>\n" +
                            "    <li class=\"done\">\n" +
                            "        <span class=\"name\">Accepted</span>\n" +
                            "        <span class=\"step\"><span>2</span></span>\n" +
                            "    </li>\n" +
                            "    <li class=\"active\">\n" +
                            "        <span class=\"name\">Sending</span>\n" +
                            "        <span class=\"step\"><span>3</span></span>\n" +
                            "    </li>\n" +
                            "    <li>\n" +
                            "        <span class=\"name\">Delivered</span>\n" +
                            "        <span class=\"step\"><span>4</span></span>\n" +
                            "    </li>\n" +
                            "</ol>\n" +
                            "</body>\n" +
                            "</html>");
                }
                if (orderStatus.getDeliverDate() !=null){
                    writer.println("<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<link rel=\"stylesheet\" href=\"trackStyle.css\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>track</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "\n" +
                            "<ol class=\"progress\" data-steps=\"4\">\n" +
                            "    <li class=\"done\">\n" +
                            "        <span class=\"name\">Registered</span>\n" +
                            "        <span class=\"step\"><span>1</span></span>\n" +
                            "    </li>\n" +
                            "    <li class=\"done\">\n" +
                            "        <span class=\"name\">Accepted</span>\n" +
                            "        <span class=\"step\"><span>2</span></span>\n" +
                            "    </li>\n" +
                            "    <li class=\"done\">\n" +
                            "        <span class=\"name\">Sending</span>\n" +
                            "        <span class=\"step\"><span>3</span></span>\n" +
                            "    </li>\n" +
                            "    <li class=\"active\">\n" +
                            "        <span class=\"name\">Delivered</span>\n" +
                            "        <span class=\"step\"><span>4</span></span>\n" +
                            "    </li>\n" +
                            "</ol>\n" +
                            "</body>\n" +
                            "</html>");
                }
            }else{
                writer.println("Incorrect track code");
                request.getRequestDispatcher("/trackCode1").include(request, response);
            }



        }else{
            writer.println("Please login first");
            request.getRequestDispatcher("customer.html").include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
