<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="messages" />
<%@ page session="true"%>
<c:if test="${param.token != null}">
<spring:message code="token.message"><c:out value="${param.token}"></c:out></spring:message>
</c:if>
<html>
<head>
<title><spring:message code="label.navbar.home"></spring:message></title>
</head>
<body>
<div>
	<h1 class="alert alert-info"><spring:message code="message.regSucc"></spring:message></h1>
    <a class="btn btn-primary" href="<c:url value="login.html" />"><spring:message code="title.login"></spring:message></a>
</div>          
</body>
</html>