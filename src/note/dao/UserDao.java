package note.dao;

import java.util.List;

import note.entity.User;

public interface UserDao {
	public User findByName(String name);
	public void save(User user);
	public List<User> findAll();
}
