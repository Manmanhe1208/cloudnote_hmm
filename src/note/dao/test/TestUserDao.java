package note.dao.test;

import note.dao.UserDao;
import note.entity.User;

public class TestUserDao extends TestBase{
	public static void main(String[] args) {
		UserDao userDao = getContext().getBean("userDao",UserDao.class);
//		User user = userDao.findByName("demo");
//		if(user==null){
//			System.out.println("用户名不正确");
//		}else{
//			System.out.println(user.getCn_user_password());
//		}
//		User user = new User();
//		user.setCn_user_id("1000");
//		user.setCn_user_name("demo1");
//		user.setCn_user_password("1234");
//		user.setCn_user_token("1000");
//		user.setCn_user_nick("sunshine");
//		userDao.save(user);
		
	}
	
}
