<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="navigation.jsp"/>
<html>
<head>
</head>
<body>
	<h1>Search a User</h1>
	<form action="/twitter-api-3ks/" method="post">
		<input type="string" name="name"/>
		<button type="submit">Search User</button>
	</form>
	<%=request.getAttribute("responseString")%>
</body>