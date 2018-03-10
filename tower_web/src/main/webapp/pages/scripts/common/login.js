$(function() {
	var Login = function() {
	};

	var submitUrl = $('#submitUrl').val();
	var redirectUrl = $('#redirectUrl').val();
	var $remoteValidTip = $('#remote-valid-tip');
	var $loginForm = $('#login-form');
	var $loginBtn = $('#login-btn');
	var codeUrl = $('#codeUrl').val();

	Login.prototype.submitForm = function() {
		var loginName = $.trim($("#loginName").val());
		var passwordShow = $.trim($("#passwordShow").val());
		var validateCode = $.trim($("#validateCode").val());
		if (loginName.length == 0) {
			$("#loginName").next().text("请输入用户名");
			$("#loginName").focus();
			return;
		}
		if (passwordShow.length == 0) {
			$("#passwordShow").next().text("请输入密码");
			$("#passwordShow").focus();
			return;
		}
		if (validateCode.length == 0) {
			$("#validateCode").next().text("请输入验证码");
			$("#validateCode").focus();
			return;
		}
		$("#password").val(md5($("#passwordShow").val()));
		$.ajax({
			url : submitUrl,
			type : 'POST',
			dataType : 'json',
			data : $loginForm.serialize(),
			async : false,
			beforeSend : function() {
				// $loginBtn.prop('disabled', true);
			}
		}).done(function(data) {
			if (data.success) {
				location.href = redirectUrl;
			} else {
				if (data.respCode == "0023") {
					$("#loginName").next().text("该用户名不存在");
				}else if (data.respCode == "0018") {
					$("#passwordShow").next().text("密码不正确");
					$("#passwordShow").val("");
				}else if (data.respCode == "0111") {
					$("#validateCode").next().text("验证码不正确");
					Login.prototype.getValidateCode();
					$("#validateCode").val("");
				} else {
					layer.msg("登录异常",{icon: 1});
				}
			}
		});
	};

	Login.prototype.submitFormByKey = function() {
		if (event.keyCode == "13") {
			if ($loginForm.valid()) {
				Login.prototype.formSubmit();
			} else {
				$loginForm.validate().focusInvalid();
				return false;
			}
		}
	};

	Login.prototype.getValidateCode = function() {
		$("#imageCode").attr("src", codeUrl + "?" + new Date().getTime());
	}

	$(document).on('click', '#submitBtn', Login.prototype.submitForm).on(
			'click', '#imageCode', Login.prototype.getValidateCode).on('keyup',
			'#validateCode', Login.prototype.submitFormByKey);
});