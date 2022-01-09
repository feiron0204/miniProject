<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<style type="text/css">

#modifyForm div{
color : red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<form name="modifyForm" id="modifyForm" method="post" action="/miniProject/member/modify.do">
	<table border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td width="100" align="center">이름</td>
			<td>
				<input type="text" name="name" id="name" placeholder="이름 입력" value="${memberDTO.name }">
				<div id="nameDiv"></div>
			</td>	
		</tr>
		
		<tr>
			<td width="100" align="center">아이디</td>
			<td>
				<input type="text" name="id" id="id" value="${memberDTO.id}" readonly>
			</td>	
		</tr>
		
		<tr>
			<td width="100" align="center">비밀번호</td>
			<td>
				<input type="password" name="pwd" id="pwd" size="30" placeholder="비밀번호 입력" value="${memberDTO.pwd}">
				<div id="pwdDiv"></div>
			</td>	
		</tr>
		
		<tr>
			<td width="100" align="center">재확인</td>
			<td>
				<input type="password" name="repwd" id="repwd" size="30" placeholder="비밀번호 입력" value="${memberDTO.pwd}">
				<div id="repwdDiv"></div>
			</td>	
		</tr>
		
		<tr>
			<td width="100" align="center">성별</td>
			<td>
				<%-- <input type="radio" name="gender" value="0" ${memberDTO.gender==0?"checked":""}>남
				<input type="radio" name="gender" value="1" ${memberDTO.gender==1?"checked":""}>여 --%>
				<input type="radio" name="gender" value="0" >남
				<input type="radio" name="gender" value="1" >여
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">이메일</td>
			<td>
				<input type="text" name="email1" value="${memberDTO.email1}">
				@
				<input type="text" name="email2" list="email2" placeholder="직접입력" value="${memberDTO.email2}">
				<datalist id="email2">
					<option value="naver.com">naver.com
					<option value="daum.net">daum.net
					<option value="gmail.com">gmail.com
				</datalist>
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">핸드폰</td>
			<td>
				<select name="tel1" >
					<%-- <option value="010" ${memberDTO.tel1==010?"selected":""}>010</option>
					<option value="011" ${memberDTO.tel1==011?"selected":""}>011</option>
					<option value="019" ${memberDTO.tel1==019?"selected":""}>019</option> --%>
					<option value="010" >010</option>
					<option value="011" >011</option>
					<option value="019" >019</option>
				</select>
				-
				<input type="text" name="tel2" size="6" maxlength="4" value="${memberDTO.tel2}">
				-
				<input type="text" name="tel3" size="6" maxlength="4" value="${memberDTO.tel3}">
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">주소</td>
			<td>
				<input type="text" name="zipcode" id="zipcode" value="${memberDTO.zipcode}" readonly>
				<input type="button" value="우편번호 검색" onclick="checkPost()" ><br>
				<input type="text" name="addr1" id="addr1" size="60" placeholder="주소" value="${memberDTO.addr1}" readonly><br>
				<input type="text" name="addr2" id="addr2" size="60" placeholder="상세주소" value="${memberDTO.addr2}">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" id="modifyBtn" value="회원정보수정">
				<!-- <input type="reset" id="resetBtn" value="다시작성"> -->
				<input type="reset" id="resetBtn" value="다시작성" onclick="location.reload()">
				<input type="button" id="back" value="뒤로가기" onclick="javascrip:history.back()">
			</td>
		</tr>
	</table>
</form >
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script><!-- 다음 우편번호 검색을 위한 스크립트 -->
<script type="text/javascript">
$(function(){
	
	document.modifyForm.gender['${memberDTO.gender}'].checked=true;

	document.modifyForm.email2.value='${memberDTO.email2}';
	document.modifyForm.tel1.value='${memberDTO.tel1}';
});

$('#modifyBtn').click(function(){
	$('#nameDiv').empty();
	$('#pwdDiv').empty();
	$('#repwdDiv').empty();
	
	if($('#name').val() == "") $('#nameDiv').text("이름을 입력하세요");
	else if($('#pwd').val() =="") $('#pwdDiv').text("비밀번호를 입력하세요");
	else if($('#pwd').val() != $('#repwd').val()) $('#repwdDiv').text("비밀번호가 맞지 않습니다.");
	else document.modifyForm.submit();
});

$('#resetBtn').click(function(){
	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();
	$('#repwdDiv').empty();
	
});

function checkPost() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; 
            if (data.userSelectedType === 'R') { 
                addr = data.roadAddress;
            } else { 
                addr = data.jibunAddress;
            }
            if(data.userSelectedType === 'R'){
            } else {
            } 

            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById("addr1").value = addr;
            document.getElementById("addr2").focus();
        }
    }).open();
}

</script>

</body>
</html>







