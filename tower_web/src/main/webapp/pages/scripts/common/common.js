$(function() {
	var AccMenu = function() {
	};

	var loginAcctUrl = $('#login-acct').val();
	var logoutUrl = $('#logout-url').val();
	

    AccMenu.prototype.getAcct = function () {
        $.ajax({
            url: loginAcctUrl,
            type: 'POST',
            dataType: 'json',
            async: false
        }).done(function (data) {
            $('#acc-name').html(data.data.name);
        })
    };
    
    AccMenu.prototype.getAcct();
    
    AccMenu.prototype.logout = function () {
    	window.location=logoutUrl;
    };
    
    $(document)
    .on('click', '#logout', AccMenu.prototype.logout);

});