package note.controller.note;

import javax.annotation.Resource;

import note.entity.NoteResult;
import note.service.NoteService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class AddNoteControll {
	@Resource
	private NoteService noteService;
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult execute(String noteTitle, String bookId,String userId){
		NoteResult result = noteService.addNote(noteTitle, bookId, userId);
		return result;
		
	}
}
