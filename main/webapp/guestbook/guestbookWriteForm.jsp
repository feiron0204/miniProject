<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form name="guestbookWriteForm" id="guestbookWriteForm" >
<h3>글쓰기</h3>
	<table border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td width="100" align="center">작성자</td>
			<td>
				<input type="text" name="name" id="name" size="20" placeholder="작성자 입력" value="${memName}" readonly>
			</td>
		</tr>
		<tr>
			<td width="100" align="center">이메일</td>
			<td>
				<input type="text" name="email" id="email" size="40" placeholder="이메일 입력" value="${memEmail}" readonly>
			</td>
		</tr>
		<tr>
			<td width="100" align="center">홈페이지</td>
			<td>
				<input type="text" name="homepage" id="homepage" size="50" placeholder="홈페이지를 입력하세요" value="http://">
			</td>
		</tr>
		<tr>
			<td width="100" align="center">제목</td>
			<td>
				<input type="text" name="subject" id="subject" size="60" placeholder="제목입력" >
				<div id="subjectDiv"></div>
			</td>
		</tr>
		<tr>
			<td width="100" align="center">내용</td>
			<td>
				<textarea rows="15" cols="60" placeholder="내용입력" name="content" id="content"></textarea>
				<div id="contentDiv"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" id="guestbookWriteBtn" value="글쓰기"> 
			<input type="reset" id="resetBtn" value="다시작성">
			<input type="button" id="guestbookListBtn" value="글목록" onclick="location.href='/miniProject/guestBookList.do?pg=1'">
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$('#guestbookWriteBtn').click(function() {
		$('#subjectDiv').empty();
		$('#contentDiv').empty();
		
		if ($('#subject').val() == '')
			$('#subjectDiv').text('제목를 입력하세요');
		else if ($('#content').val() == '')
			$('#contentDiv').text('글내용을 입력하세요');
		else
			$.ajax({
				type:'post',
				url:'/miniProject/guestbook/guestbookWrite.do',
				data:$('#guestbookWriteForm').serialize(),
				success:function(){
					alert('방명록쓰기 성공');
					location.href="/miniProject/guestbook/guestbookList.do?pg=1";
				},
				error:function(err){
					alert(err);
				}
			});
	});
	
	$('#resetBtn').click(function(){
		$('#subjectDiv').empty();
		$('#contentDiv').empty();
		
	});
	</script>