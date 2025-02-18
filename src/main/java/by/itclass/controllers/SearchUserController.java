package by.itclass.controllers;

import by.itclass.model.db.DataBase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/searchUser")
public class SearchUserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var id = Integer.parseInt(req.getParameter("id"));
        var user = DataBase.findUserById(id);
        var rd = req.getRequestDispatcher("/user.jsp");
        if (user != null) {
            req.setAttribute("user", user);
        } else {
            req.setAttribute("message", "User not found");
        }
        rd.forward(req, resp);
    }
}
