package by.itclass.controllers;

import by.itclass.model.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dbSearch")
public class SearchFromDb extends HttpServlet {
    private UserService service;

    @Override
    public void init() throws ServletException {
        service = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var params = req.getParameterMap();
        var users = service.getUsersFomDbByCriteria(params);
        if (users.isEmpty()) {
            req.setAttribute("message", "Users not found");
        } else {
            req.setAttribute("users", users);
        }
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }
}
