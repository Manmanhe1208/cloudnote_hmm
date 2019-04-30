package note.dao.test;

import java.util.List;

import note.dao.NoteBookDao;
import note.entity.NoteBook;

public class TestNoteBookDao extends TestBase{
	public static void main(String[] args) {
		NoteBookDao noteBookDao = 
				getContext().getBean("noteBookDao",NoteBookDao.class);
		List<NoteBook> notebooks = 
				noteBookDao.findByUser("48595f52-b22c-4485-9244-f4004255b972");
		for(NoteBook list:notebooks){
			System.out.println(list);
		}
	}
	
}
