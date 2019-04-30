package note.aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLogger {
	@AfterThrowing(throwing="e",
			pointcut="within(note.controller..*)")
	public void log(Exception e){
		//将异常信息写入文件
		System.out.println("记录异常信息:"+e);
		try {
			FileWriter fw = new FileWriter("E:\\error.txt");
			PrintWriter out = new PrintWriter(fw);
			e.printStackTrace(out);
			out.flush();
			out.close();
			fw.close();
		} catch (IOException e1) {
			System.out.println("记录异常信息失败");
		}
	}	
}
