<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

	<h1>${board.subject}</h1>
	<hr/>
	<c:if test="${not empty board.displayFileName}">
		<a href="<c:url value="/board/download/${board.boardId}"/>">${board.displayFileName}</a>
	</c:if><br/>
	<span> ${board.writer}</span><span>${board.writeDate}</span><span>${board.likeCount}</span>
	<p>
		${board.content}
	</p>
	<a href="<c:url value="/board/delete/${board.boardId}" />"/>삭제</a>
	

</body>
</html>