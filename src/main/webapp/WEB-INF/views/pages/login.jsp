<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page session="true"%>
<html>
<head>
	<spring:message code="label.signInForm.password" var="password"></spring:message>
	<spring:message code="label.signInForm.username" var="username"></spring:message>
	<title><spring:message code="title.login"></spring:message></title>
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/styles.css"/>
</head>
<body>		
	<div class="container" id="user-auth-template">
		<c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
      <form class="form-signin" action="<c:url value='/login'/>" method='POST'>
        <h2 class="form-signin-heading"><spring:message code="label.signInForm.title"></spring:message></h2>
        <label for="username" class="sr-only">${username }</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="${username }">
        <label for="password" class="sr-only">${password }</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="${password}">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> <spring:message code="label.signInForm.remember"></spring:message>
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="submit">
        	<spring:message code="label.navbar.signIn"></spring:message>
        </button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      </form>
    </div>
</body>
</html>