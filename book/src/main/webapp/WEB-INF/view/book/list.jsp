<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

<!-- 부트스트랩 -->
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">


<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

<title>Insert title here</title>
<script type="text/javascript"
	src="<c:url value="/static/js/jquery-3.1.1.min.js" /> "></script>
<script type="text/javascript"
	src="<c:url value="/static/js/bootstrap.min.js"/> "></script>
<script type="text/javascript">
	$().ready(function() {
		
	});
</script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
			<a class="navbar-brand" href="#">Book Store</a>
			<ul class="nav navbar-nav">
				<li><a href="<c:url value="/pub/write"/> ">출판사 등록</a></li>
				<li><a href="<c:url value="/author/write"/> ">저자등록</a></li>
				<li class="active"><a href="<c:url value="/book/write"/> ">도서 등록</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<table class="table table-striped">
			<colgroup>
				<col width="20%">
				<col width="*">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>출판사</th>
					<th>저자(공동저자)</th>
					<th>ISBN</th>
					<th>가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookListVO.bookList}" var="book">
					<tr>
						<td>${book.bookId}</td>
						<td>
							${book.bookName}<br/>${book.bookSubName}
						</td>
						<td>${book.publisherVO.publisherName }
						<td>
							<c:forEach items="${book.authorList}" var="auth">
								${auth.authorName}
							</c:forEach>
						</td>
						<td>${book.isbn}</td>
						<td>${book.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form id="searchForm">
			<nav>${pager.getPagingListBoot("pageNO", "@", "&laquo;", "&raquo;", "searchForm")}
			</nav>
		</form>

		<div class="modal fade" id="introModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">Modal title</h4>
					</div>
					<div class="modal-body">
						<p>One fine body&hellip;</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>