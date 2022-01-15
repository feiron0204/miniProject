<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style type="text/css" >
#imageboardListTable th{
	font-size: 16px;
}

#imageboardListTable td{
	font-size: 13px;
}

#imageboardListTable{
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

#imageboardPagingDiv span {
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

#imageboardPagingDiv{
text-align: center;
font-size:13pt;
margin-top: 10px;
display:flex;
justify-content: space-between;
}
</style>   
<input type="hidden" name="pg" id="pg" value="${pg}">    
<table border="1" cellspacing="0" cellpadding="5" id="imageboardListTable" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="100">이미지</th>
		<th width="100">상품명</th>
		<th width="100">단가</th>
		<th width="100">개수</th>
		<th width="100">합계</th>
	</tr>
	<c:forEach var="imageboardDTO" items="${list }">
		<tr>
			<td align="center"> ${imageboardDTO.seq} </td>
			<td align="center"> <img src='../storage/${imageboardDTO.image1}' alt="사진" width="100" height="auto"> </td>
			<td align="center"><a class="imageNameA" href="#"> ${imageboardDTO.imageName }</a> </td>
			<td align="center"> <fmt:formatNumber value='${imageboardDTO.imagePrice}' pattern="\#,###.##"/> </td>
			<td align="center"> ${imageboardDTO.imageQty } </td>
			<td align="center"><fmt:formatNumber value='${imageboardDTO.imagePrice*imageboardDTO.imageQty }' pattern="\#,###.##"/>  </td>
		</tr>
		
	</c:forEach>
</table>

<div id="imageboardPagingDiv" >
	<div >
		<input type="button" id="imageboardDeleteBtn" value="선택삭제">
	</div>
	<div >
		${imageboardPaging}
	</div>
	<div>
		<input type="hidden" >
	</div>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- <script type="text/javascript" src="/miniProjectT/js/imageboardList.js"></script> -->
<script type="text/javascript">
function imageboardPaging(pg2){
	location.href="/miniProject/imageboard/imageboardList.do?pg="+pg2;
}
</script>