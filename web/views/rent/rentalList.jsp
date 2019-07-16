<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<style>
	.ui.cards {
    padding-left: 14%;
	}
	#search {
		text-align:center;
	}
</style>

<title>Insert title here</title>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />

<div id="search">

	<label for="location">지역</label>
<div class="ui compact menu">
  <div class="ui simple dropdown item" name="location">
    지역
    <i class="dropdown icon"></i>
    <div class="menu">
      <div class="item">Choice 1</div>
      <div class="item">Choice 2</div>
      <div class="item">Choice 3</div>
    </div>
   </div>
    &nbsp;&nbsp;&nbsp;&nbsp;
  </div>
  &nbsp;&nbsp;&nbsp;&nbsp;
  	<label for="date">이용일</label>
	<input type="date" name="date">
	<label for="price">가격</label>
	<input type="number" name="price">  ~  <input type="number">
	<div>
		<button class="ui yellow button">필터</button>
	</div>

</div>
<hr>

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

<script>
$('.special.cards .image').dimmer({
	  on: 'hover'
	});
</script>

<jsp:include page="/views/common/footer.jsp" />
</body>
</html>