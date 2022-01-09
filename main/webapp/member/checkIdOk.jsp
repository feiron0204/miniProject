<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${id}는(은)사용 가능합니다</h3>
<input type="button" value="사용하기" onclick="checkIdClose('${id}')">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function checkIdClose(id){
//현재 열려있는 객체들 중에서! = opener<-부모창여는거임
	//opener.document.getElementById("id").value=id;
	$('#id',opener.document).val(id);
	window.close();
	//opener.document.writeForm.pwd.focus();
	$('#pwd',opener.document).focus();//나한테pwd찾지말고 opener에서 찾앙!
	$('#checkIdHidden',opener.document).val("ok");
	/* 강사님답
	$('#check',opener.document).val(id);
	*/
}	

</script>
</body>
</html>