package note.dao;

import java.util.List;

import note.entity.NoteBook;

public interface NoteBookDao {
	public List<NoteBook> findByUser(String userId);
	public void save(NoteBook book);
}
