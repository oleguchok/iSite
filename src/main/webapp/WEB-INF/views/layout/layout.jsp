<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<tiles:insertAttribute name="header" />
		
		<tiles:insertAttribute name="body" />
	
		<tiles:insertAttribute name="footer" />
	</div>	
	
	<script src="resources/js/jquery-1.11.3.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>