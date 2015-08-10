<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>${projectName }</title>
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/${style }" />
</head>
<body>
<div class="container">
	<c:if test="${isUserPage == true }">
		<div class="btn-group pull-right">
			<button class="btn btn-danger"><spring:message code="label.delete"></spring:message></button>
			<a href="${pageContext.request.contextPath}/projects/add/${projectName}">
				<button class="btn btn-default"><spring:message code="label.addPage"></spring:message></button>
			</a>
			<a href="${pageContext.request.contextPath}/projects/${projectName}/${pageNumber - 1}">
				<button class="btn btn-default">&lt;&lt;</button>
			</a>
			<a href="${pageContext.request.contextPath}/projects/${projectName}/${pageNumber + 1}">
				<button class="btn btn-default">>></button>
			</a>
		</div>
	</c:if>
	<c:choose>
		<c:when test="${project.menu == 'horizontal' }">
		<div class="masthead">
	        <h3 class="text-muted">${projectName}</h3>
	        <nav>
	          <ul class="nav nav-justified">
	          <c:forEach items="${pages }" var="page">
	            <li><a href="${pageContext.request.contextPath}/projects/${projectName}/${page.number}">${page.menu }</a></li>
	           </c:forEach>
	          </ul>
	        </nav>
	      </div>
	      <div class="row-fluid">
			${content }
		  </div>
	    </c:when>
	    <c:otherwise>
	    <h3 class="text-muted">${projectName}</h3>
	    	<div class="row-fluid">
	    		<div class="col-md-2" id="sidebar">
			          <div class="list-group">
			          	<c:forEach items="${pages }" var="page">
			            	<a href="${pageContext.request.contextPath}/projects/${projectName}/${page.number}" class="list-group-item">${page.menu }</a>
			            </c:forEach>
			          </div>
			    </div>
				<div class="col-md-10">
					${content }
				</div>
			</div>
	    </c:otherwise>
	</c:choose>
</div>
</body>
</html>