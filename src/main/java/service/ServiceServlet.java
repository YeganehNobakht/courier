package service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServiceServlet")
public class ServiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session.getAttribute("name") != null) {
            writer.println("Welcome "+session.getAttribute("name"));
            writer.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<link rel=\"stylesheet\" href=\"firstpagestyle.css\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>service</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\n" +
                    "<div class=\"button-item\">\n" +
                    "    <div class=\"shift\">\n" +
                    "    <div class=\"\">\n" +
                    "    <a class=\"inner-button\"\n" +
                    "       tabindex=\"0\" role=\"button\" aria-disabled=\"false\" title=\"New Delivery\" href=\"delivery\">\n" +
                    "        <div class=\"item-img\"><img src=\"newdelivery.jpg\" alt=\"\"></div>\n" +
                    "    </a>\n" +
                    "    </div>\n" +
                    "<div >\n" +
                    "    <a class=\"inner-button \"\n" +
                    "       tabindex=\"0\" role=\"button\" aria-disabled=\"false\" title=\"Track Order\" href=\"trackorder\">\n" +
                    "        <div class=\"item-img\"><img src=\"track.png\" alt=\"\"></div>\n" +
                    "    </a>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "    </div>\n" +
                    "\n" +
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
