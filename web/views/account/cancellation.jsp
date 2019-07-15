<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>대관 취소 / 환불</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
<style>

 #c{
	
   font-size: 15px;
   color: black;
   text-align: center;
   text-shadow: 0 1px 2px rgba(0, 0, 0, 0.25);
   background:#FFBF00;
   border: 0;
   border-bottom: 2px solid #FFBF00;
   border-radius: 5px;
   cursor: pointer;
   -webkit-box-shadow: inset 0 -2px #FFBF00;
   box-shadow: inset 0 -2px #FFBF00;
   width:10%;
   float: right;
}

 #p1{
 	
 	margin:auto;
 	text-align:center;
 	width:95%;
 	padding: 3px;
 }
 
 #p{
 	text-align: center;
 	margin:auto;
 	padding:5px;
 }
 
 #p3{
 	margin: auto;
 	text-align: left;
 	width:85%;
 	padding: 10px;
 	height: 30px;	
 
 }
 
 #p2{
 	text-align: center;
 	padding: 10px;
 	
 }
 
 .modal-footer{
 	text-align: center;
 	width:100%;
 }

#id{
	background-color: red;
}

#t1{
margin: auto;
 	text-align: left;
 	width:85%;
 	padding: 10px;
 	height: 40px;	
 	background-color: #F7D358;
 	border: 1px solid black;
	
}


</style>
</head>
<body>

	<div id="t1">
		<tr>
		  <td>예약내용<td>
		</tr>
	</div>
<div class="container">

		<form id="canText">
          <hr> 
          <label>결제금액</label><label style="float: right;">2019/01/01</label>
          <hr>
          <label>예약공간</label><label style="float: right;">가나다</label>
          <hr>
          <label>예약내용</label><label style="float: right;"> 2019.07.26 (금) 13시 ~ 16시, 3시</label>
          <hr>
          <label>예약인원</label><label style="float: right;">00명</label>
          <hr>
      	  <label>추가옵션</label><label style="float: right; color: red;">없음</label>
          <hr>
          <label>요청사항</label><label style="float: right; color: red;">없음</label>
          <hr>
            
        
		</form>
        </div>
        
        <br><br>
        
        <div id="t1">
		<tr>
		  <td>예약자 정보<td>
		</tr>
	</div>
	
<div class="container">

		<form id="canText">
          <hr> 
          <label>예약자명</label><label style="float: right;">하민희</label>
          <hr>
          <label>연락처</label><label style="float: right;">010-9478-2687</label>
          <hr>
          <label>e-mail</label><label style="float: right;">abcd@naver.com</label>
          <hr>
       
		</form>
        </div>


        <div id="p2">
		<input type="text" id="p3" placeholder="계좌정보">	
        </div>
          
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" id="c">예약 취소</button>
        </div>


</body>
</html>