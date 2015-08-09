var id = 0;
var currentDropp = "";

function docReady() {
	
	makeDraggable();
	
	makeDroppable();
	
	makeSortable();
	
	$('#slider').slider({
		min: 1,
		max: 4,
		change: function(event,ui){
			$('#slider-value').text($('#slider').slider("option", "value"));
		}
	});
	
}

function makeSortable() {
	
	$( ".droppedFields" ).sortable({
        cancel: null, 
        connectWith: ".droppedFields"
    }).disableSelection();
}

function makeDroppable() {
	
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
}


function addWell() {
	
	
	var count = $('#slider').slider("option", "value");
	if (count == 0)
		count = 1;
	var size = 12/count;
	for(var i = 0; i < count; i++){
		$('#workPlace').after($('<div></div>').addClass('well droppedFields col-md-' + size));
	}
	makeDroppable();
	makeSortable();
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
