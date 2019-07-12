<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    
<title>Insert title here</title>
<style>


#center {

	width: 1300px;
	height: 800px;
	margin: auto;
}

#line {
	border: 0.5px solid gray;
	width: 1300px;
	margin: auto;
}
<!--회원관리내역-->
#text1 {
	width: 180px;
	height: 30px;
	margin-left: 70px;
}
#left{
	width: 600px;
	height: 450px;
}

#left-bottom{
	width: 600px;
	height: 280px;
}

#leave{
	margin-left:-280px;
	margin-top:30px
}

#select1{
	margin-left:-116px;
	margin-top:30px;
}

#right{

width: 670px;
	height:700px;
	margin-top:-480px;
	margin-left:300px;
}
#register {
	margin-left:500px;
	margin-top:-500px;
}
#register1 {

width: 150px;
	margin-left:150px;
	margin-top:40px;
}


#t1{

	margin-left:100px;
	margin-top:-150px;
}

#t2{

	margin-top:20px;

}




#table1{

weigth:200px;
}

#searchbutton{
weigth:300px;
margin-left:850px;
}

.filebox input[type="file"] { position: absolute; width: 1px; height: 1px; 
padding: 0; margin: -1px; overflow: hidden; clip:rect(0,0,0,0); border: 0; }

 .filebox label { display: inline-block; padding: .5em .75em; color: #999; font-size: inherit;
  line-height: normal; vertical-align: middle; background-color: #fdfdfd; cursor: pointer;
   border: 1px solid #ebebeb; border-bottom-color: #e2e2e2; border-radius: .25em; } /* named upload */
   
  .filebox .upload-name { display: inline-block; padding: .5em .75em; 
  /* label의 패딩값과 일치 */ font-size: inherit; font-family: inherit; line-height: normal;
   vertical-align: middle; background-color: #f5f5f5; border: 1px solid #ebebeb;
    border-bottom-color: #e2e2e2; border-radius: .25em; -webkit-appearance: none; 
    /* 네이티브 외형 감추기 */ -moz-appearance: none; appearance: none; }


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
			<div id="left">
				<div class="t1">
				<br>
				<br>
  <form class="form-horizontal">
    <div class="form-group">
      <label class="control-label col-sm-2" for="userno">회원번호</label>
      <div class="col-sm-10">
        <input type="email" class="form-control" id="userno"  name="userno" style="width:300px;">
      </div>
    </div>
    <br>
    <div class="form-group">
      <label class="control-label col-sm-2" for="nickname ">닉네임</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="nickname "name="nickname " style="width:300px;">
      </div>
    </div>
        <br>
     <div class="form-group">
      <label class="control-label col-sm-2" for="name">이름</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="name" name="name" style="width:300px;">
      </div>
    </div>
        <br>
      <div class="form-group">
      <label class="control-label col-sm-2" for="phone">연락처</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="phone" name="phone" style="width:300px;">
      </div>
    </div>
        <br>
      <div class="form-group">
      <label class="control-label col-sm-2" for="email">이메일</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="email" name="email" style="width:300px;">
      </div>
    </div>
    <br>
    <div class="form-group">
       <label class="control-label col-sm-2" for="email">첨부파일</label>
<div class="filebox"> <input class="upload-name" value="파일선택" disabled="disabled"> <label for="ex_filename">업로드</label> <input type="file" id="ex_filename" class="upload-hidden"> </div>
 </div>
 <br>
   <div class="form-group">
      <label class="control-label col-sm-2" >대관등록승인여부</label>
      <div class="col-sm-10">          
       <div class="col-sm-2" id="select"  style="width:100px;">
        <select class="form-control" id="gender1">
          <option>Y</option>
          <option>N</option>
        </select>       
      </div>
      </div>
      </div>
      <br>
   <div class="form-group">
      <label class="control-label col-sm-2"id="leave">탈퇴여부</label>
      <div class="col-sm-10">   
        <div class="col-sm-2" id="select1" style="width:100px;" >
        <select class="form-control" id="gender1">
          <option>Y</option>
          <option>N</option>
        </select>       
      </div>
      
      <div id="right">
      
      <div class="form-group">
      <label class="control-label col-sm-2" id=register>대관등록내역</label>
      <div class="col-sm-10">   
      
      <div class="t1" id="t1" style="width:500px;" >
          
  <table class="table">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
      </tr>
    </tbody>
  </table>
</div>
      
    
      
      <div class="t1" id="t1" style="width:500px;" >
       <div class="form-group">
      <label class="control-label col-sm-2" id=register1>대관사용내역</label>
      <div class="col-sm-10"> 
      
 <div class="t1" id="t2" style="width:500px;" >
          
  <table class="table">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
      </tr>
    </tbody>
  </table>
</div>
      
    
      </div>  
      </div>
      
      
      </div>
      </div>
      
    </div>
    
      </div>
    </div>
    </div>
   </form> 
   <button type="button" class="btn btn-warning" id="searchbutton">수정</button>
      <button type="button" class="btn btn-warning" id="searchbutton1">취소</button>
      </div>
 
    </div>
    
    </div>
    <jsp:include page="/views/common/footer.jsp" />
</body>
</html>

			
			
		