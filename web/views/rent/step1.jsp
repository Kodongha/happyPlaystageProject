<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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

	<div class="fileArea">
		<input type="file" id="titleImgInput" name="titleImgInput" accept="image/*" onchange="titleLoadImg(this);">
		<input type="file" class="subImg" id="subImgInput1" name="subImgInput1" accept="image/*" onchange="subLoadImg(this,1);">
		<input type="file" class="subImg" id="subImgInput2" name="subImgInput2" accept="image/*" onchange="subLoadImg(this,2);">
		<input type="file" class="subImg" id="subImgInput3" name="subImgInput3" accept="image/*" onchange="subLoadImg(this,3);">
		<input type="file" id="hallRegisCerPathInput" name="hallRegisCerPathInput">
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