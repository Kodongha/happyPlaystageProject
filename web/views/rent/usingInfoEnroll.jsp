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
		<h2>A관의 이용 정보를 입력해주세요.</h2>
		<hr style="background: black">
		<form action="#">

			<!-- 대표번호 -->
			<div class="form-group">
				<label class="necessary">*</label><label for="startTime">이용 가능 시간</label>
				<br>

				<div class="ui checkbox">
					<input type="checkbox" name="example"><label>24시 운영</label>
				</div>

				<br>
				<select class="form-control" id="startTime" style="width: 200px; min-width: 200px; display:inline; margin: 0 2% 0 0">
					<%for(int i=0; i<=24; i++){ %>
						<%if (i / 10 == 0){%>
							<option><%="0" + i + " 시" %></option>
						<%} else {%>
							<option><%=i + " 시" %></option>
						<%} %>
					<%}%>
				</select>
				<label> ~ </label>
				<select class="form-control" id="endTime" style="width: 200px; min-width: 200px; display:inline; margin: 0 2% 0 2%">
					<%for(int i=0; i<=24; i++){ %>
						<%if (i / 10 == 0){%>
							<option><%="0" + i + " 시" %></option>
						<%} else {%>
							<option><%=i + " 시" %></option>
						<%} %>
					<%}%>
				</select>
			</div>

			<br>

			<!-- 최소 예약 시간 -->
			<div class="form-group" style="display: inline; width: 49%; float: left;">
				<label class="necessary">*</label><label for="avilTime">이용 가능 시간</label>
				<br><br>
				<select class="form-control" id="avilTime" style="width: 200px; min-width: 200px; display:inline; margin: 0 2% 0 0">
					<%for(int i=0; i<=24; i++){ %>
						<%if (i / 10 == 0){%>
							<option><%="0" + i + " 시간" %></option>
						<%} else {%>
							<option><%=i + " 시간" %></option>
						<%} %>
					<%}%>
				</select>
				<p style="margin-top: 2%">* 최소 예약 가능한 시간을 입력해주세요.</p>
			</div>

			<!-- 최소 예약 시간 -->
			<div class="form-group" style="display: inline; width: 49%; float: right;">
				<label class="necessary">*</label><label for="avilCount">예약 가능 인원 수</label>
				<br><br>
				<select class="form-control" id="avilCount" style="width: 200px; min-width: 200px; display:inline; margin: 0 2% 0 0">
					<%for(int i=0; i<=24; i++){ %>
						<%if (i / 10 == 0){%>
							<option><%="0" + i + " 시간" %></option>
						<%} else {%>
							<option><%=i + " 시간" %></option>
						<%} %>
					<%}%>
				</select>
				<br>
				<p style="margin-top: 2%">* 예약 가능한 최대 인원수를 입력해주세요.</p>
			</div>

			<br><br><br><br><br><br><br><br>

			<h2>시설 세부항목 설정</h2>
			<hr style="background: black">

			<br><br><br><br><br><br><br><br>

			<h2>휴무일 설정</h2>
			<hr style="background: black">

			<div class="form-group">
				<label class="necessary">*</label><label for="regHoliday">정기 휴무</label>
				<br>

				<div class="ui checkbox">
					<input type="checkbox" name="example"><label>공휴일 휴무</label>
				</div>

				<br>
				<select class="form-control" id="regHoliday" style="width: 200px; min-width: 200px;">
					<%for(int i=0; i<=24; i++){ %>
						<%if (i / 10 == 0){%>
							<option><%="0" + i + " 시" %></option>
						<%} else {%>
							<option><%=i + " 시" %></option>
						<%} %>
					<%}%>
				</select>
			</div>

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
			<button type="button" class="btn btn-danger" style="width: 49%;">취소</button>
			<button type="button" class="btn btn-success" style="width: 49%; float: right;">다음</button>

		</form>
	</div>



	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>