//ע��
$(function() {
	$("#regist_button").click(function() {
		//���ԭ����ʾ��Ϣ
		$("#warning_1 span").html("");
		$("#warning_2 span").html("");
		$("#warning_3 span").html("");
		//alert("----");
		//��ȡ����Ϣ
		var name = $("#regist_username").val().trim();
		var nick = $("#nickname").val().trim();
		var password = $("#regist_password").val().trim()
		var final_password = $("#final_password").val().trim();
		var ok = true;
		//������Ϣ��ʽ(�ǿպ�����λ�����)
		if (name == "") {
			$("#warning_1 span").html("�û�������Ϊ��");
			$("#warning_1").show();//��ʾ����
			ok = false;
		}
		if (password == "") {
			$("#warning_2 span").html("���벻��Ϊ��");
			$("#warning_2").show();
			ok = false;
		} else if (password.length > 0 && password.length < 6) {
			$("#warning_2 span").html("���벻��С��6λ");
			$("#warning_2").show();
			ok = false;
		}
		//�������
		//1.�ǿ� 2.�Ƿ�������һ��
		if (final_password == "") {
			$("#warning_3 span").html("ȷ�����벻��Ϊ��");
			$("#warning_3").show();
			ok = false;
		} else if (final_password != password) {
			$("#warning_3 span").html("�������벻һ��");
			$("#warning_3").show();
			ok = false;
		}
		if (ok) {
			//����Ajax����
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
						$("#back").click();//�������ذ�ť�ĵ���
					} else if (result.status == 1) {//�û�����ռ��
						$("#warning_1 span").html(result.msg);
						//��ʾ��ʾ��Ϣ
						$("#warning_1").show();//��ʾdiv��Ϣ��
					}
				},
				error : function() {
					alert("ע�ᷢ���쳣");
				}
			});

		}
	});
});