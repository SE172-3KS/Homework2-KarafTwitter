package org.threeks;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

public class UserTimelineServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {	
        request.getRequestDispatcher("/userTimeline.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String apiUrl = "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=%s&count=%d";
        String screenName = req.getParameter("name");
        int count = Integer.parseInt(req.getParameter("count"));
        JSONArray responseJsonArray = MyConnection.getUserTimeline(String.format(apiUrl, screenName, count ));
        resp.setContentType("application/json");
        req.setAttribute("jsonArray", responseJsonArray);
        req.getRequestDispatcher("/userTimeline.jsp").forward(req, resp);
    }
}
