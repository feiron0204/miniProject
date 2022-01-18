<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style type="text/css" >
#boardListTable th{
	font-size: 16px;
}

#boardListTable td{
	font-size: 13px;
}

#boardListTable{
	border-color:yellow;
	margin-left: 10pt;
}
/* a태그 활성화순간 */
.subjectA:link{
		color: white;
		text-decoration:none;
}
/* 클릭당한경험 유 */
.subjectA:visited{
		color: white;
		text-decoration:none;
}
/* 마우스올라왔을때 */
.subjectA:hover{
		color: green;
		text-decoration:underline;
}
/* 마우스클릭동안 */
.subjectA:active{
		color: cyan;
		text-decoration:none;
}

#boardPagingDiv span {
	margin: 5px;
	padding: 5px;
	border: 1px white solid;
}

#currentPaging{
	color:red;
	cursor:pointer;
}

#paging{
	cursor:pointer;
}

#boardPagingDiv{
text-align: center;
font-size:13pt;
margin-top: 10px;
}
.red{
	color:red;
}
</style>   
<input type="hidden" name="pg" id="pg" value="${pg}">    
<table border="1" cellspacing="0" cellpadding="5" id="boardListTable" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="300">제목</th>
		<th width="100">작성자</th>
		<th width="100">작성일</th>
		<th width="100">조회수</th>
	</tr>
</table>
<div id="boardPagingDiv"></div>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/miniProject/js/boardList.js"></script>
<script type="text/javascript">
function boardPaging(pg2){
	location.href="/miniProject/board/boardList.do?pg="+pg2;
}
</script>