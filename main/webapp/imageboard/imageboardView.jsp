<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style type="text/css" >
#imageboardViewTable th{
	font-size: 16px;
	width: 100px
}

#imageboardViewTable td{
	font-size: 13px;
	/* vertical-align:top; */
	width: 100px;
	text-align: center;
}

#imageboardViewTable{
	border-color:yellow;
	margin-left: 10px;
	table-layout: fixed;
}


</style>   
<table border="1" cellspacing="0" cellpadding="5" id="imageboardViewTable" frame="hsides" rules="rows">
	<tr>
		<td rowspan="4">
			<img src="/miniProject/storage/${imageboardDTO.image1}" width="150" height="auto" alt="${imageboardDTO.imageName}">
		</td>
		<th>상품명</th>
		<td>
			${imageboardDTO.imageName}
			</td>
	</tr>
	<tr>
		<th>단가</th>
		<td>
			<fmt:formatNumber pattern="#,###">${imageboardDTO.imagePrice}</fmt:formatNumber>
		</td>
	</tr>
	<tr>
		<th>개수</th>
		<td>${imageboardDTO.imageQty}</td>
	</tr>
	<tr>
		<th>합계</th>
		<td>
			<fmt:formatNumber pattern="#,###">${imageboardDTO.imagePrice * imageboardDTO.imageQty}</fmt:formatNumber>
		</td>	
	</tr> 
	<tr>
		<td colspan="3" style="text-align: left;" valign="top"><pre>${imageboardDTO.imageContent}</pre></td>
	</tr> 
</table>
<input type="button" value="목록" onclick="location.href='/miniProject/imageboard/imageboardList.do?pg=${pg}'" style="margin: 5px 10px">