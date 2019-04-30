package note.controller.note;

import javax.annotation.Resource;

import note.entity.NoteResult;
import note.service.NoteService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller 
@RequestMapping("/note")
public class LoadShareController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/loadShare.do")
	@ResponseBody
	public NoteResult execute(String shareId){
		NoteResult result = noteService.shareNote(shareId);
		return result;
		
	}
}
