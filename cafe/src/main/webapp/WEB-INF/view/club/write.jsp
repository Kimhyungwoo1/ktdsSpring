<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script src="<c:url value="/static/js/ckeditor/ckeditor.js"/>"></script>
<script type="text/javascript">
	$().ready(function () {
		$("#saveBtn").click(function() {
			$("#writeForm").attr({
				"method":"post",
				"action":"<c:url value="/club/write/${menuId}"/>"
			});
			$("#writeForm").submit();
		});
	});
</script>
</head>
<body>
	<div>
		<form id="writeForm">
			<input type="text" name="subject" id="subject" />
			<textarea name="content" id="content" rows="10" cols="80">
				This is my textarea to be replaced with CKEditor.
			</textarea>
			<script>
				CKEDITOR.replace( 'content' );
			</script>
		</form>
	</div>
		<div id="uploadFiles"></div>
		<div>
		<form target="uploadFrame" method="post" action="<c:url value="/club/upload" />" 
				enctype="multipart/form-data">
			<input type="file" name="file" />
			<input type="submit" value="Upload" />
		</form>
		<iframe name="uploadFrame" style="display: none;"></iframe>
	</div>
	<input type="button" id="saveBtn" value="Save" />
	<input type="button" id="cancleBtn" value="Cencle" />
</body>
</html>