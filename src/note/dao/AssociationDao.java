package note.dao;

import java.util.List;

import note.entity.NoteBook;
import note.entity.User;

public interface AssociationDao {
	public User findUser(String userId);
//	public List<NoteBook> findBooks(String userId);
	//�������(����)����ӳ��
	public List<User> findAllUser();
	//�����������ӳ��
	public List<NoteBook> findAllBooks();
}
