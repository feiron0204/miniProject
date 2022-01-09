<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
#boardWriteForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<h3>글쓰기</h3>
	<form name="boardWriteForm" id="boardWriteForm" method="post" action="http://localhost:8090/miniProject/board/boardWrite.do">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<td width="100" align="center">제목</td>
				<td><input type="text" name="subject" id="subject" size="30"
					placeholder="제목입력">
					<div id="subjectDiv"></div></td>
			</tr>
			<tr>
				<td width="100" align="center">내용</td>
				<td><textarea rows="10" cols="30" placeholder="내용입력" name="content" id="content"></textarea>
					<div id="contentDiv"></div></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" id="boardWriteBtn" value="글작성"> 
				<input type="reset" id="resetBtn" value="다시작성">
				<input type="button" id="back" value="뒤로가기" onclick="javascrip:history.back()">
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		$('#boardWriteBtn').click(function() {
			$('#subjectDiv').empty();
			$('#contentDiv').empty();
			if ($('#subject').val() == "")
				$('#subjectDiv').text("제목를 입력하세요");
			else if ($('#content').val() == "")
				$('#contentDiv').text("글내용을 입력하세요");
			else
				$('#boardWriteForm').submit();
		});
		$('#resetBtn').click(function(){
			$('#subjectDiv').empty();
			$('#contentDiv').empty();
			
		});

	</script>
</body>
</html>