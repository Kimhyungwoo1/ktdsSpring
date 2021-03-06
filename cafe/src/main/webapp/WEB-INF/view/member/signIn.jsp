<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>signIn</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function () {
		$("#signInForm").find("input[type=button]").click(function () {
			$.post("<c:url value="/user/signin" />", $("#signInForm").serialize(), function(data) {
				if ( data == "OK" ) {
					window.location.href = "<c:url value="/club/qwdqw"/>";
				}
				else if (data == "FAIL") {
					alert("로그인 실패");
					location.reload();
				}
			});
		});
	});
</script>
</head>
<body>

	<form id="signInForm">
		<input type="text" name="memberId" placeholder="아이디를 입력하세요."/><br/>
		<input type="password" name="memberPassword" placeholder="페스워드를 입력하세요." /><br/>
		<input type="button" value="Submit" />
	</form>
	

</body>
</html>