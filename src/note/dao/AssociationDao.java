package note.dao;

import java.util.List;

import note.entity.NoteBook;
import note.entity.User;

public interface AssociationDao {
	public User findUser(String userId);
//	public List<NoteBook> findBooks(String userId);
	//多个对象(集合)关联映射
	public List<User> findAllUser();
	//单个对象关联映射
	public List<NoteBook> findAllBooks();
}
