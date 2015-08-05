<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<spring:message code="label.nameOfProject" var="projectName"></spring:message>
	<spring:message code="label.style" var="style"></spring:message>
	<spring:message code="label.menu" var="menu"></spring:message>
	<title><spring:message code="label.addProject"></spring:message></title>
</head>
<body>
	<h1 id="header-center">
		<spring:message code="label.addProject"></spring:message>
	</h1>
	<div class="container" id="user-auth-template">
		<c:if test="${error != null}">
			<div class="alert alert-error">
		    	${error }
		    </div>
		</c:if>
		<form:form modelAttribute="project" id="projForm" class="form-registration" enctype="utf8" method='POST'>
	        <label for="projectName" >${projectName }</label>
	        <form:input type="text" id="projectName" path="projectName" name="projectName" class="form-control" placeholder="${projectName }"/>
	        <div id="error-text"></div>
	        <label for="style" >${style }</label><br/>
	        <form:radiobutton checked="checked" value="light" id="style" path="style" placeholder="${style }"/>Light
	        <form:radiobutton value="dark" id="style" path="style" placeholder="${style }"/>Dark<br/>
	        <label for="menu" >${menu }</label><br/>
	        <form:radiobutton checked="checked" value="horizontal" id="menu" path="menu" placeholder="${menu }"/>Horizontal
	        <form:radiobutton value="vertical" id="menu" path="menu" placeholder="${menu }"/>Vertical
	        <button class="btn btn-lg btn-primary btn-block" type="submit" value="submit">
        	<spring:message code="label.ok"></spring:message>
        </button>
        </form:form>
	</div>
</body>
</html>