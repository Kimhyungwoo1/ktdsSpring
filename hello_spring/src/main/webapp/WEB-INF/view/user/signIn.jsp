<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login page</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js" />"></script>
<script type="text/javascript">
	$().ready(function () {
		$("#signIn").find("input[type=button]").click(function () {
			$("#signIn").attr({
				"method":"post",
				"action":"<c:url value="/user/signIn" />"
			});
			$("#signIn").submit();
		});
	});
</script>
</head>
<body>

	<form id="signIn">
		<input type="text" name="userId" placeholder="아이디를 입력하세요."/>
		<input type="password" name="userPassword" placeholder="비밀번호를 입력하세요."/>
		<input type="button" value="signIn" />
	</form>
	
</body>
</html>