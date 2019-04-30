package note.dao.test;

import note.dao.NoteDao;
import note.entity.Note;

public class TestDynamicUpdate extends TestBase{
	public static void main(String[] args) {
		NoteDao noteDao = 
				getContext().getBean("noteDao",NoteDao.class);
		//测试动态更新，回收站恢复笔记
		Note note = new Note();
		note.setCn_note_status_id("1");
		note.setCn_notebook_id("10001");
		note.setCn_note_id("0e086e15000e4d3385afef193c18bb89");
		noteDao.dynamicUpdate(note);
	}
}
