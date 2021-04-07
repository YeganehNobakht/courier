package service;

import data.CustomerDao;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginFromSineInPageServlet")
public class LoginFromSineInPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username != null && password !=null ) {
                Customer customer = CustomerDao.fetchCustomerByUsername(username);
                HttpSession session = request.getSession();
                session.setAttribute("name", customer.getName());
                request.getRequestDispatcher("/service").include(request, response);
            }
            else {
                HttpSession session = request.getSession(false);
                String uname = (String) session.getAttribute("name");
                if (uname!=null){
                    request.getRequestDispatcher("/service").include(request, response);
                }else {
                    writer.println("Please login first");
                    request.getRequestDispatcher("customer.html").include(request, response);

                }
                writer.close();
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
