<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>${projectName }</title>
</head>
<body>
<div class="container">
	<c:if test="${isUserPage == true }">
		<div class="btn-group pull-right">
			<button class="btn btn-default"></button>
		    <button class="btn btn-default"><spring:message code="label.addPage"></spring:message></button>
		</div>
	</c:if>
	<div class="row-fluid">
		${content }
	</div>
</div>
</body>
</html>