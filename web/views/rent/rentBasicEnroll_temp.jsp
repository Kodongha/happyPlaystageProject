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
<script type="text/javascript">

	$(function(){
		var facSeq = 0;
		var coutionSeq = 0;
		var detAddrSeq = 0;

		$("#facInfoContentAddBtn").click(function(){

			var facInfoContent = $.trim($("#facInfoContent").val())
			if(facInfoContent != "" && facInfoContent != null && facSeq < 5){
				facSeq++;
				$("#facInfoContent").clone(true).attr({"name" : "facInfoContent"+facSeq, "id" : "facInfoContent"+facSeq, "value" : $("facInfoContent").val(), "readonly" : "true"}).appendTo($(".facInfo"));

				$("#facInfoContent").val("");
				$("#facInfoContent").focus();
				/* $("#facInfoContentAddBtn").append($("<br>")); */
				$(".facInfo").append($("<br>"));
			}

			if(facSeq == 5){

				$("#facInfoContent").attr({"readonly" : "true"});
				$("#facInfoContentAddBtn").attr("disabled", "true");

				/*
				$("#facInfoContent").attr({"style" : "display:none"});
				$("#facInfoContentAddBtn").attr({"style" : "display:none"});
				 */
			}
		});


		$("#cautionContentAddBtn").click(function(){

			var facInfoContent = $.trim($("#cautionContent").val())
			if(facInfoContent != "" && facInfoContent != null && coutionSeq < 5){
				coutionSeq++;
				$("#cautionContent").clone(true).attr({"name" : "cautionContent"+coutionSeq, "id" : "cautionContent"+coutionSeq, "value" : $("cautionContent").val(), "readonly" : "true"}).appendTo($(".caution"));
				$("#cautionContent").val("");
				$("#cautionContent").focus();
				/* $("#facInfoContentAddBtn").append($("<br>")); */
				$(".caution").append($("<br>"));
			}

			if(coutionSeq == 5){
				$("#cautionContent").attr("readonly", "true");
				$("#cautionContentAddBtn").attr("disabled", "true");
			}
		});


		$("#detAddressAddBtn").click(function(){

			var facInfoContent = $.trim($("#detAddress").val())
			if(facInfoContent != "" && facInfoContent != null && detAddrSeq < 5){
				detAddrSeq++;
				$("#detAddress").clone(true).attr({"name" : "detAddress"+detAddrSeq, "id" : "detAddress"+detAddrSeq, "value" : $("detAddress").val(), "readonly" : "true"}).appendTo($(".detAddr"));
				$("#detAddress").val("");
				$("#detAddress").focus();
				/* $("#facInfoContentAddBtn").append($("<br>")); */
				$(".detAddr").append($("<br>"));
			}

			if(detAddrSeq == 5){
				$("#detAddress").attr("readonly", "true");
				$("#detAddressAddBtn").attr("disabled", "true");
			}
		});
	});

</script>

</head>
<body>
<jsp:include page="/views/common/header.jsp" />

	<div class="container">
		<h2>대관 정보를 입력해주세요.</h2>
		<hr style="background: black">
		<form action="<%=request.getContextPath() %>/moveRentBasicInfo.rent" method="post">

			<!-- 공연장명 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="hallNm">공연장 명</label>
				<input type="text" class="form-control" name="hallNm" id="hallNm" placeholder="공연장 명을 입력해주세요.">
			</div>

			<br>

			<!-- 공연장 한 줄 소개 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="hallSimIntro">공연장 한 줄 소개</label>
				<input type="text" class="form-control" name="hallSimIntro" id="hallSimIntro" placeholder="공연장 한 줄 소개를 입력해주세요.">
			</div>

			<br>

			<!-- 공연장 상세 소개 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="hallDetIntro">공연장 상세 소개</label>
				<textarea class="form-control" rows="5" name="hallDetIntro" id="hallDetIntro" placeholder="공연장 상세 소개를 입력해주세요." style="resize:none"></textarea>
			</div>

			<br>
<!--  -->
			<!-- 시설 안내 -->
			<div class="form-group facInfo">
				<label class="necessary">*</label><label for="facInfoContent">시설 안내</label>
				<div class="form-group">
					<input type="text" class="col-sm-10 col-xs-10 form-control" name="facInfoContent" id="facInfoContent" placeholder="공연장 한 줄 소개를 입력해주세요." style="width: 80%">
					<button type="button" id="facInfoContentAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">추가</button>
				</div>
			</div>

			<br><br><br><br><br>

<!--  -->
			<!-- 예약시 주의사항 -->
			<div class="form-group caution">
				<label class="necessary">*</label><label for="cautionContent">예약시 주의사항</label>
				<div class="form-group">
					<input type="text" class="col-sm-10 col-xs-10 form-control" id="cautionContent" placeholder="예약시 주의사항을 입력해주세요." name="cautionContent" style="width: 80%">
					<button type="button" id="cautionContentAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">추가</button>
				</div>
			</div>

			<br><br><br><br><br>

			<!-- 웹사이트 -->
			<div class="form-group">
				<label for="website"> 웹사이트</label>
				<input type="text" class="form-control" name="website" id="website" placeholder="웹사이트 주소를 입력해주세요.">
			</div>

			<!-- 이미지 -->

			<br>

			<!-- 주소 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="address">주소</label>
				<div class="form-group">
					<input type="text" class="col-sm-10 col-xs-10 form-control postcodify_address" name="address" id="address" placeholder="주소를 입력해주세요." style="width: 80%" readonly="readonly">
					<button type="button" id="search_button" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">등록</button>
				</div>
			</div>

			<br><br>
<!--  -->
			<!-- 상세 주소(세부 공간) -->
			<div class="form-group detAddr">
				<label class="necessary">*</label><label for="detAddress">상세 주소</label>
				<div class="form-group">
					<input type="text" class="col-sm-10 col-xs-10 form-control" id="detAddress" placeholder="상세주소를 입력해주세요." name="detAddress" style="width: 80%">
					<button type="button" id="detAddressAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">추가</button>
				</div>
			</div>

			<br><br><br><br>

			<br>

<!--  -->
			<div class="form-group">
				<label class="necessary">*</label><label for="hallRegisCerPath">공연장 등록증 첨부</label>
				<div class="form-group">
					<input type="text" class="col-sm-10 col-xs-10 form-control" name="hallRegisCerPath" id="hallRegisCerPath" placeholder="공연장 등록증을 첨부해주세요." style="width: 80%">
					<button type="button" id="cautionAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">첨부</button>
				</div>
			</div>

			<br><br><br>

			<!-- 공연계획서 첨부 여부 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="perfPlanTf">공연계획서 첨부 여부</label>
				<span style="float: right;">
					<input type="checkbox" name="perfPlanTf" id="perfPlanTf" checked data-toggle="toggle" data-onstyle="primary" >
				</span>
				<h6> * 대관 신청 시 공연단체의 공연 계획서 첨부 여부입니다.</h6>
			</div>

			<button type="button" class="btn btn-danger" style="width: 49%;">취소</button>
			<button type="submit" class="btn btn-success" style="width: 49%; float: right;">다음</button>
		</form>
	</div>

	<script type="text/javascript">
		$("#search_button").postcodifyPopUp();
	</script>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>