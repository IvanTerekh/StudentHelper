package edu.iba.sh.controller.common;

//import edu.iba.sh.jms.JmsException;
//import edu.iba.sh.jms.JmsSender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SendMessage")
public class SendMessageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        sendMessage(text, request, response);
    }

    private void sendMessage(String text, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            JmsSender.send(text);
//            response.sendRedirect("Index");
//        } catch (JmsException e) {
//            request.setAttribute("errorMessage", "Failed to send message");
//            request.setAttribute("messageText", text);
//            request.getRequestDispatcher("WEB-INF/jsp/sendMessageForm.jsp").forward(request, response);
//        }
        response.sendRedirect("Index");
    }
}
