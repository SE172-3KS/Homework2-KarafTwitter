package org.threeks;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

public class UserFavoritesServlet extends HttpServlet
{
    protected static final String apiUrl = "https://api.twitter.com/1.1/favorites/list.json?screen_name=%s&count=%d";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/userFavorites.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String screenName = req.getParameter("name");
        int count = Integer.parseInt(req.getParameter("count"));
        JSONArray responseJsonArray = MyConnection.getArrayResponse(String.format(apiUrl, screenName, count ));
        resp.setContentType("application/json");
        req.setAttribute("jsonArray", responseJsonArray);
        req.getRequestDispatcher("/userFavorites.jsp").forward(req, resp);
    }
}
