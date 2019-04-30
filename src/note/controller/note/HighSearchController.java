package note.controller.note;

import javax.annotation.Resource;

import note.entity.NoteResult;
import note.service.NoteService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class HighSearchController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/highSearch.do")
	@ResponseBody
	public NoteResult execute(String title, String status, String begin, String end){
		NoteResult result = noteService.highSearch(title, status, begin, end);
		return result;
		
	}
}
