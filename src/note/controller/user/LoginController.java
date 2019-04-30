package note.controller.user;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import note.entity.NoteResult;
import note.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller//扫描控制组件
@RequestMapping("/user")
public class LoginController {
	@Resource
	private UserService userService;//注入
	@RequestMapping("/login.do")
	@ResponseBody//将返回值NoteResult转成json输出
	public NoteResult execute(String name,String pwd) throws NoSuchAlgorithmException{
		System.out.println(name);
		System.out.println(pwd);
		NoteResult result =userService.checkLogin(name, pwd);
		return result;
	}	
}
