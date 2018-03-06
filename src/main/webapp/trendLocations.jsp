<jsp:include page="navigation.jsp"/>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.Iterator"%>

<body>
    <h1>Trend Locations</h1>
    <form action="/twitter-api-3ks/trendLocations" method="POST">
        <input type="string" name="lat" placeholder="lat"/>
        <input type="string" name="long" placeholder="long"/>
        <button type="submit">See Locations</button>
    </form>

    <% JSONArray locationArr = (JSONArray) request.getAttribute("jsonArray"); %>
        <%
            if(locationArr!=null)
            {
                Iterator<JSONObject> iter = locationArr.iterator();
                while(iter.hasNext()){
                    JSONObject location = iter.next();
        %>
                    <p>Country:<%=location.get("country") %></p>
                    <p>Country Code:<%=location.get("countryCode") %></p>
                    <p>Name: <%=location.get("name") %></p>
                    <br>
            <%	}
            }
            %>
</body>