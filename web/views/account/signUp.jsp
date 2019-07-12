<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- 리스트 -->  
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

   <style>
      div.form-group{
         border:1px solid #999;
         height:500px;
         width:500px; 
             padding: 40px 10px 0px 130px;
             border-radius: 10px;
      }

     .form-group {
        width:300px;
        height:50px;
        margin:0 auto;
     }
     #login a{text-decoration: none;}
     
     h2 {
        text-align:center;
        padding: 20px;
     }
     
     #login{
   position: relative;
   vertical-align: top;
   width: 100%;
   height: 40px;
   padding: 0;
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
     
     
     }

     input.form-control{
        
        display: inline-block;
            width: 210px;
    height: 30px;
     }
     
     a{
     color: white;
     
     }
     table tr td{
        
        width: 400px;
        padding: 5px;

     }
     table{
        text-align:left;
     }
     #inj{
        width: 100px;
     }
     #injbu{
            width: 100px;
    height: 25px;
     }
    #hr{
       border-bottom: 1px solid #999;
    }

  </style>


</head>
<body>
<jsp:include page="/views/common/header.jsp" />
 
   <h2><b>회원가입</b></h2>
 
   <form>
       <div class="form-group">
        <table>
           <tr>
              <td><input class="form-control" id="inputdefault1" type="email" placeholder="이메일"></td>
           </tr>
           <tr>
              <td> <input class="form-control" id="inputdefault2" type="password" placeholder="비밀번호"></td>
           </tr>
           <tr>
              <td><input class="form-control" id="inputdefault3" type="password" placeholder="비밀번호 확인"></td>
           </tr>
           <tr>
              <td><input class="form-control" id="inputdefault4" type="text" placeholder="이름"></td>
           </tr>
           <tr>
              <td><input class="form-control" id="inputdefault5" type="text" placeholder="닉네임"></td>
           </tr>
           <tr>
              <td><input class="form-control" id="inputdefault6" type="tel" placeholder="연락처"></td>
           </tr>
           <tr>
              <td><input class="form-control" id="inputdefault" type="password" placeholder="인증번호 6자리 숫자 입력"></td>
              <td id="inj"><input id="injbu" type="button" value="인증번호 받기"></td>
           </tr>
           
           <tr>

              <td id="hr"><input type="checkbox"> 아래 약관에 모두 동의합니다.</td>
              
           </tr>
           
           <tr>
              <td><input type="checkbox"> 서비스 이용약관(필수)</td>
              
           </tr>
           <tr>
              <td><input type="checkbox"> 개인정보 처리 방침(필수)</td>
              
           </tr>
           <tr>
              <td> <button onclick="alert('회원가입을 축하합니다');" id="login" type="button" class="btn btn-default btn-lg btn-block"><a href="index.html">회원가입</a></button></td>
              
           </tr>
 </table>
     
      
      
      
      
     
        </div>
        
   </form>
   <jsp:include page="/views/common/footer.jsp" />
</body>
</html>