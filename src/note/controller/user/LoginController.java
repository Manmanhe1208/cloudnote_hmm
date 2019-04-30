package note.controller.user;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import note.entity.NoteResult;
import note.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller//ɨ��������
@RequestMapping("/user")
public class LoginController {
	@Resource
	private UserService userService;//ע��
	@RequestMapping("/login.do")
	@ResponseBody//������ֵNoteResultת��json���
	public NoteResult execute(String name,String pwd) throws NoSuchAlgorithmException{
		System.out.println(name);
		System.out.println(pwd);
		NoteResult result =userService.checkLogin(name, pwd);
		return result;
	}	
}
