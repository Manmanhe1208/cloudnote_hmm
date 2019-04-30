package note.service;

import note.entity.NoteBook;
import note.entity.NoteResult;

public interface NoteBookService {
	public NoteResult loadBooks(String userId);
	public NoteResult addBook(String bookName,String userId);
}
