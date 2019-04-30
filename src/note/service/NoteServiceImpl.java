package note.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import note.dao.NoteDao;
import note.dao.ShareDao;
import note.entity.Note;
import note.entity.NoteResult;
import note.entity.Share;
import note.util.NoteUtil;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class NoteServiceImpl implements NoteService{
	@Resource 
	private NoteDao noteDao;
	@Resource
	private ShareDao shareDao;
	public NoteResult loadNotes(String bookId) {
		List<Map> list = noteDao.findByBookId(bookId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("��ѯ�ʼǳɹ�");
		result.setData(list);
		return result;
	}

	public NoteResult addNote(String noteTitle, String bookId,String userId) {
		NoteResult result = new NoteResult();
		//��ӱʼ�
		Note note = new Note();
		note.setCn_note_title(noteTitle);
		note.setCn_notebook_id(bookId);
		note.setCn_user_id(userId);
		note.setCn_note_status_id("1");//normal
		note.setCn_note_type_id("1");//normal
		note.setCn_note_body("");
		note.setCn_note_create_time(System.currentTimeMillis());
		String noteId = NoteUtil.createId();
		note.setCn_note_id(noteId);
		noteDao.save(note);
		result.setStatus(0);
		result.setMsg("�ʼǴ����ɹ�");
		result.setData(noteId);
		return result;
	}

	@Override
	public NoteResult loadNote(String noteId) {
		NoteResult result = new NoteResult();
		Note note = noteDao.findById(noteId);
		result.setStatus(0);
		result.setMsg("��ѯ�ʼǳɹ�");
		result.setData(note);
		return result;
	}

	@Override
	public NoteResult updateNote(String noteId,String noteTitle, String noteBody) {
		NoteResult result = new NoteResult();
		//����
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(noteTitle);
		note.setCn_note_body(noteBody);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		noteDao.dynamicUpdate(note);//����
		//TODO����ʼǷ������·������Ϣ
		result.setStatus(0);
		result.setMsg("���±ʼǳɹ�");
		return result;
	}

	@Override
	public NoteResult recycleNote(String noteId) {
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_status_id("2");
		noteDao.dynamicUpdate(note);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("ɾ���ʼǳɹ�");
		return result;
	}

	@Override
	public NoteResult shareNote(String noteId) {
		NoteResult result = new NoteResult();
		//���ñʼ��Ƿ�����
		Share has_share = shareDao.findByNoteId(noteId);
		if(has_share!=null){
			result.setStatus(1);
			result.setMsg("�ñʼ��ѱ������");
			return result;
		}
		//δ���������������
		Note note = noteDao.findById(noteId);
		Share share = new Share();
		share.setCn_share_title(note.getCn_note_title());
		share.setCn_note_id(note.getCn_note_body());
		share.setCn_note_id(noteId);
		String shareId = NoteUtil.createId();
		share.setCn_share_id(shareId);
		shareDao.save(share);
		result.setStatus(0);
		result.setMsg("����ʼǳɹ�");
		return result;
	}
	public NoteResult moveNote(String noteId, String bookId) {
		Note note = new Note();
		note.setCn_note_id(noteId);//���ñʼ�ID
		note.setCn_notebook_id(bookId);//���ñʼǱ�ID
		int rows = 
			noteDao.updateBookId(note);//����
		//�������ؽ��
		NoteResult result = new NoteResult();
		if(rows>=1){
			result.setStatus(0);
			result.setMsg("ת�Ʊʼǳɹ�");
		}else{
			result.setStatus(1);
			result.setMsg("ת�Ʊʼ�ʧ��");
		}
		return result;
	}

	@Override
	public NoteResult searchNote(String keyword) {
		NoteResult result = new NoteResult();
		if(keyword!=null && !"".equals(keyword) ){
			keyword="%"+keyword+"%";
		}else{
			keyword="%";
		}
		List<Map> list = shareDao.findLikeTitle(keyword);
		result.setData(list);
		result.setStatus(0);
		result.setMsg("��������ʼǳɹ�");
		return result;
	}

	@Override
	public NoteResult loadShare(String shareId) {
		NoteResult result = new NoteResult();
		Share share = shareDao.findById(shareId);
		result.setStatus(0);
		result.setMsg("��ѯ����ʼǳɹ�");
		result.setData(share);
		return result;
	}

	@Override
	public NoteResult loadDelete(String userId) {
		NoteResult result = new NoteResult();
		List<Map> note = noteDao.findDelete(userId);
		result.setStatus(0);
		result.setMsg("��ѯ����վ��Ϣ�ɹ�");
		result.setData(note);
		return result;
	}
	//�ָ�
	public NoteResult replayNote(String noteId,String bookId) {
//		Map<String,Object> params = new HashMap<String,Object>();
//		params.put("noteId", noteId);
//		params.put("bookId", bookId);
//		noteDao.replayNote(params);
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookId);
		note.setCn_note_status_id("1");
		noteDao.dynamicUpdate(note);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("�ָ�����վ�ʼǳɹ�");
		return result;
	}

	@Override
	public NoteResult highSearch(
			String title, 
			String status, 
			String begin,
			String end) {
		Map params = new HashMap();
		//������ⲻΪ�գ������map����
		if(title!=null && !"".equals(title)){
			title = "%"+title+"%";
			params.put("title",title);
		}
		//���״̬û��ѡ��ȫ���������map����
		if(status!=null && !"0".equals(status)){
			params.put("status", status);
		}
		//�����ʼ���ڲ�Ϊ�գ������map����
		if(begin !=null && !"".equals(begin)){
			//���ַ���ת��������(Long��ʾ)
			Date beginDate=java.sql.Date.valueOf(begin);
			params.put("beginDate",beginDate.getTime());
		}
		//����������ڲ�Ϊ�գ������map����
		if(end!=null  && !"".equals(end)){
			//���ַ���ת��������(Long��ʾ)
			Date endDate=java.sql.Date.valueOf(end);
			//��ǰ���ڼ�1
			Calendar c = Calendar.getInstance();
			c.setTime(endDate);
			c.add(Calendar.DATE,1);
			params.put("endDate",c.getTimeInMillis());
		}
		//����Dao
		List<Note> list = noteDao.highSearch(params);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("�����ɹ�");
		result.setData(list);
		return result;
	}

}
