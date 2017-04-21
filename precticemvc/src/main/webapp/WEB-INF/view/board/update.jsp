<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update Article</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function () {
		$("#updateForm").find("input[type=button]").click(function () {
			$("#updateForm").attr({
				"method":"post",
				"action":"<c:url value="/board/update/${board.boardId}"/>"
			});
			$("#updateForm").submit();
		});
	});
</script>
</head>
<body>

	<form id="updateForm">
		<input type="text" name="subject" value="${board.subject}" /><br/>
		<input type="text" name="writer" value="${board.writer}" /><br/>
		<textarea name="content" >${board.content}</textarea><br/>
		<input type="button" value="확인" />
	</form>

</body>
</html>