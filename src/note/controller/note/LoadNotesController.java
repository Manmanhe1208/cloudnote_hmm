package note.controller.note;

import javax.annotation.Resource;

import note.entity.NoteResult;
import note.service.NoteService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class LoadNotesController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/loadnotes.do")
	@ResponseBody
	public NoteResult execute(String bookId){
		NoteResult result = noteService.loadNotes(bookId);
		return result;
		
	}
}
