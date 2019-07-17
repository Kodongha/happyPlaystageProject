<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,  com.kh.hp.admin.model.vo.*"%>
 
 <%
 ArrayList<User> list = (ArrayList<User>) request.getAttribute("list");
 User u = (User) session.getAttribute("User");
 
 %>   
   
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
<!--회원관리내역-->
#text1 {
	width: 180px;
	height: 30px;
	margin-left: 70px;
	
}

#area{

	border: 1px solid gray; 
	width: 1200px;
	height:150px;
	margin-left:50px;
	border-top-left-radius:8px;
	border-top-right-radius:8px;
	border-bottom-left-radius:8px;
	border-bottom-right-radius:8px;
	
}

#users1{
width: 500px;
height:150px;
margin-left:50px;
}
#users2{

width: 100px;
height:150px;
margin-left:480px;
margin-top:-150px;

}

#users3{

width: 100px;
height:150px;
margin-left:570px;
margin-top:-150px;

}

#users4{

width: 100px;
height:150px;
margin-left:150px;
margin-top:-150px;

}

#users5{

width: 100px;
height:150px;
margin-left:200px;
margin-top:-150px;

}


#userno{
	width: 100px;
	margin-left:10px;
	margin-top:30px;
	
}
#input{
	width: 110px;
	margin-left:100px;
	margin-top:-32px;
}

#input1{
	width: 110px;
	margin-left:250px;
	margin-top:-26px;
}

#wave{ 
	width: 10px;
	margin-left:220px;
	margin-top:-28px;
	
}

#assent{
	background:red;
	width: 100px;
	margin-left:0px;
	margin-bottom:30px;
	
}

#leave{
	width: 100px;
	margin-left:100px;
	margin-top:-30px;
}

.col-sm-2{
	width: 100px;
	margin-top:25px;
}

#select{
	width: 100px;
	margin-left:-15px;
	margin-top:25px;
}

#searchbutton{
	margin-left:330px;
	margin-top:40px;
}

</style>

</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<div id="center" class="fram">

		<h2 id="text1">
			<strong>회원 관리 내역</strong>
			
		</h2>

		<div id="line"></div>
		<br>
		
		<form action="<%=request.getContextPath() %>/selectAllUser.ad" method="get">
		<div id="area">
		<div id="users1">
		<label id="userno">회원번호</label>
		 <div id="input"><input class="form-control" id="ex1" type="text"style="width:100px;"></div> 
		 <div id="wave">~</div>
		 <div id="input1"><input class="form-control" id="ex1" type="text"style="width:100px;"></div> 
		
		<label id="userno">회원명</label>
		 <div id="input"><input class="form-control" id="ex1" type="text"style="width:250px;"></div> 
		
		</div>
		
			<div id="users2">
		<label id="userno">대관등록승인</label>

		</div>
		
		<div id="users3">
		  <div class="col-sm-2" >
        <select class="form-control" id="gender1">
          <option>Y</option>
          <option>N</option>
        </select>       
        </div>
        
        
        
        <div id="users4">
        <label id="userno">탈퇴</label>
        </div>
        
        
        <div id="users5">
          <div class="col-sm-2" id="select" >
        <select class="form-control" id="gender1">
          <option>Y</option>
          <option>N</option>
        </select>       
           
		</div>
          <button type="button" class="btn btn-warning" id="searchbutton">검색</button>
          
          </div>
        </div> 
		</div>
		
		<br><br>
<div class="container">
  <table class="table">
    <thead>
      <tr>
        <th>회원번호</th>
        <th>이메일(아이디)</th>
        <th>이름</th>
        <th>연락처</th>
        <th>대관승인여부</th>
        <th>탈퇴여부</th>

        
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
        <td>010-1111-1111</td>
        <td>Y</td>
        <td>N<td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
        <td>010-1111-1111</td>
        <td>Y</td>
        <td>N<td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
        <td>010-1111-1111</td>
        <td>Y</td>
        <td>N<td>
      </tr>
    </tbody>
  </table>
</div>
</form>
</div>
		
		
		
		

		
		
	


<jsp:include page="/views/common/footer.jsp" />
</body>
</html>