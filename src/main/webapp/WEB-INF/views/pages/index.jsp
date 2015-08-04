<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<body>
	<c:if test="${not empty registerInformation}">
		<div class="alert alert-danger" role="alert">${registerInformation}</div>
	</c:if>

	<div class="jumbotron">
        <h1><spring:message code="label.projectName"></spring:message></h1>
        <p>
        	<spring:message code="label.aboutSite"></spring:message>
        </p>
        <p>
        	<sec:authorize access="isAuthenticated()">
	          <a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/projects" role="button">
	          	<spring:message code="label.start"></spring:message>
	          </a>
          	</sec:authorize>
          	<sec:authorize access="isAnonymous()">
          	  <a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/login" role="button">
	          	<spring:message code="label.start"></spring:message>
	          </a>	
          	</sec:authorize>
        </p>
      </div>
</body>
</html>