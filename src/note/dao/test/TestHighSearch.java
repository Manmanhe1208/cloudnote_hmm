package note.dao.test;

import java.util.List;

import note.entity.Note;
import note.entity.NoteResult;
import note.service.NoteService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHighSearch {
	public static void main(String[] args) {
		String conf = "applicationContext.xml";
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext(conf);
		NoteService service = 
				ac.getBean("noteServiceImpl",NoteService.class);
		NoteResult result = 
				service.highSearch(null, null, "2019-3-1", "2019-4-1");
		List<Note> list = (List) result.getData();
		for(Note n:list){
			System.out.println(n.getCn_note_title());
		}
		System.out.println("搜索结果数量："+list.size());
	}
}
