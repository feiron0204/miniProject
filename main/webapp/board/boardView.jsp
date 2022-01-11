<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style type="text/css" >
#boardViewTable th{
	font-size: 16px;
}

#boardViewTable td{
	font-size: 13px;
	vertical-align:top;
}

#boardViewTable{
	border-color:yellow;
	margin-left: 10pt;
}
#contentSpan{
	white-space: pre-line;
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
	
<%-- <input type="hidden" name="pg" id="pg" value="${pg}">     --%>
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
		<td colspan="3" height="300">
			<span id="contentSpan" ></span>
		</td>
	</tr>
</table>
<input type="button" value="목록" onclick="location.href='/miniProject/board/boardList.do?pg=${pg}'">
	
	
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/miniProject/js/boardView.js"></script>