<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- <h3>${name}님 로그인 성공</h3> -->
<h3>${sessionScope.memName}님 로그인 성공</h3>

<%-- 이젠 세션에 실려있음 id정보가
<input type="button" value="회원정보수정" id="modifyBtn" onclick="location.href='modifyForm.do?id=${id}'"> --%>
<input type="button" value="회원정보수정" id="modifyBtn" onclick="location.href='/miniProject/member/modifyForm.do'">
<input type="button" value="로그아웃" onclick="location.href='/miniProject/member/logout.do'">
<!-- 강사님답 (세션처리후라서 id 가져갈필요없음)
<input type="button" value="회원정보수정" id="modifyBtn">

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$('#modifyBtn').click(function(){
	location.href='/mvcMember/member/modifyForm.do?id=${id}';
});
</script>
 -->
