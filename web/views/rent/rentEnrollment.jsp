<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
		<h2>대관 정보를 입력해주세요.</h2>
		<hr style="background: black">
		<form action="#">
			<div class="form-group">
				<label class="necessary">*</label><label for="hallName">공연장 명</label> 
				<input type="text" class="form-control" id="hallName" placeholder="공연장 명을 입력해주세요." name="hallName">
			</div>
			<br>
			<div class="form-group">
				<label class="necessary">*</label><label for="hallintro">공연장 한 줄 소개</label> 
				<input type="password" class="form-control" id="hallintro" placeholder="공연장 한 줄 소개를 입력해주세요." name="hallintro">
			</div>
			<br>
			<div class="form-group">
				<label class="necessary">*</label><label for="hallDetailIntro">공연장 상세 소개</label> 
				<textarea class="form-control" rows="5" id="hallDetailIntro" placeholder="공연장 상세 소개를 입력해주세요." style="resize:none"></textarea>
			</div>
			<br>
			<div class="form-group">
				<label class="necessary">*</label><label for="hallInfo">시설 안내</label>

				
				<div class="form-group">
					<input type="text" class="col-sm-10 col-xs-10 form-control" id="hallInfo" placeholder="공연장 한 줄 소개를 입력해주세요." name="hallInfo" style="width: 80%">
					<button type="button" id="hallInfoAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">추가</button>
					<br><br>
					<input type="text" class="form-control" id="hallInfo" placeholder="공연장 한 줄 소개를 입력해주세요." name="hallInfo" style="width: 100%;">
				</div>
			</div>
			
			<script type="text/javascript">
				$(function(){
					$("#hallInfoAddBtn").click(function(){
						console.log("aa");
						$("#hallInfo").clone(true).addClass();
						
						// .appendTo($("#hallInfo").last());
					});
				});
			
			</script>
			
			
			
			
			
			
			<br><br><br>
			<button type="button" class="btn btn-danger" style="width: 49%;">취소</button>
			<button type="submit" class="btn btn-success" style="width: 49%; float: right;">다음</button>
		</form>
	</div>


	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>