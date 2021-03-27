package service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body style=\"background-color:powderblue;\">");
        HttpSession session = request.getSession(false);
        if (session.getAttribute("name") != null) {
            session.invalidate();
            writer.println("You are successfully logged out");
            writer.println("<br><a href='customer.html'>Login</a>");
        }
        else {
            writer.println("Please login first.");
            request.getRequestDispatcher("customer.html").include(request, response);
        }
        writer.println("</html></body>");
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
