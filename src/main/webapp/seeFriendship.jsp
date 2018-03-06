<jsp:include page="navigation.jsp"/>
<%@ page import="org.json.simple.JSONObject"%>

<body>
    <h1>See Friendship</h1>
    <form action="/twitter-api-3ks/seeFriendship" method="POST">
        <input type="string" name="source" placeholder="Source Screen Name" required="" />
        <input type="string" name="target" placeholder="Target Screen Name"required="" />
        <button type="submit">See Friendship</button>
    </form>


    <%
    JSONObject jsonResponse = (JSONObject)request.getAttribute("jsonObject");
    %>

    <%
    if (jsonResponse != null) {
        JSONObject relationship = (JSONObject)jsonResponse.get("relationship");
        JSONObject source = (JSONObject)relationship.get("source");
        %>
        <p><%=request.getParameter("source")%> is <%= Boolean.parseBoolean(source.get("following").toString()) ? "" : "not"%> following <%=request.getParameter("target")%></p>
        <p><%=request.getParameter("source")%> is <%= Boolean.parseBoolean(source.get("followed_by").toString()) ? "" : "not"%> followed by <%=request.getParameter("target")%></p>
        <br>
        <%
    }
    %>
</body>
