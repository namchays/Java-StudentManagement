package edu.fa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fa.dao.StudentHibernateDao;
import edu.fa.dao.StudentJDBCDao;
import edu.fa.dao.StudentJDBCDaoSupport;
import edu.fa.dao.StudentJDBCTemplateDao;
import edu.fa.model.Student;
import edu.fa.service.StudentService;

public class StudentManagement {
	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
	
	//	dao.insertStudent(new Student(1,"nam","danang"));
		//dao.deleteStudent();
//		System.out.println(dao.countStudent());
		
		//System.out.println(dao.getNameStudent());
//		System.out.println(dao.getStudentById(1));
//		System.out.println(dao.getAllStudent());
//		
		//StudentHibernateDao
		// dao = context.getBean("studentHibernateDao", StudentHibernateDao.class);
		//dao.save(new Student("ducky","hanoi"));
		
		StudentService service = context.getBean("studentService",StudentService.class);
		service.save(new Student("ducky","hue"));
		service.test();
	}
}
