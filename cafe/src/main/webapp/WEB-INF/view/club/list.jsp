<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/common.css"/>">
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>

</head>
<body>

	
	<jsp:include page="/WEB-INF/view/common/menu.jsp" />
	
	<div id="content">
		<h2>
			<c:forEach items="${currentMenu}" var="currentMenuItem" varStatus="index">
				${currentMenuItem.menuName}<c:if test="${ !index.last }"> > </c:if>
				<c:if test="${ index.last }"> <h1><br/> ${currentMenuItem.menuName}</h1></c:if>
			</c:forEach>
		</h2>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:if test="${empty clubList}" >
				<tr>
					<td colspan="5">등록된 게시글이 존재하지 않습니다.</td>
				</tr>
			</c:if>
			
			<c:forEach items="${clubList}" var="club">
				<tr>
					<td>${club.articleId}</td>
					<td>
						<a href="<c:url value="/club/read/${menuId}/${club.articleId}"/> ">${club.subject}</a>
						(${club.repliesCount})
					</td>
					<td>${club.memberVO.nickName}</td>
					<td>${club.createData}</td>
					<td>${club.readCount}</td>
				</tr>
			</c:forEach>
		</table>
			<form id="searchForm">
				${pager}<br/>
				<input type="text" name="subjectKeyword" value="${sessionScope._SEARCH_.subjectKeyword}" />
				<input type="button" value="Search" onclick="movePage(0)" />
				<input type="button" value="검색 초기화" onclick="location.href='<c:url value="/club/${menuId}/init"/> ';" />
			</form>
			<a href="<c:url value="/club/write/${menuId}"/>">글쓰기</a>
	</div>

</body>
</html>