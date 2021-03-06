package note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import note.entity.NoteResult;
import note.service.NoteService;
@Controller
@RequestMapping("/note")
public class LoadNoteController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/load.do")
	@ResponseBody
	public NoteResult execute(String noteId){
		NoteResult result = noteService.loadNote(noteId);
		return result;
		
	}
}
