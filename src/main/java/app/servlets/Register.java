package app.servlets;
import app.entity.User;
import app.model.Base;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class Register extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        User user = new User(login, pass);
        Base base = Base.getBase();
        base.addUser(user);
        req.setAttribute("userLogin", login);
        RequestDispatcher rd = req.getRequestDispatcher("/welcomePage.jsp");
        rd.forward(req, resp);

    }
}
