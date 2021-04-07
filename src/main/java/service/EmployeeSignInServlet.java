package service;

import data.EmployeeDao;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CustomerSignInServlet")
public class EmployeeSignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        try {
            String username = request.getParameter("cUsername");
            String password = request.getParameter("cPassword");

            if (username != null && password !=null ) {
                Employee employee = EmployeeDao.fetchEmployeeByUsername(username);
                HttpSession session = request.getSession();
                session.setAttribute("name", employee.getName());
                session.setAttribute("username", employee.getUsername());
                request.getRequestDispatcher("/employeeServices").include(request, response);
            }
            else {
                HttpSession session = request.getSession(false);
                String uname = (String) session.getAttribute("name");
                if (uname!=null){
                    request.getRequestDispatcher("/employeeServices").forward(request, response);
                }else {
                    writer.println("Please login first");
                    request.getRequestDispatcher("employee.html").include(request, response);

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
