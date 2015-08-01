<%@ page contentType="text/html;charset=windows-1251" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<header>
	<nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="./"><spring:message code="label.projectName"></spring:message></a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
             
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="./login"><spring:message code="label.navbar.signIn"></spring:message></a></li>
              <li><a href="./registration"><spring:message code="label.navbar.signUp"></spring:message></a></li>
            </ul>
          </div>
        </div>
      </nav>
</header>