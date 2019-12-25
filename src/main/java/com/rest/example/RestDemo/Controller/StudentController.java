package com.rest.example.RestDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.example.RestDemo.Model.Response;
import com.rest.example.RestDemo.Model.Student;
import com.rest.example.RestDemo.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/Student")
	public Response addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping("/Student")
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
	}

	@GetMapping("/Student/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
	
	@PutMapping("/Student/{id}")
	public Response updateSudent(@PathVariable int id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}
}
