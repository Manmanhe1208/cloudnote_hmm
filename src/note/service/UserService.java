package note.service;

import java.security.NoSuchAlgorithmException;

import note.entity.NoteResult;

public interface UserService {
	public NoteResult checkLogin(String name,String pwd) 
			throws NoSuchAlgorithmException;
	public NoteResult regist(String name,String password,String nickname) 
			throws NoSuchAlgorithmException;
}
