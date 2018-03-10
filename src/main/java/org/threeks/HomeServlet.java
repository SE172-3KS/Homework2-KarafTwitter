package org.threeks;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet
{
    protected static final String apiUrl = "https://api.twitter.com/1.1/users/show.json?screen_name=%s";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("jsonObject", null);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject responseJson = MyConnection.getResponse(String.format(apiUrl, req.getParameter("name")));
        resp.setContentType("application/json");
        req.setAttribute("jsonObject", responseJson);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
