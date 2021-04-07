package service;

import data.EmployeeDao;
import model.Employee;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "EmployeeSignInFilter")
public class EmployeeSignInFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        try {
            String username = req.getParameter("cUsername");
            String password = req.getParameter("cPassword");
            Employee employee = EmployeeDao.fetchEmployeeByUsername(username);

            if (employee != null && employee.getPassword().equals(password)) {
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


    public void init(FilterConfig config) throws ServletException {

    }

}
