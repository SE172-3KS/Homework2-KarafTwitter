<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.json.simple.JSONObject"%>

<jsp:include page="navigation.jsp"/>

	<h1>Search a User</h1>
	<form action="/twitter-api-3ks/" method="post">
		<input type="string" name="name" placeholder="screenName"/>
		<button type="submit">Search User</button>
	</form>
	<% JSONObject json = (JSONObject) request.getAttribute("jsonObject"); %>
	<%
		if(json!=null)
		{
		%>
		 <h2>Info of <%=request.getParameter("name") %></h2>
		 <ul>
		 	<li>Name: <%=json.get("name") %></li>
		 	<li>ScreenName: <%=json.get("screen_name") %></li>
		 	<li>Friends: <%=json.get("friends_count") %></li>
		 	<li>Followers: <%=json.get("followers_count") %></li>
		 	<li>Text: <%=json.get("texts") %>
		 </ul>
		 
		<%
		}
		%>
</body>