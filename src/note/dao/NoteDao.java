package note.dao;

import java.util.List;
import java.util.Map;

import note.entity.Note;

public interface NoteDao {
	public void dynamicUpdate(Note note);
	public List<Note> highSearch(Map params);
	public List<Map> findByBookId(String bookId);
	public void save(Note note);
	public Note findById(String noteId);
	public void update(Note note);
	public void updateStatus(String noteId);
	public int updateBookId(Note note);
	public List<Map> findDelete(String userId);
	public void replayNote(Map params);
	public int deleteNotes(String[] ids);
}
