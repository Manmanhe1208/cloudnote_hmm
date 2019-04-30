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
		result.setMsg("查询笔记成功");
		result.setData(list);
		return result;
	}

	public NoteResult addNote(String noteTitle, String bookId,String userId) {
		NoteResult result = new NoteResult();
		//添加笔记
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
		result.setMsg("笔记创建成功");
		result.setData(noteId);
		return result;
	}

	@Override
	public NoteResult loadNote(String noteId) {
		NoteResult result = new NoteResult();
		Note note = noteDao.findById(noteId);
		result.setStatus(0);
		result.setMsg("查询笔记成功");
		result.setData(note);
		return result;
	}

	@Override
	public NoteResult updateNote(String noteId,String noteTitle, String noteBody) {
		NoteResult result = new NoteResult();
		//更新
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(noteTitle);
		note.setCn_note_body(noteBody);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		noteDao.dynamicUpdate(note);//更新
		//TODO如果笔记分享，更新分享表信息
		result.setStatus(0);
		result.setMsg("更新笔记成功");
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
		result.setMsg("删除笔记成功");
		return result;
	}

	@Override
	public NoteResult shareNote(String noteId) {
		NoteResult result = new NoteResult();
		//检查该笔记是否分享过
		Share has_share = shareDao.findByNoteId(noteId);
		if(has_share!=null){
			result.setStatus(1);
			result.setMsg("该笔记已被分享过");
			return result;
		}
		//未被分享过，分享处理
		Note note = noteDao.findById(noteId);
		Share share = new Share();
		share.setCn_share_title(note.getCn_note_title());
		share.setCn_note_id(note.getCn_note_body());
		share.setCn_note_id(noteId);
		String shareId = NoteUtil.createId();
		share.setCn_share_id(shareId);
		shareDao.save(share);
		result.setStatus(0);
		result.setMsg("分享笔记成功");
		return result;
	}
	public NoteResult moveNote(String noteId, String bookId) {
		Note note = new Note();
		note.setCn_note_id(noteId);//设置笔记ID
		note.setCn_notebook_id(bookId);//设置笔记本ID
		int rows = 
			noteDao.updateBookId(note);//更新
		//创建返回结果
		NoteResult result = new NoteResult();
		if(rows>=1){
			result.setStatus(0);
			result.setMsg("转移笔记成功");
		}else{
			result.setStatus(1);
			result.setMsg("转移笔记失败");
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
		result.setMsg("检索分享笔记成功");
		return result;
	}

	@Override
	public NoteResult loadShare(String shareId) {
		NoteResult result = new NoteResult();
		Share share = shareDao.findById(shareId);
		result.setStatus(0);
		result.setMsg("查询分享笔记成功");
		result.setData(share);
		return result;
	}

	@Override
	public NoteResult loadDelete(String userId) {
		NoteResult result = new NoteResult();
		List<Map> note = noteDao.findDelete(userId);
		result.setStatus(0);
		result.setMsg("查询回收站信息成功");
		result.setData(note);
		return result;
	}
	//恢复
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
		result.setMsg("恢复回收站笔记成功");
		return result;
	}

	@Override
	public NoteResult highSearch(
			String title, 
			String status, 
			String begin,
			String end) {
		Map params = new HashMap();
		//如果标题不为空，就添加map参数
		if(title!=null && !"".equals(title)){
			title = "%"+title+"%";
			params.put("title",title);
		}
		//如果状态没有选择全部，就添加map参数
		if(status!=null && !"0".equals(status)){
			params.put("status", status);
		}
		//如果开始日期不为空，就添加map参数
		if(begin !=null && !"".equals(begin)){
			//将字符串转换成日期(Long表示)
			Date beginDate=java.sql.Date.valueOf(begin);
			params.put("beginDate",beginDate.getTime());
		}
		//如果结束日期不为空，就添加map参数
		if(end!=null  && !"".equals(end)){
			//将字符串转换成日期(Long表示)
			Date endDate=java.sql.Date.valueOf(end);
			//当前日期加1
			Calendar c = Calendar.getInstance();
			c.setTime(endDate);
			c.add(Calendar.DATE,1);
			params.put("endDate",c.getTimeInMillis());
		}
		//调用Dao
		List<Note> list = noteDao.highSearch(params);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("检索成功");
		result.setData(list);
		return result;
	}

}
