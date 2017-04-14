<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>signUp page</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js" />"></script>
<script type="text/javascript">
	$().ready(function () {
		$("#signUp").find("input[type=button]").click(function () {
			$("#signUp").attr({
				"method":"post",
				"action":"<c:url value="/user/signUp" />"
			});
			$("#signUp").submit();
		});
	});
</script>
</head>
<body>
	
	<form id="signUp">
		<input type="text" name="userId" placeholder="아이디를 입력하세요." /><br/>
		<input type="text" name="userName" placeholder="이름을 입력하세요." /><br/>
		<input type="password" name="userPassword" placeholder="패스워드를 입력하세요." /><br/>
		<input type="button" value="확인"/>
	</form>
	
</body>
</html>