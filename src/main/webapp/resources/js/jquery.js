$(document).ready(function () {

    $('#projForm').validate({ 
        rules: {
            projectName: {
                required: true
            }
        },
        messages: {},
        errorElement : 'div',
        errorLabelContainer: '#error-text'
    });
});