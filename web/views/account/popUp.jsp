<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
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
   width:95%;
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
 	width:95%;
 	padding: 10px;
 	height: 50px;	
 
 }
 
 #p2{
 	text-align: center;
 	padding: 10px;
 	
 }
 
 .modal-footer{
 	text-align: center;
 	width:100%;
 }

</style>
</head>
<body>

<div class="container">
  <h2>대관 예약 취소 팝업</h2>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">예약 취소</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" style="text-align: center;">예약을 취소하시겠습니까?</h4>
        </div>
        <div class="modal-body">
          <label>결제금액</label><label style="float: right;">500,000원</label>
          <hr>
          <label>차감금액</label><label style="float: right;">0원</label>
          <hr>
          <label>환불금액</label><label style="float: right;">300,000원</label>
          <hr>
          <label>취소 사유</label> <label style="color: red;">(필수)</label>  
        </div>
        
        <div>
  		<form id="p">

				<select name="p" id="p1">

					<option value="">일정 / 취소</option>
					<option value="">일정 변경</option>
					<option value="">환불</option>
					<option value=""></option>
				</select>
				
		</form>
        </div>
        
        <div id="p2">
		        
		<input type="text" id="p3" placeholder="일정이 취소 / 변경되어 취소합니다.">		
		
        </div>
              
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" id="c">취소 / 환불 요청하기</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>

</body>
</html>