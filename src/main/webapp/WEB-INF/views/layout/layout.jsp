<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/styles.css"/>
	<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
	<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-2.1.4.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-ui.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<tiles:insertAttribute name="header" />
		
		<tiles:insertAttribute name="body" />
	
		<tiles:insertAttribute name="footer" />
	</div>	
	
	
	
	<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.validate.min.js"></script>	
	<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.js"></script>
	<script type="text/javascript" src="https://cdn.rawgit.com/jashkenas/coffeescript/master/extras/coffee-script.js"></script>
</body>
</html>