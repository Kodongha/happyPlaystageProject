<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.hp.admin.model.vo.* "%>
<%
    ArrayList<DetailInspectionVO> DetailInspectionVOList = (ArrayList<DetailInspectionVO>) request.getAttribute("DetailInspectionVOList");
	String[] mainImg  = (String[]) request.getAttribute("mainImg");
	String rentSeq = request.getParameter("rentSeq");
//	ArrayList<AttachmentVO> fileList = (ArrayList<AttachmentVO>) request.getAttribute("fileList");
//	AttachmentVO titleImg = fileList.get(0);

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<title>Insert title here</title>

<style>
#center {
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
	margin-left: 120px;
}

.btn-default {
	margin-left: 800px;
}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<div id="center" class="fram">
		<!-- 타이틀 -->
		<h2 id="text1">
			<strong>대관 등록 검수 리스트 상세</strong>

		</h2>
		<!-- 회원관리내역과 검색창 사이의 선 -->
		<div id="line"></div>
		<div id="left">
			<div class="container">
				<br> <br>
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-2" for="Performancename">공연장명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="rentNm"
								value="<%=DetailInspectionVOList.get(0).getHallNm()%>"
								name="rentNm" style="width: 500px;">
						</div>
					</div>
					<br>
					<div class="form-group">
						<label class="control-label col-sm-2" for="address ">주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								value="<%=DetailInspectionVOList.get(0).getAddress()%>"
								id="address " name="address " style="width: 500px;">
						</div>
					</div>
					<br>
					<div class="form-group">
						<label class="control-label col-sm-2" for="Detailedintroduction">공연장상세소개</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								value="<%=DetailInspectionVOList.get(0).getHallDetIntro()%>"
								id="HallDetIntro" name="HallDetIntro" style="width: 500px;">
						</div>
					</div>
					<br>
					<div class="form-group">
						<label class="control-label col-sm-2" for="caution">공연장주의사항</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="CautionContent"
								value="<%=DetailInspectionVOList.get(0).getCautionContent()%>"
								name="CautionContent" style="width: 500px;">
						</div>
					</div>
					<br>
					<div class="form-group">
						<label class="control-label col-sm-2" for="Website">웹사이트</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								value="<%=DetailInspectionVOList.get(0).getWebsite()%>"
								id="Website" name="Website" style="width: 500px;">
						</div>
					</div>


					<br>
					<div class="form-group">
						<label class="control-label col-sm-2">검수상태</label>
						<div class="col-sm-10">
							<div class="col-sm-2" id="select" style="width: 150px;">
								<select class="form-control" id="inspTf">
									 <%
										if (DetailInspectionVOList.get(0).getInspTf().equals('Y')) {
									%>
									<option>검수대기</option>
									<option selected="selected">검수완료</option>
									<%
										} else {
									%>
									<option selected="selected">검수대기</option>
									<option>검수완료</option>
									<%
										}
									%>
								</select> <br>
							</div>


						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="mainimg">대표이미지</label>
						<div class="col-sm-10">
						<img alt="" src="<%=request.getContextPath() %>/images/profilePhotos/<%=mainImg[0] %>">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="img">내부이미지</label>
						<div class="col-sm-10">
						<%for(int i=1; i<mainImg.length; i++){ %>
						<img alt="" src="<%=request.getContextPath() %>/images/profilePhotos/<%=mainImg[i] %>">
						<%} %>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="Registration">공연장등록증</label>
						<div class="col-sm-10">
						<input type="button" onclick="location.href='<%=request.getContextPath()%>/download.tn?rentSeq=<%=rentSeq %>'" value="다운로드">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">검수완료</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>



