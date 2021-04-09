package servlet;

import data.CustomerDao;
import model.Customer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "CustomerSignInFilter")
public class CustomerSignInFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            Customer customer = CustomerDao.fetchCustomerByUsername(username);

            if (customer != null && customer.getPassword().equals(password)) {
                chain.doFilter(req, resp);
            }
            else {
                writer.println("Invalid username or password");
                req.getRequestDispatcher("customerSignIn.html").include(req, resp);
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
