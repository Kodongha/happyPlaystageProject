<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>

<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>


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

			<!-- 공연장명 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="hallName">공연장 명</label>
				<input type="text" class="form-control" id="hallName" placeholder="공연장 명을 입력해주세요." name="hallName">
			</div>

			<br>

			<!-- 공연장 한 줄 소개 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="hallintro">공연장 한 줄 소개</label>
				<input type="text" class="form-control" id="hallintro" placeholder="공연장 한 줄 소개를 입력해주세요." name="hallintro">
			</div>

			<br>

			<!-- 공연장 상세 소개 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="hallDetailIntro">공연장 상세 소개</label>
				<textarea class="form-control" rows="5" id="hallDetailIntro" placeholder="공연장 상세 소개를 입력해주세요." style="resize:none"></textarea>
			</div>

			<br>

			<!-- 시설 안내 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="hallInfo">시설 안내</label>
				<div class="form-group">
					<input type="text" class="col-sm-10 col-xs-10 form-control" id="hallInfo" placeholder="공연장 한 줄 소개를 입력해주세요." name="hallInfo" style="width: 80%">
					<button type="button" id="hallInfoAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">추가</button>
					<br><br>
					<input type="text" class="form-control" id="hallInfo" placeholder="공연장 한 줄 소개를 입력해주세요." name="hallInfo" style="width: 100%;">
				</div>
			</div>

			<br>

			<!-- 예약시 주의사항 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="hallInfo">예약시 주의사항</label>
				<div class="form-group">
					<input type="text" class="col-sm-10 col-xs-10 form-control" id="caution" placeholder="예약시 주의사항을 입력해주세요." name="caution" style="width: 80%">
					<button type="button" id="cautionAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">추가</button>
					<br><br>
					<input type="text" class="form-control" id="caution" placeholder="예약시 주의사항을 입력해주세요." name="caution" style="width: 100%;">
				</div>
			</div>

			<br>

			<!-- 웹사이트 -->
			<div class="form-group">
				<label for="website"> 웹사이트</label>
				<input type="text" class="form-control" id="website" placeholder="웹사이트 주소를 입력해주세요." name="website">
			</div>

			<!-- 이미지 -->

			<br>

			<!-- 주소 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="address">주소</label>
				<div class="form-group">
					<input type="text" class="col-sm-10 col-xs-10 form-control postcodify_address" id="address" placeholder="주소를 입력해주세요." name="address" style="width: 80%">
					<button type="button" id="search_button" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">주소등록</button>
				</div>
			</div>

			<br><br>

			<!-- 상세 주소(세부 공간) -->
			<div class="form-group">
				<label class="necessary">*</label><label for="detailAddress">상세 주소</label>
				<div class="form-group">
					<input type="text" class="col-sm-10 col-xs-10 form-control" id="detailAddress" placeholder="상세주소를 입력해주세요." name="detailAddress" style="width: 80%">
					<button type="button" id="detailAddressAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">추가</button>
					<br><br>
					<input type="text" class="form-control" id="detailAddress" placeholder="상세주소를 입력해주세요." name="detailAddress" style="width: 100%;">
				</div>
			</div>
			<h6> * 같은 건물 내의 정확한 상세 주소를 입력하세요.</h6>
			<br>

			<!-- 공연장 등록증 첨부 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="regisCer">공연장 등록증 첨부</label>
				<div class="form-group">
					<input type="text" class="col-sm-10 col-xs-10 form-control" id="regisCer" placeholder="공연장 등록증을 첨부해주세요." name="regisCer" style="width: 80%">
					<button type="button" id="cautionAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">주소등록</button>
				</div>
			</div>

			<br><br><br>

			<!-- 공연계획서 첨부 여부 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="website">공연계획서 첨부 여부</label>
				<span style="float: right;"><input type="checkbox" checked data-toggle="toggle" data-onstyle="primary" ></span>
				<h6> * 대관 신청 시 공연단체의 공연 계획서 첨부 여부입니다.</h6>
			</div>

			<button type="button" class="btn btn-danger" style="width: 49%;">취소</button>
			<button type="button" class="btn btn-success" style="width: 49%; float: right;">다음</button>
		</form>
	</div>

	<script type="text/javascript">
		$("#search_button").postcodifyPopUp();
	</script>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>