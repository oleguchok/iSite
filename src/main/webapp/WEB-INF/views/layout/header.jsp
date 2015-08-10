<%@ page contentType="text/html;charset=windows-1251" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<script type="text/coffeescript" src="${pageContext.servletContext.contextPath}/resources/coffee/scripts.coffee"></script>
	<nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/"><spring:message code="label.projectName"></spring:message></a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
            	<li>
            		<sec:authorize access="isAuthenticated()">
            			<a href="${pageContext.request.contextPath}/projects"><spring:message code="label.myProjects"></spring:message></a>
            		</sec:authorize>
            	</li> 
            	<li>
            		<sec:authorize access="hasRole('ROLE_ADMIN')">
            			<a href="${pageContext.request.contextPath}/admin">admin</a>
            		</sec:authorize>
            	</li>
            </ul>
            <c:url value="/logout" var="logoutUrl" />
            <ul class="nav navbar-nav navbar-right">
              <li>
              	<sec:authorize access="isAnonymous()">
              		<a href="${pageContext.request.contextPath}/login"><spring:message code="label.navbar.signIn"></spring:message></a>
              	</sec:authorize>
              </li>
              <li>
              	<sec:authorize access="isAnonymous()">
              	<a href="${pageContext.request.contextPath}/registration"><spring:message code="label.navbar.signUp"></spring:message></a>
              	</sec:authorize>
              </li>
              <li>
              	<sec:authorize access="isAuthenticated()">              							
              		<a onclick="formSubmit('logoutForm');" id="link"><spring:message code="label.logout"></spring:message></a>
              	</sec:authorize>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	  </form>	
</header>