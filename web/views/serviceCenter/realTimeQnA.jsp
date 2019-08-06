<%@page import="com.kh.hp.admin.model.vo.RealTimeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.hp.account.model.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<RealTimeVO> realTimeVOs = (ArrayList<RealTimeVO>) request.getAttribute("realTimeVOs");
	String textValue = "";
	for(int i=0; i<realTimeVOs.size(); i++){

		if(realTimeVOs.get(i).getRcvMsg() != null){
			textValue += realTimeVOs.get(i).getUserNick() + ":" + realTimeVOs.get(i).getRcvMsg();
		} else {
			System.out.println("else in!!!");
			System.out.println("realTimeVOs.get(i).getSendMsg()::" + realTimeVOs.get(i).getSendMsg());

			textValue += "관리자:" + realTimeVOs.get(i).getSendMsg();
		}

		if(i != realTimeVOs.size() - 1){
			textValue += "\r\n";
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link href="/happyPlaystage/css/common/all.min.css" rel="stylesheet">
<script src="/happyPlaystage/js/common/all.min.js"></script>

<script type="text/javascript">

	function getConnection(){
		ws = new WebSocket("ws://localhost:8001" + '<%=request.getContextPath()%>/serverStart?userSeq=<%=((UserVO) request.getSession().getAttribute("user")).getUserSeq() %>');
		//서버 시작할 때 동작
		ws.onopen = function(event){
			onopen(event);
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

	function onopen(event){

	}

	// 메시지 왔을 때
	function onMessage(event){
		console.log("onMessage in!");
		var txaVal = $("#txa").val();

		receivedMessage = txaVal + "\r\n" + event.data;
		$("#txa").val(receivedMessage);
		const top = $("#txa").prop('scrollHeight');
		$("#txa").scrollTop(top);
	}

	$(function(){
		const top = $("#txa").prop('scrollHeight');
		$("#txa").scrollTop(top);
		// connection 연결
		getConnection();

		$("#sendBtn").click(function(){
			var sendInput = $("#sendInput");
			var txaVal = $("#txa").val();

			var sendMessage = '<%=((UserVO) request.getSession().getAttribute("user")).getUserNick() %>' + '§§' + sendInput.val();
			ws.send(sendMessage);
			setMessage = txaVal + "\r\n" + '<%=((UserVO) request.getSession().getAttribute("user")).getUserNick() %>' + ':' + sendInput.val();
			$("#txa").val(setMessage);
			sendInput.val("");
			const top = $("#txa").prop('scrollHeight');
			$("#txa").scrollTop(top);
		});

		$("#sendInput").keydown(function(key) {
			if (key.keyCode == 13) {
				var sendInput = $("#sendInput");
				var txaVal = $("#txa").val();

				var sendMessage = '<%=((UserVO) request.getSession().getAttribute("user")).getUserNick() %>' + '§§' + sendInput.val();
				ws.send(sendMessage);
				setMessage = txaVal + "\r\n" + '<%=((UserVO) request.getSession().getAttribute("user")).getUserNick() %>' + ':' + sendInput.val();
				$("#txa").val(setMessage);
				sendInput.val("");
				const top = $("#txa").prop('scrollHeight');
				$("#txa").scrollTop(top);
			}
		});
	});
</script>
<style>
	#span1, #span2 {
		display:inline;
	}
</style>

</head>
<body>
	<jsp:include page="/views/common/header.jsp" />
	<br><h2 align="center"><b>1:1 문의</b></h2><br>
	<div class="container" align="center">
		<div style="margin-right: 5%; float:left; width:45%;" id="span1">
				<i class="fas fa-question-circle" style="width: 350px; height: 350px;"></i>
		</div>
		<div id="span2" style="float:left; width:45%";>
			<textarea class="form-control" rows="17" cols="20" id="txa" style="resize: none; width: 400px; margin-bottom: 1%; background:#a2c9db"><%=textValue%></textarea>
			<input size="40" id="sendInput" class="form-control" style="width: 330px; display: inline-block;" placeholder="문의 사항을 입력해주세요">
			<button id="sendBtn" class="btn btn-default" style="background:#ffe600;">보내기</button>
		</div>
	</div>
	<br><br><br>
	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>