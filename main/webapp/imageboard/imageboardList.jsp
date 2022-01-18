<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
.imageNameA:link{
		color: white;
		text-decoration:none;
}
/* 클릭당한경험 유 */
.imageNameA:visited{
		color: white;
		text-decoration:none;
}
/* 마우스올라왔을때 */
.imageNameA:hover{
		color: cyan;
		text-decoration:underline;
}
/* 마우스클릭동안 */
.imageNameA:active{
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
	text-decoration:underline;
	cursor:pointer;
}

#paging{
	color:black;
	text-decoration:none;
	cursor:pointer;
}

#imageboardPagingDiv{
text-align: center;
font-size:13pt;
margin-top: 10px;
}
</style>   

<form name="" method="post" action="/miniProject/imageboard/imageboardDelete.do">
<input type="hidden" name="pg" id="pg" value="${pg}">    
<table border="1" cellspacing="0" cellpadding="5" id="imageboardListTable" frame="hsides" rules="rows">
	<tr>
		<th width="100">
		<input type="checkbox" id="all" onclick="checkAll()">글번호</th>
		<th width="100">이미지</th>
		<th width="150">상품명</th>
		<th width="150">단가</th>
		<th width="100">개수</th>
		<th width="150">합계</th>
	</tr>
	<c:if test="${list!=null}">
		<c:forEach var="imageboardDTO" items="${list}">
			<tr>
				<td align="center">
					<input type="checkbox" name="check" class="check" value="${imageboardDTO.seq }">${imageboardDTO.seq}
				</td>
				<td align="center">
					<img src="/miniProject/storage/${imageboardDTO.image1}" width="70" height="70" alt="${imageboardDTO.imageName}">
				</td>
				<td align="center">
					<a href="/miniProject/imageboard/imageboardView.do?pg=${pg}&seq=${imageboardDTO.seq}" class="imageNameA">${imageboardDTO.imageName}</a>
				</td>
				<td align="center">
				<fmt:formatNumber pattern="#,###">${imageboardDTO.imagePrice}</fmt:formatNumber> 
				</td>
				<td align="center">${imageboardDTO.imageQty}</td>
				<td align="center">
				<fmt:formatNumber pattern="#,###">${imageboardDTO.imagePrice * imageboardDTO.imageQty}</fmt:formatNumber>
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<input type="submit" value="선택삭제" style="float: left; margin: 5px 10px">
<div style="text-align:center; width: 750; font-size: 15pt">${imageboardPaging }</div>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- <script type="text/javascript" src="/miniProjectT/js/imageboardList.js"></script> -->
<script type="text/javascript">
function imageboardPaging(pg2){
	location.href="/miniProject/imageboard/imageboardList.do?pg="+pg2;
}
function checkAll(){
	//alert("체크박스의 개수 = "+document.getElementsByName("check").length);
	//alert("글번호 체크 여부 = "+document.getElementById("all").checked);
	
	var check = document.getElementsByName("check");
	if(document.getElementById("all").checked){
		for(i=0;i<check.length;i++){
			check[i].checked=true;
		}
	}else{
		for(i=0;i<check.length;i++){
			check[i].checked=false;
		}
	}
	
}
</script>