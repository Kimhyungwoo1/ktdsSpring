<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>signUp</title>
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
	<h1>로그인</h1>
	<form:form commandName="signUp">
		<input type="text" name="userId" placeholder="아이디를 입력하세요" /><br/>
			<form:errors path="userId" ></form:errors><br/>
		<input type="text" name="userName" placeholder="이름을 입력하세요" /><br/>
			<form:errors path="userName" ></form:errors><br/>
		<input type="password" name="userPassword" placeholder="페스워드를 입력하세요" /><br/>
			<form:errors path="userPassword" ></form:errors><br/>
		<input type="button" value="가입" />
	</form:form>

</body>
</html>