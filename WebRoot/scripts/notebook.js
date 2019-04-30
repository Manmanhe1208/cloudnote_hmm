function loadNoteBooks(){
	$.ajax({
		url:"http://localhost:8080/cloudnote/notebook/loadbooks.do",
		type:"post",
		data:{"userId":userId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var books = result.data;// 笔记本json集合
				// 循环集合生成笔记本li列表
				for(var i=0;i<books.length;i++){
					// 获取每个笔记本元素的笔记本名称
					var bookName = books[i].cn_notebook_name;
					// 获取每个笔记本元素的笔记本ID
					var bookId = books[i].cn_notebook_id;
					// 拼成li元素
					var s_li = '<li class="online"><a>';
		            s_li += '<i class="fa fa-book" title="online" rel="tooltip-bottom">';
		            s_li +='</i> '+bookName+'</a></li>';
	                // 将s_li字符串转成jQuery对象，藏bookId
	                var $li = $(s_li);
	                $li.data("bookId",bookId);
		            // 将li添加到笔记本ul中
		            $("#book_list").append($li);
				}
				
			}
		}
	});
}
//创建笔记本
function sureAddBook(){
	//获取笔记本名
	var bookName = $("#input_notebook").val();
	//TODO检查笔记本名是否为空
	if(bookName == ""){
		alert("笔记本名为空！");
		return false;
	} 
	//发送请求
	$.ajax({
		url:"http://localhost:8080/cloudnote/notebook/add.do",
		type:"post",
		data:{"bookName":bookName,"userId":userId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				closeWindow();//关闭对话框
				//添加笔记本li
				var bookId = result.data;//获取返回的bookId
				// 拼成li元素
				var s_li = '<li class="online"><a>';
	            s_li += '<i class="fa fa-book" title="online" rel="tooltip-bottom">';
	            s_li +='</i> '+bookName+'</a></li>';
                // 将s_li字符串转成jQuery对象，藏bookId
                var $li = $(s_li);
                $li.data("bookId",bookId);
	            // 将li添加到笔记本ul中
	            $("#book_list").prepend($li);
			}
		},
		error:function(){
			alert("创建笔记本失败");
		}
	});
}
//弹出添加笔记本对话框
function showAddBookWindow(){
		//发出一个alert/alert_notebook.html请求
		//将返回的结果放入id=can的div
		$(".opacity_bg").show();//显示背景
		$("#can").load("alert/alert_notebook.html");//显示对话框
}
//关闭弹出添加笔记本对话框
function closeWindow(){
	$("#can").empty();
	$(".opacity_bg").hide();
}
//加载用户笔记本，生成option选项
function loadReplaySelect(){
	$.ajax({
		url:"http://localhost:8080/cloudnote/notebook/loadbooks.do",
		type:"post",
		data:{"userId":userId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var books = result.data;// 笔记本json集合
				// 循环集合生成option
				for(var i=0;i<books.length;i++){
					// 获取每个笔记本元素的笔记本名称
					var bookName = books[i].cn_notebook_name;
					// 获取每个笔记本元素的笔记本ID
					var bookId = books[i].cn_notebook_id;
					//拼一个option
					var s_opt = '<option value="'+bookId+'">'+bookName+'</option>';
					//将option加入到select中
					$("#replaySelect").append(s_opt);
			    }
		   }
		}
	});
}