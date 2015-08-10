<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title><spring:message code="label.setMenu"></spring:message></title>
</head>
<body>
	<h1 class="text-center"><spring:message code="label.setMenu"></spring:message></h1>
	<div class="container" id="user-auth-template">
		<form:form mehtod="post" action="${projectName }/menu" modelAttribute="menus">
			<c:forEach items="${pages }" var="page">
				<label for="${page.menu }" >${page.menu }</label>
	        	<form:input type="text" id="${page.menu }" path="${page.menu }" class="form-control" placeholder="${page.menu }"/>
			</c:forEach>
			<button class="btn btn-lg btn-primary btn-block" type="submit" value="submit">
	        	<spring:message code="label.ok"></spring:message>
	        </button>
		</form:form>
	</div>
</body>
</html>