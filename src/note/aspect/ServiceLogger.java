package note.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component//ɨ�裬�����ɨ�赽����
@Aspect//����ǰ�������Ϊ�������
public class ServiceLogger {
	@Before("within(note.service..*)")
	public void slogger(){
		System.out.println("����Service����");
	}
}
