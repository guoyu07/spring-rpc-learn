<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-3.2.1.js "></script>

</head>


<body>
<h2>websocket</h2>
<div id="test"></div>

<script type="text/javascript">
var url = "ws://"+window.location.host+"${pageContext.request.contextPath}/websocket";

var socket = new WebSocket(url);
socket.onopen = function(){
	console.info("opening");
	sendMessage();
}

socket.onmessage = function(e){
	$("#test").html($("#test").html() + e.data + "</br>");
	setTimeout(sendMessage,1000);
}
socket.onclose = function(){
	console.info("closing");
}

function sendMessage(){
	socket.send("hello from brower");
}



</script>


</body>
</html>