<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>signUp</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/signUp.css"/>">
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function () {
		$("#signUpForm").find("input[type=button]").click(function () {
			$.post("<c:url value="/user/signup" />", $("#signUpForm").serialize(), function(data) {
				if(data == "OK") {
					alert("회원가입이 완료되었습니다.!");
					window.location.href = "<c:url value="/club/qsdqe"/>";
				}
				else if(data =="FAIL") {
					alert("비밀번호는 영소문자, 영대문자, 숫자, 특수문자로 이루어진 8글자 이상으로 입력해주세요.");
				}
			});
		}); 
		
	});
</script>
</head>
<body>
		
	<h1 style="text-align: center; margin-top: 290px;">회원 가입</h1>
	<form id="signUpForm" >
		<div id="signUp">
			<input type="text" name="memberId" placeholder="아이디를 입력하세요." /><br/>
			<input type="password" name="memberPassword" placeholder="페스워드를 입력하세요." /><br/>
			<input type="text" name="nickName" placeholder="닉네임을 입력하세요."/><br/>
			<input type="button" id="signUpButton" value="Submit"/>
		</div>
	</form>

</body>
</html>