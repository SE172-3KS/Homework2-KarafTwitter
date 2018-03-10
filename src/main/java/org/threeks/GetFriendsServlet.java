package org.threeks;

import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetFriendsServlet extends HttpServlet{
    protected static final String apiUrl = "https://api.twitter.com/1.1/friends/list.json?screen_name=%s";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/getFriends.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("screenName");
        JSONObject responseJson = MyConnection.getResponse(String.format(apiUrl, query));
        resp.setContentType("application/json");
        req.setAttribute("jsonObject", responseJson);
        req.getRequestDispatcher("/getFriends.jsp").forward(req, resp);
    }
}
