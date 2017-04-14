<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

	<h1>${board.subject}</h1>
	<hr/>
	<span> ${board.writer}</span><span>${board.writeDate}</span><span>${board.likeCount}</span>
	<p>
		${board.content}
	</p>
	<a href="<c:url value="/board/delete/${board.boardId}" />"/>삭제</a>
	<a href="<c:url value="/board/update/${board.boardId}" />"/>수정</a>
	<!-- <form method="post" action="/precticemvc/board/delete/${board.boardId}">
		<input type="hidden" name="boardId"/>
		<input type="submit" value="삭제" />
	</form> -->
	

</body>
</html>