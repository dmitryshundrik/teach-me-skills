package tms.servlet.servlet;

import tms.servlet.dao.UserDao;
import tms.servlet.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(userDao.findByUsername(username).isPresent()) {
            req.setAttribute("message", "Wrong username!");
            getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
        } else {
            userDao.save(userDao.createUser(name, username, password));
            resp.sendRedirect("/");
        }
    }
}
