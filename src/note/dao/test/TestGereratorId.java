package note.dao.test;

import note.dao.EmpDao;
import note.entity.Emp;

public class TestGereratorId extends TestBase{
	public static void main(String[] args) {
		EmpDao dao = getContext().getBean("empDao",EmpDao.class);
		Emp emp = new Emp();
		emp.setName("spring");
		emp.setAge(21);
		dao.save(emp);
		System.out.println("Ö÷¼üÖµÎª:"+emp.getId());
	}
}
