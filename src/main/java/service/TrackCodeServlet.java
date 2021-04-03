package service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TrackCodeServlet")
public class TrackCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session.getAttribute("name") != null) {
            writer.println("Welcome " + session.getAttribute("name"));
            writer.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<link rel=\"stylesheet\" href=\"firstpagestyle.css\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>trackCode</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"content\">\n" +
                    "    <form  method=\"post\" action=\"TrackOrder\">\n" +
                    "\n" +
                    "        <div class=\"modal-img\">\n" +
                    "            <img src=\"trackCode1.png\" style=\"width: 256px;height: 256px;\" alt=\"\">\n" +
                    "        </div>\n" +
                    "            <center>\n" +
                    "            <input type=\"text\" name=\"customerTrack\" placeholder=\"Enter Your Track Code\">\n" +
                    "            <button type=\"submit\">Tracking</button>\n" +
                    "            </center>\n" +
                    "            <br><br>\n" +
                    "    </form>\n" +
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
