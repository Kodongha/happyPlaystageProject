<%@page import="com.kh.hp.account.model.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserVO uv = (UserVO) request.getAttribute("uv");
	System.out.println("views:::" + uv);
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		alert("귀하의 아이디는 [ <%=uv.getUserEmail() %> ] 입니다.");
		location.href='<%=request.getContextPath()%>/views/account/login.jsp';
	});
</script>
</head>
<body>
</body>
</html>