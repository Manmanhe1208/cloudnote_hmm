package note.dao.test;

import note.dao.NoteDao;

public class TestDeleteNotes extends TestBase {
	public static void main(String[] args) {
		NoteDao noteDao =
				getContext().getBean("noteDao",NoteDao.class);
		String[] ids = {"0e086e15000e4d3385afef193c18bb89",
				"13b87b3a-0a98-4b3f-aec8-2477d94fbfff"};
		int rows = noteDao.deleteNotes(ids);
		System.out.println("删除的记录数是:"+rows);
	}
}
