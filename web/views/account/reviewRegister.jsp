<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import=" com.kh.hp.account.model.vo.*"%>
 <%
		ReviewSearchVO rs =(ReviewSearchVO) request.getAttribute("rs");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>리뷰 등록</title>


<style>

h4 {
	text-align: left;
	font-size: large;
	font-weight: bold;
}

#review1 {
	padding: 10px;
	width: 80%;
	margin-right: auto;
	margin-left: auto;
}

.form-group{
	padding: 5px;
	width: 80%;
	margin-right: auto;
	margin-left: auto;
}

#reviewContent{
	width: 100%;
	height: 200px;
	text-align: left;
}


</style>

</head>
<body>
	
	<jsp:include page="/views/common/header.jsp" />

	<h2 id="text1" align="center">
		<strong>리뷰 등록</strong></h2>
	<br>
	
	<form action="<%=request.getContextPath()%>/reviewInsert.acc" >
	<div class="review1" id="review1">
		<h4>리뷰를 입력해 주세요.</h4>
		<hr>
	</div>
	<br>

	<div class="form-group">
		<label for="공연장 명">공연장 명</label>  
		<input type="text" placeholder="예약번호를 확인하여 자동입력"
			class="form-control" value="<%= rs.getHallNm() %>" id="p1">
	</div>
	<div class="form-group">
		<label for="이용소감">공연장 이용 소감</label> <input type="text" name="reviewContent"
			class="form-control" name="reviewCon" id="reviewContent">
	</div>
	<div class="form-group">
		<label for="이미지">별점</label> <input type="number" placeholder="이미지는 최대 1개만 첨부 가능합니다."
			class="form-control" id="ran" name="ran">

	</div>
	
	


	
	<div class="chek1" style="margin: 50px;">
	<button type="button" class="btn btn-danger" style="width: 49%;" onclick="location.href='../main/main.jsp'">취소</button>
	<button type="submit" class="btn btn-success next-step" style="width: 49%; float: right;">저장</button>
	</div>
	
	</form>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>