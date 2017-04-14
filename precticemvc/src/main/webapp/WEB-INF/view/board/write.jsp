<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>write page</title>
<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function () {
		$("#writeForm").find("input[type=button]").click(function() {
			$("#writeForm")attr({
				"method":"post",
				"action":"<c:url valeu="/board/write" />"
			});
			$("#writeForm").submit();
		});
	});
</script>
</head>
<body>

	<form id="writeForm">
		<input type="text" name="writer" placeholder="작성자를 입력하세요." /><br/>
		<input type="text" name="subject" placeholder="제목을 입력하세요." /><br/>
		<textarea name="content" placeholder="내용을 입력하세요."></textarea><br/>
		<input type="button" value="확인" />
	</form>

</body>
</html>