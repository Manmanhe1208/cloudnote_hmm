package note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import note.entity.NoteResult;
import note.service.NoteService;
@Controller
@RequestMapping("/note")
public class LoadDeleteNoteController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/loadDelete.do")
	@ResponseBody
	public NoteResult execute(String userId){
		NoteResult result = noteService.loadDelete(userId);
		return result;
	}
}
