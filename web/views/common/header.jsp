<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<!-- Header_Navigator -->
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Happay PlayStage</a>
	    </div>

	    <ul class="nav navbar-nav">

	      <!-- 대관 관련 -->
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">대관<span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="#">대관 등록하기</a></li>
	          <li><a href="#">대관 신청하기</a></li>
	        </ul>
	      </li>

		  <!-- 리뷰 관련 -->
	      <li><a href="#">리뷰</a></li>

		  <!-- 고객센터 관련 -->
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">고객센터<span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="#">공지사항</a></li>
	          <li><a href="#">자주 묻는 질물</a></li>
	          <li><a href="#">회사 소개</a></li>
	          <li><a href="#">1:1 문의</a></li>
	          <li><a href="#">약관 및 개인정보 보호</a></li>
	        </ul>
	      </li>

		  <!-- 관리자 관련 -->
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">관리자<span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="#">회원 관리</a></li>
	          <li><a href="#">대관등록 권한설정</a></li>
	          <li><a href="#">대관등록 검수</a></li>
	          <li><a href="#">매출 통계</a></li>
	          <li><a href="#">회원 수 통계</a></li>
	          <li><a href="#">매출 정산</a></li>
	          <li><a href="#">환불 정산</a></li>
	          <li><a href="#">1:1 문의 관리</a></li>
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
			<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</ul>

	  </div>
	</nav>