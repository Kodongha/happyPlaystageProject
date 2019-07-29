<%@page import="com.kh.hp.account.model.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript">

	function getConnection(){
		ws = new WebSocket("ws://localhost:8001" + '<%=request.getContextPath()%>/serverStart');
		//서버 시작할 때 동작
		ws.onopen = function(event){
			var sendText = <%=((UserVO) request.getSession().getAttribute("user")).getUserSeq() %>;
			ws.send(sendText);
		}

		//서버로부터 메세지를 전달 받을 때 동작하는 메소드
		ws.onmessage = function(event){
			onMessage(event);
		}

		function onError(event){
			alert(event.data);
		}

		function onClose(event){
			alert(event);
		}
	}

	// 메시지 왔을 때
	function onMessage(event){
		console.log("onMessage in!");
		var txaVal = $("#txa").val();

		receivedMessage = txaVal + "\r\n" + event.data;
		$("#txa").val(receivedMessage);

	}

	$(function(){

		// connection 연결
		getConnection();

		$("#sendBtn").click(function(){
			var sendInput = $("#sendInput");
			var txaVal = $("#txa").val();

			sendMessage = txaVal + "\r\n" + sendInput.val();
			$("#txa").val(sendMessage);

			ws.send(sendInput.val());
			sendInput.val("");
		});

		$("#sendInput").keydown(function(key) {
			if (key.keyCode == 13) {
				var sendInput = $("#sendInput");
				var txaVal = $("#txa").val();

				sendMessage = txaVal + "\r\n" + sendInput.val();
				$("#txa").val(sendMessage);

				ws.send(sendInput.val());
				sendInput.val("");
			}
		});


	});

</script>
</head>
<body>
	<jsp:include page="/views/common/header.jsp" />

	<div class="container">
		<textarea rows="30" cols="50" id="txa"></textarea>
		<br>
		<input size="40" id="sendInput">
		<button id="sendBtn">보내기</button>
	</div>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>