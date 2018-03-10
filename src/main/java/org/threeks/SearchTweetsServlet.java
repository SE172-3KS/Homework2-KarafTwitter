package org.threeks;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

public class SearchTweetsServlet extends HttpServlet
{
    protected static final String apiUrl = "https://api.twitter.com/1.1/search/tweets.json?q=%s&count=%d";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {	
        request.getRequestDispatcher("/searchTweets.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");
        int count = Integer.parseInt(req.getParameter("count"));
        JSONObject responseJson = MyConnection.getResponse(String.format(apiUrl, query, count ));
        resp.setContentType("application/json");
        req.setAttribute("jsonObject", responseJson);
        req.getRequestDispatcher("/searchTweets.jsp").forward(req, resp);
    }
}
