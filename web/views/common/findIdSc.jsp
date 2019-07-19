<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"import="com.kh.hp.account.model.vo.UserVO"%>
<%
	UserVO uv = (UserVO) request.getAttribute("uv");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2><%=uv.getUserEmail() %></h2>
</body>
</html>