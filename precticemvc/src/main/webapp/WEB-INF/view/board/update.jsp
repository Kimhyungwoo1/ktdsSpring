<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update Article</title>
</head>
<body>

	<form method="post" action="/precticemvc/board/update/${board.boardId}">
		<input type="text" name="subject" value="${board.subject}"/>
		<input type="text" name="writer" value="${board.writer}" />
	</form>

</body>
</html>