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
		
		<form action="#">
			<!-- 이메일 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="email">이메일</label> 
				<input id="email" type="text" class="form-control" name="email" placeholder="Email">
			</div>
			
			<br>
			
			<!-- 휴대폰 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="phone1">휴대폰</label>
				<br><br>
				<select class="form-control" id="phone1" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 0">
					<option>010</option>
					<option>011</option>
					<option>016</option>
					<option>017</option>
					<option>019</option>
				</select>
				<label>-</label>
				<input id="phone2" type="tel" class="form-control" name="phone2" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 2%">
				<label>-</label>
				<input id="phone3" type="tel" class="form-control" name="phone3" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 2%">
				<button type="button" id="cautionAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; min-width: 50px; float: right;">추가</button>
			</div>
			<p>
				* 해당 휴대폰으로 예약 관련 연락이 갑니다. (추가 핸드폰에도 동일한 연락이 갑니다.) 
			</p>


			<br>
			
			<!-- 대표번호 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="mailTel1">대표번호</label>
				<br>
				
				<div class="ui checkbox">
					<input type="checkbox" name="example"><label>휴대폰과 동일</label>
				</div>
				
				<br>
				<select class="form-control" id="mailTel1" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 0">
					<option>010</option>
					<option>011</option>
					<option>016</option>
					<option>017</option>
					<option>019</option>
				</select>
				<label>-</label>
				<input id="mailTel2" type="tel" class="form-control" name="mailTel2" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 2%">
				<label>-</label>
				<input id="mailTel3" type="tel" class="form-control" name="mailTel3" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 2%">
			</div>
			
			<br><br>
			<button type="button" class="btn btn-danger" style="width: 49%;">취소</button>
			<button type="button" class="btn btn-success" style="width: 49%; float: right;">다음</button>
		</form>
	</div>
	
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>