<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
	<spring:message code="label.signInForm.password" var="password"></spring:message>
	<spring:message code="label.signInForm.username" var="username"></spring:message>
	<spring:message code="label.input.matchingPassword" var="matchingPassword"></spring:message>
	<title><spring:message code="label.form.registration.title"></spring:message></title>
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/styles.css"/>
</head>
<body>
	<h1 id="header-center">
		<spring:message code="label.form.registration.title"></spring:message>
	</h1>
	<div class="container" id="user-auth-template">
      <form:form modelAttribute="user" class="form-registration" enctype="utf8" method='POST'>
        <label for="username" >${username }</label>
        <form:input type="text" id="username" path="username" class="form-control" placeholder="${username }"/>
        <form:errors path="username" element="div" id="error-text"/>
        <label for="email" >Email</label>
        <form:input type="text" id="email" path="email" class="form-control" placeholder="Email"/>
        <form:errors path="email" element="div" id="error-text"/>
        <label for="password">${password }</label>
        <form:input type="password" id="password" path="password" class="form-control" placeholder="${password}"/>
        <form:errors path="password" element="div" id="error-text"/>
        <label for="matchingPassword" >${matchingPassword}</label>
        <form:input type="password" id="matchingPassword" path="matchingPassword" class="form-control"
        	 placeholder="${matchingPassword}"/>
       	<form:errors element="div" id="error-text" />
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="submit">
        	<spring:message code="label.navbar.signUp"></spring:message>
        </button>        
      </form:form>
      <a href="<c:url value="login.html" />">
	  	<spring:message code="label.form.loginLink"></spring:message>
	  </a>
    </div>	
</body>
</html>