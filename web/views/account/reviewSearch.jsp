<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

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

<title>Insert title here</title>


<style>
#line {
	border: 0.5px solid gray;
	width: 1024px;
	margin: auto;
}

#text1 {
	width: 180px;
	height: 30px;
	margin: auto;
}

#area {
	border: 2px solid black;
	width: 1000px;
	height:100px;
		margin: auto;
}
#area1 {
	border: 1px solid black;
	width: 600px;
	height:50px;
	margin-left:240px;
	margin-top:-45px;
}



#Information{
	font-weight: bold ;
	font-size:30px;
	margin-left:10px;
	margin-top:25px;
}
#searchbutton{
	margin-left:900px;
	margin-top:-70px;
}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />

	<h2 id="text1" align="center">
		<strong>리뷰</strong>

	</h2>
	<br>
	<!-- 회원관리내역과 검색창 사이의 선 -->
	<div id="line"></div>
	<br>
	

	<div id="area">
		<div id="Information">예약정보 검색 :
		&nbsp; 
		
		<tr>
			<td><input type="text" placeholder="예약 번호" id="search" style="width: 60%"></td>
		</tr>
		</div>
		<button type="button" class="btn btn-warning" id="searchbutton" onclick="search()">등록</button>
	
			


	
		</div>
	<%-- 	<script>
		function search(){
		var num = $("#search").val();
		location.href = "<%=request.getContextPath()%>/reviewInsert.acc?num="+num;	
		console.log(num);
		
		}
		
		
		
		</script> --%>
		

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>