package edu.fa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fa.dao.StudentHibernateDao;
import edu.fa.model.Student;
import edu.fa.service.StudentService;

public class StudentManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
//		StudentHibernateDao dao = context.getBean("studentHibernateDao",StudentHibernateDao.class);
//		dao.save(new Student("NamNV", "Ha Noi"));
		
		StudentService studentService = context.getBean("studentService", StudentService.class);
		
		studentService.save(new Student("Hoang","Hai Phong"));
		studentService.test();
	}

}
