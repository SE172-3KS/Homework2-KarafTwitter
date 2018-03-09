<jsp:include page="navigation.jsp"/>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.Iterator"%>

<body>
	<h1>User Favorites</h1>
	<form action="/twitter-api-3ks/userFavorites" method="POST">
		<input type="string" name="name" placeholder="screenName"/>
		<input type="number" name="count" placeholder="count"/>
		<button type="submit">See Favorites</button>
	</form>

	<% JSONArray favArr = (JSONArray) request.getAttribute("jsonArray"); %>
		<%
			if(favArr!=null)
			{
				Iterator<JSONObject> iter = favArr.iterator();
				while(iter.hasNext()){
					JSONObject fav = iter.next(); %>
					<p>Tweet:<%=fav.get("text") %></p>
					<p>Posted: <%=fav.get("created_at") %></p>
					<br>
			<%	}
			}
			%>
</body>
