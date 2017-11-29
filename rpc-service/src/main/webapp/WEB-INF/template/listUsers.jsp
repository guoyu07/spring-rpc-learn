<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-3.2.1.js "></script>

</head>


<body>
<h2>listUsers!</h2>
<div id="test"></div>
<h2>listUsersJSON!</h2>
<div id="user"></div>
<h2>addUser!</h2>
<button id="add">添加</button>
<h2>getUser id=1!</h2>
<div id="user1"></div>

<script type="text/javascript">

$("#test").html("测试jquery")

$.ajax({
	url:"listUsersJSON",
	//contentType:"application/json",
	dataType:"json",
	type:"POST",
	success:function(data){
		var text = "";
		$(data).each(function(i,n){
			text += (n.id + " "+ n.name + "  " + n.age + "</br>")
		})
		
		$("#user").html(text)
	}
	
})

$.ajax({
	url:"getUser",
	//contentType:"application/json",
	data:{"id":1},
	dataType:"json",
	type:"POST",
	success:function(data){
		var text = "";
		text += (data.id + " "+ data.name + "  " + data.age + "</br>")
		
		$("#user1").html(text)
	}
	
})
$("#add").click(function(){
	var user = {"id":"2","name":"b","age":31};
	$.ajax({
		url:"addUser",
		data:{"id":"2","name":"b","age":"31"},
		contentType:"application/json",
		dataType:"json",
		type:"POST",
		success:function(data){
			location.reload();
				
		}
		
	})
	
	
})



</script>


</body>
</html>