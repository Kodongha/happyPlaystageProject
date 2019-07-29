<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#createQnA").click(function(){
			location.href="<%=request.getContextPath()%>/createQna.sc";
		});
	});


</script>
</head>
<body>
	<jsp:include page="/views/common/header.jsp" />

	<div class="container" align="center">
		<button class="btn btn-primary" id="createQnA">관리자에게 문의하기 ! </button>
	</div>


	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>