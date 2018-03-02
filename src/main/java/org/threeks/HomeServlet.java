package org.threeks;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("responseString", "");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String apiUrl = "https://api.twitter.com/1.1/users/show.json?screen_name=%s";
        String responseString = MyConnection.getResponse(String.format(apiUrl, req.getParameter("name")));

        resp.setContentType("application/json");
        req.setAttribute("responseString", responseString);
        System.out.println(responseString);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
