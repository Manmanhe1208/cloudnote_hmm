//��¼
$(function() {
	//����ť׷�ӵ���
	$("#login").click(function() {
		//���ԭ����ʾ��Ϣ
		$("#count_msg").html("");
		$("#password_msg").html("");
		//alert("---");
		//��ȡ��������
		var name = $("#count").val().trim();
		var password = $("#password").val().trim();
		//������ݸ�ʽ
		var ok = true;
		if (name == "") {
			$("#count_msg").html("�û�������Ϊ��");
			ok = false;
		}
		if (password == "") {
			$("#password_msg").html("���벻��Ϊ��");
			ok = false;
		}
		if (ok) {
			//����Ajax����
			//alert(name);
			//alert(password);
			$.ajax({
				url : "http://localhost:8080/cloudnote/user/login.do",
				type : "post",
				data : {
					"name" : name,
					"pwd" : password
				},
				dataType : "json",
				success : function(result) {
					//result�Ƿ��������ص�json���
					if (result.status == 0) {//�ɹ�
						//��ȡ�û�ID,д��Cookie
						var userId = result.data;
						addCookie("uid", userId, 2);//�洢2Сʱ
						window.location.href = "edit.html";
					} else if (result.status == 1) {//�û�����
						$("#count_msg").html(result.msg);
					} else if (result.status == 2) {//�����
						$("#password_msg").html(result.msg);
					}
				}
			});
		}
	});
});
