root = exports ? this
root.formSubmit = (form) ->
	document.getElementById(form).submit()
	return