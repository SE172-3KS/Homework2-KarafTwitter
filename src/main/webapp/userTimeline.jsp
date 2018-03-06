<jsp:include page="navigation.jsp"/>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.Iterator"%>

<body>
	<h1>User Timeline</h1>
	<form action="/twitter-api-3ks/userTimeline" method="POST">
		<input type="string" name="name" placeholder="screenName" required=""/>
		<input type="number" name="count" placeholder="count" required=""/>
		<button type="submit">See Timeline</button>
	</form>

	<% JSONArray timelineArr = (JSONArray) request.getAttribute("jsonArray"); %>
		<%
			if(timelineArr!=null)
			{
				Iterator<JSONObject> iter = timelineArr.iterator();
				while(iter.hasNext()){
					JSONObject timeline = iter.next(); %>
					<p>Tweet:<%=timeline.get("text") %></p>
					<p>Posted: <%=timeline.get("created_at") %></p>
					<br>
			<%	}
			}
			%>
</body>
