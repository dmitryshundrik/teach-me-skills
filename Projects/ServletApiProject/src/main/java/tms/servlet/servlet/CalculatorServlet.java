package tms.servlet.servlet;

import tms.servlet.entity.User;
import tms.servlet.service.Calculator;
import tms.servlet.storage.OperationStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/calc", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    private final OperationStorage operationStorage = new OperationStorage();
    private final Calculator calculator = new Calculator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operationName = req.getParameter("operation");

        String result = String.valueOf(calculator.calculate(num1, num2, operationName));
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        operationStorage.save(operationStorage.createOperation(num1, num2, operationName, result, currentUser));

        req.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/calc.jsp").forward(req, resp);
    }
}
