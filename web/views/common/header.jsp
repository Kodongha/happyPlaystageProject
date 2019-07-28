<%@page import="com.kh.hp.account.model.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	UserVO user = (UserVO) session.getAttribute("user");
%>
<!DOCTYPE html>
	<!-- Header_Navigator -->
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="<%=request.getContextPath() %>/moveMain.main">Happay PlayStage</a>
	    </div>

	    <ul class="nav navbar-nav">

	      <!-- 대관 관련 -->
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">대관<span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="<%=request.getContextPath() %>/MoveRentEnroll.rt">대관 등록하기</a></li>
	          <li><a href="<%=request.getContextPath() %>/moveRentList.rt">대관 신청하기</a></li>
	        </ul>
	      </li>

		  <!-- 리뷰 관련 -->
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">리뷰<span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="<%=request.getContextPath() %>/views/review/reviewmain.jsp">리뷰 보기</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/review/beforeriveiw.jsp">리뷰 등록하기</a></li>
	        </ul>
	      </li>

		  <!-- 고객센터 관련 -->
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">고객센터<span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="<%=request.getContextPath() %>/notice.sc">공지사항</a></li>
	          <li><a href="<%=request.getContextPath() %>/faq.sc">자주 묻는 질문</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/serviceCenter/introduce.jsp">회사 소개</a></li>
	          <li><a href="<%=request.getContextPath() %>/moveRealtimeQnA.sc">1:1 문의</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/serviceCenter/terms.jsp">약관 및 개인정보 보호</a></li>
	        </ul>
	      </li>



		  <!-- 관리자 관련 -->
		  <%if(user != null && user.getUserGradeCd() == 0){ %>
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">관리자<span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="<%=request.getContextPath() %>/selectAllUser.ad">회원 관리</a></li>
	          <li><a href="<%=request.getContextPath() %>/SetRegPermissions.ad">대관등록 권한설정</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/04_checkList.jsp">대관등록 검수</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/06_salesStatus.jsp">매출 통계</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/07_statistics.jsp">회원 수 통계</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/08_calculate.jsp">매출 정산</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/09_refund.jsp">환불 정산</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/10_noticeWirte.jsp">공지사항 등록</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/11_1vs1.jsp">1:1 문의 관리</a></li>
	        </ul>
	      </li>
		<%} %>
	    </ul>

		<!-- 검색 관련 -->
		<ul class="nav navbar-nav navbar-right">
			<li>
				<form class="navbar-form navbar-left" action="/action_page.php">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search" name="search">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>
			</li>

			<!-- 회원가입 및 로그인 관련 -->


			<!-- 로그인이 안됐을 경우 -->
 			<%if(user == null){ %>
			<li><a href="<%=request.getContextPath() %>/views/account/signUp.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
 			<li><a href="<%=request.getContextPath() %>/views/account/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>

			<!-- 로그인 됐을 경우 -->
			<%} else { %>
			<%-- <li><a href="<%=request.getContextPath() %>/views/account/signUp.jsp"><span class="glyphicon glyphicon-user"></span> <%=user.getUserNick() %>님 환영합니다. </a></li> --%>

			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-pencil"></span> <%=user.getUserNick() %></a>
	        <ul class="dropdown-menu">
	          <li><a href="<%=request.getContextPath() %>/myPage.mp">마이 페이지</a></li>
	          <li><a href="<%=request.getContextPath() %>/registList.mp">대관 등록 내역</a></li>
	          <li><a href="<%=request.getContextPath() %>/usingInfo">대관 사용 내역</a></li>
	          <li><a href="<%=request.getContextPath() %>/applyInfo1">대관 신청 내역</a></li>
	          <li><a href="<%=request.getContextPath() %>/levelUp">등업 신청</a></li>
	        </ul>
	      </li>
 			<li><a href="<%=request.getContextPath() %>/logout.acc"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
 			<%} %>
		</ul>
	  </div>
	</nav>