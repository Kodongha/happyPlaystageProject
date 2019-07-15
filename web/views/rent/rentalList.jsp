<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style>
</style>

<title>Insert title here</title>
</head>
<body>
<jsp:include page="/views/common/header.jsp" />

<div class="container search">
    <div class="form-group selectGroup">
      <label for="sel1">지역</label>
      <select class="form-control" id="sel1" style="width:150px;">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
      </select>
    </div>
</div>
    <div>
    	<label for="sel2">이용일</label>
    	<input type="date" id="sel2">
    </div>

<jsp:include page="/views/common/footer.jsp" />
</body>
</html>