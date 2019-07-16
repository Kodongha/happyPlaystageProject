<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<style>
	#picture {
		width:100%;
	}
	#text4 {
		color: #ffb300;
	}
	#text5 {
		color:white;
	}
	#d4 {
		text-align: center;
		font-size: 23px;
	}
	.btns {
		width:300px;
	}
	.ui.cards {
    padding-left: 14%;
}
</style>

</head>
<body>
<jsp:include page="/views/common/header.jsp" />

<div class="container">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div id="picture">
    <div class="carousel-inner introPic">
      <div class="item active">
        <img src="../../images/main/main1.jpg" style="height:400px; width:100%">
      </div>

      <div class="item">
        <img src="../../images/main/main2.jpg" style="height:400px; width:100%">
      </div>

      <div class="item" style="height:400px; width:100%; background-image:url(../../images/main/main3.jpg)">
      	<div id="d4">
      	<br><br><br><br><br>
		<p id="text4">
			<b>우리에게 꼭 맞는 공연장이 필요할땐!</b>
		</p>
		<p id="text5">
			<b>Happy Playstage에서 쉽게 예약하고 등록해 보세요.</b>
		</p>
		<br><br>
		<div class="container">
			<button type="button" class="btn btn-warning btns"><b>공연장 찾아보기</b></button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-warning btns"><b>공연장 등록하기</b></button>
		</div>
		<br><br>
	</div>
        <!-- <img src="../../images/main/main2.jpg" style="height:400px;  width:100%"> -->
      </div>
    </div>
	</div>
    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<!-- 새로 등록된 공간 -->
<hr>
	<br><br>
	<div>
		<h2 align="center"><b>새로 등록된 공간!</b></h2>
	</div>
	<br><br>
	<div class="ui special cards">
  <div class="card">
    <div class="blurring dimmable image">
      <div class="ui dimmer">
        <div class="content">
          <div class="center">
            <div class="ui inverted button">상세보기</div>
          </div>
        </div>
      </div>
      <img src="../../images/rent/rent3.jpg">
    </div>
    <div class="content">
      <a class="header">Team Fu</a>
      <div class="meta">
        <span class="date">Created in Sep 2014</span>
      </div>
    </div>
    <div class="extra content">
      <a>
        <i class="users icon"></i>
        2 Members
      </a>
    </div>
  </div>
  <div class="card">
    <div class="blurring dimmable image">
      <div class="ui inverted dimmer">
        <div class="content">
          <div class="center">
            <div class="ui primary button">상세보기</div>
          </div>
        </div>
      </div>
      <img src="../../images/rent/rent3.jpg">
    </div>
    <div class="content">
      <a class="header">Team Hess</a>
      <div class="meta">
        <span class="date">Created in Aug 2014</span>
      </div>
    </div>
    <div class="extra content">
      <a>
        <i class="users icon"></i>
        2 Members
      </a>
    </div>
  </div>
  <div class="card">
    <div class="blurring dimmable image">
      <div class="ui dimmer">
        <div class="content">
          <div class="center">
            <div class="ui inverted button">상세보기</div>
          </div>
        </div>
      </div>
      <img src="../../images/rent/rent3.jpg">
    </div>
    <div class="content">
      <a class="header">Team Fu</a>
      <div class="meta">
        <span class="date">Created in Sep 2014</span>
      </div>
    </div>
    <div class="extra content">
      <a>
        <i class="users icon"></i>
        2 Members
      </a>
    </div>
  </div>

</div>

<!-- 리뷰 -->
<hr>
	<br><br>
	<div>
		<h2 align="center"><b>Review</b></h2>
	</div>
	<br><br>
	<!-- 카드 -->
	<div class="ui link cards" align="center">
  <div class="card" align="center">
    <div class="image">
      <img src="../../images/rent/rent1.jpg">
    </div>
    <div class="content">
      <div class="header">엘지 아트센터</div>
      <div class="meta">
      	<span class="date">Coworker</span>
      </div>
      <div class="description">
     	  역삼동 679번지 강남구 서울특별시
      </div>
    </div>
    <div class="extra content">
      <span class="right floated">
        2019.07.15
      </span>
      <span>
        <i class="user icon"></i>
        450,000 원 /일
      </span>
    </div>
  </div>
  <div class="card">
    <div class="image">
      <img src="../../images/rent/rent2.jpg">
    </div>
    <div class="content">
      <div class="header">Molly</div>
      <div class="meta">
        <span class="date">Coworker</span>
      </div>
      <div class="description">
        Molly is a personal assistant living in Paris.
      </div>
    </div>
    <div class="extra content">
      <span class="right floated">
        Joined in 2011
      </span>
      <span>
        <i class="user icon"></i>
        35 Friends
      </span>
    </div>
  </div>
  <div class="card">
    <div class="image">
      <img src="../../images/rent/rent3.jpg">
    </div>
    <div class="content">
      <div class="header">Elyse</div>
      <div class="meta">
        <a>Coworker</a>
      </div>
      <div class="description">
        Elyse is a copywriter working in New York.
      </div>
    </div>
    <div class="extra content">
      <span class="right floated">
        Joined in 2014
      </span>
      <span>
        <i class="user icon"></i>
        151 Friends
      </span>
    </div>
  </div>
</div>

<script>
$('.special.cards .image').dimmer({
	  on: 'hover'
	});
</script>




<jsp:include page="/views/common/footer.jsp" />
</body>
</html>