<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.mainnav {
	background-color: #483D8B;
	list-style: none;
}

.mainnav li {
	display: inline-block;
}

.mainnav li a {
	display: block;
	padding: 0 13px; /* 위아래, 좌우 */
	color: #ffffff;
	font: bold       16px/40px 'Nanum Gothic', sans-serif;
	    /* 폰트 굵기 | 크기/line-height : 글꼴  */
	text-decoration: none;
}

.mainnav li a:hover {
	color: #660000;
	background-color: #ffcc00;
}
</style>

<ul class="mainnav">
	<c:if test="${memId !=null }">
		<li><a href="/miniProject/board/boardWriteForm.do">글쓰기</a></li>
		<li><a href="/miniProject/imageboard/imageboardWriteForm.do">이미지등록</a></li>
		<li><a href="/miniProject/guestbook/guestbookWriteForm.do">방명록작성</a></li>
	</c:if>
	<li><a href="/miniProject/board/boardList.do?pg=1">목록</a></li><!-- 변수로 page를 못씀 키워드라서 -->
	<li><a href="/miniProject/imageboard/imageboardList.do?pg=1">이미지목록</a></li>
	<li><a href="/miniProject/guestbook/guestbookList.do?pg=1">방명록보기</a></li>
</ul>











