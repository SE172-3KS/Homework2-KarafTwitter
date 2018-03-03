package org.threeks;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;

public class MyConnection {
	static String authString = "Bearer AAAAAAAAAAAAAAAAAAAAAER14gAAAAAApuJMwsvaiIkoQP0IPNSByLqz9gU%3DUQ5E3zxgK08dIZtarDNpQ826hBWkAUNVhMTEGl01mm68OBIUV4";
	
	//set up connection based on url and http method
	private static HttpURLConnection setUpConnection(URL url, String method) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setRequestProperty("Content-Type", "application/xml");
        connection.setRequestProperty("Authorization", authString);
        connection.setDoInput(true);
        return connection;
        
	}
	
	//return string input from http calls 
	private static String readOutput(HttpURLConnection con) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder responseString = new StringBuilder();
        String output = input.readLine();
        while (output != null) {
            responseString.append(output);
            output = input.readLine();
        }
        return responseString.toString();
	}
	
	//get user info
    public static JSONObject getResponse (String apiUrl) throws IOException{
        URL url = new URL(apiUrl);

        HttpURLConnection connection = setUpConnection(url, "GET");

        
        String responseString = readOutput(connection);
        
        connection.disconnect();
        
        JSONParser parser = new JSONParser();
        JSONObject json = null;
        try{
        	json = (JSONObject) parser.parse(responseString);
        }catch(Exception ex){
        	ex.printStackTrace();
        }
        
        return json;
    }
    
    //get user timeline
    public static JSONArray getArrayResponse(String apiUrl) throws IOException{
    	URL url = new URL(apiUrl);
    	
    	HttpURLConnection connection = setUpConnection(url, "GET");
    	
    	String responseString = readOutput(connection);
    	
    	connection.disconnect();
    	
    	JSONParser parser = new JSONParser();
    	JSONArray jsonArray = null;
    	try{
    		jsonArray = (JSONArray) parser.parse(responseString);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	
    	return jsonArray;
    }
}
