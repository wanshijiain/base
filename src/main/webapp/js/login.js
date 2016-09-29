$(function() {
	$("body").keydown(function(event) {
		if(event.keyCode == "13") { //keyCode=13是回车键
			$('#formSubmit').click();
		}
	});
})

function login() {
	$form = $("form");
	$form.submit(false);
	$account = $("#inputAccount");
	$password = $("#inputPassword");
	var formClass = "has-error has-feedback";
	var errSpan = "<span class='glyphicon glyphicon-remove form-control-feedback'></span>";
	if($account.val() == null || $account.val() == '') {
		if(!$account.parent().parent().hasClass(formClass)) {
			$account.parent().parent().addClass(formClass);
		}
		if(!$("#inputAccount+span").length > 0) {
			$account.after(errSpan);
		}

		$account.focus();
		return false;
	}
	$account.parent().parent().removeClass(formClass);
	$("#inputAccount + span").remove();
	if($password.val() == null || $password.val() == '') {
		if(!$password.parent().parent().hasClass(formClass)) {
			$password.parent().parent().addClass(formClass);
		}
		if(!$("#inputPassword+span").length > 0) {
			$password.after(errSpan);
		}
		$password.focus();
		return false;
	}
	$password.parent().parent().removeClass(formClass);
	$("#inputPassword + span").remove();
	var url = $form.attr("action");

	$.post(url, $form.serialize(), function(data) {
		alert(data)
	}, 'json')
}