<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
<c:when test="${sessionScope.memId!=null }">
<jsp:include page="/member/loginOk.jsp"/>
</c:when>
<c:otherwise>
<jsp:include page="/member/loginForm.jsp"/>
</c:otherwise>
</c:choose>