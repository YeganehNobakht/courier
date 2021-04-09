package servlet;

import data.EmployeeDao;
import data.ManagerDao;
import model.Employee;
import model.Manager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "ManagerSignInFilter")
public class ManagerSignInFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            Manager manager = ManagerDao.fetchEmployeeByUsername(username);

            if (manager != null && manager.getPassword().equals(password)) {
                chain.doFilter(req, resp);
            }
            else {
                writer.println("Invalid username or password");
                req.getRequestDispatcher("employee.html").include(req, resp);
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }


    }

}
