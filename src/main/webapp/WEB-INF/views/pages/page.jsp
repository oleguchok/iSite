<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>${projectName }</title>
</head>
<body>
<div class="container">
	<div class="row-fluid">
		${content }
	</div>
	<c:if test="${isUserPage == true }">
		<div class="col-md-3 col-xs-3 col-sm-3 sidebar-offcanvas" id="sidebar">
		    	<div class="list-group">
		            <span class="list-group-item active" id="header-center">
		            	<spring:message code="label.toolbar"></spring:message>
		            </span>
		            <div class="list-group-item">
			            <button class="btn btn-default"></button>
		            </div>	
		            <div class="list-group-item">
		            	<button class="btn btn-default"><spring:message code="label.addPage"></spring:message></button>
		            </div>	    		          
		      	</div>
		    </div>
	</c:if>
</div>
</body>
</html>