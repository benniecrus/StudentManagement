package edu.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.model.Student;
import edu.fa.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public void save(Student student) {
		studentRepository.save(student);
	}
	
	public void test() {
		System.out.println(studentRepository.count());
		System.out.println(studentRepository.findAll());
		System.out.println(studentRepository.findByNameAndLocation("NamNV", "Ha Noi"));
		System.out.println(studentRepository.findFirstByOrderByNameAsc());
//		System.out.println(studentRepository.get);
		System.out.println(studentRepository.getAllByNameabc("Hoang"));
	}
	
}
