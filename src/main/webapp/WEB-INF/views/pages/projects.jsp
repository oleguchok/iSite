<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="label.myProjects"></spring:message></title>
</head>
<body>
<script>
function deleteProj(projectName) {
	
	$.ajax({
		type: "get",
        url:  '/isite/projects/' + projectName + '/delete',
		success: function(){
			location.reload();
		}
	});;
}
</script>
	<div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          <h1 id="header-center"><spring:message code="label.myProjects"></spring:message></h1>
           
          <div class="row">
          <c:forEach items="${projects }" var="project">
            <div class="col-xs-6 col-lg-4" id="${project.projectName }">
              <h2>${project.projectName }<button class="btn btn-danger pull-right" onclick="deleteProj('${project.projectName}');">
              	<span class="glyphicon glyphicon-trash"></span>
              </button></h2>
              <p><spring:message code="label.style"></spring:message>: ${project.style }</p>
              <p><spring:message code="label.menu"></spring:message>: ${project.menu }</p>
              <p><a class="btn btn-default"
              	href="${pageContext.request.contextPath}/projects/${project.projectName }/1" role="button">
              	<spring:message code="label.viewProj"></spring:message> »
              </a></p>
            </div>
           </c:forEach>
          </div>
        </div>

        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
          <div class="list-group">
            <a href="${pageContext.request.contextPath}/projects" class="list-group-item active"><spring:message code="label.myProjects"></spring:message></a>
            <a href="${pageContext.request.contextPath}/projects/add" class="list-group-item">
            	<span class="glyphicon glyphicon-plus">
            		<spring:message code="label.addProject"></spring:message>
            	</span>
            </a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
          </div>
        </div>
      </div>
</body>
</html>