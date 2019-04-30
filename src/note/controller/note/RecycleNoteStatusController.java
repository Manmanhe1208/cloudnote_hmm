package note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import note.entity.NoteResult;
import note.service.NoteService;
@Controller
@RequestMapping("/note")
public class RecycleNoteStatusController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/updateRecycle.do")
	@ResponseBody
	public NoteResult execute(String noteId){
		NoteResult result = noteService.recycleNote(noteId);
		return result;
		
	}
}
