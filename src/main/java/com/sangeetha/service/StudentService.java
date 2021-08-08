package com.sangeetha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangeetha.entity.Student;
import com.sangeetha.repository.StudentRepo;

@Service
public class StudentService {
	
    @Autowired
	private StudentRepo repo;
    
    //Create Student Record
    public Student addStudent(Student student) {
    	return repo.save(student);
    }
    
    //Create multiple Students Records at a time
    public List<Student> addAllStudent(List<Student> students){
		return repo.saveAll(students);	
    }
    
    //fetch particular student details
    public Optional<Student> getStudent(Integer id) {
		return repo.findById(id);
    }
    
    //fetch all student details
    public List<Student> getAllStudents(){
		return repo.findAll();
     }
    
 
    //update student record
    public Student updateStudent(Student studId) {
		return repo.save(studId);	
    }
    
    
    //delete student record
    public String deleteStudent(int delStudId) {
    	repo.deleteById(delStudId);;
		return "Student record deleted successfully"  ;	
    }

}
