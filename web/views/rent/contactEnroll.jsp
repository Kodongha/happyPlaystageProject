<%@page import="com.kh.hp.rent.model.vo.RentBasicVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	RentBasicVO requestRentBasicVO = (RentBasicVO) request.getAttribute("requestRentBasicVO");
	request.setAttribute("requestRentBasicVO1", requestRentBasicVO);
	System.out.println(requestRentBasicVO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<style type="text/css">
	label {
		font-size: 1.5em;
	}

	.necessary {
		color: red;
	}
</style>
</head>
<body>
	<jsp:include page="/views/common/header.jsp" />

	<div class="container">
		<h2>연락처 정보를 입력해주세요.</h2>
		<hr style="background: black">

		<form action="<%=request.getContextPath() %>/moveContact.rent" method="post">
			<!-- request RentBasicVO -->
			<input type="hidden" name="requestRentBasicVO" id="requestRentBasicVO" value="<%=requestRentBasicVO %>">

			<!-- 이메일 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="rentEmail">이메일</label>
				<input id="rentEmail" type="text" class="form-control" name="rentEmail" placeholder="Email">
			</div>

			<br>

			<!-- 휴대폰 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="rentPhone1">휴대폰</label>
				<br><br>
				<select class="form-control" name="rentPhone1" id="rentPhone1" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 0">
					<option>010</option>
					<option>011</option>
					<option>016</option>
					<option>017</option>
					<option>019</option>
				</select>
				<label>-</label>
				<input id="rentPhone2" type="tel" class="form-control" name="rentPhone2" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 2%">
				<label>-</label>
				<input id="rentPhone3" type="tel" class="form-control" name="rentPhone3" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 2%">
				<button type="button" id="cautionAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; min-width: 50px; float: right;">추가</button>
			</div>
			<p>
				* 해당 휴대폰으로 예약 관련 연락이 갑니다. (추가 핸드폰에도 동일한 연락이 갑니다.)
			</p>


			<br>

			<!-- 대표번호 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="rentMainTel1">대표번호</label>
				<br>

				<div class="ui checkbox">
					<input type="checkbox" name="example"><label>휴대폰과 동일</label>
				</div>

				<br>
				<select class="form-control" name="rentMainTel1" id="rentMainTel1" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 0">
					<option>010</option>
					<option>011</option>
					<option>016</option>
					<option>017</option>
					<option>019</option>
				</select>
				<label>-</label>
				<input id="rentMainTel12" type="tel" class="form-control" name="rentMainTel12" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 2%">
				<label>-</label>
				<input id="rentMainTel13" type="tel" class="form-control" name="rentMainTel13" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 2%">
			</div>

			<input type="text" class="form-control" name="hallNm" id="hallNm">
			<input type="text" class="form-control" name="hallSimIntro" id="hallSimIntro">
			<input type="text" class="form-control" name="hallDetIntro" id="hallDetIntro">
			<input type="text" class="form-control" name="hallInfo" id="hallInfo">
			<input type="text" class="form-control" name="perfPlanTf" id="perfPlanTf">


			<br><br>
			<button type="button" class="btn btn-danger" style="width: 49%;">취소</button>
			<button type="submit" class="btn btn-success" style="width: 49%; float: right;">다음</button>
		</form>
	</div>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>