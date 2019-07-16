<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<!-- Header_Navigator -->
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="<%=request.getContextPath() %>/views/main/main.jsp">Happay PlayStage</a>
	    </div>

	    <ul class="nav navbar-nav">

	      <!-- 대관 관련 -->
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">대관<span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="<%=request.getContextPath() %>/views/rent/rentBasicEnroll.jsp">대관 등록하기</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/rent/rentalList.jsp">대관 신청하기</a></li>
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
	          <li><a href="<%=request.getContextPath() %>/views/serviceCenter/notice.jsp">공지사항</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/serviceCenter/fAQ.jsp">자주 묻는 질물</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/serviceCenter/introduce.jsp">회사 소개</a></li>
	          <li><a href="#">1:1 문의</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/serviceCenter/terms.jsp">약관 및 개인정보 보호</a></li>
	        </ul>
	      </li>

		  <!-- 관리자 관련 -->
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">관리자<span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="<%=request.getContextPath() %>/views/admin/01_userManagement.jsp">회원 관리</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/03_authorize.jsp">대관등록 권한설정</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/04_checkList.jsp">대관등록 검수</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/06_salesStatus.jsp">매출 통계</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/07_statistics.jsp">회원 수 통계</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/08_calculate.jsp">매출 정산</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/09_refund.jsp">환불 정산</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/11_1vs1.jsp">1:1 문의 관리</a></li>
	        </ul>
	      </li>
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
			<li><a href="<%=request.getContextPath() %>/views/account/signUp.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<li><a href="<%=request.getContextPath() %>/views/account/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</ul>

	  </div>
	</nav>