package servlet;

import service.Courier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddNewEmployeeServlet")
public class AddNewEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try {
            String username = request.getParameter("username1");
            String password = request.getParameter("psw1");
            String mail = request.getParameter("mail1");
            String name1 = request.getParameter("name1");
            String lastName1 = request.getParameter("lastName1");
            String mobileNumber = request.getParameter("mobileNumber");
            String province = request.getParameter("Province");
            String city = request.getParameter("citySelect");
            String street = request.getParameter("customerStreet");
            String block = request.getParameter("customerBlock");

            String address = province + ", " + city + "', " + street + ", " + block;

            Courier.saveToEmployee(username, password, name1, lastName1, mail, mobileNumber, address);

            request.getRequestDispatcher("registerEmployee.jsp").include(request, response);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
