package org.threeks;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

public class TrendLocationsServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {	
        request.getRequestDispatcher("/trendLocations.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String apiUrl = "https://api.twitter.com/1.1/trends/closest.json?lat=%f&long=%f";
        Double lat = Double.parseDouble(req.getParameter("lat"));
        Double longi = Double.parseDouble(req.getParameter("long"));
        JSONArray responseJsonArray = MyConnection.getArrayResponse(String.format(apiUrl,lat,longi));
        resp.setContentType("application/json");
        req.setAttribute("jsonArray", responseJsonArray);
        req.getRequestDispatcher("/trendLocations.jsp").forward(req, resp);
    }
}
