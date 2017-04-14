<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 List</title>
</head>
<body>

	<table>
		<tr>
			<td>ID</td>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>좋아요</td>
			<td>작성일</td>
			<td>IP</td>
		</tr>
		
			<c:forEach items="${allArticles}" var="list">
			<tr>
				<td>${list.boardId}</td>
				<td><a href="<c:url value="/board/detail/${list.boardId}" />"/>${list.subject}</a></td>
				<td>${list.content}</td>
				<td>${list.writer}</td>
				<td>${list.likeCount}</td>
				<td>${list.writeDate}</td>
				<td>${list.ip}</td>
			</tr>
			</c:forEach>
	</table>
	<a href="<c:url value="/board/write"/>"/>글쓰기</a>

</body>
</html>