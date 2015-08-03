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
          <a class="btn btn-lg btn-primary" href="" role="button">
          	<spring:message code="label.start"></spring:message>
          </a>
        </p>
      </div>
</body>
</html>