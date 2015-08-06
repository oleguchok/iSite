<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css" />
<title>${projectName }</title>
</head>
<body>
<script>
function makeDraggable() {
	$(".selectorField").draggable({ 
		helper: "clone",
		stack: "div",
		appendTo: "body",
		cursor: "move", 
		cancel: null  
	});
}

function docReady() {
	
	makeDraggable();
	
	$(".droppedFields").droppable({
    	activeClass: "activeDroppable",
    	hoverClass: "hoverDroppable",
    	accept: ":not(.ui-sortable-helper)",
    	drop: function( event, ui ) {
			var draggable = ui.draggable;				
			draggable = draggable.clone();
			draggable.removeClass("selectorField");
			draggable.addClass("droppedField");
			draggable.appendTo(this);
    	}
    });
	
	$( ".droppedFields" ).sortable({
        cancel: null, 
        connectWith: ".droppedFields"
    }).disableSelection();
	
	
}

function preview() {
	console.log('Preview clicked');
	
	
	var selected_content = $("#selected-content").clone();
	selected_content.find("div").each(function(i,o) {
							var obj = $(o)
							obj.removeClass("draggableField ui-draggable well ui-droppable ui-sortable");
						});
	
	selected_content.find("#form-title-div").remove();
	
	var selected_content_html = selected_content.html();
	
	var dialogContent  ='<!DOCTYPE HTML>\n<html lang="en-US">\n<head>\n<meta charset="UTF-8">\n<title></title>\n';
	dialogContent+= '<link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" media="screen">\n';
	dialogContent+='<style>\n'+$("#content-styles").html()+'\n</style>\n';
	dialogContent+= '</head>\n<body>';
	dialogContent+= selected_content_html;
	dialogContent+= '\n</body></html>';
	
	
	var win = window.open("about:blank");
	win.document.write(dialogContent);
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
			            <div id="draggablePanel" class="well well-mini selectorField draggableField">			            	
			            	<spring:message code="label.markdown"></spring:message>
			            </div>
		            </div>		       
		      	</div>
		    </div>	
            <div class="col-md-9 col-xs-9 col-sm-9" id="selected-content">
            	<div class="text-center">
                	<h3>${projectName }</h3>
                </div>                
                <div class="row-fluid">
                	<div class="well droppedFields col-md-6">
                	
                	</div>
                	<div class="well droppedFields col-md-6">
                	
                	</div>
                </div>                       
             </div>
    	</div>
	</div>
	<button onclick="preview();"></button>
<script>
	$(document).ready(docReady);
</script>
</body>
</html>