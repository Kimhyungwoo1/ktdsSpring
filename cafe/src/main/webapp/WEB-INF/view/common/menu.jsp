<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 
<ul>
	<li>Menu 1</li>
		<ul>
			<li>Menu 1-1</li>
			<li>Menu 1-2</li>
			<li>Menu 1-3</li>
		</ul>
	<li>Menu 2</li>
	<li>
		<ul>
			<li>Menu 2-1</li>
			<li>Menu 2-2</li>
			<li>Menu 2-3</li>
		</ul>
	</li>
</ul>
-->

<style type="text/css">

	li > a:LINK {
		color: #333;
		text-decoration: none;
	}
	
	li > a:VISITED {
		color: #333;
		text-decoration: none;
	}
	
	li > a:HOVER {
		color: #111;
		text-decoration: underline;
	}
	
	li > a:ACTIVE {
		color:#FF0000;
		text-decoration: underline;
	}

	body > ul {
		padding: 0;
	}
	ul {
		list-style: none;
	}
	
	ul > li {
		padding-top: 3px;
		paddion-bottom: 3px;
	}
	
	/*li:HOVER {
		backgound-color: blue;
		color: white;
	}*/

</style>
<c:set var="depth" value="0"/>
<ul>
	<c:forEach items="${menu}" var="menuItem">
		<c:if test="${menuItem.level < prevLevel }">
			<c:set var="depth" value="${depth - 1 }" />
			</ul>
		</c:if>
		<c:if test="${menuItem.level > prevLevel}">
			<c:set var="depth" value="${depth + 1 }" />
			<ul>
		</c:if>
			<li><a href="<c:url value="${menuItem.menuUrl}"/>">${menuItem.menuName}</a></li>

		<c:set var="prevLevel" value="${menuItem.level}" /> <!--현재 level 변수 지정  -->
	
	</c:forEach>
</ul>