package app.servlets;

import app.entity.User;
import app.model.Base;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CheckLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        req.setAttribute("userLogin", login);
        User tmpUser = new User(login, pass);

        Base base = Base.getBase();
        List<User> list = base.getUser();

        for (User user : list) {
            if (user.getLogin().equals(login)) {
                if ((user.getPass().equals(pass))) {
                    RequestDispatcher rd = req.getRequestDispatcher("/welcomePage.jsp");
                    rd.forward(req, resp);
                    break;
                }
            }
            RequestDispatcher rd = req.getRequestDispatcher("/incorrect.jsp");
            rd.forward(req, resp);
        }
    }
}
