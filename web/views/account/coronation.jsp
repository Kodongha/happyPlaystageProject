<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대관 사용 내역</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
   

table{
   margin: auto;
   padding: 40px;

}

h3{
   text-align: center;

}

h5{

   text-align: left;
}
#findid1{
   width: 550PX;
   text-align: center;
   display: inline-block;
    height: 100px;
}

body{
   text-align: center;
}

td.td1{
   text-align: right;
}

td{
   padding: 5px;
}
#findid2{
   padding: 20px;
   border: 1px solid black;
   width: 600px;
   margin-right: auto;
   margin-left: auto;
 
}

label{
   font-weight: bold;
}

h2{
	
	text-align: left;
	font-size: large;

}

.form-control{
	
	border-radius: 

}
hr{
	width: 80%;
}

#f1{
	width: 80%;
	text-align: center;
}

th{
	text-align: center;
}

</style>
</head>


<body>
<jsp:include page="/views/common/header.jsp" />
<div class= "findId" id= "findid1">
<h1>대관 사용 내역</h1>
</div>

<div class = "findId" id= "findid2">
<form>
<table>	
	<tr>
		<td><label>공연장 고유 번호</label><input type="text" placeholder="내용 입력"></td>
		<td><label>공연장 이름</label><input type="text" placeholder="내용 입력"></td>
		<td><label>일자</label><input type="text" placeholder="내용 입력"></td>
		
	</tr>   
   
	
 
</table>
</form>
</div>
<hr>
<div>
<table class="table table-bordered" id="f1">
    <thead>
      <tr>
        <th>신청 공연장 고유번호</th>
        <th>공연장 이름</th>
        <th>신청 일자</th>
        <th>신청 상태</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>001</td>
        <td>아트홀</td>
        <td>2019/01/01</td>
        <td>대기중</td>
      </tr>
      <tr>
        <td>002</td>
        <td>블랙홀</td>
        <td>2019/01/01</td>
      	<td>대기중</td>
      </tr>
      <tr>
        <td>003</td>
        <td>공연홀</td>
        <td>2019/01/01</td>
      	 <td>대기중</td>
      </tr>
    </tbody>
  </table>
</div>


<jsp:include page="/views/common/footer.jsp" />
</body>
</html>