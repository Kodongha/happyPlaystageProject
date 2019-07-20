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

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>



<style type="text/css">

	label {
		font-size: 1.5em;
	}

	.necessary {
		color: red;
	}

	.wizard {
	    margin: 20px auto;
	}

    .wizard .nav-tabs {
        position: relative;
        margin: 40px auto;
        margin-bottom: 0;
        border-bottom-color: black;
    }

    .wizard > div.wizard-inner {
        position: relative;
    }

	.connecting-line {
	    height: 2px;
	    background: black;
	    position: absolute;
	    width: 80%;
	    margin: 0 auto;
	    left: 0;
	    right: 0;
	    top: 50%;
	    z-index: 1;
	}

	.wizard .nav-tabs > li.active > a, .wizard .nav-tabs > li.active > a:hover, .wizard .nav-tabs > li.active > a:focus {
	    color: #555555;
	    cursor: default;
	    border: 0;
	    border-bottom-color: transparent;
	}

	span.round-tab {
	    width: 70px;
	    height: 70px;
	    line-height: 70px;
	    display: inline-block;
	    border-radius: 100px;
	    background: #fff;
	    border: 2px solid black;
	    z-index: 2;
	    position: absolute;
	    left: 0;
	    text-align: center;
	    font-size: 25px;
	}
	span.round-tab i{
	    color:##00ffff;
	}
	.wizard li.active span.round-tab {
	    background: #fff;
	    border: 2px solid black;

	}
	.wizard li.active span.round-tab i{
	    color: #5bc0de;
	}

	span.round-tab:hover {
	    color: #333;
	    border: 2px solid black;
	}

	.wizard .nav-tabs > li {
	    width: 20%;
	}

	.wizard li:after {
	    content: " ";
	    position: absolute;
	    left: 46%;
	    opacity: 0;
	    margin: 0 auto;
	    bottom: 0px;
	    border: 5px solid transparent;
	    border-bottom-color: #5bc0de;
	    transition: 0.1s ease-in-out;
	}

	.wizard li.active:after {
	    content: " ";
	    position: absolute;
	    left: 46%;
	    opacity: 1;
	    margin: 0 auto;
	    bottom: 0px;
	    border: 10px solid transparent;
	    border-bottom-color: black;
	}

	.wizard .nav-tabs > li a {
	    width: 70px;
	    height: 70px;
	    margin: 20px auto;
	    border-radius: 100%;
	    padding: 0;
	}

	    .wizard .nav-tabs > li a:hover {
	        background: transparent;
	    }

	.wizard .tab-pane {
	    position: relative;
	    padding-top: 50px;
	}

	.wizard h3 {
	    margin-top: 0;
	}

	@media( max-width : 585px ) {

	    .wizard {
	        width: 90%;
	        height: auto !important;
	    }

	    span.round-tab {
	        font-size: 16px;
	        width: 50px;
	        height: 50px;
	        line-height: 50px;
	    }

	    .wizard .nav-tabs > li a {
	        width: 50px;
	        height: 50px;
	        line-height: 50px;
	    }

	    .wizard li.active:after {
	        content: " ";
	        position: absolute;
	        left: 35%;
	    }
	}

	#titleImgDiv, .subImgDiv{
		width: 350px;
		height: 200px;
		border: 2px dashed darkgray;
		color: darkgray;
		font-size: 5em;
		display: table-cell;
		text-align: center;
    	vertical-align: middle;
	}
	#titleImgDiv:hover, .subImgDiv:hover{
		cursor:pointer;
	}

</style>

<script type="text/javascript">

	var facSeq = 0;
	var coutionSeq = 0;
	var detAddrSeq = 0;

	$(document).ready(function () {
	    //Initialize tooltips
	    $('.nav-tabs > li a[title]').tooltip();

	    //Wizard
	    $('a[data-toggle="tab"]').on('show.bs.tab', function (e) {

	        var $target = $(e.target);

	        if ($target.parent().hasClass('disabled')) {
	            return false;
	        }
	    });

	    $(".next-step").click(function (e) {

	        var $active = $('.wizard .nav-tabs li.active');
	        $active.next().removeClass('disabled');
	        nextTab($active);
			scroll(0,0);
	    });
	    $(".prev-step").click(function (e) {

	        var $active = $('.wizard .nav-tabs li.active');
	        prevTab($active);

	    });


		$("#facInfoContentAddBtn").click(function(){

			console.log("facInfoContentAddBtn");
			console.log("facSeq::"+facSeq);

			var facInfoContent = $.trim($("#facInfoContent").val())
			if(facInfoContent != "" && facInfoContent != null && facSeq < 5){
				facSeq++;
				$("#facInfoContent").clone(true).attr({"name" : "facInfoContentReq", "id" : "facInfoContent"+facSeq, "value" : $("facInfoContent").val(), "readonly" : "true"}).appendTo($(".facInfo"));

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

			console.log("cautionContentAddBtn");
			console.log("coutionSeq::"+coutionSeq);

			var facInfoContent = $.trim($("#cautionContent").val())
			if(facInfoContent != "" && facInfoContent != null && coutionSeq < 5){
				coutionSeq++;
				$("#cautionContent").clone(true).attr({"name" : "cautionContentReq", "id" : "cautionContent"+coutionSeq, "value" : $("cautionContent").val(), "readonly" : "true"}).appendTo($(".caution"));
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

			console.log("detAddressAddBtn");
			console.log("detAddrSeq::"+detAddrSeq);

			var facInfoContent = $.trim($("#detAddress").val())
			if(facInfoContent != "" && facInfoContent != null && detAddrSeq < 5){
				detAddrSeq++;
				$("#detAddress").clone(true).attr({"name" : "detAddressReq", "id" : "detAddress"+detAddrSeq, "value" : $("detAddress").val(), "readonly" : "true"}).appendTo($(".detAddr"));
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

	function nextTab(elem) {
	    $(elem).next().find('a[data-toggle="tab"]').click();
	}
	function prevTab(elem) {
	    $(elem).prev().find('a[data-toggle="tab"]').click();
	}

</script>

</head>
<body>
<jsp:include page="/views/common/header.jsp" />

	<div class="container">
		<div class="row">
			<section>
	        <div class="wizard">
	            <div class="wizard-inner">
	                <div class="connecting-line"></div>
	                <ul class="nav nav-tabs" role="tablist">

	                    <li role="presentation" class="active">
	                        <a href="#step1" data-toggle="tab" aria-controls="step1" role="tab" title="Step 1">
	                            <span class="round-tab">
	                                <i class="glyphicon glyphicon-folder-open"></i>
	                            </span>
	                        </a>
	                    </li>

	                    <li role="presentation" class="disabled">
	                        <a href="#step2" data-toggle="tab" aria-controls="step2" role="tab" title="Step 2">
	                            <span class="round-tab">
	                                <i class="glyphicon glyphicon-phone"></i>
	                            </span>
	                        </a>
	                    </li>
	                    <li role="presentation" class="disabled">
	                        <a href="#step3" data-toggle="tab" aria-controls="step3" role="tab" title="Step 3">
	                            <span class="round-tab">
	                                <i class="glyphicon glyphicon-calendar"></i>
	                            </span>
	                        </a>
	                    </li>

	                    <li role="presentation" class="disabled">
	                        <a href="#step4" data-toggle="tab" aria-controls="step4" role="tab" title="Step 4">
	                            <span class="round-tab">
	                                <i class="glyphicon glyphicon-picture"></i>
	                            </span>
	                        </a>
	                    </li>

	                    <li role="presentation" class="disabled">
	                        <a href="#complete" data-toggle="tab" aria-controls="complete" role="tab" title="Complete">
	                            <span class="round-tab">
	                                <i class="glyphicon glyphicon-ok"></i>
	                            </span>
	                        </a>
	                    </li>
	                </ul>
	            </div>

	           <%-- <form action="<%=request.getContextPath() %>/moveRentBasicInfo.rent" method="post" enctype="multipart/form-data"> --%>
	                <div class="tab-content">
<!-- step1 -->
	                    <div class="tab-pane active" role="tabpanel" id="step1">

							<div class="form-group">
								<label class="necessary">*</label><label for="hallNm">공연장 명</label><br><br>
								<input type="text" class="form-control" name="hallNm" id="hallNm" placeholder="공연장 명을 입력해주세요.">
							</div>

							<br>

							<!-- 공연장 한 줄 소개 -->
							<div class="form-group">
								<label class="necessary">*</label><label for="hallSimIntro">공연장 한 줄 소개</label><br><br>
								<input type="text" class="form-control" name="hallSimIntro" id="hallSimIntro" placeholder="공연장 한 줄 소개를 입력해주세요.">
							</div>

							<br>

							<!-- 공연장 상세 소개 -->
							<div class="form-group">
								<label class="necessary">*</label><label for="hallDetIntro">공연장 상세 소개</label><br><br>
								<textarea class="form-control" rows="5" name="hallDetIntro" id="hallDetIntro" placeholder="공연장 상세 소개를 입력해주세요." style="resize:none"></textarea>
							</div>

							<br>

							<!-- 시설 안내 -->
							<div class="form-group facInfo">
								<label class="necessary">*</label><label for="facInfoContent">시설 안내</label><br><br>
								<div class="form-group">
									<input type="text" class="col-sm-10 col-xs-10 form-control" name="facInfoContent" id="facInfoContent" placeholder="공연장 한 줄 소개를 입력해주세요." style="width: 80%">
									<button type="button" id="facInfoContentAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">추가</button>
								</div>
							</div>

							<br><br><br><br><br>

							<!-- 예약시 주의사항 -->
							<div class="form-group caution">
								<label class="necessary">*</label><label for="cautionContent">예약시 주의사항</label><br><br>
								<div class="form-group">
									<input type="text" class="col-sm-10 col-xs-10 form-control" id="cautionContent" placeholder="예약시 주의사항을 입력해주세요." name="cautionContent" style="width: 80%">
									<button type="button" id="cautionContentAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">추가</button>
								</div>
							</div>

							<br><br><br><br><br>

							<!-- 웹사이트 -->
							<div class="form-group">
								<label for="website"> 웹사이트</label><br><br>
								<input type="text" class="form-control" name="website" id="website" placeholder="웹사이트 주소를 입력해주세요.">
							</div>

							<br>
<!-- !!!!!!!!!!!!!!!!!!! -->
							<!-- 대표 이미지 -->
							<div class="form-group">
								<label class="necessary">*</label><label for="titleImgDiv">대표 이미지</label><br><br>
								<div id="titleImgDiv">
									<span id="titleImgSpan">+</span>
								</div>
							</div>

							<br>

							<!-- 추가 이미지 -->
							<div class="form-group">
								<label class="necessary">*</label><label for="subImgDiv">추가 이미지</label><br><br>
								<div class="subImgDiv" id="subImgDiv1">
									<span id="subImgSpan1">+</span>
								</div>
								<div class="subImgDiv" id="subImgDiv2">
									<span id="subImgSpan2">+</span>
								</div>
								<div class="subImgDiv" id="subImgDiv3">
									<span id="subImgSpan3">+</span>
								</div>


							</div>

							<br>

							<!-- 주소 -->
							<div class="form-group">
								<label class="necessary">*</label><label for="address">주소</label><br><br>
								<div class="form-group">
									<input type="text" class="col-sm-10 col-xs-10 form-control" name="address" id="address" placeholder="주소를 입력해주세요." style="width: 80%" readonly="readonly">
									<button type="button" id="search_button" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">등록</button>
								</div>
							</div>

							<br><br>

							<!-- 상세 주소(세부 공간) -->
							<div class="form-group detAddr">
								<label class="necessary">*</label><label for="detAddress">상세 주소</label><br><br>
								<div class="form-group">
									<input type="text" class="col-sm-10 col-xs-10 form-control" id="detAddress" placeholder="상세주소를 입력해주세요." name="detAddress" style="width: 80%">
									<button type="button" id="detAddressAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">추가</button>
								</div>
							</div>

							<br><br><br><br>

							<br>

							<div class="form-group">
								<label class="necessary">*</label><label for="hallRegisCerPath">공연장 등록증 첨부</label><br><br>
								<div class="form-group">
									<input type="text" class="col-sm-10 col-xs-10 form-control" name="hallRegisCerPath" id="hallRegisCerPath" placeholder="공연장 등록증을 첨부해주세요." style="width: 80%">
									<button type="button" id="hallRegisCerPathAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">첨부</button>
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

							<button type="button" class="btn btn-danger" style="width: 49%;" onclick="location.href='../main/main.jsp'">취소</button>
							<button type="button" class="btn btn-success next-step" style="width: 49%; float: right;">다음</button>
							<!--
	                        <ul class="list-inline pull-right">
	                            <li><button type="button" class="btn btn-primary next-step">Save and continue</button></li>
	                        </ul>
	                         -->
	                         <div class="fileArea">
								<input type="file" id="titleImgInput" name="titleImgInput" accept="image/*" onchange="titleLoadImg(this);">
								<input type="file" class="subImg" id="subImgInput1" name="subImgInput1" accept="image/*" onchange="subLoadImg(this,1);">
								<input type="file" class="subImg" id="subImgInput2" name="subImgInput2" accept="image/*" onchange="subLoadImg(this,2);">
								<input type="file" class="subImg" id="subImgInput3" name="subImgInput3" accept="image/*" onchange="subLoadImg(this,3);">
								<input type="file" id="hallRegisCerPathInput" name="hallRegisCerPathInput">
							</div>
	                    </div>

						<script type="text/javascript">
							var i = 1;

							$(".fileArea").hide();
							$("#titleImgDiv").click(function(){
								$("#titleImgInput").click();
							});
							$(".subImgDiv").click(function(){
								$("#subImgInput"+i).click();
								i++;
							});

							/* 공연장 등록증 첨부 */
							$("#hallRegisCerPathAddBtn").click(function(){
								$("#hallRegisCerPathInput").click();
							});

							$("#hallRegisCerPathInput").change(function(){
								$("#hallRegisCerPath").val($(this).val());
							});


							/* 이미지 미리보기 */
							function titleLoadImg(value){
								if(value.files && value.files[0]){
									var reader = new FileReader();

									reader.onload = function(e){
										$("#titleImgSpan").remove();
										$("#titleImgDiv").append("<img id='titleImg' width='100%' height='100%'>");
										$("#titleImg").attr("src", e.target.result);
										$("#titleImgDiv").css("border","0px");
									}
								}

								reader.readAsDataURL(value.files[0]);
							}

							function subLoadImg(value, num){
								if(value.files && value.files[0]){
									var reader = new FileReader();

									reader.onload = function(e){
										var addImgTag = "<img id='titleImg" + num + "' width='100%' height='100%'>"
										$("#subImgSpan" + num).remove();
										$("#subImgDiv" + num).append(addImgTag);
										$("#titleImg"  + num).attr("src", e.target.result);
										$("#subImgDiv" + num).css("border","0px");
									}
								}
								reader.readAsDataURL(value.files[0]);
							}
						</script>

<!-- Step2 -->
	                    <div class="tab-pane" role="tabpanel" id="step2">

							<div class="container">
								<h2>연락처 정보를 입력해주세요.</h2>
								<hr style="background: black">

								<!-- 이메일 -->
								<div class="form-group">
									<label class="necessary">*</label><label for="rentEmail">이메일</label><br><br>
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
									<input id="rentMainTel12" type="tel" class="form-control" name="rentMainTel2" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 2%">
									<label>-</label>
									<input id="rentMainTel13" type="tel" class="form-control" name="rentMainTel3" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 2%">
								</div>

								<br><br>
								<button type="button" class="btn btn-danger prev-step" style="width: 49%;">취소</button>
								<button type="button" class="btn btn-success next-step" style="width: 49%; float: right;">다음</button>
							</div>
                            <!--
	                        <ul class="list-inline pull-right">
	                            <li><button type="button" class="btn btn-default prev-step">Previous</button></li>
	                            <li><button type="button" class="btn btn-primary next-step">Save and continue</button></li>
	                        </ul>
                             -->
	                    </div>

<!-- step3 -->
	                    <form action="<%=request.getContextPath() %>/moveRentBasicInfo.rent" method="post" enctype="multipart/form-data">
	                    <div class="tab-pane" role="tabpanel" id="step3">
	                        <div class="container">
								<h2>A관의 이용 정보를 입력해주세요.</h2>
								<hr style="background: black">

								<!-- 이용 가능 시간 -->
								<div class="form-group">
									<label class="necessary">*</label><label for="availStartTm">이용 가능 시간</label>
									<br>

									<div class="ui checkbox">
										<input type="checkbox" name="example"><label>24시 운영</label>
									</div>

									<br>
									<select class="form-control" name="availStartTm" id="availStartTm" style="width: 150px; min-width: 150px; display:inline; margin: 0 2% 0 0">
										<%for(int i=0; i<=24; i++){ %>
											<%if (i / 10 == 0){%>
												<option><%="0" + i + ":00" %></option>
											<%} else {%>
												<option><%=i + ":00" %></option>
											<%} %>
										<%}%>
									</select>
									<label>~</label>
									<select class="form-control" name="availEndTm" id="availEndTm" style="width: 150px; min-width: 150px; display:inline; margin: 0 2% 0 2%">
										<%for(int i=0; i<=24; i++){ %>
											<%if (i / 10 == 0){%>
												<option><%="0" + i + ":00" %></option>
											<%} else {%>
												<option><%=i + ":00" %></option>
											<%} %>
										<%}%>
									</select>
								</div>

								<br>

								<!-- 최소 예약 시간 -->
								<div class="form-group" style="display: inline; width: 49%; float: left;">
									<label class="necessary">*</label><label for="minRsvTm">최소 예약 시간</label>
									<br><br>
									<select class="form-control" name="minRsvTm" id="minRsvTm" style="width: 200px; min-width: 200px; display:inline; margin: 0 2% 0 0">
										<%for(int i=0; i<=24; i++){ %>
											<%if (i / 10 == 0){%>
												<option value="<%=i %>"><%=i  %> 시간</option>
											<%} else {%>
												<option value="<%=i %>"><%=i %> 시간</option>
											<%} %>
										<%}%>
									</select>
									<p style="margin-top: 2%">* 최소 예약 가능한 시간을 입력해주세요.</p>
								</div>

								<!-- 최소 예약 가능 인원 수 -->
								<div class="form-group" style="display: inline; width: 49%; float: right;">
									<label class="necessary">*</label><label for="maxHeadCount">예약 가능 인원 수</label>
									<br><br>
									<input id="maxHeadCount" type="number" class="form-control" name="maxHeadCount" style="width: 200px; min-width: 200px; display:inline; margin: 0 2% 0 0" placeholder="예약 가능 인원 수">

									<%--
									<select class="form-control" name="maxHeadCount" id="maxHeadCount" style="width: 200px; min-width: 200px; display:inline; margin: 0 2% 0 0">
										<%for(int i=0; i<=24; i++){ %>
											<%if (i / 10 == 0){%>
												<option><%="0" + i + " 시간" %></option>
											<%} else {%>
												<option><%=i + " 시간" %></option>
											<%} %>
										<%}%>
									</select>
									 --%>

									<br>
									<p style="margin-top: 2%">* 예약 가능한 최대 인원수를 입력해주세요.</p>
								</div>

								<br><br><br><br><br><br><br><br>

								<h2>시설 세부항목 설정</h2>
								<hr style="background: black">

								<br><br><br><br><br><br><br><br>

								<h2>휴무일 설정</h2>
								<hr style="background: black">

								<!-- 정기 휴무일 -->
								<div class="form-group">
									<label class="necessary">*</label><label for="regHoliday">정기 휴무</label>
									<br>

									<div class="ui checkbox">
										<input type="checkbox" name="example"><label>공휴일 휴무</label>
									</div>

									<br>
									<select class="form-control" name="regCloseCd" id=regCloseCd style="width: 200px; min-width: 200px;">
										<option value="1">휴무 없음</option>
										<option value="2">매주</option>
										<option value="3">격주(홀수주)</option>
										<option value="4">격주(짝수주)</option>
										<option value="5">매월 첫째주</option>
										<option value="6">매월 둘째두</option>
										<option value="7">매월 셋째주</option>
										<option value="8">매월 넷째주</option>
										<option value="9">매월 마지막주</option>
										<option value="10">매월 말일</option>
										<option value="11">매월 직접 입력</option>
									</select>
								</div>

								<script type="text/javascript">

								</script>

								<br><br>

								<div class="form-group">
									<label class="necessary">*</label><label for="startTime">사용자 지정 휴무일</label>
									<br><br>

									<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" style="width: 100%;">휴무일 추가 +</button>
									<!-- Modal -->
									<div class="modal fade" id="myModal" role="dialog">
										<div class="modal-dialog">

											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-header" style="background: #ad42f5;">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h4 class="modal-title" style="color:white">지정 휴무일 추가</h4>
												</div>
												<div class="modal-body">
													<p style="color: red; font-weight: bold ">* 휴무일 명</p>
													<input id="holTitle" type="text" class="form-control" name="holTitle" placeholder="휴무일 명을 입력하세요.">

													<hr>

													<p style="color: red; font-weight: bold ">* 날짜</p>
													<input id="holTitle" type="text" class="form-control" name="holTitle" placeholder="휴무일 명을 입력하세요.">

													<hr>
													<p style="color: red; font-weight: bold ">* 요일</p>
													<select class="form-control" id="regHoliday"">
														<option>매일</option>
														<option>월요일</option>
														<option>화요일</option>
														<option>수요일</option>
														<option>목요일</option>
														<option>금요일</option>
														<option>토요일</option>
														<option>일요일</option>
													</select>


												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-success" data-dismiss="modal" style="width: 100%;">저장</button>
												</div>
											</div>
										</div>
									</div>
								</div>


								<br><br>
								<button type="button" class="btn btn-danger prev-step" style="width: 49%;">취소</button>
								<button type="submit" class="btn btn-success next-step" style="width: 49%; float: right;">다음</button>
							</div>
	                    </div>
						</form>
<!-- step4 -->
	                    <div class="tab-pane" role="tabpanel" id="step4">
	                        <div class="container">
								<h2>정산 정보를 입력해주세요.</h2>
								<hr style="background: black">

								<!-- 상호명 -->
								<div class="form-group">
									<label class="necessary">*</label><label for="hallName">상호명 (개인/법인)</label> <br><br>
									<input type="text" class="form-control" id="hallName" placeholder="상호명을 입력해주세요." name="hallName">
								</div>

								<br>

								<!-- 공연장명 -->
								<div class="form-group">
									<label class="necessary">*</label><label for="hallName">대표자명</label> <br><br>
									<input type="text" class="form-control" id="hallName" placeholder="대표자명을 입력해주세요." name="hallName">
								</div>

								<br>

								<!-- 사업자 등록번호 -->
								<div class="form-group">
									<label class="necessary">*</label><label for="phone1">사업자 등록번호</label>
									<br><br>
									<input id="phone2" type="tel" class="form-control" name="phone2" style="width: 100px; min-width: 100px; display:inline; margin: 0 1% 0 0%">
									<label>-</label>
									<input id="phone2" type="tel" class="form-control" name="phone2" style="width: 100px; min-width: 100px; display:inline; margin: 0 1% 0 1%">
									<label>-</label>
									<input id="phone3" type="tel" class="form-control" name="phone3" style="width: 100px; min-width: 100px; display:inline; margin: 0 0% 0 1%">
								</div>

								<br>

								<!-- 사업자 등록증 첨부 -->
								<div class="form-group">
									<label class="necessary">*</label><label for="hallInfo">사업자 등록증 첨부</label> <br><br>
									<div class="form-group">
										<input type="text" class="col-sm-10 col-xs-10 form-control" id="caution" placeholder="사업자 등록증을 첨부해주세요." name="caution" readonly="readonly" style="width: 80%">
										<button type="button" id="cautionAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">첨부</button>
									</div>
								</div>

								<br><br><br>

								<!-- 사업장 주소 -->
								<div class="form-group">
									<label class="necessary">*</label><label for="hallInfo">사업장 주소</label> <br><br>
									<div class="form-group">
										<input type="text" class="col-sm-10 col-xs-10 form-control" id="address2" placeholder="주소를 입력해주세요." name="address2" readonly="readonly" style="width: 80%">
										<button type="button" id="search_button2" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">주소등록</button>
										<br><br>
										<input type="text" class="form-control" id="caution" placeholder="상세주소를 입력해주세요." name="caution" style="width: 100%;">
									</div>
								</div>

								<br>

								<!-- 정산용 이메일 -->
								<div class="form-group">
									<label class="necessary">*</label><label for="email">정산용 이메일</label> <br><br>
									<input id="email" type="text" class="form-control" name="email" placeholder="Email">
								</div>

								<br>

								<!-- 정산용 연락처 -->
								<div class="form-group">
									<label class="necessary">*</label><label for="mailTel1">정산용 연락처</label> <br>
									<br>
									<select class="form-control" id="mailTel1" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 0">
										<option>010</option>
										<option>011</option>
										<option>016</option>
										<option>017</option>
										<option>019</option>
									</select>
									<label>-</label>
									<input id="mailTel2" type="tel" class="form-control" name="mailTel2" style="width: 100px; min-width: 100px; display:inline; margin: 0 1% 0 1%">
									<label>-</label>
									<input id="mailTel3" type="tel" class="form-control" name="mailTel3" style="width: 100px; min-width: 100px; display:inline; margin: 0 1% 0 1%">
								</div>

								<br><br>

								<h2>계좌 정보를 입력해주세요.</h2>
								<hr>

								<!-- 은행명 -->
								<div class="form-group" style="display: inline; float: left; margin: 0 3% 0 0">
									<label class="necessary">*</label><label for="mailTel1">은행명</label> <br>
									<br>
									<select class="form-control" id="mailTel1" style="width: 200px; min-width: 200px; display:inline; margin: 0 3% 0 0">
										<option>SC제일은행</option>
											<option>국민은행</option>
											<option>경남은행</option>
											<option>광주은행</option>
											<option>기업은행</option>
											<option>농협</option>
											<option>대구은행</option>
											<option>부산은행</option>
											<option>산업은행</option>
											<option>새마을금고</option>
											<option>수협중앙회</option>
											<option>신한은행</option>
											<option>신협중앙회</option>
											<option>외환은행</option>
											<option>우리은행</option>
											<option>우체국</option>
											<option>전죽은행</option>
											<option>제주은행</option>
											<option>카카오뱅크</option>
											<option>케이뱅크</option>
											<option>하나은행</option>
											<option>한국시티은행</option>
											<option>한국은행</option>
									</select>
								</div>

								<div class="form-group" style="display: inline; float:left; margin: 0 3% 0 3%">
									<label class="necessary">*</label><label for="mailTel1">계좌번호</label> <br><br>
									<input id="email" type="text" class="form-control" name="email" placeholder="Email" style="width: 400px">
									<br>
								</div>

								<div class="form-group" style="display: inline; float: left; margin: 0 3% 0 3%">
									<label class="necessary">*</label><label for="mailTel1">예금주</label> <br><br>
									<input id="email" type="text" class="form-control" name="email" placeholder="Email" style="width: 200px">
									<br>
								</div>

								<br clear="all"><br>

								<h2>환불 기준을 입력해주세요.</h2>
								<hr>

								<label class="radio-inline"><input type="radio" name="optradio" checked>유형 1</label>
								<label class="radio-inline"><input type="radio" name="optradio">유형 2</label>
								<label class="radio-inline"><input type="radio" name="optradio">유형 3</label>
								<label class="radio-inline"><input type="radio" name="optradio">유형 4</label>

								<br><br>
								<button type="button" class="btn btn-danger prev-step" style="width: 49%;">취소</button>
								<button type="button" class="btn btn-success next-step" style="width: 49%; float: right;">신청</button>
							</div>

	                    </div>
	                    <div class="clearfix"></div>
	                </div>
	            <!-- </form> -->
	        </div>
	    </section>
	   </div>
	</div>

	<script type="text/javascript">

		$("#search_button").postcodifyPopUp({
			insertAddress : $("#address")
		});

		$("#search_button2").postcodifyPopUp({
			insertAddress : $("#address2")
		});

	</script>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>