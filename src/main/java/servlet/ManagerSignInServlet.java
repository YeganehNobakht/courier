package servlet;

import data.ManagerDao;
import model.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "ManagerSignInServlet")
public class ManagerSignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username != null && password !=null ) {
                Manager manager = ManagerDao.fetchEmployeeByUsername(username);
                HttpSession session = request.getSession();
                session.setAttribute("name", manager.getName());
                session.setAttribute("username", manager.getUsername());
                request.getRequestDispatcher("managerServices.jsp").include(request, response);
            }
            else {
                HttpSession session = request.getSession(false);
                String uname = (String) session.getAttribute("name");
                if (uname!=null){
                    request.getRequestDispatcher("managerServices.jsp").forward(request, response);
                }else {
                    request.getRequestDispatcher("manager.html").include(request, response);

                }
                writer.close();
            }
        }catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
