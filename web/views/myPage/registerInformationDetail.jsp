<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
  div {margin:auto};
  
  thead tr {
    background-color: gray;
  
  } 
  td {
    border: 1px solid lightgray;
  }
  
  label {
  	margin-left:auto;
  	margin-right:auto;
  }
  
  tbody tr:nth-child(1) {
    background-color: #b4b4b4;
  }
  
</style>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<h1 align="center" style="color:gray">대관 등록 내역 상세정보</h1>
	
	
	<div style="width:790px;">
	<h5>대관정보</h5>
	<table style="width:790px; height:113px; text-align:center; margin:auto; border-collapse: collapse;">
		<tr>
		<td>등록공간 고유번호</td>
		<td>등록공간 이름</td>
		<td>등록공간 상태</td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		</tr>
	</table>
	</div>
		
	
	<div style="width:790px;">
	<h5>검수진행상황</h5>
	<hr>
	<div style="width:240px;">
	<input type="radio" value="검수진행중">검수진행중&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="radio" value="검수완료">검수완료</div>
	<hr>
	</div>
	
	<div style="width:790px;">
	<h5>신청자 리스트</h5>
	<table style="width:790px; height:113px; text-align:center; margin:auto; border-collapse: collapse;">
		<tr>
		<td>신청자 닉네임</td>
		<td>신청공간 이름</td>
		<td>신청공간 상태</td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		</tr>
	</table>
	</div>
	
	<div style="width:790px;">
	<h5>계약자 정보</h5>
	<table style="width:790px; height:113px; text-align:center; margin:auto; border-collapse: collapse;">
		<tr>
		<td>계약계좌정보</td>
		<td>계약정보</td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		</tr>
	</table>
	</div>
	
	<hr>
	
	<div style="width:790px;"><h2><strong>성북마을극장</strong></h2></div>
	<div style="width:790px;"><h2 style="font-style:oblique">역삼의 열린공간. 성북마을 극장입니다</strong></h2></div>
	<div style="width:790px; height:380px; border:1px solid black">공연장사진</div>
	
	<div style="width:790px;">
	<h4>공간소개</h4>
	성북마을극장은 공연장 등록을 완료한 성신여대역 로데오 거리에 위치한 약 80석의 소극장입니다.성신여대 로데오거리에 위치한 지상 4층의 소극장입니다. 
	약 80석의 규모로 연극은 기본, 소규모 음악공연, 영상회, 상영회, 강연, 영화촬영, 무대 연습용 대관이 가능합니다. 장애인 이용가능합니다.
	</div>
	<br>
	
	<div style="width:790px;">
	<div style="float:left">
	<label><b>영업시간</b></label>
	<label>10시~22시</label>
	</div>
	<br>
	<div style="float:left">
	<label><b>휴무일</b> </label>
	<label>없음</label>
	</div>
	</div>
	
	<br>
	
	<div style="width:790px;">
	<h4>시설안내</h4>
	<ol>
	<li>1</li>
	<li>2</li>
	<li>3</li>
	</ol>
	</div>
	
	<div style="width:790px;">
	<h4>예약시 주의사항</h4>
	<ol>
	<li>1</li>
	<li>2</li>
	<li>3</li>
	</ol>
	</div>
	
	<div style="width:790px;">
	<div style="float:left">
	<label><b>대표자</b></label>
	<label>기성용</label>
	</div>
	<br>
	<div style="float:left">
	<label><b>상호명</b> </label>
	<label>주식회사 KIRARD</label>
	</div>
	<br>
	<div style="float:left">
	<label><b>전화번호</b> </label>
	<label>0504-0905-7515</label>
	</div>
	<br>
	<div style="float:left">
	<label><b>주소</b> </label>
	<label>서울특별시 성북구 동소문로 20다길 10 4층 성북마을극장</label>
	</div>
	<br>
	<div style="float:left">
	<label><b>웹사이트</b> </label>
	<label>http://sbtheater.org</label>
	</div>
	</div>
	<br><br>
	
	<div style="width:790px; height:380px; border:1px solid black">지도</div>
	
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>