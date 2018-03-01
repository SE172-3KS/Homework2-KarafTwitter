<jsp:include page="navigation.jsp"/>
<html>
<head>
	<title>Hello World!</title>
</head>
<body>
	<h1>Welcome home!</h1>
	<%=request.getAttribute("responseString")%>
</body>