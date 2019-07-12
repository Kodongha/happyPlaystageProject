<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>

	tr{
		text-align: center;
	}
	
	th{
		text-align: center;
		background-color: #EAEAEA;
	}
	
  </style>
  
</head>
<body>
<jsp:include page="/views/common/header.jsp" />
<div class="container">
  <h3>대관 신청 내역 검색결과</h3>
  <hr>          
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>신청 공연장 고유번호</th>
        <th>공연장 이름</th>
        <th>신청 일자</th>
        <th>신청 상태</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>001</td>
        <td>아트홀</td>
        <td>2019/01/01</td>
        <td>대기중</td>
      </tr>
      <tr>
        <td>002</td>
        <td>블랙홀</td>
        <td>2019/01/01</td>
      	<td>대기중</td>
      </tr>
      <tr>
        <td>003</td>
        <td>공연홀</td>
        <td>2019/01/01</td>
      	 <td>대기중</td>
      </tr>
    </tbody>
  </table>
</div>
<jsp:include page="/views/common/footer.jsp" />
</body>
</html>