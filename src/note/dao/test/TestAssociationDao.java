package note.dao.test;

import java.util.List;

import note.dao.AssociationDao;
import note.entity.NoteBook;
import note.entity.User;

public class TestAssociationDao extends TestBase{
	public static void main(String[] args) {
		AssociationDao dao =
				getContext().getBean("associationDao",AssociationDao.class);
//		System.out.println("--�û���Ϣ--");
//		//����dao��ȡ�û���Ϣ���Լ��ʼǱ���Ϣ
//		User user = 
//				dao.findUser("48595f52-b22c-4485-9244-f4004255b972");
//		//��ʾuser���� 
//		System.out.println(user.getCn_user_name());
//		//��ʾuser�µ�book��Ϣ
//		List<NoteBook> books = user.getBooks();
//		System.out.println("--���û��µıʼǱ���Ϣ");
//		for(NoteBook book:books){
//			System.out.println(book.getCn_notebook_name());
//		}
//		List<NoteBook> books = 
//				dao.findBooks(user.getCn_user_id());
		//����findAllUser
//		List<User> list = dao.findAllUser();
//		for(User u:list){
//			System.out.println("�û���:"+u.getCn_user_name());
//			//��ӡ������Щ�ʼǱ�
//			for(NoteBook b:u.getBooks()){
//				System.out.println("=="+b.getCn_notebook_name());
//			}
//		}
		//����findAllBooks
		List<NoteBook> list = dao.findAllBooks();
		for(NoteBook book:list){
			System.out.println(book.getCn_notebook_id()+","+
							   book.getCn_notebook_name()+","+
		                       book.getUser().getCn_user_name());
		}
	}
}
