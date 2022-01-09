<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

#checkedForm div{
color : red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<form name="checkedForm" id="checkedForm" action="/miniProject/member/checkId.do" >
<h3>${id}는(은)사용 불가능합니다</h3>
<br>
아이디 <input type="text" name="id" id="id" value="">
<input type="button" id="checkedBtn" value="중복체크">
<div id="idDiv"></div>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

$('#checkedBtn').click(function(){
	$('#idDiv').empty();
	if($('#id').val() == "") $('#idDiv').text("아이디를 입력하세요");
	else document.checkedForm.submit();
});
</script>
</body>
</html>