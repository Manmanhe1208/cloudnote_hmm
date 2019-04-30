package note.controller.user;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import note.entity.NoteResult;
import note.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/user")
public class RegistController {
	@Resource
	private UserService userService;
	@RequestMapping("/regist.do")
	@ResponseBody
	public NoteResult execute(String name,String password,String nickname) 
			throws NoSuchAlgorithmException{
		NoteResult result = userService.regist(name, password, nickname);
		return result;
	}
}
