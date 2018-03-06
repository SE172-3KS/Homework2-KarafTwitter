<jsp:include page="navigation.jsp"/>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.Iterator"%>

<body>
    <h1>Get Followers</h1>
    <form action="/twitter-api-3ks/getFollowers" method="POST">
        <input type="string" name="screenName" placeholder="Screen Name"/>
        <button type="submit">Get Followers</button>
    </form>

    <%
    JSONObject queryResponse = (JSONObject)request.getAttribute("jsonObject");
    %>

    <%
    if (queryResponse != null) {
        JSONArray statuses = (JSONArray)queryResponse.get("users");
        Iterator<JSONObject> it = statuses.iterator();
        while (it.hasNext()) {
            JSONObject obj = it.next();
            %>
            <p>Name: <%=obj.get("name")%></p>
            <p>Screen Name: <%=obj.get("screen_name")%></p>
            <p>Followers Count: <%=obj.get("followers_count")%></p>
            <br>
            <%
        }
    }
    %>
</body>
