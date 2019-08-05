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

<link href="/happyPlaystage/css/common/all.min.css" rel="stylesheet">
<script src="/happyPlaystage/js/common/all.min.js"></script>

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

	<div class="container" align="center" style="margin-top : 10%; margin-bottom: 10%;">
		<i class="fas fa-question-circle" style="width: 150px; height: 150px;"></i>
		<h3>궁금하신 사항이 있으시다면, <br> 관리자에게 문의하세요.</h3>
		<br>
		<button class="btn btn-primary" id="createQnA">관리자에게 문의하기 ! </button>
	</div>


	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>