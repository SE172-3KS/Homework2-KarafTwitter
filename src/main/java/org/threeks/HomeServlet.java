package org.threeks;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String apiUrl = "http://api.timezonedb.com/v2/list-time-zone?key=%s";
        String apiKey = "G77MPV84CPEP";

        URL url = new URL(String.format(apiUrl, apiKey));

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/xml");
        connection.setDoInput(true);

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseString = new StringBuilder();
        String output = input.readLine();
        while (output != null) {
            responseString.append(output);
            output = input.readLine();
        }

        connection.disconnect();

        response.setContentType("application/json");
        request.setAttribute("responseString", responseString);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
