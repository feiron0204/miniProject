<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0;
	padding: 0;
	height: 100%;
	width:auto;
}
#header{
	margin: auto;
	width: 1300px;
	height: 10%;
	text-align: center;
	border: 1px red solid;
}
#container{
	margin: auto;
	width: 1300px;
	height: 500px;
	border: 1px blue solid;
}
#container:after{
	content: '';
	display: block;
	clear: both;
	float:none;
}
#nav{
	margin-left: 10px;
	width: 25%;
	height: 100%;
	float: left;
	border: 1px Green solid;
}
#section{
	width: 70%;
	height: 100%;
	float: left;
	border: 1px Green solid;
}
#footer{
	margin: auto;
	width: 1300px;
	height: 10%;
	border: 1px red solid;
}
</style>
</head>

<body style="background: linear-gradient(to right, #654ea3, #eaafc8); color: white; ">

	<div id="header" >
		<h1>
			<img alt="가지가지" src="/miniProject/image/gargee.jpg" width="70"
				height="70" onclick="/miniProject/index.jsp" style="cursor: pointer;"> MVC 기반의 미니 프로젝트
		</h1>
		<br>
		<jsp:include page="/main/menu.jsp"/><!-- 밖에있는거 다가꼬와라 -->
	</div>

	<div id="container">
		<div id="nav" >
			<jsp:include page="/main/nav.jsp"/>
		</div>
		<div id="section" >
			<h1>
				홈페이지를 방문해주셔서 감사합니다<br>
				Have a nice day!!<br>
				<img src="/miniProject/image/29.jpg" alt="너의20대" height="350">
			</h1>
		</div>
	</div>

	<div id="footer">
		<p>산꼭대기에 공올리는중</p>
	</div>

</body>
</html>