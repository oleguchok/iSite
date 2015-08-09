<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>${projectName }</title>
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/${style }" />
</head>
<body>
<div class="container">
	<c:if test="${isUserPage == true }">
		<div class="btn-group pull-right">
			<button class="btn btn-danger"><spring:message code="label.delete"></spring:message></button>
			<a href="${pageContext.request.contextPath}/projects/add/${projectName}">
				<button class="btn btn-default"><spring:message code="label.addPage"></spring:message></button>
			</a>
			<a href="${pageContext.request.contextPath}/projects/${projectName}/${pageNumber - 1}">
				<button class="btn btn-default">&lt;&lt;</button>
			</a>
			<a href="${pageContext.request.contextPath}/projects/${projectName}/${pageNumber + 1}">
				<button class="btn btn-default">>></button>
			</a>
		</div>
	</c:if>
	<div class="masthead">
        <h3 class="text-muted">${projectName}</h3>
        <nav>
          <ul class="nav nav-justified">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Projects</a></li>
            <li><a href="#">Services</a></li>
            <li><a href="#">Downloads</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
          </ul>
        </nav>
      </div>
	<div class="row-fluid">
		${content }
	</div>
</div>
</body>
</html>