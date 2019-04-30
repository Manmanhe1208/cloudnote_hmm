//注册
$(function() {
	$("#regist_button").click(function() {
		//清除原有提示信息
		$("#warning_1 span").html("");
		$("#warning_2 span").html("");
		$("#warning_3 span").html("");
		//alert("----");
		//获取表单信息
		var name = $("#regist_username").val().trim();
		var nick = $("#nickname").val().trim();
		var password = $("#regist_password").val().trim()
		var final_password = $("#final_password").val().trim();
		var ok = true;
		//检测表单信息格式(非空和密码位数检测)
		if (name == "") {
			$("#warning_1 span").html("用户名不能为空");
			$("#warning_1").show();//显示出来
			ok = false;
		}
		if (password == "") {
			$("#warning_2 span").html("密码不能为空");
			$("#warning_2").show();
			ok = false;
		} else if (password.length > 0 && password.length < 6) {
			$("#warning_2 span").html("密码不能小于6位");
			$("#warning_2").show();
			ok = false;
		}
		//检测密码
		//1.非空 2.是否与密码一致
		if (final_password == "") {
			$("#warning_3 span").html("确认密码不能为空");
			$("#warning_3").show();
			ok = false;
		} else if (final_password != password) {
			$("#warning_3 span").html("输入密码不一致");
			$("#warning_3").show();
			ok = false;
		}
		if (ok) {
			//发送Ajax请求
			$.ajax({
				url : "http://localhost:8080/cloudnote/user/regist.do",
				type : "post",
				data : {
					"name" : name,
					"password" : password,
					"nickname" : nick
				},
				dataType : "json",
				success : function(result) {
					if (result.status == 0) {
						alert(result.msg)
						$("#back").click();//触发返回按钮的单击
					} else if (result.status == 1) {//用户名被占用
						$("#warning_1 span").html(result.msg);
						//显示提示信息
						$("#warning_1").show();//显示div消息区
					}
				},
				error : function() {
					alert("注册发生异常");
				}
			});

		}
	});
});