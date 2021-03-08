package edu.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.dao.StudentHibernateDao;
import edu.fa.model.Student;
import edu.fa.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentHibernateDao studentHibernateDao;
	@Autowired
	private StudentRepository studentRepository;
	public void save(Student student) {
			//studentHibernateDao.save(student);
		studentRepository.save(student);
	}
	
	public void test() {
		System.out.println(studentRepository.count());
		System.out.println(studentRepository.findAll());
		System.out.println(studentRepository.findByNameAndLocation("ducky", "hue"));
		System.out.println(studentRepository.findByNameOrLocation("ducky", "hue a"));
		System.out.println(studentRepository.findFirstByOrderByNameAsc());
		System.out.println(studentRepository.getAllByNameabc("Ducky"));
	}
	
}
