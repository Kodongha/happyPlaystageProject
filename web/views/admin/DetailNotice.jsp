<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,  com.kh.hp.admin.model.vo.*"%>

<%
	NoticeVO noticeVO = (NoticeVO) request.getAttribute("noticeVO");

	System.out.println("상세공지사항에 뷰에 들어왔니?" + noticeVO);
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>Insert title here</title>


<style>
#center {
	/* 	border: 1px solid black; */
	width: 1300px;
	height: 800px;
	margin: auto;
}

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

#option1 {
	width: 150px;
}

.name {
	text-align: center;
}

#Modifiedbutton {
	margin-left: 1090px;
}
#cancelbutton {
	margin-left: 1150px;
	margin-top:-55px;
}


</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />

	<div id="center" class="fram">
		<!-- 타이틀 -->
		<h2 id="text1">
			<strong>공지사항-관리자</strong>

		</h2>
		<!-- 회원관리내역과 검색창 사이의 선 -->
		<div id="line"></div>

		<br> <br>
		<form action="<%=request.getContextPath()%>/updateNotice.ad"
			method="get">
			<div class="container">
				<table class="table table-bordered">
					<thead>
						<tr>
						
							<th width="100px" class="noticename" ><input type="hidden" name="noticeSeq" value=<%=noticeVO.getNoticeSeq() %> ></th>
							<th width="180px"><select class="form-control" id="option1"
								name="noticeCate">
									<option><%=noticeVO.getNoticeCate()%></option>
									<option>안내</option>
									<option>중요</option>
									<option>긴급</option>
							</select></th>
							<th class="name"><input type="text" size="100px"
								name="noticeTitle"
								style="border: none; border-right: 0px; border-top: 0px; boder-left: 0px; boder-bottom: 0px;"
								value=<%=noticeVO.getNoticeTitile()%>></th>

						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="3" height="450px">

								<div class="form-group">
									<textarea
										style="border: none; border-right: 0px; border-top: 0px; boder-left: 0px; boder-bottom: 0px;"
										class="form-control" rows="25" id="content"
										name="noticeContent"><%=noticeVO.getNoticeContent()%> </textarea>
								</div>

							</td>
					</tbody>
				</table>
			</div>

			<button type="submit" class="btn btn-warning" id="Modifiedbutton">수정</button>
			</form>
			
			<button type="button" class="btn btn-warning" id="cancelbutton"
			onclick="location.href='<%=request.getContextPath()%>/SelectNotice'">취소</button>
	</div>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>