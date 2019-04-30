package note.service;

import java.util.Map;

import note.entity.Note;
import note.entity.NoteResult;

public interface NoteService {
	public NoteResult highSearch(String title,String status,String begin,String end);
	public NoteResult loadNotes(String bookId);
	public NoteResult addNote(String noteTitle, String bookId,String userId);
	public NoteResult loadNote(String noteId);
	public NoteResult updateNote(String noteId,String noteTitle, String noteBody);
	public NoteResult recycleNote(String noteId);
	public NoteResult shareNote(String noteId);
	public NoteResult moveNote(String noteId, String bookId);
	public NoteResult searchNote(String keyword);
	public NoteResult loadShare(String shareId);
	public NoteResult loadDelete(String userId);
	public NoteResult replayNote(String noteId,String bookId);
}
