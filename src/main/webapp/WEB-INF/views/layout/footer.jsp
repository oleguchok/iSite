<%@ page contentType="text/html;charset=windows-1251" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<hr>
<footer>
	<p>
		© Itransition 2015.
		<spring:message code="label.footerMessage"></spring:message>
		<span id="languages-flags">
			<a href="?lang=en"><img src="${pageContext.servletContext.contextPath}/resources/img/us.gif" /></a>
			<a href="?lang=ru"><img src="${pageContext.servletContext.contextPath}/resources/img/ru.jpg" /></a>
		</span>
	</p>
</footer>

