<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css" />
	<title>${projectName }</title>
	<script src="https://cdn.rawgit.com/showdownjs/showdown/1.2.2/dist/showdown.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/page.js"></script>
</head>
<body>
<script>
function preview() {	
	
	var win = window.open("about:blank");
	win.document.write(getHtmlCode());
}

function getHtmlCode() {
	
	var selected_content = $("#selected-content").clone();
	selected_content.find("div").each(function(i,o) {
	
		var obj = $(o)
		obj.removeClass("draggableField ui-draggable well ui-droppable ui-sortable");					
	});
	
	selected_content.find('.markdown').each(function(i,o){
		
		var converter = new showdown.Converter();
		var text = $(o).text();
		html = converter.makeHtml(text);
		$(o).html(unescape(html));
	});
	
	var selected_content_html = selected_content.html();
	
	var dialogContent  ='<!DOCTYPE HTML>\n<html lang="en-US">\n<head>\n<meta charset="UTF-8">\n<title></title>\n';
	dialogContent+= '<link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" media="screen">\n';
	dialogContent+='<style>\n'+$("#content-styles").html()+'\n</style>\n';
	dialogContent+= '</head>\n<body>';
	dialogContent+= selected_content_html;
	dialogContent+= '\n</body></html>';
	
	return dialogContent;
}

function passText() {
	
	$("#html").val(getHtmlCode());
}
</script>
	<div class="container">
		<div class="row-fluid">
			<div class="col-md-3 col-xs-3 col-sm-3 sidebar-offcanvas" id="sidebar">
		    	<div class="list-group">
		            <span class="list-group-item active" id="header-center">
		            	<spring:message code="label.toolbar"></spring:message>
		            </span>
		            <div class="list-group-item">
			            <div id="draggablePanel" class="well well-mini selectorField draggableField markdown"><spring:message code="label.markdown"></spring:message>
			            </div>
		            </div>	
		            <div class="list-group-item">
		            	<button class="btn btn-default" onclick="preview();"><spring:message code="label.preview"></spring:message></button>
		            </div>	
		            <div class="list-group-item">
		            	<form:form action="/isite/projects/edit/${projectName }/${pageNumber }" method="post">
		            		<input type="hidden" name="html" id="html" />
		            		<button class="btn btn-default" type="submit" onclick="passText();"><spring:message code="label.addPage"></spring:message></button>
		            	</form:form>    		 
		            </div>  
		            <div class="list-group-item">		            	
		            	<div id="slider"></div>
		            	<button class="btn btn-default" onclick="addWell();"><spring:message code="label.addLine"></spring:message></button>
		            	<span id="slider-value">1</span>
		            </div>       
		      	</div>
		    </div>
            <div class="col-md-9 col-xs-9 col-sm-9" id="selected-content">
            	<div class="text-center">
                	<h3>${projectName }</h3>
                </div>                
                <div class="row-fluid" id="workPlace">
                	<div class="well droppedFields col-md-12">
                	
                	</div>
                	<div class="well droppedFields col-md-6">
                	
                	</div>
                	<div class="well droppedFields col-md-6">
                	
                	</div>                	
                </div>                      
            </div>
            <div class="col-md-6 pull-right" id="markdown-editor"> 
	    		<textarea class="form-control" rows="5" id="textarea-editor"></textarea>
	    		<div class="panel panel-footer clearfix">
	    			<div class="btn-group pull-right">
		    			<button class="btn btn-danger" value="Delete" onclick="deleteElem();">Delete</button>
		    			<button class="btn btn-default" value="Save" onclick="saveText();">Save</button>
	    			</div>	    				
	    		</div>	  
	  		</div>                      
    	</div>  	
	</div>	

<script>
	$(document).ready(docReady);
	$('#markdown-editor').hide();
</script>
</body>
</html>