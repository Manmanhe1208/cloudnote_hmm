package note.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import note.dao.UserDao;
import note.entity.NoteResult;
import note.entity.User;
import note.util.NoteUtil;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service//ɨ��Service���
@Transactional
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;//ע��
	public NoteResult checkLogin(String name, String pwd) throws NoSuchAlgorithmException {
		
		NoteResult result = new NoteResult();
		//System.out.println(name+","+pwd);
		User user = userDao.findByName(name);
		//System.out.println(user);
		//���user����null,˵����name��ѯ����������
		if(user==null){
			result.setStatus(1);
			result.setMsg("�û���������");
			return result;
		}
		//���user���ز�Ϊnull,˵���û�����ȷ,�ȶ�����
		//���û����������pwd����
		String md5_pwd = NoteUtil.md5(pwd);
		//�����ݿ�����ȶ�
		if(!user.getCn_user_password().equals(md5_pwd)){
			result.setStatus(2);
			result.setMsg("�������");
			return result;
		}
		result.setStatus(0);
		result.setMsg("�û�����������ȷ");
		result.setData(user.getCn_user_id());//����userId
		return result;
	}
	
	public NoteResult regist(String name, String password, String nickname) 
			throws NoSuchAlgorithmException {
		NoteResult result = new NoteResult();
		//����û����Ƿ�ռ��
		User has_user = userDao.findByName(name);
		System.out.println(has_user);
		if(has_user!=null){
			result.setStatus(1);
			result.setMsg("�û����ѱ�ռ��");
			return result;
		}
		//ע��
		User user = new User();
		user.setCn_user_name(name);
		String md5_pwd = NoteUtil.md5(password);
		user.setCn_user_password(md5_pwd);//���ü��ܺ������
		user.setCn_user_nick(nickname);
		String userId = NoteUtil.createId();
		user.setCn_user_id(userId);//����ID
		//����userDao����
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("ע��ɹ�");
		return result;
	}

}
