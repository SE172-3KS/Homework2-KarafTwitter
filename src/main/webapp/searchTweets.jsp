<jsp:include page="navigation.jsp"/>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.Iterator"%>

<body>
    <h1>Search Tweets</h1>
    <form action="/twitter-api-3ks/searchTweets" method="POST">
        <input type="string" name="query" placeholder="Query" required="" />
        <input type="number" name="count" placeholder="Count"required="" />
        <button type="submit">Search Tweets</button>
    </form>


    <%
    JSONObject queryResponse = (JSONObject)request.getAttribute("jsonObject");
    %>

    <%
    if (queryResponse != null) {
        JSONArray statuses = (JSONArray)queryResponse.get("statuses");
        Iterator<JSONObject> it = statuses.iterator();
        while (it.hasNext()) {
            JSONObject obj = it.next();
            %>
            <p>Tweet: <%=obj.get("text")%></p>
            <p>Created at: <%=obj.get("created_at")%></p>
            <br>
            <%

        }
    }
    %>
</body>
