<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="messages" />
<%@ page session="true"%>
<html>
<head>
    <title><spring:message code="badUser.title"></spring:message></title>
</head>
<body>
    <h1>${message}</h1>
    <br>
    <a href="<c:url value="/registration" />">
        <spring:message code="label.navbar.signUp"></spring:message>
    </a>
</body>
</html>