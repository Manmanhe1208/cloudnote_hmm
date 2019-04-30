package note.controller.note;

import javax.annotation.Resource;

import note.entity.NoteResult;
import note.service.NoteService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/note")
public class SearchNoteController {
	@Resource
	public NoteService noteService;
	@RequestMapping("/search.do")
	@ResponseBody
	public NoteResult execute(String keyword){
		NoteResult result = noteService.searchNote(keyword);
		return result;
	}
}
