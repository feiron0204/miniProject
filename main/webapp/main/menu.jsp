<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<style>
.mainnav {
	background-color: #483D8B;
	list-style: none;
}
.mainnav li {
	display: inline-block;
	/* 기존은 block -> 한줄마다 잡음 */
}
.mainnav li a {
	display:block;
	padding: 0 13px; 
	/* 위아래 0 양옆 13px */
	color:#ffffff;
	text-decoration: none;
	font: bold 16px/40px 'Nanum Gothic',sans-serif;
	       /* 글자크기/높이 *//* 나눔고딕 없으면 산스로해라*/
}
.mainnav li a:hover{
	background-color: #ffcc00;
	color: #660000;
}
</style>

	<ul class="mainnav"><!-- 얘도 알아서 div처럼 한줄먹는다네.. -->
		<li><a href="">회원가입</a></li>
		<li><a href="">로그인</a></li>
		<li><a href="">회원정보수정</a></li>
		<li><a href="">로그아웃</a></li>
		<li><a href="">글쓰기</a></li>
	</ul>
