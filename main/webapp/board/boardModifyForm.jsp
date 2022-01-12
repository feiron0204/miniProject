<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style type="text/css">
#boardModifyForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>

<h3>수정하기</h3>

<input type="hidden" id="seq" name="seq" value="${boardDTO.seq }">
<form name="boardModifyForm" id="boardModifyForm" >
	<table border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td width="100" align="center">제목</td>
			<td>
				<input type="text" name="subject" id="subject" size="30" value="${boardDTO.subject }">
				<div id="subjectDiv"></div>
			</td>
		</tr>
		<tr>
			<td width="100" align="center">내용</td>
			<td>
				<textarea rows="15" cols="50" name="content" id="content" >${boardDTO.content }</textarea>
				<div id="contentDiv"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" id="boardModifyBtn" value="수정하기"> 
			<input type="reset" id="resetBtn" value="다시작성">
			<input type="button" id="back" value="뒤로가기" onclick="history.back()">
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
	$('#boardModifyBtn').click(function() {
		$('#subjectDiv').empty();
		$('#contentDiv').empty();
		
		if ($('#subject').val() == '')
			$('#subjectDiv').text('제목를 입력하세요');
		else if ($('#content').val() == '')
			$('#contentDiv').text('글내용을 입력하세요');
		else
			$.ajax({
				type:'post',
				url:'/miniProject/board/boardModify.do',
				dataType: "text",
				data:{
					'seq':$("#seq").val(),
					'subject':$("#subject").val(),
					'content':$('#content').val()
				},
				success:function(data){
					if(data.trim()=='1'){
					alert('수정 성공');
					}else{
						alert('수정 실패');
					}
						
					location.href="/miniProject/board/boardList.do?pg="+${pg};
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















