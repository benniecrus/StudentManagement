package edu.fa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.fa.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByNameAndLocation(String name, String location);
	Student findFirstByOrderByNameAsc();
	
	@Query("SELECT s FROM Student s WHERE s.name = ?1")
	List<Student> getAllByNameabc(String name);
}
