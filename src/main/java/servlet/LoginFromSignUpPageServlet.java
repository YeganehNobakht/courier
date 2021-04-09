package servlet;

import model.data.CustomerDao;
import service.Courier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginFromSignUpPageServlet")
public class LoginFromSignUpPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            String username = request.getParameter("username1");
            String password = request.getParameter("psw1");
            String mail = request.getParameter("email1");
            String name1 = request.getParameter("name1");
            String lastName1 = request.getParameter("lastName1");
            String mobileNumber = request.getParameter("mobileNumber");
            String province = request.getParameter("Province");
            String city = request.getParameter("citySelect");
            String street = request.getParameter("customerStreet");
            String block = request.getParameter("customerBlock");

            if (Courier.findDuplicateCustomerUsername(username)) {

                if (Courier.findDuplicateCustomerEmail(mail)) {
                    if (username != null && password != null) {
                        String address = province + ", " + city + "', " + street + ", " + block;
                        Courier.saveToCustomer(username, password, name1, lastName1, mail, mobileNumber, address);

                        //create session
                        HttpSession session = request.getSession();
                        session.setAttribute("name", name1);
                        session.setAttribute("username", username);
                        request.getRequestDispatcher("customerService.jsp").include(request, response);

                    } else {
                        HttpSession session = request.getSession(false);
                        String uname = (String) session.getAttribute("name");
                        if (uname != null) {
                            request.getRequestDispatcher("customerService.jsp").include(request, response);
                        } else {
                            request.getRequestDispatcher("customer.html").include(request, response);
                        }
                    }
                }else {
                    writer.println("<meta http-equiv='refresh' content='3;URL=index.jsp'>");//redirects after 3 seconds
                    writer.println("<p style='color:red;'>Email address is already exists!</p>");
                }
            }else {
                writer.println("<meta http-equiv='refresh' content='3;URL=index.jsp'>");//redirects after 3 seconds
                writer.println("<p style='color:red;'>Username is already exists!</p>");
            }
        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
