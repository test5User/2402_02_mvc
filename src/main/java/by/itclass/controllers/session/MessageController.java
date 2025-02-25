package by.itclass.controllers.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/message")
public class MessageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        var sessionMessage = (String) session.getAttribute("sessionMessage");
        var requestMessage = (String) req.getAttribute("requestMessage");
        resp.getWriter()
                .append("Session message: " + sessionMessage)
                .append("\n")
                .append("Request message: " + requestMessage);
    }
}
