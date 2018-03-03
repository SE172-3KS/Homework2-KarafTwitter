package org.threeks;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyConnection {
    public static String getResponse (String apiUrl) throws IOException{
        URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/xml");
        connection.setRequestProperty("Authorization", "Bearer AAAAAAAAAAAAAAAAAAAAAER14gAAAAAApuJMwsvaiIkoQP0IPNSByLqz9gU%3DUQ5E3zxgK08dIZtarDNpQ826hBWkAUNVhMTEGl01mm68OBIUV4");
        connection.setDoInput(true);

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseString = new StringBuilder();
        String output = input.readLine();
        while (output != null) {
            responseString.append(output);
            output = input.readLine();
        }
        connection.disconnect();
        return responseString.toString();
    }
}
