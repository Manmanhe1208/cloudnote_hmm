package note.dao.test;

import java.util.List;

import note.dao.AssociationDao;
import note.entity.NoteBook;
import note.entity.User;

public class TestAssociationDao extends TestBase{
	public static void main(String[] args) {
		AssociationDao dao =
				getContext().getBean("associationDao",AssociationDao.class);
//		System.out.println("--用户信息--");
//		//调用dao提取用户信息，以及笔记本信息
//		User user = 
//				dao.findUser("48595f52-b22c-4485-9244-f4004255b972");
//		//显示user内容 
//		System.out.println(user.getCn_user_name());
//		//显示user下的book信息
//		List<NoteBook> books = user.getBooks();
//		System.out.println("--该用户下的笔记本信息");
//		for(NoteBook book:books){
//			System.out.println(book.getCn_notebook_name());
//		}
//		List<NoteBook> books = 
//				dao.findBooks(user.getCn_user_id());
		//测试findAllUser
//		List<User> list = dao.findAllUser();
//		for(User u:list){
//			System.out.println("用户名:"+u.getCn_user_name());
//			//打印包含哪些笔记本
//			for(NoteBook b:u.getBooks()){
//				System.out.println("=="+b.getCn_notebook_name());
//			}
//		}
		//测试findAllBooks
		List<NoteBook> list = dao.findAllBooks();
		for(NoteBook book:list){
			System.out.println(book.getCn_notebook_id()+","+
							   book.getCn_notebook_name()+","+
		                       book.getUser().getCn_user_name());
		}
	}
}
