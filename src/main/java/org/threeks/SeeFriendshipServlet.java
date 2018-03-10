package org.threeks;

import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SeeFriendshipServlet extends HttpServlet{

    protected static final String apiUrl = "https://api.twitter.com/1.1/friendships/show.json?source_screen_name=%s&target_screen_name=%s";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/seeFriendship.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String source = req.getParameter("source");
        String target = req.getParameter("target");
        JSONObject responseJson = MyConnection.getResponse(String.format(apiUrl, source, target));
        resp.setContentType("application/json");
        req.setAttribute("jsonObject", responseJson);
        req.getRequestDispatcher("/seeFriendship.jsp").forward(req, resp);
    }


}
