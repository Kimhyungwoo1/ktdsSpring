<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

<!-- 부트스트랩 -->
<link href="<c:url value="/static/css/bootstrap.min.css" />" rel="stylesheet">


<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js" /> "></script>
<script type="text/javascript" src="<c:url value="/static/js/bootstrap.min.js"/> "></script>
<script type="text/javascript">
	$().ready(function() {
		$("#writeForm").find("button").click(function () {
			$("#writeForm").attr({
				method:"post",
				action:"<c:url value="/book/write"/>"
			});
			$("#writeForm").submit();
		});
	});
</script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
			<a class="navbar-brand" href="#">Book Store</a>
			<ul class="nav navbar-nav">
				<li> <a href="<c:url value="/pub/write"/> ">출판사 등록</a></li>
				<li> <a href="<c:url value="/author/write"/> ">저자 등록</a></li>
				<li class="active"> <a href="<c:url value="/book/write"/> ">도서 등록</a></li>
			</ul>
		</div>
	</nav>
	
	<div class="container">
	
		<div class="row">
			<div class="col-md-8">
				<form id="writeForm">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
							<label for="bookName">책 제목</label>
							<input type="text" id="bookName" name="bookName"
								placeholder="책 제목을 입력하세요." class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
							<label for="bookSubName">책 부제</label>
							<input type="text" id="bookSubName" name="bookSubName"
								placeholder="책 부제를 입력하세요." class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
							<label for="publisherId">출판사</label>
								<select name="publisherId" id="publisherId" class="form-control">
								 	<option value="">출판사를 선택하세요.</option>
									<c:forEach items="${bookVO.publisherList}" var="pub">
										 <option value="${pub.publisherId}">${pub.publisherName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
							<label for="authorId">저자</label>
								<select name="authorId" id="authorId"
								class="form-control" multiple="multiple">
									<option value="">저자를 선택하세요.</option>
									<c:forEach items="${bookVO.authorList}" var="author">
										 <option value="${author.authorId}">${author.authorName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
							<label for="releaseDate">출판일</label>
								<input type="date" name="releaseDate" id="releaseDate" class="form-control" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
							<label for="price">가격</label>
								<input type="number" name="price" id="price"
									class="form-control" placeholder="가격을 입력하세요."/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
							<label for="isbn"></label>
								<input type="text" name="isbn" id="isbn" class="form-control" placeholder="isbn을 입력하세요." />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
							<label for="bookIntro"></label>
								<textarea name="bookIntro" id="bookIntro" class="form-control" 
								placeholder="소개글을 입력하세요." ></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
							<label for="index"></label>
								<textarea name="index" id="index" class="form-control" 
								placeholder="목차를 입력하세요." ></textarea>
							</div>
						</div>
					</div>
					<button type="button" class="btn btn-primary">등록</button>
				</form>
				
			</div>
			
			<div class="col-md-4 col-sx-12 col-sm-12">
				<div>로그인폼</div>
			</div>
		</div>
	</div>

</body>
</html>