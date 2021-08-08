package com.sangeetha.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sangeetha.customException.RecordNotFoundException;
import com.sangeetha.entity.Student;
import com.sangeetha.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	//Create Student Record
	@PostMapping(value = "/createStudent", consumes = "application/json")
	public Student saveStud(@RequestBody Student s) {
		return service.addStudent(s);
	}
		
	
	//Create multiple Students Records at a time
	@PostMapping(value = "/createStudents", consumes = "application/json")
	public List<Student> saveStuds(@RequestBody List<Student> stud) {
		return service.addAllStudent(stud);
	}
	
	//fetch particular student details
	public static final Logger log = LoggerFactory.getLogger(StudentController.class);
	@GetMapping(value = "/getStudent/{sid}")
	public ResponseEntity<Student> getStud(@PathVariable Integer sid) throws RecordNotFoundException{
	log.info("getStudentById() execution starts");
	Optional<Student>  op = service.getStudent(sid);
		if(op.isPresent())
		{
			log.info("getStudentById() execution ends");
		return new ResponseEntity<Student>(op.get(),HttpStatus.OK);	
		}
		else
		{
			throw new RecordNotFoundException ("Give student id with URL to get a particular student");
		}
	}
	
	//fetch all student details
	@GetMapping(value = "/getStudents")
	public List<Student> getStuds() {
		return service.getAllStudents();
	}
	
	//update student record
	@PutMapping(value = "/updateStudent")
	public Student updateStud(@RequestBody Student id) {
		return service.updateStudent(id);
	}
	
	//delete student record
	@DeleteMapping(value = "/deleteStudent/{delId}")
	public String deleteStud(@PathVariable Integer delId) {
		return service.deleteStudent(delId);
	}
	
	
}
