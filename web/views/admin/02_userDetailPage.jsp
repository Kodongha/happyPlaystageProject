<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.hp.admin.model.vo.*"%>

<%
	ArrayList<User> list = (ArrayList<User>) request.getAttribute("list");

	User oneUser = (User) request.getAttribute("oneUser");

	ArrayList<UseHistoryVO> UseHistoryVOlist = (ArrayList<UseHistoryVO>) request
			.getAttribute("UseHistoryVOlist");

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
				<form class="form-horizontal" action="/action_page.php">
					<div class="form-group">
						<label class="control-label col-sm-2" for="userId" id="userseq">회원번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userseq"
								value="<%=oneUser.getUserSeq()%>" name="userseq"
								style="width: 500px;">

						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="nikName">이메일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="email" name="email"
								style="width: 500px;" value="<%=oneUser.getUserEmail()%>">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="name">이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								value="<%=oneUser.getUserNm()%>" id="name" name="name"
								style="width: 500px;">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="nick">닉네임</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								value="<%=oneUser.getUserNick()%>" id="nick" name="nick"
								style="width: 500px;">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="phone">연락처</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								value="<%=oneUser.getUserPhone()%>" id="phone" name="phone"
								style="width: 500px;">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="EnrollDt">회원가입일자</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="text"
								value="<%=oneUser.getEnrollDt()%>" name="text"
								style="width: 500px;">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="sns">SNS코드</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="text"
								value="<%=oneUser.getEnrollDt()%>" name="text"
								style="width: 500px;">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="LeaveTf">탈퇴여부</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="text"
								value="<%=oneUser.getLeaveTf()%>" name="text"
								style="width: 500px;">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="tLeaveDt">탈퇴일자</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="text"
								value="<%=oneUser.getLeaveDt()%>" name="text"
								style="width: 500px;">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="file">첨부파일:</label>
						<div class="col-sm-10">
							<input type="file" id="ex_filename" class="upload-hidden">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="cd">대관등록승인</label>
						<div class="col-sm-10">
							<div class="col-sm-2" id="select" style="width: 100px;">
								<select class="form-control" id="cd">
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
					<br> <br> <br> <br>
					<div align="center">
						<label>대관등록내역</label>
					</div>
					<div id="Enrollment"></div>
					<br> <br>


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
								</tr>
								<%
									for (UseHistoryVO useHistory : UseHistoryVOlist) {
								%>
							</thead>
							<tbody>

								<tr>
									<th><%=useHistory.getRentSeq()%></th>
									<th><%=useHistory.getCompNm()%></th>
									<th><%=useHistory.getUseStartDt()%></th>
									<th><%=useHistory.getHallNm()%></th>
								</tr>
							</tbody>
							<%
								}
							%>
						</table>
					</div>
				</form>
				
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
		<button type="submit" class="btn btn-warning" id="revisebutton"
		onclick="location.href='<%=request.getContextPath()%>/updateOneUser.ad?userSeq=<%=oneUser.getUserSeq() %>'" >수정</button>
		
		
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



