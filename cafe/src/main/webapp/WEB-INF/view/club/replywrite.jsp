<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function () {
		$("#replyForm").find("input[type=button]").click(function () {
			$("#replyForm").attr({
				"method":"post",
				"action":"<c:url value="/club/replyWrite/${menuId}/${articleId}"/>"
			});
			
			$("#replyForm").submit();
		});
	});
</script> 
</head>
<body>

	<form id="replyForm">
		<input type="text" name="content" placeholder="댓글을 입력하세요." />
		<input type="button" value="submit" />
	</form> 

</body>
</html>