package tms.servlet.servlet;

import tms.servlet.dao.OperationDao;
import tms.servlet.entity.User;
import tms.servlet.service.OperationService;
import tms.servlet.service.OperationServiceImpl;
import tms.servlet.dao.OperationDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/calc", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    private final OperationDao operationDao = new OperationDaoImpl();
    private final OperationService operationService = OperationServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operationName = req.getParameter("operation");

        String result = String.valueOf(operationService.calculate(num1, num2, operationName));
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        operationDao.save(operationDao.createOperation(num1, num2, operationName, result, currentUser));

        req.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/calc.jsp").forward(req, resp);
    }
}
