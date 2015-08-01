<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<body>
	<h1><spring:message code="permission.header"></spring:message></h1>

	<c:choose>
		<c:when test="${empty username}">
			<h2><spring:message code="permission.message"></spring:message></h2>
		</c:when>
		<c:otherwise>
			<h2><spring:message code="label.user.username"></spring:message>: ${username} <br/>
			<spring:message code="permission.reason"></spring:message></h2>
		</c:otherwise>
	</c:choose>

</body>
</html>