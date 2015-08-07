var id = 0;
var currentDropp = "";

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
			var droppedClass = "droppedField" + id++;
			draggable.addClass(droppedClass);
			draggable.appendTo(this);
			draggable.click(function () {
				
				
				if (draggable.hasClass("markdown")){
					
					editDroppedField(droppedClass);
				}
			});
    	}
    });
	
	$( ".droppedFields" ).sortable({
        cancel: null, 
        connectWith: ".droppedFields"
    }).disableSelection();
	
}

function makeDraggable() {
	$(".selectorField").draggable({ 
		helper: "clone",
		stack: "div",
		appendTo: "body",
		cursor: "move", 
		cancel: null  
	});
}



function deleteElem() {
	
	$("." + currentDropp).remove();
	$('#markdown-editor').hide();
}

function saveText() {
	
	var text = $('textarea#textarea-editor').val();	
	$('div.'+currentDropp).text(text);
	$('#markdown-editor').hide();
}


function editDroppedField(fieldId){
	
	$('#markdown-editor').toggle();
	currentDropp = fieldId;
	$('textarea#textarea-editor').val($('div.'+fieldId).text());
}
