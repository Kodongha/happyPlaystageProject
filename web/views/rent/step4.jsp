<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
