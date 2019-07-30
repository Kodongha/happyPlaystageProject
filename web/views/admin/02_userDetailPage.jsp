<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.hp.admin.model.vo.*"%>

<%
	ArrayList<User> list = (ArrayList<User>) request.getAttribute("list");
	User oneUser = (User) request.getAttribute("oneUser");

	ArrayList<UseHistoryVO> UseHistoryVOlist = (ArrayList<UseHistoryVO>) request
			.getAttribute("UseHistoryVOlist");

	ArrayList<EnrollHistoryVO> EnrollHistoryVOlist = (ArrayList<EnrollHistoryVO>) request
			.getAttribute("EnrollHistoryVOlist");


	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>Insert title here</title>
<style>
#line {
	border: 0.5px solid gray;
	width: 1300px;
	margin: auto;
}

#text1 {
	width: 500px;
	height: 30px;
	margin-left: 70px;
}

#inner {
	width: 1000px;
	height: 700px;
	margin: auto;
}

#Enrollment {
	background: lightgray;
	width: 1000px;
	height: 300px;
	margin: auto;
}

#revisebutton {
	margin-left: 1180px;
	margin-top: 700px;
}

#resetbutton {
margin-left: 1250px;
margin-top:-55px;

}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<div id="center" class="fram">
		<!-- 타이틀 -->
		<h2 id="text1">
			<strong>회원 관리 내역 상세</strong>

		</h2>
		<!-- 회원관리내역과 검색창 사이의 선 -->
		<div id="line"></div>
		<div id="inner">

			<br> <br>


			<div class="Membership">
				<form class="form-horizontal" action="<%=request.getContextPath()%>/updateOneUser.ad?" method="post" encType="multipart/form-data">
					<div class="form-group">
						<label class="control-label col-sm-2" for="userId" id="userseq">회원번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userseq"
								value="<%=oneUser.getUserSeq()%>" name="userseq"
								style="width: 500px;" readonly="readonly">

						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="nikName">이메일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userEmail" name="userEmail"
								style="width: 500px;" value="<%=oneUser.getUserEmail()%>" readonly="">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="name">이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								value="<%=oneUser.getUserNm()%>" id="userNm" name="userNm"
								style="width: 500px;">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="nick">닉네임</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								value="<%=oneUser.getUserNick()%>" id="userNick" name="userNick"
								style="width: 500px;">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="phone">연락처</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								value="<%=oneUser.getUserPhone()%>" id="userPhone" name="userPhone"
								style="width: 500px;">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="EnrollDt">회원가입일자</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="enrollDt"
								value="<%=oneUser.getEnrollDt()%>" name="enrollDt"
								style="width: 500px;" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="sns">SNS코드</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="snsCd"
								value="<%=oneUser.getSnsCd()%>" name="snsCd"
								style="width: 500px;" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="LeaveTf">탈퇴여부</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="leaveTf"
								value="<%=oneUser.getLeaveTf()%>" name="leaveTf"
								style="width: 500px;">
						</div>
					</div>

					<!-- 탈퇴일자가 NULL이 아닐때 생김 -->
					<%if(oneUser.getLeaveTf() == 'Y' && oneUser.getLeaveDt() != null){ %>
					<div class="form-group">
						<label class="control-label col-sm-2" for="tLeaveDt">탈퇴일자</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="leaveDt"
								value="<%=oneUser.getLeaveDt()%>" name="leaveDt"
								style="width: 500px;">
						</div>
					</div>
					<%} else {%>

							<input type="hidden" class="form-control" id="leaveDt" name="leaveDt" style="width: 500px;" readonly="readonly">
					<%} %>
					<div class="form-group">
						<label class="control-label col-sm-2" for="file">첨부파일:</label>
						<div class="col-sm-10">
							<input type="file" id="ex_filename" class="upload-hidden">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="cd" >대관등록승인</label>
						<div class="col-sm-10">
							<div class="col-sm-2" id="select" style="width: 100px;">
								<select class="form-control" id="userGradeCd" name="userGradeCd">
									<%
										if (oneUser.getUserGradeCd() == 1) {
									%>
									<option>Y</option>
									<option selected="selected">N</option>
									<%
										} else {
									%>
									<option selected="selected">Y</option>
									<option>N</option>
									<%
										}
									%>
								</select>
							</div>
						</div>
						<br>
					</div>
					</form>
					<br> <br> <br> <br>
					<div align="center">
						<label>대관등록내역</label>
					</div>
					<br>
					<div class="container">
						<table class="table">
							<thead>
								<tr>
									<th>공연장 고유번호</th>
									<th>공연장명</th>
									<th>상호명</th>
									<th>주소</th>
									<th>등록일</th>
									<th>대관등록진행상태</th>
									<th>작성자</th>

								</tr>
							 	<%
									for (EnrollHistoryVO EnrollHistory : EnrollHistoryVOlist) {
								%>


							</thead>
							<tbody>

								<tr>
									<th><%=EnrollHistory.getRentSeq()%></th>
									<th><%=EnrollHistory.getHallNm()%></th>
									<th><%=EnrollHistory.getCompNm()%></th>
									<th><%=EnrollHistory.getAddress()%></th>
									<th><%=EnrollHistory.getRentEnrollDt()%></th>
									<th><%=EnrollHistory.getRentEnrollStatus()%></th>
									<th><%=EnrollHistory.getUserNm() %></th>
								</tr>
							</tbody>
							<%
								}
							%>
						</table>
					</div>

				<%-- 페이징처리 --%>
		<div class="pagingArea" align="center">
			<button
				onclick="location.href='<%=request.getContextPath()%>/selectOneUser.ad?userSeq=<%=oneUser.getUserSeq()%>&currentPage=1'"><<</button>

			<%
				if (currentPage <= 1) {
			%>
			<button disabled><</button>
			<%
				} else {
			%>
			<button
				onclick="location.href='<%=request.getContextPath()%>/selectOneUser.ad?userSeq=<%=oneUser.getUserSeq()%>&currentPage=<%=currentPage - 1%>'"></button>
			<%
				}
			%>

			<%
				for (int p = startPage; p <= endPage; p++) {
					if (currentPage == p) {
			%>
			<button disabled><%=p%></button>
			<%
				} else {
			%>
			<button
				onclick="location.href='<%=request.getContextPath()%>/selectOneUser.ad?userSeq=<%=oneUser.getUserSeq() %>&currentPage=<%=p%>'"><%=p%></button>
			<%
				}
				}
			%>

			<%
				if (currentPage >= maxPage) {
			%>
			<button disabled>></button>
			<%
				} else {
			%>
			<button
				onclick="location.href='<%=request.getContextPath()%>/selectOneUser.ad?userSeq=<%=oneUser.getUserSeq() %>&currentPage=<%=currentPage + 1%>'">></button>
			<%
				}
			%>

			<button
				onclick="location.href='<%=request.getContextPath()%>/selectOneUser.ad?userSeq=<%=oneUser.getUserSeq() %>&currentPage=<%=maxPage%>'">>></button>

			</div>
		</div>
		<br><br><br><br>

					<div align="center">
						<label>대관사용내역</label>
					</div>
					<br>
					<div class="container">
						<table class="table">
							<thead>
								<tr>
									<th>공연장 고유번호</th>
									<th>상호명</th>
									<th>사용일자</th>
									<th>사용공간 이름</th>
									<th>상태</th>
								</tr>
								<%
									for (UseHistoryVO useHistory : UseHistoryVOlist) {
								%>
							</thead>
							<tbody>

								<tr>
									<th><%=useHistory.getRentSeq()%></th>
									<th><%=useHistory.getCompNm()%></th>
									<th><%=useHistory.getUseStartDt()%> ~ <%=useHistory.getUseEndDt() %></th>
									<th><%=useHistory.getHallNm()%></th>
									<th><%=useHistory.getGetpropStatus()%></th>
								</tr>
							</tbody>
							<%
								}
							%>
						</table>
					</div>


				<br>
				<%-- 페이징처리 --%>
		<div class="pagingArea" align="center">
			<button
				onclick="location.href='<%=request.getContextPath()%>/selectOneUser.ad?userSeq=<%=oneUser.getUserSeq()%>&currentPage=1'"><<</button>

			<%
				if (currentPage <= 1) {
			%>
			<button disabled><</button>
			<%
				} else {
			%>
			<button
				onclick="location.href='<%=request.getContextPath()%>/selectOneUser.ad?userSeq=<%=oneUser.getUserSeq()%>&currentPage=<%=currentPage - 1%>'"></button>
			<%
				}
			%>

			<%
				for (int p = startPage; p <= endPage; p++) {
					if (currentPage == p) {
			%>
			<button disabled><%=p%></button>
			<%
				} else {
			%>
			<button
				onclick="location.href='<%=request.getContextPath()%>/selectOneUser.ad?userSeq=<%=oneUser.getUserSeq() %>&currentPage=<%=p%>'"><%=p%></button>
			<%
				}
				}
			%>

			<%
				if (currentPage >= maxPage) {
			%>
			<button disabled>></button>
			<%
				} else {
			%>
			<button
				onclick="location.href='<%=request.getContextPath()%>/selectOneUser.ad?userSeq=<%=oneUser.getUserSeq() %>&currentPage=<%=currentPage + 1%>'">></button>
			<%
				}
			%>

			<button
				onclick="location.href='<%=request.getContextPath()%>/selectOneUser.ad?userSeq=<%=oneUser.getUserSeq() %>&currentPage=<%=maxPage%>'">>></button>

			</div>
		</div>



		</div>
		<button class="btn btn-warning" id="revisebutton">수정</button>
		<script type="text/javascript">
			$(function(){
				$("#revisebutton").click(function(){
					$("form").submit();
				});
			});
		</script>



		<button type="reset" class="btn btn-warning" id="resetbutton"
		onclick="location.href='<%=request.getContextPath()%>/selectAllUser.ad'">취소</button>


	</div>
	<br>
	<br>
	<br>
	<br>
	<br>




	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>



