<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <style type="text/css" >
#boardViewTable th{
	font-size: 16px;
}

#boardViewTable td{
	font-size: 13px;
	/* vertical-align:top; */
}

#boardViewTable{
	border-color:yellow;
	margin-left: 10pt;
	table-layout: fixed;
}


</style>   
<%--
만들고나니쓸모없음
 <input type="hidden" name="pg" id="pg" value="${pg}"> 
  --%>   
<%-- <input type="hidden" name="seq" id="seq" value="${seq}">  
<table border="1" cellspacing="0" cellpadding="5" id="boardViewTable" frame="hsides" rules="rows">
	<tr>
		<th>제목</th>
		<td colspan="5" id="subjectTd"></td>
	</tr>
	<tr>
		<th>글번호</th>
		<td id="seqTd"></td>
		<th>작성자</th>
		<td id="idTd"></td>
		<th>조회수</th>
		<td id="hitTd"></td>
	</tr>
	<tr>
		<th height="200px">내용</th>
		<td colspan="5" id="contentTd" ></td>
	</tr>
	<tr>
		<td colspan="6">
		<input type="button" value="목록" id="listBtn" onclick="location.href='/miniProject/board/boardList.do?pg=${pg}'">
		</td>
	</tr> 
</table>--%>
	<form id="boardViewForm">
<input type="hidden" name="pg" id="pg" value="${pg}">    
<input type="hidden" name="seq" id="seq" value="${seq}">  
<table border="1" cellspacing="0" cellpadding="5" id="boardViewTable" frame="hsides" rules="rows">
	<tr>
	    <td>
	    	<h3><span id="subjectSpan"></span></h3>
	    <td>
	</tr>
	<tr>
		<td width="150">글번호 : <span id="seqSpan"></span></td>
		<td width="150">작성자 : <span id="idSpan"></span></td>
		<td width="150">조회수 : <span id="hitSpan"></span></td>
	</tr>
	<tr>
		<td colspan="3" height="300" valign="top" >
			<pre style="white-space: pre-line; word-break: break-all;"><span id="contentSpan" ></span></pre>
		</td>
	</tr>
</table>
<input type="button" value="목록" onclick="location.href='/miniProject/board/boardList.do?pg=${pg}'">
<span id ="boardViewSpan">
<input type="button" value="글수정" onclick="mode(1)"><!-- 글번호, 페이지번호를 가져가야함(seq,pg) -->
<input type="button" value="글삭제" onclick="mode(2)"><!-- 글번호 페이지는1로돌리면됨    (seq)-->
</span>
<input type="button" value="답글" onclick="mode(3)">
	</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" >
$(function(){
	$.ajax({
		type:'post',
		url:'/miniProject/board/getBoardView.do',
		data:'seq='+$('#seq').val(),
		dataType:'json',
		success:function(data){
			console.log(data);
				/* $('#subjectSpan').text(data.boardDTO.subject);
				$('#seqSpan').text(data.boardDTO.seq);
				$('#idSpan').text(data.boardDTO.id);
				$('#hitSpan').text(data.boardDTO.hit);
				$('#contentSpan').text(data.boardDTO.content); */
			$('#subjectSpan').text(data.subject);
			$('#seqSpan').text(data.seq);
			$('#idSpan').text(data.id);
			$('#hitSpan').text(data.hit);
			$('#contentSpan').text(data.content);
			if(data.memId==data.id){
				$('#boardViewSpan').show();
			}else{
				$('#boardViewSpan').hide();
			}
		},
		error:function(err){
			alert(err);
		}
	});//ajax
});

</script>
<script>
function mode(num){
	if(num==1){//글수정
		document.getElementById("boardViewForm").method='post';
		document.getElementById("boardViewForm").action='/miniProject/board/boardModifyForm.do';
		document.getElementById("boardViewForm").submit();
	}else if(num==2){//글삭제
		document.getElementById("boardViewForm").method='post';
		document.getElementById("boardViewForm").action='/miniProject/board/boardDelete.do';
		document.getElementById("boardViewForm").submit();
	}else if(num==3){
		document.getElementById("boardViewForm").method='post';
		document.getElementById("boardViewForm").action='/miniProject/board/boardReplyForm.do';
		document.getElementById("boardViewForm").submit();
	}
}

</script>