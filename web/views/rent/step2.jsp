<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
