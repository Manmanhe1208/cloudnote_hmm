package note.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import note.dao.NoteBookDao;
import note.entity.NoteBook;
import note.entity.NoteResult;
import note.util.NoteUtil;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class NoteBookServiceImpl implements NoteBookService{
	@Resource
    private	NoteBookDao bookDao;
	public NoteResult loadBooks(String userId) {
		List<NoteBook> list = bookDao.findByUser(userId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("��ѯ�ʼǱ��ɹ�");
		result.setData(list);
		return result;
	}
	public NoteResult addBook(String bookName, String userId) {
		NoteResult result = new NoteResult();
		//�����ʼǱ�
		NoteBook book = new NoteBook();
		book.setCn_notebook_name(bookName);
		book.setCn_user_id(userId);
		book.setCn_notebook_type_id("5");//normal
		String noteId = NoteUtil.createId();
		book.setCn_notebook_id(noteId);
		Timestamp createTime = new Timestamp(System.currentTimeMillis());
		book.setCn_notebook_createtime(createTime);
		bookDao.save(book);//����ʼǱ�
		result.setStatus(0);
		result.setMsg("�����ʼǱ��ɹ�");
		result.setData(noteId);//���رʼǱ�Id
		return result;
	}

}
